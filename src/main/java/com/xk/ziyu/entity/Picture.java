package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

/**

* @Description: 图片信息

* @Author: wanghaixue

* @CreateDate: 2019/2/20 11:03

* @Version: 1.0

*/
@Data
public class Picture {
    /**
     * 图片 id
     */
    private int picId;
    /**
     * 图片名称
     */
    private String picName;
    /**
     * 图片路径
     */
    private String picPath;
    /**
     * 图片类型
     */
    private String picType;
    /**
     * 图片是否展示
     */
    private String picIsShow;
    /**
     * 图片链接
     */
    private String picLink;
    /**
     * 删除标志
     */
    private int picDel;
    /**
     * 图片最新修改时间
     */
    private Date picUpdateDate;
}
