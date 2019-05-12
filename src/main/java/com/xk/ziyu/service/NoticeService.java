package com.xk.ziyu.service;

import com.xk.ziyu.entity.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 获取公告总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有公告信息
     * @return
     */
    public List<Notice> getAllNotice(int pageNum, int pageSize);

    /**
     * 查询公告总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询公告
     * @return
     */
    public List<Notice> query(Integer pageNum, Integer pageSize, String name);

    /**
     * 根据 id 获取公告
     * @param id
     */
    public Notice get(int id);

    /**
     * 删除指定 id 公告
     * @param id
     * @return
     */
    public int del(int id);

    /**
     * 发布公告
     * @return
     */
    public int add(String title, String content);

    /**
     * 获取最新 x 条公告
     * @return
     */
    public List<Notice> getLastNotice(int len);
}
