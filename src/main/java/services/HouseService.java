package services;

import dao.HouseDao;
import javaBean.House;
import javaBean.Page;
import javaBean.SignHouse;

import java.util.List;

public class HouseService {
    HouseDao houseDao=new HouseDao();

    public List<House> load(int num) throws Exception{
        return houseDao.load(num);
    }

    public List<House> recommedHouses(int num, int hid, String region,int rent) {
        return houseDao.recommedHouses(num, hid, region, rent);
    }

    public House loadByHid(int hid) throws Exception {
        return houseDao.loadByHid(hid);
    }
//region, area, floor, rent, type, decoration
    public House searchByCondition(String region, int area, int floor, int type, int rent, String decoration){
        return houseDao.loadByCondition(region, area, floor, rent, type, decoration);

    }

    public int signHouseService(SignHouse signHouse) {
        return houseDao.signHouse(signHouse);
    }

    public SignHouse searchSignHouseService(int sid ){
        return houseDao.searchSignHouse(sid);
    }

    public int postHouseService(House house)
    {
        return houseDao.postHouse(house);
    }

    public boolean updateHouseService(House house) {
        return houseDao.updateHouse(house);
    }

    public boolean deleteByHidService(int hid) {
        return houseDao.deleteByHid(hid);
    }

    public Page<House> findByPage(int pageCode, int pageSize, String uid) {
        return HouseDao.findByPage(pageCode, pageSize, uid);
    }
    public Page<House> findByPage(int pageCode, int pageSize){
        return HouseDao.findByPage(pageCode, pageSize);
    }

    public Page<SignHouse> SignfindByPage(int pageCode, int pageSize, String uid) {
        return HouseDao.SignfindByPage(pageCode, pageSize, uid);
    }

    public List<House> loadBySignList(Page<SignHouse> page) {
        return HouseDao.loadBySignList(page);
    }

    public Page<House> findByPageIndex(int pageCode, int pageSize, String keyWord) {
        return HouseDao.findByPageIndex(pageCode, pageSize, keyWord);
    }

 }
