package com.xk.ziyu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EsComUserConDao {
    /**
     * 获取所有评论
     * @return
     */
    public List selectAll(@Param("essayId") Integer essayId);
}
