package com.xk.ziyu.service;

import com.xk.ziyu.entity.QuestionTag;

import java.util.List;

public interface QuestionTagService {
    /**
     * 获取标签总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有标签信息
     * @return
     */
    public List<QuestionTag> getAll(int pageNum, int pageSize);

    /**
     * 查询标签总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询标签
     * @return
     */
    public List<QuestionTag> query(Integer pageNum, Integer pageSize, String name);

    /**
     * 删除指定 id 标签
     * @param id
     * @return
     */
    public int del(int id);

    /**
     * 添加标签
     * @return
     */
    public int add(String name);
}
