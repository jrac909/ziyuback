package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**

* @Description: 公告 Dao

* @Author: wanghaixue

* @CreateDate: 2019/3/5 21:59

* @Version: 1.0

*/
@Mapper
public interface NoticeDao {
    /**
     * 获取公告总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有公告
     * @return
     */
    List<Notice> selectAllNotice();

    /**
     * 获取查询公告总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找公告：公告标题
     * @param name
     * @return
     */
    List<Notice> selectByKeywords(@Param("name") String name);

    /**
     * 根据id查询公告
     * @param id
     * @return
     */
    Notice get(@Param("id") Integer id);

    /**
     * 删除指定 id 公告
     * @param id
     * @return
     */
    int del(@Param("id") Integer id);

    /**
     * 发布公告
     * @return
     */
    int add(@Param("noticeTitle") String noticeTitle, @Param("noticeContent") String noticeContent, @Param("date") Date date);

    /**
     * 获取最新x条公告
     * @return
     */
    List<Notice> selectLastNotice(@Param("len") Integer len);
}
