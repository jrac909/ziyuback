package com.xk.ziyu.service;

import com.xk.ziyu.entity.ExpertBoard;
import com.xk.ziyu.entity.ExpertReply;
import com.xk.ziyu.entity.form.ExpertBoardUserCon;

import java.util.Date;
import java.util.List;

public interface ExpertBoardService {
    List<ExpertBoard> getAllExpertBoard();

    /**
     * 获取指定专家 ID 留言板内容
     * @param expertId
     * @return
     */
    public List<ExpertBoardUserCon> get(int expertId);

    /**
     * 删除指定 ID 的留言
     * @param ebId
     * @return
     */

    public int del(int ebId);

    /**
     * 专家回复用户留言
     * @param erCommentId
     *      被回复用户 ID
     * @param expertId
     *      专家 ID
     * @param content
     *      专家回复内容
     * @return
     */
    public int addReply(int erCommentId, int expertId, String content);

    /**
     * 获取专家回复列表
     * @return
     */
    public List<ExpertReply> listReply();

    /**
     * 获取指定ID专家回复列表
     * @return
     */
    public List<ExpertReply> getReply(int expertId);
    /**
     * 删除指定 ID 回复
     * @param id
     * @return
     */
    public int delReply(int id);

}
