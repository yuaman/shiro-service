/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.controller
 *
 *    Filename:    RoleController.java
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
 *    Create at:   2017年3月1日 下午1:54:41
 *
 *    Revision:
 *
 *    2017年3月1日 下午1:54:41
 *        - first revision
 *
 *****************************************************************/
package com.service.controller;

import com.service.domain.*;
import com.service.domain.UserExample.Criteria;
import com.service.service.*;
import com.service.util.CommTool;
import com.service.util.JSONTool;
import com.service.util.YMDTools;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年3月1日 下午1:54:41
 * @version 1.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
@Inject
private RoleService roleService;
@Resource
private UserRoleService userRoleService;
@Resource
private UserService userService;
@Resource
private RoleAuthService roleAuthService;
@Resource
private AuthService authService;

//控制台打印
Log logger = LogFactory.getLog(getClass());

@RequestMapping("/showRoles")
@ResponseBody
public Map<String,List<?>> showFrameworkagreements(){
	RoleExample example = new RoleExample();
	com.service.domain.RoleExample.Criteria criteria = example.createCriteria();
	criteria.andRoleIdIsNotNull();
	List<Role> list = roleService.selectByExample(example);
	
	Map<String ,List<?>> map  = new HashMap<>();
	map.put("data", list);
	return map;
}

@RequestMapping("/showUser")
public ModelAndView showFrameworkagreement(String userNo){
	Role role = roleService.selectByPrimaryKey(userNo);
	ModelAndView mView = new ModelAndView();
	mView.setViewName("/login.jsp");
	mView.addObject("Role", role);
	mView.addObject("staticURL", GetUrl.STATICURL);
	return mView;
}

/**
* 
* @Description 进入详情页面
* @return
*//*
@RequestMapping("/gotoDetail")
public ModelAndView gotoDetail(@RequestParam(value="userNo",required=true)String userNo ){
	User user = roleService.selectByPrimaryKey(userNo);
	ModelAndView mView = new ModelAndView();
	mView.addObject("user", user);
  mView.addObject("staticURL", GetUrl.STATICURL);
  mView.setViewName("/userDetail.jsp");	
  return mView;
}

*//**
* 
* @Description 进入框架协议编辑页面
* @return
*//*
@RequestMapping("/gotoEdit")
public ModelAndView gotoEdit(@RequestParam(value="userNo",required=true)String userNo){
	User user = roleService.selectByPrimaryKey(userNo);
  ModelAndView mView = new ModelAndView();
	mView.addObject("user", user);
  mView.addObject("staticURL", GetUrl.STATICURL);
  mView.setViewName("/userEdit.jsp");	
  return mView;
}
*/
/**
* 
* @Description 进入协议列表
* @return
*/
@RequestMapping("/gotoAdd")
public ModelAndView gotoAdd( ){
  ModelAndView mView = new ModelAndView();
  mView.addObject("staticURL", GetUrl.STATICURL);
  mView.setViewName("/userAdd.jsp");	
  return mView;
}

@RequestMapping("/gotoRoleList")
public ModelAndView gotoUserList( ){
  ModelAndView mView = new ModelAndView();
  mView.addObject("staticURL", GetUrl.STATICURL);
  mView.setViewName("/roleList.jsp");	
  return mView;
}

/**
* 保存添加
* @Description (TODO这里用一句话描述这个方法的作用)
* @param frameworkagreement
* @return
*/
@RequestMapping("/addRole")
@ResponseBody
public String save_addFrameworkagreement(@RequestParam(value="role_name_add",required=true)String role_name_add,
		@RequestParam(value="role_disc_add",required=true)String role_disc_add){
	Role role = new Role();
	role.setRoleId("Role_"+YMDTools.currentTimestampkey());
	role.setRoleName(role_name_add);
	role.setRoleDisc(role_disc_add);
	role.setRoleDisFlag("Y");
	int num = roleService.insertSelective(role);
	return num+"";
}


/**
* 
* @Description 同步刪除操作
* @param framework_id
* @return
*/
@RequestMapping("/delUser")
public ModelAndView delFrameworkagreement(@RequestParam(value="userNo",required=true)String userNo ){
	int num = roleService.deleteByPrimaryKey(userNo);
	 ModelAndView mView = new ModelAndView();
      mView.addObject("staticURL", GetUrl.STATICURL);
      mView.setViewName("/userList.jsp");	
      return mView;
}

/**
* 
* @Description 异步删除操作
* @param framework_id
* @return
*/
@RequestMapping("/delete_ajax")
@ResponseBody
public String delete_ajax(@RequestParam(value="role_id",required=true)String role_id){
	int num = roleService.deleteByPrimaryKey(role_id);
      return num+"";
}
/*
*//**
* 
* @Description 修改用户
* @param ykagreement
* @return
*/
@RequestMapping("/editRole")
@ResponseBody
public String editUser(@RequestParam(value="role_id",required=true)String role_id,
		@RequestParam(value="role_name_edit_input",required=true)String role_name_edit_input,
		@RequestParam(value="role_disc_edit_input",required=true)String role_disc_edit_input){
		
	Role role = roleService.selectByPrimaryKey(role_id);
	role.setRoleName(role_name_edit_input);
	role.setRoleDisc(role_disc_edit_input);
	int num = roleService.updateByPrimaryKeySelective(role);	
	return num+"";
}


/**
 * 
 * @Description 查询拥有该角色的用户
 * @param role_id
 * @return
 */
@RequestMapping("/queryUser")
@ResponseBody
public List<String> queryUser(@RequestParam(value="role_id",required=true)String role_id){
	com.service.domain.UserRoleExample example = new com.service.domain.UserRoleExample();
	com.service.domain.UserRoleExample.Criteria criteria = example.createCriteria();
	criteria.andRoleIdEqualTo(role_id);
	List<UserRole> userRoleList = userRoleService.selectByExample(example);
	List<String> userNameList = new ArrayList<>();
	for(UserRole userRole : userRoleList) {
		String userNo = userRole.getUserId();
		User user = userService.selectByPrimaryKey(userNo);
		if(CommTool.checkStr(user.getUserName())) {
			userNameList.add(user.getUserName());
		}
	}
	return userNameList;
	}


/**
 * 
 * @Description 查询拥有该角色的用户
 * @param role_id
 * @return
 */
@RequestMapping("/queryUserNotContain")
@ResponseBody
public List<String> queryUserNotContain(@RequestParam(value="role_id",required=true)String role_id){
	com.service.domain.UserRoleExample example = new com.service.domain.UserRoleExample();
	com.service.domain.UserRoleExample.Criteria criteria = example.createCriteria();
	criteria.andRoleIdEqualTo(role_id);
	List<UserRole> userRoleList = userRoleService.selectByExample(example);
	List<String> userNameList = new ArrayList<>();
	for(UserRole userRole : userRoleList) {
		String userNo = userRole.getUserId();
		User user = userService.selectByPrimaryKey(userNo);
		if(user.getUserName() != null) {
			userNameList.add(user.getUserName());
		}
	}
	//查出不具有该角色的用户
	//先取出所有用户
	UserExample userExample = new UserExample();
	List<User> allUser = userService.selectByExample(userExample);
	//进行不具有该角色的用户的查询
	List<String> difUserNames = new ArrayList<>();
	for(User u : allUser) {
		if(!userNameList.contains(u.getUserName())) {
			difUserNames.add(u.getUserName());
		}
	}
	return difUserNames;
	}

/**
 * 
 * @Description (TODO这里用一句话描述这个方法的作用)
 * @param role_id
 * @return
 */
@RequestMapping("/userRoleChange")
@ResponseBody
public String userRoleChange(@RequestParam(value="role_id",required=true)String role_id,
		@RequestParam(value="contained",required=true)String contained,
		@RequestParam(value="contained_yet",required=true)String contained_yet){
	//清空该角色已有记录
	UserRoleExample userRoleExample = new UserRoleExample();
	com.service.domain.UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
	criteria.andRoleIdEqualTo(role_id);
	userRoleService.deleteByExample(userRoleExample);
	
	if (CommTool.checkStr(contained)) {
		List<String> contained_list = JSONTool.convertJson2List(contained, String.class);
		for (String contained_name : contained_list) {
			UserExample userExample = new UserExample();
			Criteria criteria_user = userExample.createCriteria();
			criteria_user.andUserNameEqualTo(contained_name);
			List<User> users = userService.selectByExample(userExample);
			for (User user : users) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(role_id);
				userRole.setUserId(user.getUserNo());
				userRoleService.insertSelective(userRole);
			}
			
		}
	}
	if (CommTool.checkStr(contained_yet)) {
		List<String> contained_yet_list = JSONTool.convertJson2List(contained_yet, String.class);
		for (String contained_name : contained_yet_list) {
			UserExample userExample = new UserExample();
			Criteria criteria_user = userExample.createCriteria();
			criteria_user.andUserNameEqualTo(contained_name);
			List<User> users = userService.selectByExample(userExample);
			for (User user : users) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(role_id);
				userRole.setUserId(user.getUserNo());
				userRoleService.insertSelective(userRole);
			}
		}
	}
	return 6+"";
	}


/**
 * 
 * @Description 查询拥有该角色的用户
 * @param role_id
 * @return
 */
@RequestMapping("/queryRoleAuth")
@ResponseBody
public List<String> queryRoleAuth(@RequestParam(value="role_id",required=true)String role_id){
	RoleAuthExample roleAuthExample = new RoleAuthExample();
	com.service.domain.RoleAuthExample.Criteria criteria = roleAuthExample.createCriteria();
	criteria.andRoleIdEqualTo(role_id);
	List<RoleAuth> roleAuths = roleAuthService.selectByExample(roleAuthExample);
	List<String> auth_codes = new ArrayList<>();
	for (RoleAuth roleAuth : roleAuths) {
		AuthExample example = new AuthExample();
		com.service.domain.AuthExample.Criteria criteria2 = example.createCriteria();
		criteria2.andAuthIdEqualTo(roleAuth.getAuthId());
		String auth_code = authService.selectByExample(example).get(0).getAuthCode();
		auth_codes.add(auth_code);
	}
	return auth_codes;
	}

/**
 * 
 * @Description 查询拥有该角色的用户
 * @param role_id
 * @return
 */
@RequestMapping("/RoleAuthChange")
@ResponseBody
public String RoleAuthChange(@RequestParam(value="role_id",required=true)String role_id,
		@RequestParam(value="auth_id_array",required=true)String auth_id_array){
	RoleAuthExample roleAuthExample = new RoleAuthExample();
	com.service.domain.RoleAuthExample.Criteria criteria = roleAuthExample.createCriteria();
	criteria.andRoleIdEqualTo(role_id);
	roleAuthService.deleteByExample(roleAuthExample);
	
	List<String> auth_ids = JSONTool.convertJson2List(auth_id_array, String.class);
	logger.info("=========="+auth_ids);
	for (String auth_id : auth_ids) {
		RoleAuth roleAuth = new RoleAuth();
		roleAuth.setRoleId(role_id);
		roleAuth.setAuthId(auth_id);
		roleAuthService.insertSelective(roleAuth);
	}
	return 6+"";
	}
}
