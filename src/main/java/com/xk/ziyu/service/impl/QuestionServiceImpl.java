package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.QuestionDao;
import com.xk.ziyu.entity.Question;
import com.xk.ziyu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDao questionDao;

    @Override
    public int getCount() {
        return questionDao.selectCount();
    }

    @Override
    public List<Question> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question> questionList = questionDao.selectAll();
        PageInfo<Question> pageInfo = new PageInfo<>(questionList);
        questionList = pageInfo.getList();
        return questionList;
    }

    @Override
    public int getQueryCount(String name, String type) {
        return questionDao.selectQueryCount(name, type);
    }

    @Override
    public List<Question> query(Integer pageNum, Integer pageSize, String name, String type) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question> questionList = questionDao.selectByKeywords(name, type);
        PageInfo<Question> pageInfo = new PageInfo<>(questionList);
        questionList = pageInfo.getList();
        return questionList;
    }

    @Override
    public Question get(Integer id) {
        return questionDao.get(id);
    }

    @Override
    public int del(int id) {
        return questionDao.del(id);
    }

    @Override
    public int addQues(int userId, String title, String content, int niming, String tag) {
        return questionDao.addQues(userId, title, content, new Date(), niming, tag);
    }

    @Override
    public List<Question> getTopList(int userId, int len) {
        return questionDao.getTopList(userId, len);
    }
}
