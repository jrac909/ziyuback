package com.xk.ziyu.service;

import com.xk.ziyu.entity.Shenhe;

import java.util.Date;
import java.util.List;

public interface ShenheService {
    /**
     * 获取审核总记录数
     * @return
     */
    public int getCount();

    /**
     * 获取所有审核信息
     * @return
     */
    public List<Shenhe> getAllShenhe(int pageNum, int pageSize);

    /**
     * 查询审核总记录数
     * @param name
     * @return
     */
    public int getQueryCount(Integer name);

    /**
     *  查询审核
     * @return
     */
    public List<Shenhe> query(Integer pageNum, Integer pageSize, Integer name);
    /**
     * 添加一条新的审核记录
     * @return
     */
    public int addshenhe(String quaLevel, String reportingTime, String occupation, String
            certificateNo, String zili, String zilidesc, String field, String fielddesc, String client,
                         Integer userid, String photo, String name, String idcard);

    /**
     * 获取指定id用户的审核状态
     * @param userid
     * @return
     */
    public List<Shenhe> getStatus(int userid);

    /**
     * 获取指定id审核记录
     * @param id
     * @return
     */
    public Shenhe getShenheById(int id);

    /**
     * 通过申请
     * @param id
     * @return
     */
    public int agree(int id);

    /**
     * 拒绝申请
     * @param id
     * @return
     */
    public int jujue(int id);

}
