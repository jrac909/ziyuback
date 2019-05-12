package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**
 * 专家留言板回复表
 */
@Data
public class ExpertReply {
    /**
     * 回复 ID
     */
    private int erId;
    /**
     * 被回复用户 ID
     */
    private int erCommentId;
    /**
     * 回复专家 ID
     */
    private int erExpertId;
    /**
     * 回复内容
     */
    private String erContent;
    /**
     * 回复时间
     */
    private Date erCreateDate;
    /**
     * 回复删除标志
     */
    private int erDel;
}
