package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 问题信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 11:32

* @Version: 1.0

*/
@Data
public class Question {
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
