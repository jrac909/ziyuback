package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.dao.QuesAnsUserDao;
import com.xk.ziyu.entity.QuesAnsUser;
import com.xk.ziyu.service.QuesAnsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/quesAnsUser")
public class QuesAnsUserController {
    @Autowired
    private QuesAnsUserService quesAnsUserService;

    @RequestMapping("/list")
    public ResponseDTO getAllEssayBoard(Integer currentpage, Integer pagesize){
        System.out.println("页码信息："+currentpage+"____"+pagesize);
        ResponseDTO responseDTO = new ResponseDTO();
        List<QuesAnsUser> quesAnsUserList = quesAnsUserService.getAll(currentpage, pagesize);
        System.out.println("list length:"+quesAnsUserList.size());
        responseDTO.setCode(20000);
        responseDTO.setTotal(quesAnsUserService.getCount());
        System.out.println("count:"+quesAnsUserService.getCount());
        responseDTO.setData(quesAnsUserList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<QuesAnsUser> quesAnsUserList = quesAnsUserService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(quesAnsUserService.getQueryCount(name));
        responseDTO.setData(quesAnsUserList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        QuesAnsUser quesAnsUser = quesAnsUserService.get(id);

        responseDTO.setCode(20000);
        responseDTO.setData(quesAnsUser);

        return responseDTO;
    }

    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = quesAnsUserService.del(id);

        if (res != 0){
            responseDTO.setCode(20000);
        }

        return responseDTO;
    }
}
