package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class QuesUserCon {
    /**
     * 用户 id
     */
    private int userId;
    /**
     * 用户简介
     */
    private String userJianjie;
    /**
     * 用户角色
     */
    private int userRole;
    /**
     * 用户头像
     */
    private String userPhoto;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 问题 id
     */
    private int quesId;
    /**
     * 提问用户 id
     */
    private int quesUserId;
    /**
     * 提问标题
     */
    private String quesTitle;
    /**
     * 提问内容
     */
    private String  quesContent;
    /**
     * 问题回答数
     */
    private int quesAnsCount;
    /**
     * 提问时间
     */
    private Date quesCreateDate;
    /**
     * 提问收藏数
     */
    private int quesCollectCount;
    /**
     * 是否匿名 0-不匿名   1-匿名
     */
    private int quesNiming;
    /**
     * 删除标志
     */
    private int quesDel;
    /**
     * 问题标签
     */
    private String quesTag;
}
