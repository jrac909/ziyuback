package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 问题回答回复信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 11:43

* @Version: 1.0

*/
@Data
public class QuestionReplyUser {
    /**
     * 回复 id
     */
    private int qruId;
    /**
     * 回复用户 id
     */
    private int qruUserId;
    /**
     * 被回复用户 id
     */
    private int qruUseredId;
    /**
     * 回复评论 id
     */
    private int qruCommentId;
    /**
     * 回复时间
     */
    private Date qruCreateDate;
    /**
     * 回复内容
     */
    private String qruContent;
    /**
     * 删除标志
     */
    private int qruDel;
    /**
     * 问题id
     */
    private int qruQuesId;
}
