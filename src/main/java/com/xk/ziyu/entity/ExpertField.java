package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 专家擅长领域信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 9:40

* @Version: 1.0

*/
@Data
public class ExpertField {
    /**
     * 领域 id
     */
    private int efId;
    /**
     * 领域名称
     */
    private String efName;
    /**
     * 领域创建时间
     */
    private Date efCreateDate;
    /**
     * 领域修改时间
     */
    private Date efUpdateDate;
}
