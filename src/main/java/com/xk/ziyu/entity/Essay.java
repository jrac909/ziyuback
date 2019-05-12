package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 文章信息

* @Author: wanghaixue

* @CreateDate: 2019/2/18 21:46

* @Version: 1.0

*/
@Data
public class Essay {
    /**
     * 文章 id
     */
    private int essayId;
    /**
     * 文章标题
     */
    private String essayTitle;
    /**
     * 文章内容
     */
    private String essayContent;
    /**
     * 发布文章的用户 id
     */
    private int essayUserId;
    /**
     * 发布文章的时间
     */
    private Date essayCreateDate;
    /**
     * 文章获赞数
     */
    private int essayAgreeCount;
    /**
     * 文章收藏数
     */
    private int essayCollectCount;
    /**
     * 删除标志
     */
    private int essayDel;
    /**
     * 作者用户名
     */
    private String essayUsername;
}
