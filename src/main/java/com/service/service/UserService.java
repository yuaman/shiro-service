/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.service
 *
 *    Filename:    UserService.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     lightSmart
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年2月27日 上午11:15:08
 *
 *    Revision:
 *
 *    2017年2月27日 上午11:15:08
 *        - first revision
 *
 *****************************************************************/
package com.service.service;

import com.service.domain.User;
import com.service.domain.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年2月27日 上午11:15:08
 * @version 1.0.0
 */
public interface UserService {
	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String userNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(String userNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
}
