package com.xk.ziyu.service;

import com.xk.ziyu.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    /**
     * 根据 id 获取用户
     * @param id
     * @return
     */
    public User getUser(int id);

    public int getCount();

    public List<User> getAll(int pageNum, int pageSize);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 添加一个新用户
     * @param username
     * @param password
     * @return
     */
    public int addUser(String username, String password);

    /**
     * 检测用户输入的登录信息是否正确，正确返回 token，错误返回 null
     * @param username
     * @param password
     * @return
     */
    public String checkUser(String username, String password);

    /**
     * 获取被关注的用户
     * @param id
     * @return
     */
    public List<User> getUserFans(int id);

    /**
     * 获取关注的用户
     * @param id
     * @return
     */
    public List<User> getUserFollowed(int id);

    /**
     * 修改用户信息
     * @param id
     * @param name
     * @param address
     * @param gender
     * @param jianjie
     * @return
     */
    public int updateUser(int id, String name, String address, int gender, String jianjie);

    /**
     * 修改头像
     * @param id
     * @param path
     * @return
     */
    public int updatePhoto(int id, String path);

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    public int updatePwd(int id, String pwd);

    /**
     * 查看是否有关注记录
     * @param followId
     * @param followedId
     * @return  0 未关注   1 已关注
     */
    public int isFollow(int followId, int followedId);

    /**
     * 关注
     * @param followId
     * @param followedId
     * @return
     */
    public int follow(Integer followId, Integer followedId);

    /**
     * 取消关注
     * @param followId
     * @param followedId
     * @return
     */
    public int cancelFollow(Integer followId, Integer followedId);
}
