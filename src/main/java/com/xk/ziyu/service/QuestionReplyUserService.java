package com.xk.ziyu.service;

import com.xk.ziyu.entity.QuestionReplyUser;

import java.util.List;

public interface QuestionReplyUserService {
    /**
     * 回复总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有回复
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<QuestionReplyUser> getAll(int pageNum, int pageSize);

    /**
     * 查询回复总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询回复
     * @return
     */
    public List<QuestionReplyUser> query(Integer pageNum, Integer pageSize, String name);

    /**
     * 根据 id 查询回复
     * @param id
     * @return
     */
    public QuestionReplyUser get(int id);

    /**
     * 删除指定 id 回复
     * @param id
     * @return
     */
    public int del(int id);
}
