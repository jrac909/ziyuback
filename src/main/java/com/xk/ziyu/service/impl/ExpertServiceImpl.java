package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.ExpertDao;
import com.xk.ziyu.entity.Expert;
import com.xk.ziyu.entity.ExpertUserCon;
import com.xk.ziyu.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService{
    @Autowired
    private ExpertDao expertDao;

    @Override
    public List<ExpertUserCon> getAllExpert() {
        return expertDao.selectAllExpert();
    }

    @Override
    public List<ExpertUserCon> getExpertByNameAndField(String keyWord) {
        return expertDao.selectExpertByNameOrField(keyWord);
    }

    @Override
    public List<ExpertUserCon> getLastEUC(int len) {
        return expertDao.selectLastEUC(len);
    }

    /**
     * 获取专家表未标记删除的总记录数
     * @return
     */
    @Override
    public int getCount() {
        return expertDao.selectCount();
    }

    /**
     * 按页码获取专家表的数据，包括审核成功和审核中的专家
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ExpertUserCon> getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExpertUserCon> expertUserConList = expertDao.selectAll();
        PageInfo<ExpertUserCon> pageInfo = new PageInfo<>(expertUserConList);
        expertUserConList = pageInfo.getList();
        return expertUserConList;
    }

    /**
     * 获取审核成功专家的总记录数
     * @return
     */
    @Override
    public int getTrueCount() {
        return expertDao.selectTrueCount();
    }

    /**
     * 按页码获取专家表的数据，只取审核成功的专家
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ExpertUserCon> getTrueList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExpertUserCon> expertUserConList = expertDao.selectTrueAll();
        PageInfo<ExpertUserCon> pageInfo = new PageInfo<>(expertUserConList);
        expertUserConList = pageInfo.getList();
        return expertUserConList;
    }

    /**
     * 查询审核成功专家的总记录数(专家名和领域名查询)
     * @return
     */
    @Override
    public int queryTrueCount(String name) {
        return expertDao.queryTrueCount(name);
    }

    /**
     * 按页码查询专家表的数据，只取审核成功的专家(专家名和领域名查询)
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ExpertUserCon> queryTrueList(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExpertUserCon> expertUserConList = expertDao.queryTrueAll(name);
        PageInfo<ExpertUserCon> pageInfo = new PageInfo<>(expertUserConList);
        expertUserConList = pageInfo.getList();
        return expertUserConList;
    }

    /**
     * 根据专家 ID 获取专家用户 JOIN 信息
     * @param expertId
     * @return
     */
    @Override
    public ExpertUserCon getById(int expertId) {
        return expertDao.getById(expertId);
    }
}
