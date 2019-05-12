package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Sixin;
import com.xk.ziyu.service.SixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/sixin")
public class SixinController {
    @Autowired
    private SixinService sixinService;

    @RequestMapping("/list")
    public ResponseDTO getAllEssayBoard(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Sixin> sixinList = sixinService.getAll(currentpage, pagesize);
        responseDTO.setCode(20000);
        responseDTO.setTotal(sixinService.getCount());
        responseDTO.setData(sixinList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Sixin> sixinList = sixinService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(sixinService.getQueryCount(name));
        responseDTO.setData(sixinList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Sixin sixin = sixinService.get(id);

        responseDTO.setCode(20000);
        responseDTO.setData(sixin);

        return responseDTO;
    }
}
