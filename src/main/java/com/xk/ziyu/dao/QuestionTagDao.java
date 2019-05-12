package com.xk.ziyu.dao;

import com.xk.ziyu.entity.QuestionTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionTagDao {
    /**
     * 获取标签总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有标签
     * @return
     */
    List<QuestionTag> selectAll();

    /**
     * 获取查询标签总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找标签：标签名
     * @param name
     * @return
     */
    List<QuestionTag> selectByKeywords(@Param("name") String name);

    /**
     * 删除指定 id 标签
     * @param id
     * @return
     */
    int del(@Param("id") Integer id);

    /**
     * 添加公告
     * @return
     */
    int add(@Param("name") String name, @Param("date") Date date);
}
