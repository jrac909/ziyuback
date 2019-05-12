package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.NoticeDao;
import com.xk.ziyu.entity.Notice;
import com.xk.ziyu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public int getCount() {
        return noticeDao.selectCount();
    }

    @Override
    public List<Notice> getAllNotice(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> noticeList = noticeDao.selectAllNotice();
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        noticeList = pageInfo.getList();
        return noticeList;
    }

    @Override
    public int getQueryCount(String name) {
        return noticeDao.selectQueryCount(name);
    }

    @Override
    public List<Notice> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> noticeList = noticeDao.selectByKeywords(name);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        noticeList = pageInfo.getList();
        return noticeList;
    }

    @Override
    public Notice get(int id) {
        return noticeDao.get(id);
    }

    @Override
    public int del(int id) {
        return noticeDao.del(id);
    }

    @Override
    public int add(String title, String content) {
        int res = noticeDao.add(title, content, new Date());
        return res;
    }

    @Override
    public List<Notice> getLastNotice(int len) {
        return noticeDao.selectLastNotice(len);
    }
}
