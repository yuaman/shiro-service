/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.controller
 *
 *    Filename:    UserController.java
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
 *    Create at:   2017年2月27日 上午10:50:46
 *
 *    Revision:
 *
 *    2017年2月27日 上午10:50:46
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年2月27日 上午10:50:46
 * @version 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
@Resource
private UserService userService;

//控制台打印
Log logger = LogFactory.getLog(getClass());

@RequestMapping("/showUsers")
@ResponseBody
public Map<String,List<?>> showFrameworkagreements(){
	UserExample example = new UserExample();
	Criteria criteria = example.createCriteria();
	criteria.andUserNameIsNotNull();
	List<User> list = userService.selectByExample(example);
	
	Map<String ,List<?>> map  = new HashMap<>();
	map.put("data", list);
	return map;
}

@RequestMapping("/showUser")
public ModelAndView showFrameworkagreement(String userNo){
    User user = userService.selectByPrimaryKey(userNo);
	ModelAndView mView = new ModelAndView();
	mView.setViewName("/login.jsp");
	mView.addObject("User", user);
	mView.addObject("staticURL", GetUrl.STATICURL);
	return mView;
}

/**
 * 
 * @Description 进入详情页面
 * @return
 */
@RequestMapping("/gotoDetail")
public ModelAndView gotoDetail(@RequestParam(value="userNo",required=true)String userNo ){
	User user = userService.selectByPrimaryKey(userNo);
	ModelAndView mView = new ModelAndView();
	mView.addObject("user", user);
    mView.addObject("staticURL", GetUrl.STATICURL);
    mView.setViewName("/userDetail.jsp");	
    return mView;
}

/**
 * 
 * @Description 进入框架协议编辑页面
 * @return
 */
@RequestMapping("/gotoEdit")
public ModelAndView gotoEdit(@RequestParam(value="userNo",required=true)String userNo){
	User user = userService.selectByPrimaryKey(userNo);
    ModelAndView mView = new ModelAndView();
	mView.addObject("user", user);
    mView.addObject("staticURL", GetUrl.STATICURL);
    mView.setViewName("/userEdit.jsp");	
    return mView;
}

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

@RequestMapping("/gotoUserList")
public ModelAndView gotoUserList( ){
    ModelAndView mView = new ModelAndView();
    mView.addObject("staticURL", GetUrl.STATICURL);
    mView.setViewName("/userList.jsp");	
    return mView;
}

/**
 * 保存添加
 * @Description (TODO这里用一句话描述这个方法的作用)
 * @param frameworkagreement
 * @return
 */
@RequestMapping("/save_addUser")
@ResponseBody
public String save_addFrameworkagreement(User user){
	user.setUserNo("User_"+YMDTools.currentTimestampkey());
	int num = userService.insertSelective(user);
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
	int num = userService.deleteByPrimaryKey(userNo);
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
@Resource
private UserRoleService userRoleService;
@RequestMapping("/delete_ajax")
@ResponseBody
public String delete_ajax(@RequestParam(value="userNo",required=true)String userNo){
	int num = userService.deleteByPrimaryKey(userNo);
	UserRoleExample userRoleExample = new UserRoleExample();
	userRoleExample.createCriteria().andUserIdEqualTo(userNo);
    userRoleService.deleteByExample(userRoleExample);	
    return num+"";
}

/**
 * 
 * @Description 修改用户
 * @param ykagreement
 * @return
 */
@RequestMapping("/editUser")
@ResponseBody
public String editUser(@RequestParam(value="userNo",required=true)String userNo,
		@RequestParam(value="userTel",required=true)String userTel,
		@RequestParam(value="userQQ",required=true)String userQQ,
		@RequestParam(value="userEmail",required=true)String userEmail){
	User user = userService.selectByPrimaryKey(userNo);
	if (CommTool.checkStr(userEmail)) {
		user.setUserEmail(userEmail);
	}else if (CommTool.checkStr(userTel)) {
		user.setUserTel(userTel);
	}else if (CommTool.checkStr(userQQ)) {
		user.setUserQq(userQQ);
		}
	int num = userService.updateByPrimaryKeySelective(user);	
	return num+"";
}
}
