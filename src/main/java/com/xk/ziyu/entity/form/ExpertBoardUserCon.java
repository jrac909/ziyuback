package com.xk.ziyu.entity.form;

import lombok.Data;

import java.util.Date;

@Data
public class ExpertBoardUserCon {
    /**
     * 用户 id
     */
    private int userId;
    /**
     * 用户角色
     */
    private int userRole;
    /**
     * 用户头像
     */
    private String userPhoto;
    /**
     * 用户性别
     */
    private int userGender;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 用户删除标志
     */
    private Integer userDel;
    /**
     * 专家留言 id
     */
    private int ebId;
    /**
     * 留言内容
     */
    private String ebContent;
    /**
     * 留言时间
     */
    private Date ebCreateDate;
    /**
     * 专家 id
     */
    private int ebExpertId;
    /**
     * 留言删除标志
     */
    private int ebDel;
}
