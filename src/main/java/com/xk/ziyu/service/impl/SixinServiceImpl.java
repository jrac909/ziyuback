package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.SixinDao;
import com.xk.ziyu.entity.Sixin;
import com.xk.ziyu.service.SixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SixinServiceImpl implements SixinService {
    @Autowired
    private SixinDao sixinDao;

    @Override
    public int getCount() {
        return sixinDao.selectCount();
    }

    @Override
    public List<Sixin> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Sixin> sixinList = sixinDao.selectAll();
        PageInfo<Sixin> pageInfo = new PageInfo<>(sixinList);
        sixinList = pageInfo.getList();
        return sixinList;
    }

    @Override
    public int getQueryCount(String name) {
        return sixinDao.selectQueryCount(name);
    }

    @Override
    public List<Sixin> query(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sixin> sixinList = sixinDao.selectByKeywords(name);
        PageInfo<Sixin> pageInfo = new PageInfo<>(sixinList);
        sixinList = pageInfo.getList();
        return sixinList;
    }

    @Override
    public Sixin get(int id) {
        return sixinDao.get(id);
    }
}
