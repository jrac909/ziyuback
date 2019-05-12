package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.UserDao;
import com.xk.ziyu.entity.User;
import com.xk.ziyu.service.UserService;
import com.xk.ziyu.util.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    /**
     * 根据 id 获取用户
     * @param id
     * @return
     */
    @Override
    public User getUser(int id) {
        return userDao.selectUser(id);
    }

    @Override
    public int getCount() {
        return userDao.selectCount();
    }

    @Override
    public List<User> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        userList = pageInfo.getList();
        return userList;
    }

    @Override
    public User getUserByName(String username) {
        return userDao.selectByName(username);
    }

    /**
     * 添加一个新用户 nickname 默认为用户+账号
     * @param username 账号（手机号）
     * @param password 密码
     * @return
     */
    @Override
    public int addUser(String username, String password) {
        return userDao.addUser(username, password, "用户"+username, "/static/image/img1.jpg", new Date());
    }

    /**
     * 检测用户输入的登录信息是否正确，正确返回 token，错误返回 null
     * @param username
     * @param password
     * @return
     */
    public String checkUser(String username, String password){
        String token = null;
        User user = userDao.selectByName(username);
        if (user.getUserPassword().trim().equals(password)){
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("username", user.getUserAccount());
            token = JavaWebToken.createJavaWebToken(m);
        }
        return token;
    }

    @Override
    public List<User> getUserFans(int id) {
        return userDao.getUserFans(id);
    }

    @Override
    public List<User> getUserFollowed(int id) {
        return userDao.getUserFollowed(id);
    }

    @Override
    public int updateUser(int id, String name, String address, int gender, String jianjie) {
        return userDao.updateUser(id, name, address, gender, jianjie);
    }

    @Override
    public int updatePhoto(int id, String path) {
        return userDao.updatePhoto(id, path);
    }

    @Override
    public int updatePwd(int id, String pwd) {
        return userDao.updatePwd(id, pwd);
    }

    @Override
    public int isFollow(int followId, int followedId) {
        return userDao.isFollow(followId, followedId);
    }

    @Override
    public int follow(Integer followId, Integer followedId) {
        return userDao.follow(followId, followedId);
    }

    @Override
    public int cancelFollow(Integer followId, Integer followedId) {
        return userDao.cancelFollow(followId, followedId);
    }
}
