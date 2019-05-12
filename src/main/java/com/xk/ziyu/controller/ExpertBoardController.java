package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.ExpertBoard;
import com.xk.ziyu.entity.ExpertReply;
import com.xk.ziyu.entity.form.ExpertBoardUserCon;
import com.xk.ziyu.service.ExpertBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/expertBoard")
public class ExpertBoardController {
    @Autowired
    private ExpertBoardService expertBoardService;

    @RequestMapping("/getAllExpertBoard")
    public List<ExpertBoard> getAllExpertBoard(){
        List<ExpertBoard> expertBoardList = expertBoardService.getAllExpertBoard();

        return expertBoardList;
    }

    /**
     * 获取专家个人中心留言板内容
     * @param expertId
     * @return
     */
    @RequestMapping("/get")
    public ResponseDTO get(Integer expertId){
        ResponseDTO responseDTO = new ResponseDTO();
        List<ExpertBoardUserCon> expertBoardUserConList = expertBoardService.get(expertId);
        responseDTO.setCode(20000);
        responseDTO.setData(expertBoardUserConList);

        return responseDTO;
    }

    /**
     * 删除指定 ID 的留言
     * @param ebId
     * @return
     */
    @RequestMapping("/del")
    public ResponseDTO del(Integer ebId){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = expertBoardService.del(ebId);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 专家回复留言
     * @param erCommentId
     *      用户 ID
     * @param expertId
     *      专家 ID
     * @param content
     *      回复内容
     * @return
     */
    @RequestMapping("/reply")
    public ResponseDTO addReply(Integer erCommentId, Integer expertId, String content){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = expertBoardService.addReply(erCommentId, expertId, content);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 获取专家回复列表
     * @return
     */
    @RequestMapping("/listReply")
    public ResponseDTO listReply(){
        ResponseDTO responseDTO = new ResponseDTO();
        List<ExpertReply> expertReplyList = expertBoardService.listReply();

        responseDTO.setCode(20000);
        responseDTO.setData(expertReplyList);

        return responseDTO;
    }

    /**
     * 获取指定ID专家回复列表
     * @return
     */
    @RequestMapping("/getReply")
    public ResponseDTO getReply(Integer expertId){
        ResponseDTO responseDTO = new ResponseDTO();
        List<ExpertReply> expertReplyList = expertBoardService.getReply(expertId);

        responseDTO.setCode(20000);
        responseDTO.setData(expertReplyList);

        return responseDTO;
    }

    /**
     * 删除指定 ID 回复
     * @param id
     * @return
     */
    @RequestMapping("/delReply")
    public ResponseDTO delReply(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();

        System.out.println("删除Contro："+id);
        int res = expertBoardService.delReply(id);
        responseDTO.setCode(20000);

        return responseDTO;
    }
}
