package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.EssayBoardDao;
import com.xk.ziyu.entity.EssayBoard;
import com.xk.ziyu.service.EssayBoardService;
import com.xk.ziyu.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EssayBoardServiceImpl implements EssayBoardService{
    @Autowired
    EssayBoardDao essayBoardDao;

    @Override
    public int getCount() {
        return essayBoardDao.selectCount();
    }

    @Override
    public List<EssayBoard> getAllEssayBoard(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EssayBoard> essayBoardList = essayBoardDao.selectAllEssayBoard();
        PageInfo<EssayBoard> pageInfo = new PageInfo<>(essayBoardList);
        essayBoardList = pageInfo.getList();
        return essayBoardList;
    }

    @Override
    public int getQueryCount(String name) {
        return essayBoardDao.selectQueryCount(name);
    }

    @Override
    public List<EssayBoard> queryEssayBoard(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<EssayBoard> essayBoardList = essayBoardDao.selectByKeywords(name);
        PageInfo<EssayBoard> pageInfo = new PageInfo<>(essayBoardList);
        essayBoardList = pageInfo.getList();
        return essayBoardList;
    }

    @Override
    public EssayBoard get(int id) {
        return essayBoardDao.get(id);
    }

    @Override
    public int delEB(int id) {
        return essayBoardDao.del(id);
    }

    @Override
    public int addEB(int userId, String comment, int essayId) {
        return essayBoardDao.addEssay(userId, comment, new Date(), essayId);
    }
}
