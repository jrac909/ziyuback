package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.QuestionReplyUserDao;
import com.xk.ziyu.entity.Question;
import com.xk.ziyu.entity.QuestionReplyUser;
import com.xk.ziyu.service.QuestionReplyUserService;
import com.xk.ziyu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionReplyUserServiceImpl implements QuestionReplyUserService{
    @Autowired
    private QuestionReplyUserDao questionReplyUserDao;


    @Override
    public int getCount() {
        return questionReplyUserDao.selectCount();
    }

    @Override
    public List<QuestionReplyUser> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionReplyUser> questionReplyUserList = questionReplyUserDao.selectAll();
        PageInfo<QuestionReplyUser> pageInfo = new PageInfo<>(questionReplyUserList);
        questionReplyUserList = pageInfo.getList();
        return questionReplyUserList;
    }

    @Override
    public int getQueryCount(String name) {
        return questionReplyUserDao.selectQueryCount(name);
    }

    @Override
    public List<QuestionReplyUser> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionReplyUser> questionReplyUserList = questionReplyUserDao.selectByKeywords(name);
        PageInfo<QuestionReplyUser> pageInfo = new PageInfo<>(questionReplyUserList);
        questionReplyUserList = pageInfo.getList();
        return questionReplyUserList;
    }

    @Override
    public QuestionReplyUser get(int id) {
        return questionReplyUserDao.get(id);
    }

    @Override
    public int del(int id) {
        return questionReplyUserDao.del(id);
    }
}
