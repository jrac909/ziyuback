package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Sixin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SixinDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有回复
     * @return
     */
    List<Sixin> selectAll();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找
     * @param name
     * @return
     */
    List<Sixin> selectByKeywords(@Param("name") String name);

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    Sixin get(@Param("id") Integer id);
}
