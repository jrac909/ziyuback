package com.xk.ziyu.dao;

import com.xk.ziyu.entity.NoticeComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeCommentDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有公告留言
     * @return
     */
    List<NoticeComment> selectList();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找公告：公告标题
     * @param name
     * @return
     */
    List<NoticeComment> selectByKeywords(@Param("name") String name);

    /**
     * 根据 id 查询公告评论
     * @param id
     * @return
     */
    NoticeComment get(@Param("id") Integer id);

    /**
     * 删除指定 id 公告评论
     * @return
     */
    int del(@Param("id") Integer id);
}
