package javaBean;

import java.sql.Timestamp;
import java.util.Calendar;

public class SignHouse {
    private int sid;
    private int hid;
    private String uid;
    private  String connect;
    private  String phone;
    private  String idCard;
    private String idImage;
    private Timestamp stime;
    private Calendar timeStart = Calendar.getInstance();

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public Timestamp getStime() {
        return stime;
    }

    public void setStime(Timestamp stime) {
        this.stime = stime;
    }

    public Calendar getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp stime) {
        try {
            this.timeStart.setTime(stime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
