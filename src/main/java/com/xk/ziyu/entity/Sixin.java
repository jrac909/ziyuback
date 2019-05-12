package com.xk.ziyu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Sixin {
    private int sxId;
    private int sxUserId;
    private String sxUserName;
    private String sxContent;
    private int sxAdminId;
    private Date sxDate;
}
