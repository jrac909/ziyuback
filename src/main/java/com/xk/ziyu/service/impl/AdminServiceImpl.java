package com.xk.ziyu.service.impl;

import com.xk.ziyu.dao.AdminDao;
import com.xk.ziyu.entity.ALoginInfo;
import com.xk.ziyu.entity.Admin;
import com.xk.ziyu.service.AdminService;
import com.xk.ziyu.util.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    @Override
    public Admin getAdminByAccount(String account) {
        return adminDao.selectByAccount(account);
    }


    /**
     * 验证账号密码是否正确，正确返回 token，错误返回 null
     * @param username
     * @param password
     * @return
     */
    @Override
    public String checkAdmin(String username, String password) {
        String token = null;
        Admin admin = adminDao.selectByAccount(username);
        if (admin != null){
            if(admin.getAdminPassword().equals(password)){
                /* 根据 id 生成 token */
                Map<String, Object> m = new HashMap<String, Object>();
                m.put("userId", admin.getAdminId());
                token = JavaWebToken.createJavaWebToken(m);
            }
        }
        return token;
    }

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    @Override
    public Admin checkUsername(String username) {
        return adminDao.selectByAccount(username);
    }
}
