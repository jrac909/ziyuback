package com.xk.ziyu.service.impl;

import com.xk.ziyu.dao.ExpertFieldDao;
import com.xk.ziyu.entity.ExpertField;
import com.xk.ziyu.service.ExpertFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertFieldServiceImpl implements ExpertFieldService{
    @Autowired
    private ExpertFieldDao expertFieldDao;

    @Override
    public List<ExpertField> getAllExpertField() {
        return expertFieldDao.selectAllExpertField();
    }
}
