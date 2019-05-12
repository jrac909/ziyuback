package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.NoticeCommentDao;
import com.xk.ziyu.entity.NoticeComment;
import com.xk.ziyu.service.NoticeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeCommentServiceImpl implements NoticeCommentService{
    @Autowired
    private NoticeCommentDao noticeCommentDao;

    @Override
    public int getCount() {
        return noticeCommentDao.selectCount();
    }

    @Override
    public List<NoticeComment> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<NoticeComment> noticeCommentList = noticeCommentDao.selectList();
        PageInfo<NoticeComment> pageInfo = new PageInfo<>(noticeCommentList);
        noticeCommentList = pageInfo.getList();
        return noticeCommentList;
    }

    @Override
    public int getQueryCount(String name) {
        return noticeCommentDao.selectQueryCount(name);
    }

    @Override
    public List<NoticeComment> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<NoticeComment> noticeCommentList = noticeCommentDao.selectByKeywords(name);
        PageInfo<NoticeComment> pageInfo = new PageInfo<>(noticeCommentList);
        noticeCommentList = pageInfo.getList();
        return noticeCommentList;
    }

    @Override
    public NoticeComment get(int id) {
        return noticeCommentDao.get(id);
    }

    @Override
    public int del(int id) {
        return noticeCommentDao.del(id);
    }
}
