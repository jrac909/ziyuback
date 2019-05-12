package com.xk.ziyu.dao;

import com.xk.ziyu.entity.EssayBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**

* @Description: 文章留言 Dao

* @Author: wanghaixue

* @CreateDate: 2019/2/18 22:13

* @Version: 1.0

*/
@Mapper
public interface EssayBoardDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有文章留言
     * @return
     */
    List<EssayBoard> selectAllEssayBoard();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找文章：文章id  用户 id 评论内容
     * @param name
     * @return
     */
    List<EssayBoard> selectByKeywords(@Param("name") String name);

    /**
     * 根据 id 查询文章评论
     * @param id
     * @return
     */
    EssayBoard get(@Param("id") Integer id);

    /**
     * 删除指定 id 文章评论
     * @return
     */
    int del(@Param("id") Integer id);

    /**
     * 添加文章评论
     * @param userId
     * @param comment
     * @param date
     * @param essayId
     * @return
     */
    public int addEssay(@Param("userId") Integer userId, @Param("comment") String comment, @Param("date")Date date, @Param("essayId") Integer essayId);
}
