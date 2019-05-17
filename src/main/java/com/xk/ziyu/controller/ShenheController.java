package com.xk.ziyu.controller;

import com.xk.ziyu.common.Global;
import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Shenhe;
import com.xk.ziyu.service.ShenheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shenhe")
public class ShenheController {
    @Autowired
    private ShenheService shenheService;

    /**
     * 分页获取所有审核数据
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Shenhe> shenheList = shenheService.getAllShenhe(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(shenheService.getCount());
        responseDTO.setData(shenheList);

        return responseDTO;
    }

    /**
     * 查询审核
     * @param currentpage
     * @param pagesize
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer currentpage, Integer pagesize, Integer name){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Shenhe> shenheList = shenheService.query(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(shenheService.getQueryCount(name));
        responseDTO.setData(shenheList);

        return responseDTO;
    }
    /**
     * 添加一条新的审核
     * @return
     */
    @RequestMapping("/addShenhe")
    public ResponseDTO addShenhe(String quaLevel, String reportingTime, String occupation, String certificateNo,
                                 String zili, String zilidesc, String field, String fielddesc, String client,
                                 Integer userid, String name, String idcard){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = shenheService.addshenhe(quaLevel, reportingTime, occupation, certificateNo, zili, zilidesc, field, fielddesc, client, userid, Global.zigeImage, name, idcard);

        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 获取指定id用户的审核状态
     * @param userid
     * @return
     */
    @RequestMapping("/getStatus")
    public ResponseDTO getStatus(Integer userid){
        ResponseDTO responseDTO = new ResponseDTO();
        int status = 3;
        List<Shenhe> shenheList = shenheService.getStatus(userid);
        if (shenheList != null){
            status = shenheList.get(0).getStatus();
        }
        responseDTO.setCode(20000);
        responseDTO.setData(status);

        return responseDTO;
    }

    /**
     * 获取指定id用户的审核记录
     * @param id
     * @return
     */
    @RequestMapping("/getById")
    public ResponseDTO getShenheById(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Shenhe shenhe = shenheService.getShenheById(id);
        responseDTO.setData(shenhe);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 同意申请
     * @param id
     * @return
     */
    @RequestMapping("/agree")
    public ResponseDTO agree(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = shenheService.agree(id);

        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 拒绝申请
     * @param id
     * @return
     */
    @RequestMapping("/jujue")
    public ResponseDTO jujue(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = shenheService.jujue(id);

        responseDTO.setCode(20000);

        return responseDTO;
    }
}
