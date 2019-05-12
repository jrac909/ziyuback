package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

* @Description: 用户登录

* @Author: wanghaixue

* @CreateDate: 2019/3/11 19:37

* @Version: 1.0

*/
@RestController
@EnableAutoConfiguration
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/checkName")
    public ResponseDTO checkName(String username){
        return null;
    }
}
