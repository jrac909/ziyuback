package com.xk.ziyu.service;

import com.xk.ziyu.entity.QuesUserCon;

import java.util.List;

public interface QuesUserConService {
    /**
     * 获取总数
     * @return
     */
    public int getCount();

    /**
     * 获取所有
     * @return
     */
    public List<QuesUserCon> getAll(int pageNum, int pageSize);

    /**
     * 查询总数
     * @param name
     * @return
     */
    public int queryCount(String name);

    /**
     * 获取所有
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public List<QuesUserCon> query(int pageNum, int pageSize, String name);

    /**
     * 获取所有（按回复数）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<QuesUserCon> queryByHot(int pageNum, int pageSize);

    /**
     * 查询总数（按类型）
     * @param type
     * @return
     */
    public int queryByTypeCounr(String type);

    /**
     * 查询所有（按类型）
     * @param pageNum
     * @param pageSize
     * @param type
     * @return
     */
    public List<QuesUserCon> queryByType(int pageNum, int pageSize, String type);
    /**
     * 根据 ID 查询记录
     * @param id
     * @return
     */
    public QuesUserCon get(int id);
}
