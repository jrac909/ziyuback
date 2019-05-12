package com.xk.ziyu.dao;

import com.sun.tools.corba.se.idl.InterfaceGen;
import com.xk.ziyu.entity.ExpertBoard;
import com.xk.ziyu.entity.ExpertReply;
import com.xk.ziyu.entity.form.ExpertBoardUserCon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExpertBoardDao {
    List<ExpertBoard> selectAllExpertBoard();

    /**
     * 获取专家个人中心留言板内容
     * @param expertId
     * @return
     */
    List<ExpertBoardUserCon> get(@Param("expertId") Integer expertId);

    /**
     * 删除指定 ID 留言
     * @param
     *      ebId    留言 ID
     * @return
     *      是否删除
     */
    public int del(@Param("ebId") Integer ebId);

    /**
     * 专家回复用户留言
     * @param erCommentId
     *      被回复用户 ID
     * @param expertId
     *      专家 ID
     * @param content
     *      专家回复内容
     * @param date
     *      专家回复日期
     * @return
     */
    public int addReply(@Param("erCommentId") Integer erCommentId, @Param("expertId") Integer expertId, @Param("content") String content, @Param("date")Date date);

    /**
     * 获取专家回复列表
     * @return
     */
    public List<ExpertReply> listReply();

    /**
     * 获取当前专家留言板回复
     * @param expertId
     * @return
     */
    public List<ExpertReply> getReply(@Param("expertId") Integer expertId);

    /**
     * 删除指定 ID 回复
     * @param id
     * @return
     */
    public int delReply(@Param("id") Integer id);
}
