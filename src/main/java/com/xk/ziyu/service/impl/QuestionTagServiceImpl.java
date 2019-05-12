package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.QuestionTagDao;
import com.xk.ziyu.entity.QuestionTag;
import com.xk.ziyu.service.QuestionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionTagServiceImpl implements QuestionTagService{
    @Autowired
    private QuestionTagDao questionTagDao;

    @Override
    public int getCount() {
        return questionTagDao.selectCount();
    }

    @Override
    public List<QuestionTag> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionTag> questionTagList = questionTagDao.selectAll();
        PageInfo<QuestionTag> pageInfo = new PageInfo<>(questionTagList);
        questionTagList = pageInfo.getList();
        return questionTagList;
    }

    @Override
    public int getQueryCount(String name) {
        return questionTagDao.selectQueryCount(name);
    }

    @Override
    public List<QuestionTag> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionTag> questionTagList = questionTagDao.selectByKeywords(name);
        PageInfo<QuestionTag> pageInfo = new PageInfo<>(questionTagList);
        questionTagList = pageInfo.getList();
        return questionTagList;
    }

    @Override
    public int del(int id) {
        return questionTagDao.del(id);
    }

    @Override
    public int add(String name) {
        int res = questionTagDao.add(name, new Date());
        return res;
    }
}
