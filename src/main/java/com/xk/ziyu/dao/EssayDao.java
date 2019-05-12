package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

* @Description: 文章 Dao

* @Author: wanghaixue

* @CreateDate: 2019/2/18 21:49

* @Version: 1.0

*/
public interface EssayDao {
    /**
     * 获取总记录数
     * @return
     */
    int selectCount();
    /**
     * 查询所有文章
     * @return
     */
    List<Essay> selectAllEssay();

    /**
     * 获取查询总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") String name);

    /**
     * 根据关键字查找文章：标题内容  用户 id
     * @param name
     * @return
     */
    List<Essay> selectByKeywords(@Param("name") String name);

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Essay selectEssay(@Param("id") Integer id);

    /**
     * 删除指定 id 文章
     * @param id
     * @return
     */
    int delEssay(@Param("id") Integer id);

    /**
     * 获取收藏数前三的文章
     * @return
     */
    List<Essay> selectHotEssay(@Param("len") Integer len);

    /**
     * 获取所有（按收藏数）
     * @return
     */
    public List<Essay>selectAllByCollect();

    /**
     * 获取前几条文章
     * @param userId
     * @param len
     * @return
     */
    public List<Essay> getTopList(@Param("userId") Integer userId, @Param("len") Integer len);
}
