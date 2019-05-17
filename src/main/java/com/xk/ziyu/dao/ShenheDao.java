package com.xk.ziyu.dao;

import com.xk.ziyu.entity.Shenhe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShenheDao {
    /**
     * 获取审核总记录数
     * @return
     */
    int selectCount();

    /**
     * 查询所有审核信息
     * @return
     */
    List<Shenhe> selectAllShenhe();

    /**
     * 获取查询审核总记录数
     * @param name
     * @return
     */
    int selectQueryCount(@Param("name") Integer name);

    /**
     * 根据关审核类型查找审核记录
     * @param name
     * @return
     */
    List<Shenhe> selectByKeywords(@Param("name") Integer name);

    /**
     * 添加一条新的审核记录
     * @return
     */
    public int addshenhe(@Param("quaLevel")String quaLevel, @Param("reportingTime")String reportingTime, @Param("occupation")String occupation, @Param("certificateNo")String
            certificateNo, @Param("zili")String zili, @Param("zilidesc")String zilidesc, @Param("field")String field, @Param("fielddesc")String fielddesc, @Param("client")String client,
                       @Param("userid")Integer userid, @Param("photo")String photo, @Param("name")String name, @Param("idcard")String idcard);

    /**
     * 获取指定id用户的审核状态
     * @param userid
     * @return
     */
    public List<Shenhe> getStatus(@Param("userid")Integer userid);

    /**
     * 获取指定id审核记录
     * @param id
     * @return
     */
    public Shenhe getShenheById(@Param("id")Integer id);

    /**
     * 通过申请
     * @param id
     * @return
     */
    public int agree(@Param("id")Integer id);

    /**
     * 拒绝申请
     * @param id
     * @return
     */
    public int jujue(@Param("id")Integer id);
}
