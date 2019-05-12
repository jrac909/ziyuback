package com.xk.ziyu.controller;

import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.dao.EsComUserConDao;
import com.xk.ziyu.dao.EssayBoardDao;
import com.xk.ziyu.entity.EsComUserCon;
import com.xk.ziyu.entity.EssayBoard;
import com.xk.ziyu.service.EssayBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/essayBoard")
public class EssayBoardController {

    @Autowired
    private EssayBoardService essayBoardService;
    @Autowired
    private EsComUserConDao esComUserConDao;

    @RequestMapping("/list")
    public ResponseDTO getAllEssayBoard(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<EssayBoard> essayBoardList = essayBoardService.getAllEssayBoard(currentpage, pagesize);
        responseDTO.setCode(20000);
        responseDTO.setTotal(essayBoardService.getCount());
        responseDTO.setData(essayBoardList);

        return responseDTO;
    }

    @RequestMapping("/query")
    public ResponseDTO query(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<EssayBoard> essayBoardList = essayBoardService.queryEssayBoard(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(essayBoardService.getQueryCount(name));
        responseDTO.setData(essayBoardList);

        return responseDTO;
    }

    /**
     * 获取指定 id 的文章评论
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        EssayBoard essayBoard = essayBoardService.get(id);

        responseDTO.setCode(20000);
        responseDTO.setData(essayBoard);

        return responseDTO;
    }

    @RequestMapping("/del")
    public ResponseDTO del(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = essayBoardService.delEB(id);

        if (res != 0){
            responseDTO.setCode(20000);
        }

        return responseDTO;
    }

    @RequestMapping("/getDetail")
    public ResponseDTO getDetail(Integer essayId){
        ResponseDTO responseDTO = new ResponseDTO();
        List<EsComUserCon> esComUserConList = esComUserConDao.selectAll(essayId);
        responseDTO.setCode(20000);
        responseDTO.setData(esComUserConList);

        System.out.println("akk:"+esComUserConList.size());

        return responseDTO;
    }

    /**
     * 添加文章评论
     * @param userId
     * @param comment
     * @param essayId
     * @return
     */
    @RequestMapping("/add")
    public ResponseDTO addEB(Integer userId, String comment, Integer essayId){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = essayBoardService.addEB(userId, comment, essayId);
        responseDTO.setCode(20000);

        return responseDTO;
    }
}
