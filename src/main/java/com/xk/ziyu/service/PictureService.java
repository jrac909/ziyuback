package com.xk.ziyu.service;

import com.xk.ziyu.entity.Picture;

import java.util.List;

public interface PictureService {
    /**
     * 获取记录总数
     * @return
     */
    public int getCount();
    /**
     * 获取所有图片信息
     * @return
     */
    public List<Picture> getAllPicture(int pageNum, int pageSize);

    /**
     * 获取首页 Banner 图
     * @return
     */
    public List<Picture> getAdsPicture();

    /**
     * 获取查询记录总数
     * @return
     */
    public int getQueryCount(String picname, String pictype, String picshow);

    /**
     * 根据关键字查找图片：1. 图片名称  2. 图片类型  3. 图片是否展示
     * @return
     */
    public List<Picture> queryPic(Integer pageNum, Integer pageSize, String picname, String pictype, String picshow);

    /**
     * 添加一张图片
     * @param name
     * @param type
     * @param show
     * @param link
     * @param path
     * @return
     */
    public int addPic(String name, String type, String show, String link, String path);

    /**
     * 删除指定id图片
     * @param id
     * @return
     */
    public int delPic(Integer id);

    /**
     * 根据 id 查询图片
     * @param id
     * @return
     */
    public Picture getPic(Integer id);

    /**
     * 修改指定 id 的图片
     * @param id
     * @param name
     * @param type
     * @param show
     * @param link
     * @return
     */
    public int upPic(Integer id, String name, String type, String show, String link);
}
