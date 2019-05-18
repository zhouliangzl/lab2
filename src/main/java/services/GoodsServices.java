package services;

import dao.GoodsDao;
import javaBean.Goods;
import javaBean.Page;

import java.util.List;

public class GoodsServices {
    GoodsDao goodsDao = new GoodsDao();

    public Goods loadByGid(int gid ){
        return goodsDao.loadByGid(gid);
    }

    public List<Goods> recommedGoods(int num ,int gid, String type) {
        return goodsDao.recommedGoods(num,gid,type);
    }

    public Page<Goods> findByPage(int pageCode, int pageSize , String  uid){
        return goodsDao.findByPage(pageCode, pageSize, uid);
    }

    public Page<Goods> findByPageIndex(int pageCode, int pageSize, String keyword) {
        return goodsDao.findByPageIndex(pageCode, pageSize, keyword);
    }

    public int postGoods(Goods goods){
        return GoodsDao.postGoods( goods );
    }

    public boolean UpdateByGid(Goods goods) {
        return GoodsDao.UpdateByGid( goods );
    }

    public boolean deleteByGid(int gid) {
        return GoodsDao.deleteByGid(gid);
    }

    public Page<Goods> indexFindByPage(int pageCode, int pageSize) {
        return goodsDao.indexFindByPage(pageCode, pageSize);
    }

    public List<Goods> load(int num) {
        return goodsDao.load(num);
    }
}
