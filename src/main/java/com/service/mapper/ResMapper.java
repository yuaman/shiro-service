package com.service.mapper;

import com.service.domain.Res;
import com.service.domain.ResExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int countByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int deleteByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int insert(Res record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int insertSelective(Res record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    List<Res> selectByExample(ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Res record, @Param("example") ResExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_res
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Res record, @Param("example") ResExample example);
}