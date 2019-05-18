package services;

import dao.AdDao;
import javaBean.Ad;

public class AdService {
    AdDao adDao=new AdDao();
    public int postAd(Ad ad)
    {
        return adDao.postAd(ad);
    }
    public Ad adDetile(int apid) throws Exception {
        return adDao.adDetile(apid);
    }
    public int[] getAllAdpos() throws Exception {
        return  adDao.getAllAdpos();
    }
    public int[] getAllApid() throws Exception
    {
        return adDao.getAllApid();
    }

    public boolean updateAd(int apid,String title,String content,String aimage)
    {
        return adDao.updateAd(apid,title,content,aimage);
    }
}
