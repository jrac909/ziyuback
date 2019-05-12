package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EsComUserCon {
    /**
     * 文章留言 id
     */
    private int ebId;
    /**
     * 留言用户 id
     */
    private int ebUserId;
    /**
     *
     * 留言内容
     */
    private String ebComment;
    /**
     * 留言时间
     */
    private Date ebCreateDate;
    /**
     * 删除标志
     */
    private int ebDel;
    /**
     * 文章 id
     */
    private int ebEssayId;
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
}
