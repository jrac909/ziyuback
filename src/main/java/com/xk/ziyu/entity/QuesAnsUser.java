package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 问题回答信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 11:16

* @Version: 1.0

*/
@Data
public class QuesAnsUser {
    /**
     * 回答 id
     */
    private int qauId;
    /**
     * 回答用户 id
     */
    private int qauUserId;
    /**
     * 回答内容
     */
    private String qauComment;
    /**
     * 回答时间
     */
    private Date qauCreateDate;
    /**
     * 问题 ID
     */
    private int qauQuesId;
    /**
     * 删除标志
     */
    private int qauDel;
}
