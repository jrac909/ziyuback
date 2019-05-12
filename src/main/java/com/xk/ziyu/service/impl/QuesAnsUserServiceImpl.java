package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.QuesAnsUserDao;
import com.xk.ziyu.entity.QuesAnsUser;
import com.xk.ziyu.service.QuesAnsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesAnsUserServiceImpl implements QuesAnsUserService{
    @Autowired
    private QuesAnsUserDao quesAnsUserDao;

    @Override
    public int getCount() {
        return quesAnsUserDao.selectCount();
    }

    @Override
    public List<QuesAnsUser> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesAnsUser> quesAnsUserList = quesAnsUserDao.selectAll();
        PageInfo<QuesAnsUser> pageInfo = new PageInfo<>(quesAnsUserList);
        quesAnsUserList = pageInfo.getList();
        return quesAnsUserList;
    }

    @Override
    public int getQueryCount(String name) {
        return quesAnsUserDao.selectQueryCount(name);
    }

    @Override
    public List<QuesAnsUser> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesAnsUser> quesAnsUserList = quesAnsUserDao.selectByKeywords(name);
        PageInfo<QuesAnsUser> pageInfo = new PageInfo<>(quesAnsUserList);
        quesAnsUserList = pageInfo.getList();

        return quesAnsUserList;
    }

    @Override
    public QuesAnsUser get(int id) {
        return quesAnsUserDao.get(id);
    }

    @Override
    public int del(int id) {
        return quesAnsUserDao.del(id);
    }
}
