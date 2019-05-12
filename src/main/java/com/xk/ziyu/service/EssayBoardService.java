package com.xk.ziyu.service;

import com.xk.ziyu.entity.EssayBoard;

import java.util.Date;
import java.util.List;

public interface EssayBoardService {
    /**
     * 文章评论总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有文章评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<EssayBoard> getAllEssayBoard(int pageNum, int pageSize);

    /**
     * 查询文章评论总记录数
     * @param name
     * @return
     */
    public int getQueryCount(String name);

    /**
     *  查询文章
     * @return
     */
    public List<EssayBoard> queryEssayBoard(Integer pageNum, Integer pageSize, String name);

    /**
     * 根据 id 查询文章评论
     * @param id
     * @return
     */
    public EssayBoard get(int id);

    /**
     * 删除指定 id 文章评论
     * @param id
     * @return
     */
    public int delEB(int id);
    /**
     * 添加文章评论
     * @param userId
     * @param comment
     * @param essayId
     * @return
     */
    public int addEB(int userId, String comment, int essayId);
}
