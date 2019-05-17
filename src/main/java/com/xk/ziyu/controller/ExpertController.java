package com.xk.ziyu.controller;

import com.xk.ziyu.common.Global;
import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Expert;
import com.xk.ziyu.entity.ExpertUserCon;
import com.xk.ziyu.service.ExpertService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @RequestMapping("/getAllExpert")
    public List<ExpertUserCon> getAllExpert(){
        List<ExpertUserCon> expertList = expertService.getAllExpert();

        return expertList;
    }

    @RequestMapping("/getExpertByNameAndField")
    public List<ExpertUserCon> getExpertByNameAndField(String keyWord){
        List<ExpertUserCon> expertByNameAndFieldList = expertService.getExpertByNameAndField(keyWord);


        return expertByNameAndFieldList;
    }

    @RequestMapping("/getLast")
    public ResponseDTO getLastEUC(Integer len){
        ResponseDTO responseDTO = new ResponseDTO();
        List<ExpertUserCon> expertUserConList = expertService.getLastEUC(len);
        responseDTO.setCode(20000);
        responseDTO.setData(expertUserConList);

        return responseDTO;
    }

    /**
     * 管理端：按页码获取专家细信息
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<ExpertUserCon> expertUserConList = expertService.getList(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(expertService.getCount());
        responseDTO.setData(expertUserConList);

        return responseDTO;
    }

    /**
     * 业务端：按页码获取专家细信息(只获取审核成功用户)
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/listTrue")
    public ResponseDTO listTrue(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<ExpertUserCon> expertUserConList = expertService.getTrueList(currentpage, pagesize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(expertService.getTrueCount());
        responseDTO.setData(expertUserConList);

        return responseDTO;
    }

    /**
     * 业务端：按页码查询专家细信息（根据专家姓名和擅长领域查询）
     * @param currentpage
     * @param pagesize
     * @return
     */
    @RequestMapping("/queryTrue")
    public ResponseDTO queryTrue(Integer currentpage, Integer pagesize, String name){
        ResponseDTO responseDTO = new ResponseDTO<>();
        List<ExpertUserCon> expertUserConList = expertService.queryTrueList(currentpage, pagesize, name);

        responseDTO.setCode(20000);
        responseDTO.setTotal(expertService.queryTrueCount(name));
        responseDTO.setData(expertUserConList);

        return responseDTO;
    }

    /**
     * 获取入驻专家总数
     * @return
     */
    @RequestMapping("/getCount")
    public ResponseDTO getExpertCount(){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCode(20000);
        responseDTO.setData(expertService.getTrueCount());

        return responseDTO;
    }

    /**
     * 根据专家 ID 获取专家用户 JOIN 信息
     * @param expertId
     * @return
     */
    @RequestMapping("/getById")
    public ResponseDTO getById(Integer expertId){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCode(20000);
        responseDTO.setData(expertService.getById(expertId));

        return responseDTO;
    }

    @RequestMapping("/upzige")
    public ResponseDTO addZige(HttpServletRequest req, MultipartHttpServletRequest multiReq) throws IOException {
        ResponseDTO responseDTO = new ResponseDTO();

        MultipartFile file = multiReq.getFile("file");
        String originalFilename;
        String suffix;
        String filename;
        File localfile;
        FileOutputStream fos;
        FileInputStream fs;


            // 获取图片文件名字
            originalFilename = file.getOriginalFilename();
            System.out.println("originname:"+originalFilename);
            //
           suffix =  originalFilename.substring(originalFilename.indexOf("."));
            System.out.println("suffix"+suffix);
            // 通过时间命名，避免重复
            filename = new Date().getTime()+suffix;
            // 在本地创建一个文件
            Global.zigeImage = "http://localhost:9988//images/"+filename;
            localfile = new File("F:\\zige\\images\\"+filename);
            if (!localfile.exists()){
                localfile.createNewFile();
                fos = new FileOutputStream(localfile);
                fs = (FileInputStream) file.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fs.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                fs.close();
            } else {
                System.out.println("文件已存在");
            }



        return null;
    }
}
