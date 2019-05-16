package com.xk.ziyu.service;

import com.xk.ziyu.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();

    /**
     * 指定id用户接收到的消息中有多少条未读
     * @param id
     * @return
     */
    public int getWeiduCount(int id);

    /**
     * 获取指定id用户所有消息
     * @param id
     * @return
     */
    public List<News> getAllById(int id);
    /**
     * 取消两个用户间所有的未读状态
     * @param id1
     * @param id2
     * @return
     */
    public int cancelWeidu(int id1, int id2);
    /**
     * 获取两个人的聊天记录
     * @param id1
     * @param id2
     * @return
     */
    public List<News> getCurNews(int id1, int id2);

    /**
     * 发送一条新消息
     * @param id1
     * @param id2
     * @param content
     * @param name1
     * @param name2
     * @return
     */
    public int addNews(int id1, int id2, String content, int type, int type2, String name1, String name2);

}
