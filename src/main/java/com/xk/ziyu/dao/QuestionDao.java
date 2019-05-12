package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();
    /**
     * 查询所有问题
     * @return
     */
    List<Question> selectAll();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name, @Param("type") String type);

    /**
     * 根据关键字查找问题：问题标题  问题标签  用户 id
     * @param name
     * @return
     */
    List<Question> selectByKeywords(@Param("name") String name, @Param("type") String type);

    /**
     * 根据id查询问题
     * @param id
     * @return
     */
    Question get(@Param("id") Integer id);

    /**
     * 删除指定 id 问题
     * @param id
     * @return
     */
    int del(@Param("id") Integer id);

    /**
     * 添加问题
     * @param userId
     * @param title
     * @param content
     * @param date
     * @param niming
     * @param tag
     * @return
     */
    public int addQues(@Param("userId") Integer userId, @Param("title") String title, @Param("content") String content,
                       @Param("date")Date date, @Param("niming") Integer niming, @Param("tag") String tag);

    /**
     * 获取前几条问题
     * @param userId
     * @param len
     * @return
     */
    public List<Question> getTopList(@Param("userId") Integer userId, @Param("len") Integer len);
}
