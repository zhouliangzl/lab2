package javaBean;

import java.util.Date;

/**
 * 这是一个实体类，用来表示一个用户，与之对应的数据库表中 的一条记录
 * 也就是说 在数据库中有一条记录，那么就表示成一个 User对象

 -- MySQL
 CREATE TABLE user
 (
     uid varchar(11) primary key , -- 账号
     type int not null,            -- 类型
     name varchar(50),             -- 昵称
     email varchar(50),            -- 邮箱
     password varchar(30),         -- 密码
     active char(1),               --邮箱验证激活
     coin int                      -- 金币
 );
 */
public class User {
    private String uid ;
    private int type ;
    private String name ;
    private String email ;
    private String password ;
    private String active;
    private int coin ;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return true;
    }

}
