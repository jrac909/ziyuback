package com.xk.ziyu.service.impl;

import com.xk.ziyu.dao.NewsDao;
import com.xk.ziyu.entity.News;
import com.xk.ziyu.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> getAllNews() {
        return newsDao.selectAllNews();
    }

    @Override
    public int getWeiduCount(int id) {
        return newsDao.getWeiduCount(id);
    }

    @Override
    public List<News> getAllById(int id) {
        return newsDao.getAllById(id);
    }

    @Override
    public int cancelWeidu(int id1, int id2) {
        return newsDao.cancelWeidu(id1, id2);
    }

    @Override
    public List<News> getCurNews(int id1, int id2) {
        return newsDao.getCurNews(id1, id2);
    }

    @Override
    public int addNews(int id1, int id2, String content, int type, int type2, String name1, String name2) {
        return newsDao.addNews(id1, id2, content, type, type2, name1, name2);
    }
}
