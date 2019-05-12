package com.xk.ziyu.dao;

import com.xk.ziyu.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao {
    List<News> selectAllNews();
}
