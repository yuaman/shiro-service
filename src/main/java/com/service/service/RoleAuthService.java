/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.service
 *
 *    Filename:    RoleAuthService.java
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
 *    Create at:   2017年2月28日 下午3:36:44
 *
 *    Revision:
 *
 *    2017年2月28日 下午3:36:44
 *        - first revision
 *
 *****************************************************************/
package com.service.service;

import com.service.domain.RoleAuth;
import com.service.domain.RoleAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleAuthService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年2月28日 下午3:36:44
 * @version 1.0.0
 */
public interface RoleAuthService {
	 /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int countByExample(RoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int deleteByExample(RoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int insert(RoleAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int insertSelective(RoleAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    List<RoleAuth> selectByExample(RoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RoleAuth record, @Param("example") RoleAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role_auth
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RoleAuth record, @Param("example") RoleAuthExample example);
    /** 
	* @Title: selectRoleAuthorityMap 
	* @Description: TODO[] 
	* @param @param params
	* @param @return    设定文件 
	* @return List<Map<String,Object>>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> selectRoleAuthorityMap(Map<String, Object> params);

	/** 
	* @Title: getExistAuthDisc 
	* @Description: TODO[] 
	* @param @param params
	* @param @return    设定文件 
	* @return Map<String,List<String>>    返回类型 
	* @throws 
	*/
	Map<String, List<String>> getExistAuthDisc(Map<String, String> params);
}
