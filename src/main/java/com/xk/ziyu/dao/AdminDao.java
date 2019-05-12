package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

* @Description: 管理员 Dao

* @Author: wanghaixue

* @CreateDate: 2019/2/18 20:35

* @Version: 1.0

*/
@Mapper
public interface AdminDao {
    /**
     * 查询所有管理员
     * @return 所有管理员 List
     */
    List<Admin> selectAllAdmin();

    /**
     * 根据管理员用户名查询管理员
     * @return
     */
    Admin selectByAccount(String account);

    /**
     * 根据 token 查询管理员信息
     * @param token
     * @return
     */
    Admin selectByToken(String token);
}
