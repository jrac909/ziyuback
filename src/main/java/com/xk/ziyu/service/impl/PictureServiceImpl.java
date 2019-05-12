package com.xk.ziyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xk.ziyu.dao.PictureDao;
import com.xk.ziyu.entity.Picture;
import com.xk.ziyu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureDao pictureDao;


    @Override
    public int getCount() {
        return pictureDao.selectCount();
    }

    @Override
    public List<Picture> getAllPicture(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Picture> pictureList = pictureDao.selectAllPicture();
        PageInfo<Picture> pageInfo = new PageInfo<Picture>(pictureList);
        pictureList = pageInfo.getList();
        return pictureList;
    }

    @Override
    public List<Picture> getAdsPicture() {
        return pictureDao.selectAdsPicture();
    }

    /**
     * 获取查询总记录数
     * @return
     */
    @Override
    public int getQueryCount(String picname, String pictype, String picshow) {
        return pictureDao.selectQueryCount(picname, pictype, picshow);
    }

    /**
     * 根据关键字查找图片：1. 图片名称  2. 图片类型  3. 图片是否展示
     * @return
     */
    @Override
    public List<Picture> queryPic(Integer pageNum, Integer pageSize, String picname, String pictype, String picshow) {
        PageHelper.startPage(pageNum, pageSize);
        List<Picture> pictureList = pictureDao.selectByKeywords(picname, pictype, picshow);
        PageInfo<Picture> pageInfo = new PageInfo<Picture>(pictureList);
        pictureList = pageInfo.getList();
        return pictureList;
    }

    @Override
    public int addPic(String name, String type, String show, String link, String path) {
        int res = pictureDao.insertPic(name, type, show, link, path, new Date());
        return res;
    }

    /**
     * 删除指定 id 图片
     * @param id
     * @return
     */
    @Override
    public int delPic(Integer id) {
        return pictureDao.delPic(id);
    }

    /**
     * 获取指定 id 的图片
     * @param id
     * @return
     */
    @Override
    public Picture getPic(Integer id) {
        return pictureDao.selectPic(id);
    }

    /**
     * 修改指定 id 的图片信息
     * @param id
     * @param name
     * @param type
     * @param show
     * @param link
     * @return
     */
    @Override
    public int upPic(Integer id, String name, String type, String show, String link) {
        int res = pictureDao.upPic(id, name, type, show, link, new Date());
        return res;
    }
}
