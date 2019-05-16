package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.News;
import com.xk.ziyu.entity.User;
import com.xk.ziyu.service.NewsService;
import com.xk.ziyu.service.UserService;
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
    @Autowired
    private UserService userService;

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

    @RequestMapping("/getWeiduCount")
    public ResponseDTO getWeiduCount(Integer id){
        System.out.println("收到ID："+id);
        ResponseDTO responseDTO = new ResponseDTO();
        int count = newsService.getWeiduCount(id);
        responseDTO.setData(count);
        responseDTO.setCode(20000);
        System.out.println("未读消息："+count);
        return responseDTO;
    }

    @RequestMapping("/getAllById")
    public ResponseDTO getAllById(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        List<News> newsList = newsService.getAllById(id);
        responseDTO.setData(newsList);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 取消两个用户之间所有的未读状态
     * @param id1
     * @param id2
     * @return
     */
    @RequestMapping("/cancelWeidu")
    public ResponseDTO cancel(Integer id1, Integer id2){
        ResponseDTO responseDTO = new ResponseDTO();
        newsService.cancelWeidu(id1, id2);
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @RequestMapping("/getCurNews")
    public ResponseDTO getCurNews(Integer id1, Integer id2){
        ResponseDTO responseDTO = new ResponseDTO();
        List<News> newsList = newsService.getCurNews(id1, id2);
        responseDTO.setCode(20000);
        responseDTO.setData(newsList);

        return responseDTO;
    }

    /**
     * 对应的是真实发送的id顺序
     * @param sendId
     * @param receiveId
     * @param content
     * @return
     */
    @RequestMapping("sendMsg")
    public ResponseDTO sendMsgToUser(Integer  sendId, Integer receiveId, String content){
        System.out.println("收到的三个参数："+sendId+receiveId+content);
        boolean online = webSocket.receiveUserOnline(receiveId);
        System.out.println(webSocket.receiveUserOnline(sendId));
        System.out.println(webSocket.receiveUserOnline(receiveId));
        if (online){
            webSocket.sendOneMessage(receiveId+"", content);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        User sendUser = userService.getUser(sendId);
        User receiveUser = userService.getUser(receiveId);

        if (webSocket.receiveUserOnline(receiveId)){
            newsService.addNews(sendId, receiveId, content, 1, 1, sendUser.getUserNickname(), receiveUser.getUserNickname());
        } else {
            newsService.addNews(sendId, receiveId, content, 1, 0, sendUser.getUserNickname(), receiveUser.getUserNickname());
        }
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @RequestMapping("/close")
    public ResponseDTO close(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        webSocket.closePool(id);
        responseDTO.setCode(20000);
        return responseDTO;
    }
}
