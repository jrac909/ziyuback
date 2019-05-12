package com.xk.ziyu.service.impl;

import com.xk.ziyu.dao.ExpertBoardDao;
import com.xk.ziyu.entity.ExpertBoard;
import com.xk.ziyu.entity.ExpertReply;
import com.xk.ziyu.entity.form.ExpertBoardUserCon;
import com.xk.ziyu.service.ExpertBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpertBoardServiceImpl implements ExpertBoardService{
    @Autowired
    private ExpertBoardDao expertBoardDao;

    @Override
    public List<ExpertBoard> getAllExpertBoard() {
        return expertBoardDao.selectAllExpertBoard();
    }

    /**
     * 获取指定专家 ID 留言板内容
     * @param expertId
     * @return
     */
    @Override
    public List<ExpertBoardUserCon> get(int expertId) {
        return expertBoardDao.get(expertId);
    }

    /**
     * 删除指定 ID 的留言
     * @param ebId
     * @return
     */
    @Override
    public int del(int ebId) {
        return expertBoardDao.del(ebId);
    }

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
    @Override
    public int addReply(int erCommentId, int expertId, String content) {
        return expertBoardDao.addReply(erCommentId, expertId, content, new Date());
    }

    /**
     * 获取专家回复列表
     * @return
     */
    @Override
    public List<ExpertReply> listReply() {
        return expertBoardDao.listReply();
    }

    /**
     * 获取指定ID专家回复列表
     * @return
     */
    @Override
    public List<ExpertReply> getReply(int expertId) {
        return expertBoardDao.getReply(expertId);
    }

    /**
     * 删除指定 ID 回复
     * @param id
     * @return
     */
    @Override
    public int delReply(int id) {
        return expertBoardDao.delReply(id);
    }


}
