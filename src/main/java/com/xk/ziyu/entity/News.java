package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 消息信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 9:54

* @Version: 1.0

*/
@Data
public class News {
    /**
     * 消息 id
     */
    private int newId;
    /**
     * 消息发送 id
     */
    private int newSendId;
    /**
     * 接收消息 id
     */
    private int newReceiveId;
    /**
     * 消息类型
     */
    private int newType;
    /**
     * 消息内容
     */
    private String newContent;
    /**
     * 发送消息时间
     */
    private Date newDate;
}
