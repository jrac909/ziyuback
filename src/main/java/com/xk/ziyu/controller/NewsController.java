package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.News;
import com.xk.ziyu.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private WebSocket webSocket;
    @Autowired
    private NewsService newsService;

    @RequestMapping("/test")
    public ResponseDTO test(){
        ResponseDTO responseDTO = new ResponseDTO();
        webSocket.sendAllMessage("测试一下");

        responseDTO.setCode(20000);
        return responseDTO;
    }

    @RequestMapping("/getAllNews")
    public List<News> getAllNews(){
        List<News> newsList = newsService.getAllNews();

        return newsList;
    }
}
