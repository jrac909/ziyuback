package com.xk.ziyu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.common.Global;
import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.Picture;
import com.xk.ziyu.service.PictureService;
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
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private PictureService pictureService;

    /**
     * 获取所有图片
     * @return
     */
    @RequestMapping("/list")
    public ResponseDTO getList(Integer pageNum, Integer pageSize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Picture> items = pictureService.getAllPicture(pageNum, pageSize);

        responseDTO.setCode(20000);
        responseDTO.setTotal(pictureService.getCount());
        responseDTO.setData(items);

        return responseDTO;
    }

    /**
     * 根据条件关键字查询图片
     * @param picname 名字
     * @param pictype 类型
     * @param picshow 是否展示
     * @return
     */
    @RequestMapping("/query")
    public ResponseDTO queryList(Integer pageNum, Integer pageSize, String picname, String pictype, String picshow){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Picture> items = pictureService.queryPic(pageNum, pageSize, picname, pictype, picshow);
        responseDTO.setCode(20000);
        responseDTO.setTotal(pictureService.getQueryCount(picname, pictype, picshow));
        responseDTO.setData(items);
        return responseDTO;
    }

    /**
     * 获取倒序前三条展示的图片
     * @return
     */
    @RequestMapping("/getAdsList")
    public ResponseDTO getAdsList(){

        ResponseDTO responseDTO = new ResponseDTO<>();
        List<Picture> piclist = pictureService.getAdsPicture();
        System.out.println("pic"+piclist.size());
        responseDTO.setCode(20000);
        responseDTO.setData(piclist);
        return responseDTO;
    }

    /**
     * 上传图片（单独上传）
     * @param req
     * @param multiReq
     * @return
     * @throws IOException
     */
    @RequestMapping("/add")
    public ResponseDTO addPic(HttpServletRequest req, MultipartHttpServletRequest multiReq) throws IOException {
        System.out.println("aha.....");
        MultipartFile file = multiReq.getFile("file");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String filename = new Date().getTime()+suffix;
        System.out.println("filename"+filename);
        Global.adminPhoto = "/static/image/"+filename;

        File localFile = new File("F:\\VueSpace\\vue-admin-template-master\\static\\image\\" + filename);
        File localFile2 = new File("F:\\VueSpace\\ziyu\\static\\image\\" + filename);
        if (!localFile.exists() && !localFile2.exists()) {
            localFile.createNewFile();
            localFile2.createNewFile();

            FileOutputStream fos = new FileOutputStream(
                    localFile);
            FileOutputStream fos2 = new FileOutputStream(
                    localFile2);
            FileInputStream fs = (FileInputStream) multiReq.getFile("file").getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fs.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                fos2.write(buffer, 0, len);
            }
            fos.close();
            fos2.close();
            fs.close();

        } else {
            System.out.println("文件已存在！！");
        }

        return null;
    }

    /**
     * 添加图片信息
     * @return
     */
    @RequestMapping("/addpic")
    public ResponseDTO<Picture> addPicInfo(String name, String type, String show, String link){
        System.out.println("info:"+name+type+show+link+Global.adminPhoto);
        ResponseDTO<Picture> responseDTO = new ResponseDTO<>();
        int res = pictureService.addPic(name, type, show, link, Global.adminPhoto);
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @RequestMapping("/del")
    public ResponseDTO delPic(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = pictureService.delPic(id);
        if (res != 0){
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    @RequestMapping("/getById")
    public ResponseDTO getPicById(Integer id){
        ResponseDTO<Picture> responseDTO = new ResponseDTO<>();
        Picture picture = pictureService.getPic(id);
        if (picture != null){
            responseDTO.setData(picture);
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }

    @RequestMapping("/update")
    public ResponseDTO upPic(Integer picId, String picName, String picType, String picIsShow, String picLink){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = pictureService.upPic(picId, picName, picType, picIsShow, picLink);
        if (res != 0){
            responseDTO.setCode(20000);
        }
        return responseDTO;
    }
}
