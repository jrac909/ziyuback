package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.EssayDao;
import com.xk.ziyu.entity.Essay;
import com.xk.ziyu.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImpl implements EssayService{
    @Autowired
    private EssayDao essayDao;

    /**
     * 获取总条数
     * @return
     */
    @Override
    public int getCount() {
        return essayDao.selectCount();
    }

    /**
     * 分页获取所有文章信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Essay> getAllEssay(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Essay> essayList = essayDao.selectAllEssay();
        PageInfo<Essay> pageInfo = new PageInfo<>(essayList);
        essayList = pageInfo.getList();
        return essayList;
    }

    @Override
    public int getQueryCount(String name) {
        return essayDao.selectQueryCount(name);
    }

    @Override
    public List<Essay> queryEssay(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Essay> essayList = essayDao.selectByKeywords(name);
        PageInfo<Essay> pageInfo = new PageInfo<>(essayList);
        essayList = pageInfo.getList();
        return essayList;
    }

    @Override
    public Essay getEssay(Integer id) {
        return essayDao.selectEssay(id);
    }

    /**
     * 删除指定 id 文章
     * @param id
     * @return
     */
    @Override
    public int delEssay(int id) {
        return essayDao.delEssay(id);
    }

    /**
     * 获取热门文章
     * @return
     */
    @Override
    public List getHotEssay(int len) {
        return essayDao.selectHotEssay(len);
    }

    @Override
    public List<Essay> getAllByCollect(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Essay> essayList = essayDao.selectAllByCollect();
        PageInfo<Essay> pageInfo = new PageInfo<>(essayList);
        essayList = pageInfo.getList();
        return essayList;
    }

    @Override
    public List<Essay> getTopList(int userId, int len) {
        return essayDao.getTopList(userId, len);
    }
}
