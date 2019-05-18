package javaBean;


import java.sql.Timestamp;
import java.util.Date;

public class GoodsOrder {
    private int oid;
    private int gid;
    private String uid;
    private Timestamp otime;
    private int ostatus;
    private String name;
    private String address;
    private String phone;
    private String oimage;
    private int price;

    public GoodsOrder() {
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getOstatus() {
        return ostatus;
    }

    public void setOstatus(int ostatus) {
        this.ostatus = ostatus;
    }

    public Timestamp getOtime() {
        Date new_date = new Date();
        try {
            new_date = this.otime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otime;
    }

    public void setOtime(Timestamp otime) {
        this.otime = otime;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOimage() {
        return oimage;
    }

    public void setOimage(String oimage) {
        this.oimage = oimage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
