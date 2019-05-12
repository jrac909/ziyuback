package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.QuestionTag;
import com.xk.ziyu.service.QuestionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/questionTag")
public class QuestionTagController {
    @Autowired
    private QuestionTagService questionTagService;

    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<QuestionTag> questionTagList = questionTagService.getAll(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(questionTagService.getCount());
        responseDTO.setData(questionTagList);

        return responseDTO;
    }

    /**
     * 查询标签
     * @param currentpage
     * @param pagesize
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<QuestionTag> questionTagList = questionTagService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(questionTagService.getQueryCount(name));
        responseDTO.setData(questionTagList);

        return responseDTO;
    }

    /**
     * 删除指定 id 标签
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = questionTagService.del(id);
        if (res !=0) {
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    /**
     * 添加标签
     * @return
     */
    @RequestMapping("/add")
    public ResponseDTO add(String title){
        ResponseDTO<QuestionTag> responseDTO = new ResponseDTO<>();
        int res = questionTagService.add(title);

        responseDTO.setCode(20000);

        return responseDTO;
    }
}
