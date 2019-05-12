package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Admin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public ResponseDTO test(String username, String password){
        ResponseDTO responseDTO = new ResponseDTO();

        System.out.println("接收到数据：username="+username+"   password="+password);
        Admin admin = new Admin();
        admin.setAdminId(10000);
        admin.setAdminJianjie("大概简介");
        admin.setAdminName("Jan");

        responseDTO.setCode(200);
        responseDTO.setData(admin);

        return responseDTO;
    }
}
