package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.ALoginInfo;
import com.xk.ziyu.entity.Admin;
import com.xk.ziyu.service.AdminService;
import com.xk.ziyu.util.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/a")
public class ALoginController {
    @Autowired
    private AdminService adminService;

    /**
     * 验证账号生成 token
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ResponseDTO login(String username, String password){
        ResponseDTO responseDTO = new ResponseDTO<>();
        String token = adminService.checkAdmin(username, password);
        if (token == null){
            responseDTO.setCode(60204);
            responseDTO.setMessage("密码或账号错误，请重新输入！");
        } else{
            responseDTO.setCode(20000);
            Admin admin = adminService.getAdminByAccount(username);
            admin.setAdminToken(token);
            responseDTO.setData(admin);
        }
        return responseDTO;
    }

    /**
     * token 验证方法
     * @param token
     * @return
     */
    @RequestMapping("/getUser")
    public ResponseDTO<Admin> tokenConfirm(String token, String username){
        // eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjN9.AF8NIdxZL9sR6p74l1djloAj4roThem3aqYBdJYbCG4
        ResponseDTO<Admin> responseDTO = new ResponseDTO();
        if (JavaWebToken.parserJavaWebToken(token) != null){
            responseDTO.setData(adminService.getAdminByAccount(username));
            responseDTO.setCode(20000);
            System.out.println("对了");
        } else{
            responseDTO = null;
        }
        return responseDTO;
    }
}
