package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.QuestionReplyUser;
import com.xk.ziyu.service.QuestionReplyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/questionReplyUser")
public class QuestionReplyUserController {
    @Autowired
    private QuestionReplyUserService questionReplyUserService;

    @RequestMapping("/list")
    public ResponseDTO getAllEssayBoard(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<QuestionReplyUser> questionReplyUserList = questionReplyUserService.getAll(currentpage, pagesize);
        responseDTO.setCode(20000);
        responseDTO.setTotal(questionReplyUserService.getCount());
        responseDTO.setData(questionReplyUserList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<QuestionReplyUser> questionReplyUserList = questionReplyUserService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(questionReplyUserService.getQueryCount(name));
        responseDTO.setData(questionReplyUserList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        QuestionReplyUser quesAnsUser = questionReplyUserService.get(id);

        responseDTO.setCode(20000);
        responseDTO.setData(quesAnsUser);

        return responseDTO;
    }

    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = questionReplyUserService.del(id);

        if (res != 0){
            responseDTO.setCode(20000);
        }

        return responseDTO;
    }
}
