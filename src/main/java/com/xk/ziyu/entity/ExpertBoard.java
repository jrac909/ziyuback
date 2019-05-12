package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 专家留言板

* @Author: wanghaixue

* @CreateDate: 2019/2/18 22:41

* @Version: 1.0

*/
@Data
public class ExpertBoard {
    /**
     * 专家留言 id
     */
    private int ebId;
    /**
     * 留言用户 id
     */
    private int ebUserId;
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
