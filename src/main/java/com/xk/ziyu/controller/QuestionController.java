package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Question;
import com.xk.ziyu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 获取当前页问题
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO getList(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Question> questionList = questionService.getAll(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(questionService.getCount());
        responseDTO.setData(questionList);

        return responseDTO;
    }

    /**
     * 查询问题
     * @param currentpage
     * @param pagesize
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer currentpage, Integer pagesize, String name, String type){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Question> questionList = questionService.query(currentpage, pagesize, name, type);

        responseDTO.setCode(20000);
        responseDTO.setTotal(questionService.getQueryCount(name, type));
        responseDTO.setData(questionList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Question question = questionService.get(id);

        if (question != null){
            responseDTO.setCode(20000);
            responseDTO.setData(question);
        }
        return responseDTO;
    }

    /**
     * 删除指定 id 问题
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = questionService.del(id);
        if (res !=0) {
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    /**
     * 添加新问题
     * @param userId
     * @param title
     * @param content
     * @param niming
     * @param tag
     * @return
     */
    @RequestMapping("/add")
    public ResponseDTO add(Integer userId, String title, String content, Integer niming, String tag){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = questionService.addQues(userId, title, content,niming, tag);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    @RequestMapping("/listTop")
    public ResponseDTO getTopList(Integer userId, int len){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Question> questionList = questionService.getTopList(userId, len);
        responseDTO.setCode(20000);
        responseDTO.setData(questionList);

        return responseDTO;
    }
}
