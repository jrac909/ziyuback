package com.xk.ziyu.dao;

import com.xk.ziyu.entity.ExpertField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpertFieldDao {
    List<ExpertField> selectAllExpertField();
}
