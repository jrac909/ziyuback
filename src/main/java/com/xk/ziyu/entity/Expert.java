package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 专家信息

* @Author: wanghaixue

* @CreateDate: 2019/2/18 22:29

* @Version: 1.0

*/
@Data
public class Expert {
    /**
     * 专家 id
     */
    private int expertId;
    /**
     * 专家的账号 id
     */
    private  int expertUserId;
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
     * 审核状态：0审核中 1审核通过
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
