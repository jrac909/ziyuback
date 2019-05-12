package com.xk.ziyu.dao;

import com.xk.ziyu.entity.QuestionReplyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionReplyUserDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有回复
     * @return
     */
    List<QuestionReplyUser> selectAll();

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
    List<QuestionReplyUser> selectByKeywords(@Param("name") String name);

    /**
     * 根据 id 查询回复
     * @param id
     * @return
     */
    QuestionReplyUser get(@Param("id") Integer id);

    /**
     * 删除指定 id 回答
     * @return
     */
    int del(@Param("id") Integer id);
}
