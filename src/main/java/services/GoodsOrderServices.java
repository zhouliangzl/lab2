package services;

import dao.GoodsOrderDao;
import javaBean.GoodsOrder;
import javaBean.Page;

import java.sql.SQLException;

public class GoodsOrderServices {

    GoodsOrderDao goodsOrderDao = new GoodsOrderDao();
//    name, address, phone, goods.getGimage(), goods.getGid(), user.getUid()
    public int insertService(GoodsOrder goodsOrder) throws SQLException, ClassNotFoundException {
        return GoodsOrderDao.insert(goodsOrder);
    }

    public boolean DeleteGoodsOrder(int oid) {
        return GoodsOrderDao.DeleteGoodsOrder(oid);
    }


    public Page<GoodsOrder> findByPage(int pageCode, int pageSize, String uid) {
        return goodsOrderDao.findByPage(pageCode, pageSize, uid);
    }

//    pageCode, pageSize ,user.getUid(),sortByTime,keyWord,date
    public Page<GoodsOrder> findByPage(int pageCode, int pageSize,
      String uid, String sortTime, String date ) {
        return goodsOrderDao.findByPage(pageCode, pageSize, uid, sortTime, date);
    }
// keyword
    public Page<GoodsOrder> findByPage2(int pageCode, int pageSize, String uid, String keyword) {
        return goodsOrderDao.findByPage2(pageCode, pageSize, uid , keyword);
    }

    public GoodsOrder loadByUid(String uid) {
        return goodsOrderDao.loadByUid(uid);
    }

}
