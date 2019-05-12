package com.xk.ziyu.service;

import com.xk.ziyu.entity.EsComUserCon;

import java.util.List;

public interface EsComUserConService {
    /**
     * 获取指定id文章的所有评论
     * @return
     */
    public List<EsComUserCon> getAll(int essayId);
}
