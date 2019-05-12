package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 用户信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 12:10

* @Version: 1.0

*/
@Data
public class User {
    /**
     * 用户 id
     */
    private int userId;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户简介
     */
    private String userJianjie;
    /**
     * 用户状态
     */
    private int userStatus;
    /**
     * 用户角色
     */
    private int userRole;
    /**
     * 用户头像
     */
    private String userPhoto;
    /**
     * 用户性别
     */
    private int userGender;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户粉丝数
     */
    private int userFansCount;
    /**
     * 用户关注数
     */
    private int userFollowCount;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 用户回答总数
     */
    private int userAnswerCount;
    /**
     * 用户收藏问题总数
     */
    private int userCollectCount;
    /**
     * 用户注册时间
     */
    private Date userCreateDate;
    /**
     * 用户最新修改时间
     */
    private Date userUpdateDate;
    /**
     * 用户 Token
     */
    private String userToken;
    /**
     * 用户删除标志
     */
    private Integer userDel;
    /**
     * 用户提问总数
     */
    private Integer userQuesCount;
}