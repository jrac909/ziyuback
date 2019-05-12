package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.QuesUserConDao;
import com.xk.ziyu.entity.QuesUserCon;
import com.xk.ziyu.service.QuesUserConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesUserConServiceImpl implements QuesUserConService{
    @Autowired
    private QuesUserConDao quesUserConDao;

    @Override
    public int getCount() {
        return quesUserConDao.selectCount();
    }

    @Override
    public List<QuesUserCon> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesUserCon> quesUserConList = quesUserConDao.selectAll();
        PageInfo<QuesUserCon> pageInfo = new PageInfo<>(quesUserConList);
        quesUserConList = pageInfo.getList();
        return quesUserConList;
    }

    @Override
    public int queryCount(String name) {
        return quesUserConDao.queryCount(name);
    }

    @Override
    public List<QuesUserCon> query(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesUserCon> quesUserConList = quesUserConDao.queryAll(name);
        PageInfo<QuesUserCon> pageInfo = new PageInfo<>(quesUserConList);
        quesUserConList = pageInfo.getList();
        return quesUserConList;
    }

    @Override
    public List<QuesUserCon> queryByHot(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesUserCon> quesUserConList = quesUserConDao.queryByHotAll();
        PageInfo<QuesUserCon> pageInfo = new PageInfo<>(quesUserConList);
        quesUserConList = pageInfo.getList();
        return quesUserConList;
    }

    @Override
    public int queryByTypeCounr(String type) {
        return quesUserConDao.queryByTypeCount(type);
    }

    @Override
    public List<QuesUserCon> queryByType(int pageNum, int pageSize, String type) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuesUserCon> quesUserConList = quesUserConDao.queryByTypeAll(type);
        PageInfo<QuesUserCon> pageInfo = new PageInfo<>(quesUserConList);
        quesUserConList = pageInfo.getList();
        return quesUserConList;
    }

    /**
     * 根据 ID 查询记录
     * @param id
     * @return
     */
    @Override
    public QuesUserCon get(int id) {
        return quesUserConDao.get(id);
    }

}
