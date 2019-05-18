package services;

import dao.UserDao;
import javaBean.Page;
import javaBean.User;
import utils.MySendMailThread;
import utils.StringHelper;

public class UserServices {
    UserDao userDao = new UserDao() ;

    public boolean active(String name) {
        User u = new User();
        return userDao.UpdateActive(name);
    }

    /**
     * 根据用户名和密码检查是否存在这个用户
     * @param username
     * @param password
     * @return true 表示存在，false 表示不存在
     */
    public boolean load( String username , String password ){
        User u = userDao.loadByUsername( username ) ;
        if( u != null ){
            // 验证密码
            String userPassword = u.getPassword();
            // 判断两次密码是否相等
            if( userPassword.equals( StringHelper.encrypt( password ) ) ){
                return true ;
            }
        }
        return false ;
    }
     //根据用户名查询当前注册的用户是否唯一
    public boolean isUnique( String uid ){
        // 拿到 uid 去数据库中查询 ，如果有 ，证明 不可以注册， 返回 false
        User u = userDao.loadByUsername( uid ) ;
        if( u != null ){
            return false ;
        }
        return true ;
    }
    //注册的方法
    public boolean regist( User user ){
        new MySendMailThread( user ).run();
        return userDao.insert( user );
    }

    public User login(String uid, String password)
    {
        return userDao.loginBydb(uid,password);
    }

    public User searchByUid(String uid){
        return userDao.searchByUid(uid);
    }

    public Boolean deleteByUidService(String uid) {
        return userDao.deleteByUid(uid);
    }

    public boolean updateService(User user){
        return userDao.update(user);
    }

    public Page<User> findByPage(int pageCode, int pageSize){
        return userDao.findByPage(pageCode, pageSize);
    }

}
