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
}
