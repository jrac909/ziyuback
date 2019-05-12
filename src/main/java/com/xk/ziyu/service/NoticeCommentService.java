package com.xk.ziyu.service;

import com.xk.ziyu.entity.NoticeComment;

import java.util.List;

public interface NoticeCommentService {
    /**
     * 评论总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<NoticeComment> getAll(int pageNum, int pageSize);

    /**
     * 查询评论总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询文章
     * @return
     */
    public List<NoticeComment> query(Integer pageNum, Integer pageSize, String name);

    /**
     * 根据 id 查询评论
     * @param id
     * @return
     */
    public NoticeComment get(int id);

    /**
     * 删除指定 id 评论
     * @param id
     * @return
     */
    public int del(int id);
}
