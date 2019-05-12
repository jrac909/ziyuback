package com.xk.ziyu.controller;

import com.xk.ziyu.common.Global;
import com.xk.ziyu.common.ResponseDTO;
import com.xk.ziyu.entity.User;
import com.xk.ziyu.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> userList = userService.getAllUser();

        return userList;
    }

    /**
     * 根据 id 获取用户
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public ResponseDTO get(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.getUser(id);

        if (user != null){
            responseDTO.setCode(20000);
            responseDTO.setData(user);
        }

        return responseDTO;
    }

    @RequestMapping("/list")
    public ResponseDTO list(Integer currentpage, Integer pagesize){
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> userList = userService.getAll(currentpage, pagesize);
        responseDTO.setCode(20000);
        responseDTO.setTotal(userService.getCount());
        responseDTO.setData(userList);

        return responseDTO;
    }

    @RequestMapping("/checkName")
    public ResponseDTO checkName(String username){
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userService.getUserByName(username);

        if (user != null){
            responseDTO.setData(user);
        }

        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 新用户注册
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register")
    public ResponseDTO register(String username, String password){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.addUser(username, password);
        responseDTO.setCode(20000);

        return responseDTO;
    }

    @RequestMapping("/login")
    public ResponseDTO login(String username, String password){
        ResponseDTO responseDTO = new ResponseDTO();
        String token = userService.checkUser(username, password);

        if (token == null){
            responseDTO.setCode(60204);
            responseDTO.setMessage("密码或账号错误，请重新输入！");
        } else {
            responseDTO.setCode(20000);
            User user = new User();
            user = userService.getUserByName(username);
            user.setUserToken(token);
            responseDTO.setData(user);
        }
        return responseDTO;
    }

    @RequestMapping("/getUserFan")
    public ResponseDTO getUserFans(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> userList = userService.getUserFans(id);
        responseDTO.setCode(20000);
        responseDTO.setData(userList);

        return responseDTO;
    }

    @RequestMapping("/getUserFollowed")
    public ResponseDTO getUserFollowed(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        List<User> userList = userService.getUserFollowed(id);
        responseDTO.setCode(20000);
        responseDTO.setData(userList);

        return responseDTO;
    }

    @RequestMapping("/updateUser")
    public ResponseDTO updateUser(Integer id, String name, String address, Integer gender, String jianjie){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.updateUser(id, name, address, gender, jianjie);

        responseDTO.setCode(20000);

        return responseDTO;
    }

    /**
     * 上传图片（单独上传）
     * @param req
     * @param multiReq
     * @return
     * @throws IOException
     */
    @RequestMapping("/updatePhoto")
    public ResponseDTO addPic(HttpServletRequest req, MultipartHttpServletRequest multiReq) throws IOException {
        MultipartFile file = multiReq.getFile("file");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String filename = new Date().getTime()+suffix;
        Global.userPhoto = "/static/image/"+filename;

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
    @RequestMapping("/savephoto")
    public ResponseDTO savePhoto(Integer id){
        ResponseDTO responseDTO = new ResponseDTO<>();
        int res = userService.updatePhoto(id, Global.userPhoto);
        responseDTO.setCode(20000);
        return responseDTO;
    }

    /**
     * 修改密码
     * @param id
     * @param pwd
     * @return
     */
    @RequestMapping("/updatePwd")
    public ResponseDTO updatePwd(Integer id, String pwd){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.updatePwd(id, pwd);
        responseDTO.setCode(20000);
        return responseDTO;
    }

    @RequestMapping("/isFollow")
    public ResponseDTO isFollow(Integer followId, Integer followedId){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.isFollow(followId, followedId);
        responseDTO.setCode(20000);
        responseDTO.setData(res);

        return responseDTO;
    }

    @RequestMapping("/follow")
    public ResponseDTO follow(Integer followId, Integer followedId){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.follow(followId, followedId);

        responseDTO.setCode(20000);

        return responseDTO;
    }

    @RequestMapping("/cancelFollow")
    public ResponseDTO cancelFollow(Integer followId, Integer followedId){
        ResponseDTO responseDTO = new ResponseDTO();
        int res = userService.cancelFollow(followId, followedId);

        responseDTO.setCode(20000);

        return responseDTO;
    }
}
