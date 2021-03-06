package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCHelper {

    private static String driver ;
    private static String url ;
    private static String username ;
    private static  String password ;
    private static boolean autoCommit ;
    private static int isolation ;
    // 用来表示一个连接
    private static Connection conn ;

    static{
        config() ;
    }
    // 读取配置文件
    private static void  config(){
        Properties p = new Properties() ;
        InputStream ins = JDBCHelper.class.getResourceAsStream("/db.properties") ;
        try {
            p.load( ins ) ;
            // 获取到对应的属性（根据键 获取值 ）
            String database = p.getProperty("connect") ;
            driver = p.getProperty(database+".driver") ;
            url = p.getProperty(database+".url") ;
            username = p.getProperty(database+".username") ;
            password = p.getProperty(database+".password") ;
            String autocommit = p.getProperty("autocommit") ;
            autoCommit = Boolean.valueOf( autocommit ) ;

            String level = p.getProperty("transactionIsolation") ;
            isolation = Integer.valueOf( level ) ;
            // 做一次判断 （应该等于 1 2  4 8  中的一个值 ）
            if( isolation <= 0 ){
                isolation = 2 ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // 加载驱动
    private static void load(){
        try {
            Class.forName(driver) ;
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败" + e.getMessage());
        }
    }

    /**
     * 判断连接是否有效
     * @return false 表示连接 无效
     *              true 表示连接有效
     */
    private static boolean isValid(){
        try {
            if( conn != null ){
                // 如果 该链接在 3 秒内 是 有效的 ， 那么返回 true
               return  conn.isValid( 3 ) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false ;
    }
    // 建立连接
    private static Connection conn(){
        // 加载驱动
        load() ;
        try {
            if(  ! isValid() ){ // 证明 此时的连接 是已经关闭的 或者是 无效的 ，所以应该创建这个连接
                conn = DriverManager.getConnection( url , username , password ) ;
            }
        } catch (SQLException e) {
            System.out.println("建立连接失败 " + e.getMessage() );
        }
        return conn  ;
    }

    // 设置 事务的隔离级别 、自动提交
    private static void setTransaction(){
        // 证明 Connection 是有效的
        if( ! isValid() ){
            // 能进入到这里，证明是无效的
            conn = conn() ;
        }
        try {
            conn.setAutoCommit( autoCommit );
        } catch (SQLException e) {
            System.out.println("设置事务自动提交失败 " + e.getMessage() );
        }
        try {
            conn.setTransactionIsolation( isolation );
        } catch (SQLException e) {
            System.out.println("设置事务隔离级别失败 " + e.getMessage() );
        }
    }

    /**
     * 提交事务
     * @return
     */
    private static void commit( Connection c ){
        if( c != null && !autoCommit ){
            try {
                c.commit(); // 提交事务
            } catch (SQLException e) {
                System.out.println("提交事务失败 ：" + e.getMessage() );
            }
        }
    }

    /**
     * 回滚事务
     * @return
     */
    private static void rollback( Connection c ){
        if( c != null && !autoCommit ){
            try {
                c.rollback();
            } catch (SQLException e) {
                System.out.println("回滚事务失败 ：" + e.getMessage() );
            }
        }
    }
    // 创建Statement 对象
    private static Statement state(){
        conn = conn() ;
        Statement st = null ;
        try {
            st = conn.createStatement() ;
        } catch (SQLException e) {
            System.out.println("创建 Statement 对象失败 " + e.getMessage() );
        }
        return st ;
    }

    // 创建 PreparedStatment 对象
    private static PreparedStatement prepare( String SQL , boolean autoGeneartedKeys){
        conn = conn() ;
        PreparedStatement ps = null ;
        try {
            if( autoGeneartedKeys ) {
                ps = conn.prepareStatement(SQL , Statement.RETURN_GENERATED_KEYS );
            }else{
                ps = conn.prepareStatement(SQL) ;
            }
        } catch (SQLException e) {
            System.out.println("创建 PreparedStatement 对象失败 " + e.getMessage() );
        }
        return ps ;
    }

    //插入之后返回自动生成的主键
    public static int executeInsert(String SQL) {
        int id=0;
        ResultSet rs = null ;
        if( SQL == null || SQL.trim().isEmpty()){
            throw new RuntimeException("你传入的SQL为空") ;
        }
        Connection c = null  ;

        Statement st = state() ;
        try {
            try {
                c = st.getConnection() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st.executeUpdate( SQL, Statement.RETURN_GENERATED_KEYS) ;
            rs = st.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            commit( c );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    /**
     * 执行 DDL、和 DML
     */
    public static boolean execute( String SQL , Object... params ){
        setTransaction() ;
        boolean flag = false ;
        if( SQL == null || SQL.trim().isEmpty() ){
            throw new RuntimeException("你传入的SQL为空") ;
        }
        Connection c = null  ;
        if( params.length > 0 ){
            // 此时的SQL 语句中有占位符，并且 传入了参数
            PreparedStatement ps = prepare( SQL ,  false  ) ;
            try {
                c = ps.getConnection() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                // 填充占位符
                for( int i = 0 ; i < params.length ; i ++){
                    ps.setObject( i+1 , params[i] ) ;
                }
                ps.executeUpdate() ;
                commit( c );
                flag = true ;
            } catch (SQLException e) {
                System.out.println("操作失败 " + e.getMessage() );
                rollback( c  );
            }
        }else{
            Statement st = state() ;
            try {
                c = st.getConnection() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.executeUpdate( SQL ) ;
                // 提交事务
                commit( c );
                flag = true ;
            } catch (SQLException e) {
                System.out.println("执行失败" + e.getMessage() );
                rollback( c  );
            }
        }
        return flag ;
    }

    /**
     * 执行 DQL 语句
     */
    public static ResultSet query( String SQL , Object ... params  ){
        ResultSet rs = null ;
        if( SQL == null || SQL.trim().isEmpty()){
            throw new RuntimeException("你传入的SQL为空") ;
        }
        if( params.length > 0 ){
            PreparedStatement ps = prepare( SQL  , false ) ;
            try {
                for( int i  =0 ; i < params.length ; i ++ ){
                    ps.setObject( i + 1 , params[i] ) ;
                }
               rs = ps.executeQuery() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            Statement st = state() ;
            try {
                rs = st.executeQuery( SQL ) ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs ;
    }

    /**
     * 处理结果
     * @param
     */
    public static void meta( ResultSet rs ){
        if( rs != null ){
            try {
                ResultSetMetaData rsmd = rs.getMetaData() ;
                int count = rsmd.getColumnCount() ;
                while( rs.next() ){
                    for( int i = 0 ; i < count ; i++){
                        System.out.println(rs.getObject( i + 1 ) ) ;
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //执行存储过程代码
    //当用户点击购买后若用户金币大于商品价钱则执行购买操作，减去用户账户上面相对应的金币，且相应的
    //商品状态置为已售状态，若小于商品价格则执行回滚操作，并提示账户余额不足
    public  static void executePRO(String uid, int gid) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        CallableStatement cstm = connection.prepareCall("{call PRO_usedGoods_Purchase(?,?)}");
        cstm.setString(1, uid);
        cstm.setInt(2, gid);
        cstm.execute();
        cstm.close();
        connection.close();
    }

    // 关闭资源
    public static void release( Object o ){
        if( o != null ){
            if( o instanceof  Connection ){
                Connection c = (Connection) o ;
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( o instanceof  Statement ){
                Statement st = (Statement) o ;
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( o instanceof  ResultSet ){
                ResultSet rs = (ResultSet) o ;
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
