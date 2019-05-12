package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 公告消息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 10:08

* @Version: 1.0

*/
@Data
public class Notice {
    /**
     * 公告 id
     */
    private int noticeId;
    /**
     * 公告标题
     */
    private String noticeTitle;
    /**
     * 发布公告管理员 id
     */
    private int noticeAdminId;
    /**
     * 公告内容
     */
    private String noticeContent;
    /**
     * 公告点赞总数
     */
    private int noticeAgreeCount;
    /**
     * 公告评论总数
     */
    private int noticeCommentCount;
    /**
     * 公告发布时间
     */
    private Date noticeCreateDate;
    /**
     * 公告修改时间
     */
    private Date noticeUpdateDate;
    /**
     * 删除标志
     */
    private int NoticeDel;
}
