package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 管理员信息

* @Author: wanghaixue

* @CreateDate: 2019/2/18 20:28

* @Version: 1.0

*/
@Data
public class Admin {
    /**
     * 管理员 ID
     */
    private int adminId;
    /**
     * 管理员账号（登录账号）
     */
    private  String adminAccount;
    /**
     * 管理员头像
     */
    private String adminPhoto;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 管理员姓名（其实就是昵称）
     */
    private String adminName;
    /**
     * 管理员简介（个人说明）
     */
    private String adminJianjie;
    /**
     * 管理员更新信息时间
     */
    private Date adminUpdateDate;
    /**
     * 管理员 Token
     */
    private String adminToken;
    /**
     * 管理员角色
     */
    private String adminRole;
}
