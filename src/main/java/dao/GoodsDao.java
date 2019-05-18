package dao;

import javaBean.Goods;
import javaBean.Page;
import utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    static String tableName = " usedGoods ";

    public static boolean deleteByGid(int gid) {
        String SQL = " delete from "+tableName + " where gid = ? ";
        return JDBCHelper.execute(SQL,gid);
    }

    private Goods wrap (ResultSet rs ){
        Goods goods = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    goods = new Goods();
                    goods.setGid(rs.getInt("gid"));
                    goods.setType(rs.getString("type"));
                    goods.setName(rs.getString("name"));
                    goods.setPrice(rs.getInt("price"));
                    goods.setDescription(rs.getString("description"));
                    goods.setGstatus(rs.getInt("gstatus"));
                    goods.setUid(rs.getString("uid"));
                    goods.setGdate(rs.getDate("gdate"));
                    goods.setGimage(rs.getString("gimage"));
                    goods.setOld(rs.getString("old"));
                    goods.setColor(rs.getString("color"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return goods ;
    }

    public List<Goods>  wrapList ( ResultSet rs ){
        Goods g = null ;
        if( rs != null ){
            List<Goods> goods = new ArrayList<>();
            try {
                while (rs.next()) {
                    g = new Goods();
                    g.setGid(rs.getInt("gid"));
                    g.setType(rs.getString("type"));
                    g.setName(rs.getString("name"));
                    g.setPrice(rs.getInt("price"));
                    g.setDescription(rs.getString("description"));
                    g.setGstatus(rs.getInt("gstatus"));
                    g.setUid(rs.getString("uid"));
                    g.setGdate(rs.getDate("gdate"));
                    g.setGimage(rs.getString("gimage"));
                    g.setOld(rs.getString("old"));
                    g.setColor(rs.getString("color"));
                    goods.add(g);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
            return goods ;
        }
        return null;
    }

    public List<Goods> recommedGoods(int num,int gid, String type) {
        String SQL="select * from "+tableName+" where gid <> ? and type = ? order by gid desc limit ?";
        ResultSet rs = JDBCHelper.query(SQL, gid, type, num);
        return wrapList(rs);
    }

    public Goods loadByGid( int gid){
        String SQL = "  select *  from  "+ tableName+ " where gid = ? " ;
        ResultSet rs = JDBCHelper.query( SQL , gid ) ;
        Goods goods = wrap( rs ) ;
        return goods ;
    }

    public List<Goods> load(int num) {
        String SQL="(select * from "+tableName+" ) "+" order by gid desc limit "+num;
        ResultSet rs = JDBCHelper.query(SQL);
        return wrapList(rs);
    }

    public static boolean UpdateByGid(Goods goods) {
        String SQL = " update " + tableName + " set name=? ,type=?, price=?, description=? , old =?, color=?  where gid = ?";
        return JDBCHelper.execute( SQL , goods.getName(), goods.getType(), goods.getPrice(),
                goods.getDescription(), goods.getOld(), goods.getColor(), goods.getGid() );
    }

    public static int postGoods(Goods goods){
        String SQL = " insert into "+ tableName + " ( uid , name, type, price, description, old, color, gimage ) "
                + " values ( '"+goods.getUid()+"','"+goods.getName()+"','"+goods.getType()+"',"+goods.getPrice()+",'"+goods.getDescription()+"','"+goods.getOld()+"','"+goods.getColor()+"','"+goods.getGimage()+"')";
        return  JDBCHelper.executeInsert(SQL);
    }

    public Page<Goods> findByPage(int pageCode, int pageSize , String uid){
        // 创建PageBean对象
        Page<Goods> page = new Page<Goods>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from " + tableName + " where uid = ? ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL , uid) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String GoodsSQL = " select * from  " + tableName + "  where uid = ?  order by  uid  desc limit ? , ? ";
            ResultSet GoodsList = JDBCHelper.query(GoodsSQL,uid, (pageCode-1)*pageSize, pageSize);
            List<Goods> GoodsBeanList = wrapList(GoodsList);
            // 把每页显示的数据设置成功了
            page.setGoodsBeanList(GoodsBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Page<Goods> indexFindByPage(int pageCode, int pageSize) {
        // 创建PageBean对象
        Page<Goods> page = new Page<Goods>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from " + tableName ;
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL ) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String GoodsSQL = " select * from  " + tableName + "   order by  gid  desc limit ? , ? ";
            ResultSet GoodsList = JDBCHelper.query(GoodsSQL, (pageCode-1)*pageSize, pageSize);
            List<Goods> GoodsBeanList = wrapList(GoodsList);
            // 把每页显示的数据设置成功了
            page.setGoodsBeanList(GoodsBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Page<Goods> findByPageIndex(int pageCode, int pageSize, String keyword) {
        // 创建PageBean对象
        Page<Goods> page = new Page<Goods>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from  " + tableName + " where name like binary  '%"+keyword+"%' or type " +
                " like binary  '%"+keyword+"%'  or  description  like binary  '%"+keyword+"%'  or  color  like binary  '%"+keyword+"%'  "+
                "  or  price  like binary  '%"+keyword+"%'  or  old  like binary '%"+keyword+"%'  or gdate like binary  '%"+keyword+"%' ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL );
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String GoodsSQL = " select *  from  " + tableName + " where name like binary  '%"+keyword+"%' or type " +
      " like binary  '%"+keyword+"%'  or  description  like binary  '%"+keyword+"%'  or  color  like binary  '%"+keyword+"%'  "+
      "  or  price  like binary  '%"+keyword+"%'  or  old  like binary '%"+keyword+"%'  or gdate like binary  '%"+keyword+"%' "+
      " order by  gid  desc limit  ? , ?  ";
            ResultSet GoodsList = JDBCHelper.query(GoodsSQL, (pageCode-1)*pageSize, pageSize);
            List<Goods> GoodsBeanList = wrapList(GoodsList);
            // 把每页显示的数据设置成功了
            page.setGoodsBeanList(GoodsBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
