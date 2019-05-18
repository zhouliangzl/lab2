package dao;

import javaBean.Page;
import javaBean.User;
import utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.StringHelper.encrypt;

/**
 * DAO ： Data Access Object
 * 经常用于 访问数据库
 */
public class UserDao {
    String tableName = " user " ;

    public User loadByUsername(String uid ){
        // 利用 jdbc 访问数据库
        String SQL = "select  * from "+ tableName + " where uid = ? " ;
        ResultSet rs = JDBCHelper.query( SQL , uid ) ;
        User u = wrap( rs ) ;
        return u ;
    }

    public boolean UpdateActive(String uid){
        String SQL = " update " + tableName + " set active = '1' where uid = ? ";
        return JDBCHelper.execute( SQL , uid) ;
    }

    public boolean  insert ( User u ){
        String SQL = " insert into " +tableName + " ( uid ,  name , email , password) "
                +" values ( ? , ? , ? , ? ) ";
        return JDBCHelper.execute( SQL , u.getUid()  , u.getName() , u.getEmail() ,u.getPassword()) ;
    }

    private User wrap (ResultSet rs ){
        User u = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    u = new User();
                    u.setUid(rs.getString("uid"));
                    u.setType(rs.getInt("type"));
                    u.setName(rs.getString("name"));
                    u.setEmail(rs.getString("email"));
                    u.setPassword(rs.getString("password"));
                    u.setActive(rs.getString("active"));
                    u.setCoin(rs.getInt("coin"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return u ;
    }

    public User loginBydb(String uid , String password)
    {
        String SQL=" select  *  from "+ tableName +" where uid = ?  and  password= ? " ;
        ResultSet rs=JDBCHelper.query(SQL,uid,encrypt(password));
        return  wrap(rs);
    }

    public User searchByUid(String uid) {
        String SQL="select * from "+ tableName+" where uid = '" + uid + "' ";
        ResultSet rs=JDBCHelper.query(SQL);
        return  wrap(rs);
    }

    public Boolean deleteByUid(String uid){
        String SQL="delete from "+ tableName+" where uid = ? ";
        return JDBCHelper.execute(SQL, uid);
    }

    public boolean  update( User user ){
        String SQL = " update " +tableName + " set name=? , email=? , type=?, coin=? where uid = ?";
        return JDBCHelper.execute( SQL , user.getName() , user.getEmail() ,user.getType(), user.getCoin(), user.getUid()) ;
    }

    public Page<User> findByPage(int pageCode, int pageSize ){
        // 创建PageBean对象
        Page<User> page = new Page<>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        String SQL = " select count(*)  from " + tableName ;
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
            String usersSQL = " select * from  " + tableName + " order by uid  desc limit ? , ? ";
            ResultSet usersList = JDBCHelper.query(usersSQL, (pageCode-1)*pageSize, pageSize);
            List<User> usersBeanList = search(usersList);
            // 把每页显示的数据设置成功了
            page.setGoodsBeanList(usersBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<User> search(ResultSet rs ){
        if( rs != null ){
            List<User> usersList = new ArrayList<>();
            try {
                while (rs.next()) {
                    User user = new User();
                    user.setUid(rs.getString("uid"));
                    user.setName(rs.getString("name"));
                    user.setType(rs.getInt("type"));
                    user.setEmail(rs.getString("email"));
                    user.setCoin(rs.getInt("coin"));
                    user.setPassword(rs.getString("password"));
                    usersList.add(user);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
            return usersList ;
        }
        return null;
    }


}