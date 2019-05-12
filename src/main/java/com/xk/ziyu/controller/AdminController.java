package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Admin;
import com.xk.ziyu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/getAllAdmin")
    public List<Admin> getAllAdmin(){
        List<Admin> adminList = adminService.getAllAdmin();

        return adminList;
    }

    /**
     * 检查用户账号是否存在
     * @param username 用户账号
     */
    @RequestMapping("/checkAccount")
    public ResponseDTO<Admin> checkAccount(String username){
        System.out.println("请求到了 account:"+username);
        ResponseDTO responseDTO = new ResponseDTO();
        Admin admin = adminService.checkUsername(username);

        responseDTO.setCode(20000);
        responseDTO.setMessage("请求成功！");
        responseDTO.setData(admin);

        return responseDTO;
    }
}
