package com.xk.ziyu.service;

import com.xk.ziyu.entity.Expert;
import com.xk.ziyu.entity.ExpertUserCon;

import java.util.List;

public interface ExpertService {
    List<ExpertUserCon> getAllExpert();

    /**
     * 根据专家名字/领域关键字查找专家
     */
    List<ExpertUserCon> getExpertByNameAndField(String keyWord);

    /**
     * 按照服务人数倒序获取专家信息
     * @param len
     * @return
     */
    List<ExpertUserCon> getLastEUC(int len);

    /**
     * 获取专家表未标记删除的总记录数
     * @return
     */
    public int getCount();
    /**
     * 按页码获取专家表的数据，包括审核成功和审核中的专家
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ExpertUserCon> getList(int pageNum, int pageSize);
    /**
     * 获取审核成功专家的总记录数
     * @return
     */
    public int getTrueCount();
    /**
     * 按页码获取专家表的数据，只取审核成功的专家
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ExpertUserCon> getTrueList(int pageNum, int pageSize);
    /**
     * 查询审核成功专家的总记录数(专家名和领域名查询)
     * @return
     */
    public int queryTrueCount(String name);
    /**
     * 按页码查询专家表的数据，只取审核成功的专家(专家名和领域名查询)
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ExpertUserCon> queryTrueList(int pageNum, int pageSize, String name);

    /**
     * 根据专家 ID 获取专家用户 JOIN 信息
     * @param expertId
     * @return
     */
    public ExpertUserCon getById(int expertId);
}
