package com.xk.ziyu.controller;

import com.xk.ziyu.entity.ExpertField;
import com.xk.ziyu.service.ExpertFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/expertField")
public class ExpertFieldController {
    @Autowired
    private ExpertFieldService expertFieldService;

    @RequestMapping("/getAllExpertField")
    public List<ExpertField> getAllExpertField(){
        List<ExpertField> expertFieldList = expertFieldService.getAllExpertField();

        return expertFieldList;
    }
}
