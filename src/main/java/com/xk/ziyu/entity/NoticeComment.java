package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 公告评论信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 10:51

* @Version: 1.0

*/
@Data
public class NoticeComment {
    /**
     * 公告评论 id
     */
    private int ncId;
    /**
     * 发布公告评论的用户 id
     */
    private int ncUserId;
    /**
     * 评论内容
     */
    private String ncContent;
    /**
     * 评论点赞数
     */
    private int ncAgreeCount;
    /**
     * 发表评论时间
     */
    private Date ncCreateDate;
    /**
     * 被评论的公告 id
     */
    private int ncNoticeId;
    /**
     * 删除标志
     */
    private int ncDel;
}
