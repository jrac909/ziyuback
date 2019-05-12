package com.xk.ziyu.dao;

import com.xk.ziyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserDao {

    List<User>  selectAllUser();

    /**
     * 根据名字获取用户 
     * @param username
     * @return
     */
    User selectByName(@Param("username") String username);

    /**
     * 根据 id 查询用户
     * @param id
     * @return
     */
    User selectUser(@Param("id") Integer id);

    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name, @Param("type") String type, @Param("jinyong") String jinyong);

    /**
     * 根据关键字查找用户
     * @param name
     * @return
     */
    List<User> selectByKeywords(@Param("name") String name, @Param("type") Integer type, @Param("jinyong") String jinyong);


    /**
     * 删除指定 id 回答
     * @return
     */
    int del(@Param("id") Integer id, @Param("type") Integer type);

    /**
     * 添加一个用户（用户注册）
     * @param username
     * @param password
     * @param nickname
     * @param date
     * @return
     */
    int addUser(@Param("username") String username, @Param("password") String password, @Param("nickname") String nickname, @Param("photo") String photo, @Param("date") Date date);

    /**
     * 获取指定用户粉丝列表
     * @param id
     * @return
     */
    List<User> getUserFans(@Param("id") Integer id);

    /**
     * 获取指定用户关注列表
     * @param id
     * @return
     */
    List<User> getUserFollowed(@Param("id") Integer id);

    /**
     * 修改用户信息
     * @param id
     * @param name
     * @param address
     * @param gender
     * @param jianjie
     * @return
     */
    public int updateUser(@Param("id") Integer id, @Param("name") String name, @Param("address") String address, @Param("gender") Integer gender, @Param("jianjie") String jianjie);

    /**
     * 修改头像
     * @param id
     * @param path
     * @return
     */
    public int updatePhoto(@Param("id") Integer id, @Param("path") String path);

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    public int updatePwd(@Param("id") Integer id, @Param("pwd") String pwd);

    /**
     * 查看是否有关注记录
     * @param followId
     * @param followedId
     * @return  0 未关注   1 已关注
     */
    public int isFollow(@Param("followId") Integer followId, @Param("followedId") Integer followedId);

    /**
     * 关注
     * @param followId
     * @param followedId
     * @return
     */
    public int follow(@Param("followId") Integer followId, @Param("followedId") Integer followedId);

    /**
     * 取消关注
     * @param followId
     * @param followedId
     * @return
     */
    public int cancelFollow(@Param("followId") Integer followId, @Param("followedId") Integer followedId);
}
