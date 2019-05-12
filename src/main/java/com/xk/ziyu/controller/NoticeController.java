package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Notice;
import com.xk.ziyu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Notice> noticeList = noticeService.getAllNotice(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(noticeService.getCount());
        responseDTO.setData(noticeList);

        return responseDTO;
    }

    /**
     * 查询公告
     * @param currentpage
     * @param pagesize
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Notice> noticeList = noticeService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(noticeService.getQueryCount(name));
        responseDTO.setData(noticeList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Notice notice = noticeService.get(id);

        if (notice != null){
            responseDTO.setCode(20000);
            responseDTO.setData(notice);
        }
        return responseDTO;
    }

    /**
     * 删除指定 id 公告
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = noticeService.del(id);
        if (res !=0) {
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    /**
     * 发布公告
     * @return
     */
    @RequestMapping("/add")
    public ResponseDTO add(String title, String content){
        ResponseDTO<Notice> responseDTO = new ResponseDTO<>();
        int res = noticeService.add(title, content);

        responseDTO.setCode(20000);

        return responseDTO;
    }

    @RequestMapping("/getLast")
    public ResponseDTO getLastNotice(Integer len){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Notice> noticeList = noticeService.getLastNotice(len);
        responseDTO.setCode(20000);
        responseDTO.setData(noticeList);

        return responseDTO;
    }
}
