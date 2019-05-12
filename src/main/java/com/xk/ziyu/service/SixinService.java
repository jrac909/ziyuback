package com.xk.ziyu.service;

import com.xk.ziyu.entity.Sixin;

import java.util.List;

public interface SixinService{
        /**
         * 回复总记录数
         * @return
         */
        public int getCount();

        /**
         * 获取所有
         * @param pageNum
         * @param pageSize
         * @return
         */
        List<Sixin> getAll(int pageNum, int pageSize);

        /**
         * 查询总记录数
         * @param name
         * @return
         */
        public int getQueryCount(String name);

        /**
         *  查询
         * @return
         */
        public List<Sixin> query(Integer pageNum, Integer pageSize, String name);

        /**
         * 根据 id 查询
         * @param id
         * @return
         */
        public Sixin get(int id);

}
