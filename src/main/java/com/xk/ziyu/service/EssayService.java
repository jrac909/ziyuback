package com.xk.ziyu.service;

import com.xk.ziyu.entity.Essay;

import java.util.List;

public interface EssayService {
    /**
     * 获取总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有文章信息
     * @return
     */
    public List<Essay> getAllEssay(int pageNum, int pageSize);

    /**
     * 查询文章总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询文章
     * @return
     */
    public List<Essay> queryEssay(Integer pageNum, Integer pageSize, String name);

    /**
     * 根据 id 查询文章
     * @param id
     * @return
     */
    public Essay getEssay(Integer id);

    /**
     * 删除指定 id 文章
     * @param id
     * @return
     */
    public int delEssay(int id);

    /**
     * 获取热门文章
     * @return
     */
    public List getHotEssay(int len);

    /**
     * 获取所有文章（按收藏）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Essay> getAllByCollect(int pageNum, int pageSize);

    /**
     * 获取前几条文章
     * @param userId
     * @param len
     * @return
     */
    public List<Essay> getTopList(int userId, int len);
}
