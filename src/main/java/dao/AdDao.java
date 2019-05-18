package dao;

import javaBean.Ad;
import utils.JDBCHelper;

import java.sql.ResultSet;

public class AdDao {
    String tableName=" ad ";
    public int postAd(Ad ad)
    {
        String SQL="insert into"+tableName+"(apid,uid,title,aimage,content,money) values( "+ad.getApid()+",'"+ad.getUid()+"','"+ad.getTitle()+"','"+ad.getAimage()+"','"+ad.getContent()+"','"+ad.getMoney()+"' )";
        int aid = 0;
        aid = JDBCHelper.executeInsert(SQL);
        return aid;
    }
    public Ad adDetile(int apid) throws Exception
    {
            String SQL="select aid,apid,uid,title,aimage,content,click,comp,money,atime from"+tableName+"where apid=?";
            ResultSet rs = JDBCHelper.query(SQL,apid);
            return wrapOne(rs);
        }

    private Ad wrapOne(ResultSet rs) throws Exception
    {
        Ad ad=new Ad();
        if(rs!=null)
        {
            while (rs.next())
            {
                ad.setAid(rs.getInt("aid"));
                ad.setApid(rs.getInt("apid"));
                ad.setUid(rs.getString("uid"));
                ad.setTitle(rs.getString("title"));
                ad.setAimage(rs.getString("aimage"));
                ad.setContent(rs.getString("content"));
                ad.setClick(rs.getInt("click"));
                ad.setComp(rs.getInt("comp"));
                ad.setMoney(rs.getInt("money"));
                ad.setAtime(rs.getTimestamp("atime"));
            }
        }

        return ad;
    }

        private Ad[] wrap(ResultSet rs) throws Exception
        {
            Ad[] ads=new Ad[5];
            if(rs!=null)
            {
                int i=0;
                while (rs.next())
                {
                   Ad ad=new Ad();
                   ad.setAid(rs.getInt("aid"));
                   ad.setApid(rs.getInt("apid"));
                   ad.setUid(rs.getString("uid"));
                   ad.setTitle(rs.getString("title"));
                   ad.setAimage(rs.getString("aimage"));
                   ad.setContent(rs.getString("content"));
                   ad.setClick(rs.getInt("click"));
                   ad.setComp(rs.getInt("comp"));
                   ad.setMoney(rs.getInt("money"));
                   ad.setAtime(rs.getTimestamp("atime"));
                   ads[i]=ad;
                   i++;
                }
            }
            return ads;
        }

        public int[] getAllAdpos() throws Exception
        {

            String SQL="select hid from house";
            String SQL2="select gid from usedgoods";
            ResultSet rs = JDBCHelper.query(SQL);
            ResultSet rs2 = JDBCHelper.query(SQL2);
            return  wrapAdposs(rs,rs2);
        }

    private int[] wrapAdposs(ResultSet rs,ResultSet rs2) throws Exception
    {
        int[] adposs=new int[2000];
        int i=0;
        if(rs!=null)
        {
            while (rs.next())
            {

                adposs[i]=rs.getInt("hid");
                i++;
            }
        }
        if(rs2!=null)
        {
            while (rs2.next())
            {
                adposs[i]=rs2.getInt("gid")+20000;
                i++;
            }
        }
        return adposs;
    }

    public int[] getAllApid() throws Exception
    {
        String SQL="select apid from ad";
        ResultSet rs = JDBCHelper.query(SQL);
        return  wrapApid(rs);
    }

    private int[] wrapApid(ResultSet rs) throws Exception
    {
        int[] apid=new int[2000];
        int i=0;
        if(rs!=null)
        {
            while (rs.next())
            {

                apid[i]=rs.getInt("apid");
                i++;
            }
        }
        return apid;
    }

    public boolean updateAd(int apid,String title,String content,String aimage)
    {
        String SQL="update ad set title=?,content=?,aimage=? where apid=?";
        boolean isUpdateAd=JDBCHelper.execute(SQL,title,content,aimage,apid);
        return isUpdateAd;

    }

}

