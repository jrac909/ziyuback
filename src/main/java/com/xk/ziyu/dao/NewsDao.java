package com.xk.ziyu.dao;

import com.xk.ziyu.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsDao {
    List<News> selectAllNews();

    /**
     * 指定id用户接收到的消息中有多少条未读
     * @param id
     * @return
     */
    public int getWeiduCount(@Param("id")Integer id);

    /**
     * 获取指定id用户所有消息
     * @param id
     * @return
     */
    public List<News> getAllById(@Param("id")Integer id);

    /**
     * 取消两个用户见所有的未读状态
     * @param id1
     * @param id2
     * @return
     */
    public int cancelWeidu(@Param("id1")Integer id1, @Param("id2")Integer id2);

    /**
     * 获取两个人的聊天记录
     * @param id1
     * @param id2
     * @return
     */
    public List<News> getCurNews(@Param("id1")Integer id1, @Param("id2")Integer id2);

    /**
     * 发送一条新消息
     * @param id1
     * @param id2
     * @param content
     * @param name1
     * @param name2
     * @return
     */
    public int addNews(@Param("id1")Integer id1, @Param("id2")Integer id2, @Param("content")String content,@Param("type")Integer type, @Param("type2")Integer type2, @Param("name1")String name1, @Param("name2")String name2);
}
