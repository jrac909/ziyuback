package com.xk.ziyu.entity;

import lombok.Data;

/**

* @Description: 用户登录信息(用户id/账号和密码和生成的 token 字符串信息)

* @Author: wanghaixue

* @CreateDate: 2019/3/10 18:00

* @Version: 1.0

*/
@Data
public class ALoginInfo {
    /**
     * 用户 id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 登录 token
     */
    private String token;
}
