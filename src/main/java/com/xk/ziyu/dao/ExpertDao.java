package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Expert;
import com.xk.ziyu.entity.ExpertUserCon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

* @Description: 专家 Dao

* @Author: wanghaixue

* @CreateDate: 2019/2/20 19:45

* @Version: 1.0

*/
@Mapper
public interface ExpertDao {
    /**
     * 获取所有专家信息
     * @return
     */
    List<ExpertUserCon> selectAllExpert();

    /**
     * 根据名字和领域获取专家信息
     * @return
     */
    List<ExpertUserCon> selectExpertByNameOrField(String keyWord);

    /**
     * 获取专家总数
     * @return
     */
    int selectExpertCount();

    /**
     * 获取最新 len 条专家信息
     * @param len
     * @return
     */
    List<ExpertUserCon> selectLastEUC(@Param("len") Integer len);

    /**
     * 获取总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有
     * @return
     */
    List<ExpertUserCon> selectAll();

    /**
     * 审核通过专家总数
     * @return
     */
    int selectTrueCount();

    /**
     * 查询审核通过的所有专家
     * @return
     */
    List<ExpertUserCon> selectTrueAll();

    /**
     * 查询审核通过专家总数
     * @return
     */
    int queryTrueCount(@Param("name") String name);

    /**
     * 查询审核通过的所有专家
     * @return
     */
    List<ExpertUserCon> queryTrueAll(@Param("name") String name);

    /**
     * 根据专家 ID 获取专家用户 JOIN 信息
     * @param expertId 专家 ID
     * @return 专家用户 JOIN 信息
     */
    public ExpertUserCon getById(@Param("expertId") Integer expertId);
}
