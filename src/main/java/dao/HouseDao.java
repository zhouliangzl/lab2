package dao;

import javaBean.House;
import javaBean.Page;
import javaBean.SignHouse;
import utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseDao
{
    String tableName=" house ";

    public static List<House> wrapList(ResultSet rs){
    House house = null ;
    if( rs != null ){
        List<House> House = new ArrayList<>();
        try {
            while (rs.next()) {
                house = new House();
                house.setHid(rs.getInt("hid"));
                house.setUid(rs.getString("uid"));
                house.setStatus(rs.getInt("status"));
                house.setAddress(rs.getString("address"));
                house.setArea(rs.getInt("area"));
                house.setFloor(rs.getInt("floor"));
                house.setRent(rs.getInt("rent"));
                house.setRegion(rs.getString("region"));
                house.setType(rs.getString("type"));
                house.setOrient(rs.getString("orient"));
                house.setEnviron(rs.getString("environ"));
                house.setDecoration(rs.getString("decoration"));
                house.setConnect(rs.getString("connect"));
                house.setTitle(rs.getString("title"));
                house.setDescription(rs.getString("description"));
                house.setPhoto(rs.getString("photo"));
                house.setPhone(rs.getString("phone"));
                House.add(house);
            }
        }catch( SQLException e){
            e.printStackTrace();
        }
        return House ;
    }
    return null;
}

    public static List<House>  wrapList(ResultSet rs, List<House> houseList){
        House house = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    house = new House();
                    house.setHid(rs.getInt("hid"));
                    house.setUid(rs.getString("uid"));
                    house.setStatus(rs.getInt("status"));
                    house.setAddress(rs.getString("address"));
                    house.setArea(rs.getInt("area"));
                    house.setFloor(rs.getInt("floor"));
                    house.setRent(rs.getInt("rent"));
                    house.setRegion(rs.getString("region"));
                    house.setType(rs.getString("type"));
                    house.setOrient(rs.getString("orient"));
                    house.setEnviron(rs.getString("environ"));
                    house.setDecoration(rs.getString("decoration"));
                    house.setConnect(rs.getString("connect"));
                    house.setTitle(rs.getString("title"));
                    house.setDescription(rs.getString("description"));
                    house.setPhoto(rs.getString("photo"));
                    house.setPhone(rs.getString("phone"));
                    houseList.add(house);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
            return houseList ;
        }
        return null;
    }

    public static List<SignHouse> searchSign(ResultSet rs){
        SignHouse signHouse = null ;
        if( rs != null ){
            List<SignHouse> SignHouse = new ArrayList<>();
            try {
                while (rs.next()) {
                    signHouse = new SignHouse();
                    signHouse.setSid(rs.getInt("sid"));
                    signHouse.setHid(rs.getInt("hid"));
                    signHouse.setUid(rs.getString("uid"));
                    signHouse.setConnect(rs.getString("connect"));
                    signHouse.setPhone(rs.getString("phone"));
                    signHouse.setIdCard(rs.getString("idCard"));
                    signHouse.setIdImage(rs.getString("idImage"));
                    signHouse.setStime(rs.getTimestamp("stime"));
                    SignHouse.add(signHouse);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
            return SignHouse ;
        }
        return null;
    }

    public static List<House> loadBySignList(Page<SignHouse> signHousePage) {
        List<SignHouse> signHouseList = new ArrayList<>();
        signHouseList = signHousePage.getSignHouseBeanList();
        List<House> houseList = new ArrayList<>();
        String SQL = "select * from house where hid = ?";
        int hid;
        for(int i=0; i<signHouseList.size();i++) {
            try{
                hid = signHouseList.get(i).getHid();
                ResultSet rs = JDBCHelper.query( SQL , hid) ;
                House house = wrapCon(rs);
                houseList.add(house);
            }catch (Exception e) {
                System.out.println("HouseDao：通过signHouseList查询houseList失败！");
            }
        }
        return houseList;
    }

    public static Page<House> findByPage(int pageCode, int pageSize, String uid) {
        // 创建PageBean对象
        Page<House> page = new Page<House>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from  house  where uid = ?  ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL , uid) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String HouseSQL = " select *  from  house  where uid = ? order by  uid  desc limit ? , ? ";
            ResultSet HouseList = JDBCHelper.query(HouseSQL,uid, (pageCode-1)*pageSize, pageSize);
            List<House> HouseBeanList = wrapList(HouseList);
            // 把每页显示的数据设置成功了
            page.setHouseBeanList(HouseBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Page<SignHouse> SignfindByPage(int pageCode, int pageSize, String uid) {
        // 创建PageBean对象
        Page<SignHouse> page = new Page<SignHouse>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select  count(*)  from  SignHouse  where uid = ?  ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL , uid) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String HouseSQL = " select *  from  SignHouse  where uid = ? order by  uid  desc limit ? , ? ";
            ResultSet SHouseList = JDBCHelper.query(HouseSQL,uid, (pageCode-1)*pageSize, pageSize);
            List<SignHouse> SignHouseList = searchSign(SHouseList);
            // 把每页显示的数据设置成功了
            page.setSignHouseBeanList(SignHouseList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Page<House> findByPageIndex(int pageCode, int pageSize, String  keyWord) {
        // 创建PageBean对象
        Page<House> page = new Page<House>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select  count(*)  from  house  where  title  like binary '%"+keyWord+"%' or  address like binary '%"+keyWord+"%' or " +
                "  area  like binary  '%"+keyWord+"%'  or floor like binary  '%"+keyWord+"%'" +
                "  or  type like binary  '%"+keyWord+"%'  or  region like binary  '%"+keyWord+"%'" +" or  rent  like binary '%"+keyWord+"%'"+
                "  or  decoration like binary '%"+keyWord+"%'";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL ) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String HouseSQL = " select  *  from  house  where  title  like binary '%"+keyWord+"%' or  address like binary '%"+keyWord+"%' or " +
            "  area  like binary  '%"+keyWord+"%'  or floor like binary  '%"+keyWord+"%'" +
            "  or  type like binary  '%"+keyWord+"%'  or  region like binary  '%"+keyWord+"%'" +" or  rent  like binary '%"+keyWord+"%'"+
            "  or  decoration like binary '%"+keyWord+"%' order by  hid  desc limit  ? , ?  ";
            ResultSet HouseList = JDBCHelper.query(HouseSQL,(pageCode-1)*pageSize, pageSize);
            List<House> HouseBeanList = wrapList(HouseList);
            // 把每页显示的数据设置成功了
            page.setHouseBeanList(HouseBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Page<House> findByPage(int pageCode, int pageSize) {
        // 创建PageBean对象
        Page<House> page = new Page<House>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        // totalPage  计算不用处理
        // totalCount 总记录数
        // 通过uid就可以搜索他发布的二手商品，也就是说要
        String SQL = " select count(*)  from  house  ";
        try {
            long count;
            ResultSet rs = JDBCHelper.query( SQL ) ;
            if(rs.next()) {
                count = rs.getInt(1);
                page.setTotalCount((int) count);
            }
            // beanList  数据
//      通过uid就可以搜索他发布的二手商品，也就是说要 select * from usedGoods where uid = ?  order by uid  desc limit ? , ?
            String HouseSQL = " select *  from  house   order  by   hid  desc  limit ? , ? ";
            ResultSet HouseList = JDBCHelper.query(HouseSQL,(pageCode-1)*pageSize, pageSize);
            List<House> HouseBeanList = wrapList(HouseList);
            // 把每页显示的数据设置成功了
            page.setHouseBeanList(HouseBeanList);
            // 所有的数据全部都封装成功了！！
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int postHouse(House house)
    {
        int hid;
        String SQL="insert into "+tableName+" (uid,title,address,area,floor,rent,region,type,orient,environ,decoration,connect,phone,photo,description) " +
                "values('"+house.getUid()+"','"+house.getTitle()+"','"+house.getAddress()+"',"+house.getArea()+","+house.getFloor()+","+house.getRent()+",'"+house.getRegion()+"','"+house.getType()+"','"+
                house.getOrient()+"','"+house.getEnviron()+"','"+house.getDecoration()+"','"+house.getConnect()+"','"+house.getPhone()+"','"+house.getPhoto()+"','"+house.getDescription()+"')";

        hid =JDBCHelper.executeInsert(SQL);
        return hid;
    }

    public boolean updateHouse(House house) {
        String SQL = " update "+ tableName+ " set title=?, address=?,area=?,floor=?,rent=?,region=?,type=?,orient=?,environ=?,decoration=?,connect=?,phone=?,photo=?,description=? where hid = ? " ;
        return JDBCHelper.execute( SQL , house.getTitle(),house.getAddress(),house.getArea(),house.getFloor(),house.getRent(),house.getRegion(),house.getType(), house.getOrient(),house.getEnviron(),house.getDecoration(),house.getConnect(),house.getPhone(),house.getPhoto(),house.getDescription(),house.getHid()) ;
    }

    public boolean deleteByHid(int hid) {
        String SQL = " delete * from "+ tableName+ " where hid = ? " ;
        return JDBCHelper.execute( SQL , hid ) ;
    }

    public House loadByHid(int hid) throws Exception {
        String SQL = "select * from house where hid = " + hid;
        House house = new House();
        ResultSet rs = JDBCHelper.query(SQL);
        while (rs.next()) {
            house.setHid(rs.getInt("hid"));
            house.setUid(rs.getString("uid"));
            house.setStatus(rs.getInt("status"));
            house.setAddress(rs.getString("address"));
            house.setArea(rs.getInt("area"));
            house.setFloor(rs.getInt("floor"));
            house.setRent(rs.getInt("rent"));
            house.setRegion(rs.getString("region"));
            house.setType(rs.getString("type"));
            house.setOrient(rs.getString("orient"));
            house.setEnviron(rs.getString("environ"));
            house.setDecoration(rs.getString("decoration"));
            house.setConnect(rs.getString("connect"));
            house.setTitle(rs.getString("title"));
            house.setDescription(rs.getString("description"));
            house.setPhoto(rs.getString("photo"));
            house.setPhone(rs.getString("phone"));
        }
        return house;
    }

    public List<House> load(int num) throws Exception {
        String SQL="(select * from "+tableName+" ) "+" order by hid desc limit "+num;
        List<House> houseList = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(SQL);
        if( rs != null ) {
            try {
                while (rs.next()) {
                    House house=new House();
                    house.setHid(rs.getInt("hid"));
                    house.setUid(rs.getString("uid"));
                    house.setStatus(rs.getInt("status"));
                    house.setAddress(rs.getString("address"));
                    house.setArea(rs.getInt("area"));
                    house.setFloor(rs.getInt("floor"));
                    house.setRent(rs.getInt("rent"));
                    house.setRegion(rs.getString("region"));
                    house.setType(rs.getString("type"));
                    house.setOrient(rs.getString("orient"));
                    house.setEnviron(rs.getString("environ"));
                    house.setDecoration(rs.getString("decoration"));
                    house.setConnect(rs.getString("connect"));
                    house.setTitle(rs.getString("title"));
                    house.setDescription(rs.getString("description"));
                    house.setPhoto(rs.getString("photo"));
                    house.setPhone(rs.getString("phone"));
                    houseList.add(house);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return houseList;
    }

    public SignHouse searchSignHouse(int sid) {
        SignHouse signHouse = new SignHouse();
        String SQL = "select * from signhouse where sid = ? ";
        ResultSet rs = JDBCHelper.query(SQL,sid);
        try{
            while(rs.next()){
                signHouse.setSid(sid);
                signHouse.setUid(rs.getString("uid"));
                signHouse.setHid(rs.getInt("hid"));
                signHouse.setConnect(rs.getString("connect"));
                signHouse.setPhone(rs.getString("phone"));
                signHouse.setIdCard(rs.getString("idCard"));
                signHouse.setIdImage(rs.getString("idImage"));
                signHouse.setStime(rs.getTimestamp("stime"));
                signHouse.setTimeStart(rs.getTimestamp("stime"));
            }
        } catch (Exception e) {
            System.out.println("HouseDao：searchSignHouse failed！");
        }
        return signHouse;
    }

    private static House wrapCon (ResultSet rs ){
        House house = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    house = new House();
                    house.setHid(rs.getInt("hid"));
                    house.setUid(rs.getString("uid"));
                    house.setStatus(rs.getInt("status"));
                    house.setAddress(rs.getString("address"));
                    house.setArea(rs.getInt("area"));
                    house.setFloor(rs.getInt("floor"));
                    house.setRent(rs.getInt("rent"));
                    house.setRegion(rs.getString("region"));
                    house.setType(rs.getString("type"));
                    house.setOrient(rs.getString("orient"));
                    house.setEnviron(rs.getString("environ"));
                    house.setDecoration(rs.getString("decoration"));
                    house.setConnect(rs.getString("connect"));
                    house.setTitle(rs.getString("title"));
                    house.setDescription(rs.getString("description"));
                    house.setPhoto(rs.getString("photo"));
                    house.setPhone(rs.getString("phone"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return house ;
    }

    public House loadByCondition(String region, int area, int floor, int rent, int type, String decoration) {
        String SQL = " select * from "+ tableName + " where region like binary '%?%' and  " +
                "area like binary '%?%'  and floor like binary  '%?%' and rent like binary '%?%'  and  type like binary " +
                " '%type%' and  decoration like binary '%?%'";
        ResultSet rs = JDBCHelper.query(SQL,decoration,area,floor,rent,type,decoration);
        House house = wrapCon(rs);
        return  house;
    }

    public int signHouse(SignHouse signHouse) {
        int sid;
        String SQL="insert into signhouse (hid, uid, connect, phone, idCard, idImage) " +
                "values("+signHouse.getHid()+",'"+signHouse.getUid()+"','"+signHouse.getConnect()+"','"+signHouse.getPhone()+
                "','"+signHouse.getIdCard()+"','"+signHouse.getIdImage()+"')";
        String sql =" update house set gstatus = 1 where hid = ? ";
        JDBCHelper.execute(sql,signHouse.getHid());
        sid =JDBCHelper.executeInsert(SQL);
        return sid;
    }

    public List<House> recommedHouses(int num, int hid, String region,int rent) {
        String SQL="select * from "+tableName+" where region = ? and rent between ? and ? and hid <> ? order by hid desc limit "+num;
        ResultSet rs = JDBCHelper.query(SQL,region,rent-500,rent+500,hid);
        List<House> houseList = new ArrayList<>();
        houseList = wrapList(rs, houseList);
        int size = houseList.size();
        if(size<num){
            SQL = "select * from "+tableName+" where region = ? and hid not in( ";
            if(size>0) {
                for(int i=0; i<size; i++)
                    SQL = SQL + houseList.get(i).getHid() + " , ";
            }
            SQL = SQL + hid;
            num = num-size;
            SQL = SQL + " ) order by hid desc limit "+ num;
            rs = JDBCHelper.query(SQL,region);
            houseList = wrapList(rs, houseList);
        }
        return houseList;
    }
}
