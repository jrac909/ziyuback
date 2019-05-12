package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 专家和用户 join

* @Author: wanghaixue

* @CreateDate: 2019/3/4 21:43

* @Version: 1.0

*/
@Data
public class ExpertUserCon {
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
     * 专家 id
     */
    private int expertId;
    /**
     * 专家的账号 id
     */
    private int expertUserId;
    /**
     * 专家入驻时间
     */
    private Date expertCreateDate;
    /**
     * 专家服务人数
     */
    private int expertServeCount;
    /**
     * 专家资历
     */
    private String expertStatus;
    /**
     * 专家资历说明
     */
    private String expertStatusDetail;
    /**
     * 专家真实姓名
     */
    private String expertTrueName;
    /**
     * 第一个擅长领域
     */
    private String expertFieldFirst;
    /**
     * 第二个擅长领域
     */
    private String expertFieldSecond;
    /**
     * 第三个擅长领域
     */
    private String expertFieldThird;
    /**
     * 擅长领域说明
     */
    private String expertFieldDetail;
    /**
     * 专家说明
     */
    private String expertShuoming;
    /**
     * 审核状态：0 审核中  1 已通过
     */
    private int expertShenhe;
    /**
     * 咨询面向用户
     */
    private String expertUserType;
    /**
     * 删除标志
     */
    private int expertDel;
}
