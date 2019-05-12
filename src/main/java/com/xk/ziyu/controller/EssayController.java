package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Essay;
import com.xk.ziyu.entity.Picture;
import com.xk.ziyu.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/essay")
public class EssayController {
    @Autowired
    private EssayService essayService;

    /**
     * 获取当前页文章
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO getList(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Essay> essayList = essayService.getAllEssay(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(essayService.getCount());
        responseDTO.setData(essayList);

        return responseDTO;
    }

    /**
     * 查询文章
     * @param currentpage
     * @param pagesize
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Essay> essayList = essayService.queryEssay(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(essayService.getQueryCount(name));
        responseDTO.setData(essayList);

        return responseDTO;
    }

    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Essay essay = essayService.getEssay(id);

        if (essay != null){
            responseDTO.setCode(20000);
            responseDTO.setData(essay);
        }
        return responseDTO;
    }

    /**
     * 删除指定 id 文章
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = essayService.delEssay(id);
        if (res !=0) {
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    @RequestMapping("/getHot")
    public ResponseDTO getHotEssay(Integer len){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Essay> essayList = essayService.getHotEssay(len);
        responseDTO.setCode(20000);
        responseDTO.setData(essayList);

        return responseDTO;
    }

    @RequestMapping("/listByCollect")
    public  ResponseDTO listByCollect(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Essay> essayList = essayService.getAllByCollect(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(essayService.getCount());
        responseDTO.setData(essayList);

        return responseDTO;
    }

    @RequestMapping("/listTop")
    public ResponseDTO getTopList(Integer userId, int len){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Essay> essayList = essayService.getTopList(userId, len);
        responseDTO.setCode(20000);
        responseDTO.setData(essayList);

        return responseDTO;
    }
}
