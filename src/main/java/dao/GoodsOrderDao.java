package dao;

import javaBean.GoodsOrder;
import javaBean.Page;
import utils.JDBCHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsOrderDao {

    static String tableName = " GoodsOrder " ;

    public static int insert(GoodsOrder go) throws SQLException, ClassNotFoundException {
        String sql = "select gstatus from usedGoods where gid = ?";
        ResultSet rs = JDBCHelper.query(sql,go.getGid());
        int gstatus=0;
        if(rs.next()){
            gstatus = rs.getInt(1);
        }
        if (gstatus==0) {
            String SQL = " insert into " +tableName + " ( gid ,  uid  ,name , address , phone , oimage , price) "
                    +" values ( "+go.getGid()+" , '"+go.getUid()+"' , '"+go.getName()+"' , '"+go.getAddress()+"' , '"+go.getPhone()+"' , '"+go.getOimage()+"' , "+go.getPrice()+" )";
            JDBCHelper.executePRO(go.getUid(),go.getGid());
            return JDBCHelper.executeInsert( SQL) ;
        }
        return 0;
    }

    public static boolean DeleteGoodsOrder(int oid) {
        String SQL = " delete from "+tableName + " where oid = ? ";
        return JDBCHelper.execute(SQL,oid);
    }

    public List<GoodsOrder>  search( ResultSet rs ){
        GoodsOrder go = null ;
        if( rs != null ){
            List<GoodsOrder> goodsOrder = new ArrayList<>();
            try {
                while (rs.next()) {
                    go = new GoodsOrder();
                    go.setOid(rs.getInt("oid"));
                    go.setUid(rs.getString("uid"));
                    go.setGid(rs.getInt("gid"));
                    go.setOstatus(rs.getInt("ostatus"));
                    go.setName(rs.getString("name"));
                    go.setPrice(rs.getInt("price"));
                    go.setAddress(rs.getString("address"));
                    go.setPhone(rs.getString("phone"));
                    go.setOimage(rs.getString("oimage"));
                    go.setOtime(rs.getTimestamp("otime"));
                    goodsOrder.add(go);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
            return goodsOrder ;
        }
        return null;
    }

    public Page<GoodsOrder> findByPage(int pageCode, int pageSize, String uid) {
        // 创建PageBean对象
        Page<GoodsOrder> page = new Page<GoodsOrder>();
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
            String selSql = " select * from  " + tableName + "  where uid = ?  order by  oid  desc limit ? , ? ";
            ResultSet goodsOrderList = JDBCHelper.query(selSql,uid, (pageCode-1)*pageSize, pageSize);
            List<GoodsOrder> goodsOrderBeanList = search(goodsOrderList);
            // 把每页显示的数据设置成功了
            page.setGoodsOrderBeanList(goodsOrderBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//有日期的查找
    public Page<GoodsOrder> findByPage(int pageCode, int pageSize, String uid ,String sortTime, String date ) {
        // 创建PageBean对象
        Page<GoodsOrder> page = new Page<GoodsOrder>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);

        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from  " + tableName + " where otime like '" + date +"' and  uid = ?  ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL , uid ) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?

            String selSql = "";
            if(sortTime.equals("Asc")){
                selSql = " select * from  " + tableName + "  where otime like '" + date +"' and uid = ?  order by  oid  Asc  limit ? , ? ";
            } else {
                selSql = " select * from  " + tableName + "  where otime like '" + date +"' and uid = ?  order by  oid  Desc  limit ? , ? ";
            }

            ResultSet goodsOrderList = JDBCHelper.query(selSql,uid, (pageCode-1)*pageSize, pageSize);
            List<GoodsOrder> goodsOrderBeanList = search(goodsOrderList);
            // 把每页显示的数据设置成功了
            page.setGoodsOrderBeanList(goodsOrderBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//有关键字的查找
    public Page<GoodsOrder> findByPage2(int pageCode, int pageSize, String uid , String keyword) {
        // 创建PageBean对象
        Page<GoodsOrder> page = new Page<GoodsOrder>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from  " + tableName + "  where uid = ?  and  name  like  '%" +keyword +"%' ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL , uid ) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
            String   selSql = " select * from  " + tableName + "  where uid = ?  and  name  like '%" +keyword +"%' order by  oid  Desc  limit ? , ? ";
            ResultSet goodsOrderList = JDBCHelper.query(selSql,uid, (pageCode-1)*pageSize, pageSize);
            List<GoodsOrder> goodsOrderBeanList = search(goodsOrderList);
            // 把每页显示的数据设置成功了
            page.setGoodsOrderBeanList(goodsOrderBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private GoodsOrder wrap ( ResultSet rs ){
        GoodsOrder go = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    go = new GoodsOrder();
                    go.setOid(rs.getInt("oid"));
                    go.setUid(rs.getString("uid"));
                    go.setGid(rs.getInt("gid"));
                    go.setOstatus(rs.getInt("ostatus"));
                    go.setName(rs.getString("name"));
                    go.setPrice(rs.getInt("price"));
                    go.setAddress(rs.getString("address"));
                    go.setPhone(rs.getString("phone"));
                    go.setOimage(rs.getString("oimage"));
                    go.setOtime(rs.getTimestamp("otime"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return go ;
    }

    public GoodsOrder loadByUid(String uid) {
        String SQL = " select * from " + tableName + " where  uid = ? ";
        ResultSet rs = JDBCHelper.query(SQL,uid);
        return wrap(rs);
    }

}
