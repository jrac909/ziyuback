package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

/**

* @Description: 图片 Dao

* @Author: wanghaixue

* @CreateDate: 2019/3/5 22:00

* @Version: 1.0

*/
@Mapper
public interface PictureDao {
    /**
     * 获取记录总数
     * @return
     */
    int selectCount();
    /**
     * 获取所有图片
     * @return
     */
    List<Picture> selectAllPicture();

    /**
     * 获取 Banner 广告图片
     * @return
     */
    List<Picture> selectAdsPicture();

    /**
     * 获取查询记录总数
     * @return
     */
    int selectQueryCount(@Param("picname") String picname, @Param("pictype") String pictype, @Param("picshow") String picshow);

    /**
     * 根据关键字查找图片：1. 图片名称  2. 图片类型  3. 图片是否展示
     * @return
     */
    List<Picture> selectByKeywords(@Param("picname") String picname, @Param("pictype") String pictype, @Param("picshow") String picshow);

    /**
     * 添加一张图片
     * @return
     */
    int insertPic(@Param("name") String name, @Param("type") String type, @Param("show") String show, @Param("link") String link, @Param("path") String path, @Param("date") Date date);

    /**
     * 删除指定 id 图片(本质是修改 del 字段)
     * @param id
     * @return
     */
    int delPic(@Param("id") Integer id);

    /**
     * 查询指定id图片
     * @param id
     * @return
     */
    Picture selectPic(@Param("id") Integer id);

    /**
     * 修改指定 id 的图片信息
     * @param name
     * @param type
     * @param show
     * @param link
     * @param date
     * @return
     */
    int upPic(@Param("id") Integer id, @Param("name") String name, @Param("type") String type, @Param("show") String show, @Param("link") String link, @Param("date") Date date);

}
