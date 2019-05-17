package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.ShenheDao;
import com.xk.ziyu.entity.Notice;
import com.xk.ziyu.entity.Shenhe;
import com.xk.ziyu.service.ShenheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShenheServiceImpl implements ShenheService {
    @Autowired
    private ShenheDao shenheDao;

    @Override
    public int getCount() {
        return shenheDao.selectCount();
    }

    @Override
    public List<Shenhe> getAllShenhe(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shenhe> shenheList = shenheDao.selectAllShenhe();
        PageInfo<Shenhe> pageInfo = new PageInfo<>(shenheList);
        shenheList = pageInfo.getList();
        return shenheList;
    }

    @Override
    public int getQueryCount(Integer name) {
        return shenheDao.selectQueryCount(name);
    }

    @Override
    public List<Shenhe> query(Integer pageNum, Integer pageSize, Integer name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shenhe> shenheList = shenheDao.selectByKeywords(name);
        PageInfo<Shenhe> pageInfo = new PageInfo<>(shenheList);
        shenheList = pageInfo.getList();
        return shenheList;
    }

    /**
     * 添加一条新的审核记录
     * @return
     */
    @Override
    public int addshenhe(String quaLevel, String reportingTime, String occupation, String certificateNo, String zili, String zilidesc, String field, String fielddesc, String client, Integer userid, String photo, String name, String idcard) {

        return shenheDao.addshenhe(quaLevel, reportingTime, occupation, certificateNo, zili, zilidesc, field, fielddesc, client, userid, photo, name, idcard);
    }

    @Override
    public List<Shenhe> getStatus(int userid) {
        return shenheDao.getStatus(userid);
    }

    @Override
    public Shenhe getShenheById(int id) {
        return shenheDao.getShenheById(id);
    }

    @Override
    public int agree(int id) {
        return shenheDao.agree(id);
    }

    @Override
    public int jujue(int id) {
        return shenheDao.jujue(id);
    }
}
