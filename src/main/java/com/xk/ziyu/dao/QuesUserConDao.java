package com.xk.ziyu.dao;

import com.xk.ziyu.entity.QuesUserCon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 获取所有问题信息
 */
@Mapper
public interface QuesUserConDao {
    /**
     * 获取总数
     * @return
     */
    public int selectCount();

    /**
     * 获取所有
     * @return
     */
    public List<QuesUserCon> selectAll();

    /**
     * 查询总数
     * @param name
     * @return
     */
    public int queryCount(@Param("name") String name);

    /**
     * 查询所有
     * @return
     */
    public List<QuesUserCon> queryAll(@Param("name") String name);

    /**
     * 查询所有（按回复数）
     * @return
     */
    public List<QuesUserCon> queryByHotAll();
    /**
     * 查询总数（按类型）
     * @return
     */
    public int queryByTypeCount(@Param("type") String type);
    /**
     * 查询所有（按类型）
     * @return
     */
    public List<QuesUserCon> queryByTypeAll(@Param("type") String type);

    /**
     * 根据 ID 查询记录
     * @param id
     * @return
     */
    public QuesUserCon get(@Param("id") Integer id);
}
