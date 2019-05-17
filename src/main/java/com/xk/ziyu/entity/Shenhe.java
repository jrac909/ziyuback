package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 审核相关数据，对应审核表 shenhe

* @Author: wanghaixue

* @CreateDate: 2019/5/17 22:15

* @Version: 1.0

*/
@Data
public class Shenhe {
    /**
     * 编号 id
     */
    private int id;
    /**
     * 资格证书等级
     */
    private String quaLevel;
    /**
     * 拿证书时间
     */
    private String reportingTime;
    /**
     * 证书名称
     */
    private String occupation;
    /**
     * 证书编号
     */
    private String certificateNo;
    /**
     * 用户提交的资历
     */
    private String zili;
    /**
     * 用户提交的擅长领域描述
     */
    private String zilidesc;
    /**
     * 用户提交的面向对象
     */
    private String client;
    /**
     * 用户id
     */
    private int userid;
    /**
     * 审核状态 0 审核中  1 已通过   2 未通过
     */
    private int status;
    /**
     * 提交审核的时间
     */
    private Date begintime;
    /**
     * 资格证书图片路径
     */
    private String photo;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String idcard;
}
