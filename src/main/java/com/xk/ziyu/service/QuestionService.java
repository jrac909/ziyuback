package com.xk.ziyu.service;

import com.xk.ziyu.entity.Question;

import java.util.List;

public interface QuestionService {
    /**
     * 获取总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有问题信息
     * @return
     */
    public List<Question> getAll(int pageNum, int pageSize);

    /**
     * 查询问题总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name, String type);

    /**
     *  查询问题
     * @return
     */
    public List<Question> query(Integer pageNum, Integer pageSize, String name, String type);

    /**
     * 根据 id 查询问题
     * @param id
     * @return
     */
    public Question get(Integer id);

    /**
     * 删除指定 id 问题
     * @param id
     * @return
     */
    public int del(int id);

    /**
     * 添加一个问题
     * @param userId
     * @param title
     * @param content
     * @param niming
     * @param tag
     * @return
     */
    public int addQues(int userId, String title, String content, int niming, String tag);

    /**
     * 获取前几条问题
     * @param userId
     * @param len
     * @return
     */
    public List<Question> getTopList(int userId, int len);
}
