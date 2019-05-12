package com.xk.ziyu.controller;

import com.xk.ziyu.entity.Picture;
import com.xk.ziyu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/getAllPicture")
    public List<Picture> getAllPicture(){
        List<Picture> pictureList = pictureService.getAllPicture(1,3);

        return pictureList;
    }

    @RequestMapping("/getAdsPicture")
    public List<Picture> getAdsPicture(){
        List<Picture> adsPictureList = pictureService.getAdsPicture();

        return adsPictureList;
    }
}
