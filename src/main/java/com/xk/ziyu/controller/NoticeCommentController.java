package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.NoticeComment;
import com.xk.ziyu.service.NoticeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/noticeComment")
public class NoticeCommentController {
    @Autowired
    private NoticeCommentService noticeCommentService;

    @RequestMapping("/list")
    public ResponseDTO getList(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<NoticeComment> noticeCommentList = noticeCommentService.getAll(currentpage, pagesize);
        responseDTO.setCode(20000);
        responseDTO.setTotal(noticeCommentService.getCount());
        responseDTO.setData(noticeCommentList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<NoticeComment> noticeCommentList = noticeCommentService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(noticeCommentService.getQueryCount(name));
        responseDTO.setData(noticeCommentList);

        return responseDTO;
    }

    /**
     * 获取指定 id 的文章评论
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        NoticeComment noticeComment = noticeCommentService.get(id);

        responseDTO.setCode(20000);
        responseDTO.setData(noticeComment);

        return responseDTO;
    }

    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = noticeCommentService.del(id);

        if (res != 0){
            responseDTO.setCode(20000);
        }

        return responseDTO;
    }
}
