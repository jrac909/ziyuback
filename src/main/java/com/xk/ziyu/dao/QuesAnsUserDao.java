package com.xk.ziyu.dao;

import com.xk.ziyu.entity.QuesAnsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论 Dao
 */
@Mapper
public interface QuesAnsUserDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有回答
     * @return
     */
    List<QuesAnsUser> selectAll();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找评论：问题id  评论内容  评论用户id
     * @param name
     * @return
     */
    List<QuesAnsUser> selectByKeywords(@Param("name") String name);

    /**
     * 根据 id 查询回答
     * @param id
     * @return
     */
    QuesAnsUser get(@Param("id") Integer id);

    /**
     * 删除指定 id 回答
     * @return
     */
    int del(@Param("id") Integer id);
}
