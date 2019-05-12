package com.xk.ziyu.service;

import com.xk.ziyu.entity.ALoginInfo;
import com.xk.ziyu.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    /**
     * 根据管理员账号获取管理员信息
     * @param account
     * @return
     */
    Admin getAdminByAccount(String account);

    /**
     * 验证用户信息，返回 token
     * @param username
     * @param password
     * @return
     */
    String checkAdmin(String username, String password);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    Admin checkUsername(String username);
}
