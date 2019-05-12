package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.QuesUserCon;
import com.xk.ziyu.service.QuesUserConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/quesUserCon")
public class QuesUserConController {
    @Autowired
    private QuesUserConService quesUserConService;

    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<QuesUserCon> quesUserConList = quesUserConService.getAll(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(quesUserConService.getCount());
        responseDTO.setData(quesUserConList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        System.out.println("name是："+name);
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<QuesUserCon> quesUserConList = quesUserConService.query(currentpage, pagesize, name);
        System.out.println("查询到："+quesUserConList.size());

        responseDTO.setCode(20000);
        responseDTO.setTotal(quesUserConService.queryCount(name));
        responseDTO.setData(quesUserConList);

        return responseDTO;
    }

    @RequestMapping("/queryByHot")
    public ResponseDTO queryByHot(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<QuesUserCon> quesUserConList = quesUserConService.queryByHot(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(quesUserConService.getCount());
        responseDTO.setData(quesUserConList);

        return responseDTO;
    }

    @RequestMapping("/queryByType")
    public ResponseDTO queryByType(Integer currentpage, Integer pagesize, String type){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<QuesUserCon> quesUserConList = quesUserConService.queryByType(currentpage, pagesize, type);

        responseDTO.setCode(20000);
        responseDTO.setTotal(quesUserConService.queryByTypeCounr(type));
        responseDTO.setData(quesUserConList);

        return responseDTO;
    }

    /**
     * 根据 ID 查询记录
     * @param quesId
     * @return
     */
    @RequestMapping("/get")
    public ResponseDTO get(Integer quesId){
        ResponseDTO responseDTO = new ResponseDTO();
        QuesUserCon quesUserCon = quesUserConService.get(quesId);
        responseDTO.setCode(20000);
        responseDTO.setData(quesUserCon);

        return responseDTO;
    }
}
