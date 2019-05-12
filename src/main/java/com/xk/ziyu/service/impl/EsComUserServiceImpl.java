package com.xk.ziyu.service.impl;

import com.xk.ziyu.dao.EsComUserConDao;
import com.xk.ziyu.entity.EsComUserCon;
import com.xk.ziyu.service.EsComUserConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsComUserServiceImpl implements EsComUserConService{
    @Autowired
    private EsComUserConDao esComUserConDao;

    @Override
    public List<EsComUserCon> getAll(int essayId) {
        return esComUserConDao.selectAll(essayId);
    }
}
