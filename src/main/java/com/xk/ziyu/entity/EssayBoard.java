package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 文章留言信息

* @Author: wanghaixue

* @CreateDate: 2019/2/18 22:08

* @Version: 1.0

*/
@Data
public class EssayBoard {
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
}
