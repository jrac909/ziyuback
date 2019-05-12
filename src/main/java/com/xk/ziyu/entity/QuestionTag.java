package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 问题标签信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 12:00

* @Version: 1.0

*/
@Data
public class QuestionTag {
    /**
     * 标签 id
     */
    private int qtId;
    /**
     * 标签名
     */
    private String qtName;
    /**
     * 创建标签时间
     */
    private Date qtCreateDate;
    /**
     * 修改标签时间
     */
    private Date qtUpdateDate;
    /**
     * 删除标志
     */
    private int qtDel;
}
