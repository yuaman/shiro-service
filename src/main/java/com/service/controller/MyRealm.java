/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.controller
 *
 *    Filename:    MyRealm.java
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
 *    Create at:   2017年2月28日 上午11:18:37
 *
 *    Revision:
 *
 *    2017年2月28日 上午11:18:37
 *        - first revision
 *
 *****************************************************************/
package com.service.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.RoleTag;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
//import com.mongodb.diagnostics.logging.Logger;

import net.sf.ehcache.Cache;
import net.youhj.domain.User;
import net.youhj.domain.UserExample;
import net.youhj.domain.UserExample.Criteria;
import net.youhj.service.ResService;
import net.youhj.service.RoleAuthService;
import net.youhj.service.UserRoleService;
import net.youhj.service.UserService;
import net.youhj.util.CommTool;
import net.youhj.util.Const;
import net.youhj.util.JSONTool;
import net.youhj.util.YMDTools;
import redis.clients.jedis.JedisCluster;

/**
 * @ClassName MyRealm
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年2月28日 上午11:18:37
 * @version 1.0.0
 */
/**
 * 自定义的指定Shiro验证用户登录的类
 * @see 在本例中定义了2个用户:jadyer和玄玉,jadyer具有admin角色和admin:manage权限,玄玉不具有任何角色和权限
 * @create Sep 29, 2013 3:15:31 PM
 * @author 玄玉<http://blog.csdn.net/jadyer>
 */
public class MyRealm extends AuthorizingRealm {
	@Resource
    private UserService userService;
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private RoleAuthService roleAuthService;
	@Resource
	private ResService resService;
	
	 private static String hostName = "122.136.65.69";//主机名
	    private static int port = 27017;//端口号
	    private static int poolSize = 10;//连接池大小
	/**
	 * 为当前登录的Subject授予角色和权限
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 * @see 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
	 * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		//获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String currentUsername = (String)super.getAvailablePrincipal(principals);
		List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		
		//从数据库中获取当前登录用户的详细信息
		
		//得到该用户具有的权限列表
        Map<String,Object> params = new HashMap<String,Object>();
        params.put(Const.SQLNAME,"select4001");
        params.put("userName",currentUsername);
        List<Map<String,Object>> perListMap = userRoleService.selectUserPermissMap(params); 
        for(Map<String, Object> map:perListMap) {
        	permissionList.add(map.get("authCode").toString());
        }
        //得到该用户具有的角色列表
        params.put(Const.SQLNAME, "select6001");
        List<Map<String,Object>> roleListMap = roleAuthService.selectRoleAuthorityMap(params);
        for(Map<String, Object> map:roleListMap) {
        	roleList.add(map.get("roleName").toString());
        }
        
        //要把permissionList内容进行修改，当“：”个数大于1时就要截取字符串，进行资源权限拼接，拼成资源标识符。
        List<String> permissions = new ArrayList<>();
        if(CommTool.checkList(permissionList)) {
        	for(String perStr:permissionList) {
        		//对perStr进行判断
        		String[] perArr = perStr.split(":");
        		if(perArr.length > 2) {
        			//有多个：,进行处理
        			String prefix = perArr[0];
        			for(int i=1; i<perArr.length; i++) {
        				String adc = prefix + ":" + perArr[i];
        				permissions.add(adc);
        			}
        		} else {
        			permissions.add(perStr);
        		}
        	}
        }
        
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
	    simpleAuthorInfo.addRoles(roleList);  
	    simpleAuthorInfo.addStringPermissions(permissions);  
	    return simpleAuthorInfo;
	    
	    
		/*if(CommTool.checkList(users)){
			//实体类User中包含有用户角色的实体类信息
			if(null!=user.getRoles() && user.getRoles().size()>0){
				//获取当前登录用户的角色
				for(RoleTag role : user.getRoles()){
					roleList.add(role.getName());
					//实体类Role中包含有角色权限的实体类信息
					if(null!=role.getPermissions() && role.getPermissions().size()>0){
//						//获取权限
//						for(Permission pmss : role.getPermissions()){
//							if(!StringUtils.isEmpty(pmss.getPermission())){
//								permissionList.add(pmss.getPermission());
//							}
//						}
//					}
//				}
//			}
//		}else{
//			throw new AuthorizationException();
//		}
//		//为当前用户设置角色和权限
//		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
//		simpleAuthorInfo.addRoles(roleList);
//		simpleAuthorInfo.addStringPermissions(permissionList);
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		//实际中可能会像上面注释的那样从数据库取得
*//*		if(null!=currentUsername && "jadyer".equals(currentUsername)){
			//添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色  
			simpleAuthorInfo.addRole("admin");
			//添加权限
			simpleAuthorInfo.addStringPermission("admin:manage");
			System.out.println("已为用户[jadyer]赋予了[admin]角色和[admin:manage]权限");
			return simpleAuthorInfo;
		}else if(null!=currentUsername && "玄玉".equals(currentUsername)){
			System.out.println("当前用户[玄玉]无授权");
			return simpleAuthorInfo;
		}*/
		//若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
		//详见applicationContext.xml中的<bean id="shiroFilter">的配置
//		return null;
	}

	
	/**
	 * 验证当前登录的Subject
	 * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//获取基于用户名和密码的令牌
		//实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		//两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
//		User user = userService.getByUsername(token.getUsername());
//		if(null != user){
//			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());
//			this.setSession("currentUser", user);
//			return authcInfo;
//		}else{
//			return null;
//		}
		//此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
		//说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)
		//这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(token.getUsername());
		User user = userService.selectByExample(example).get(0);
		String password = user.getUserPassword();
		
		if(null != user) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(), this.getName());
			this.setSession("user", user);
			this.setSession("userRealName", user.getUserRealName());
			Mongo  mongo = new Mongo(hostName,port);
				

	       /*   DB db=mongo.getDB("operation_record"); 
	          DBCollection collection=db.getCollection("operation_record");
	          BasicDBObject detail_document = new BasicDBObject();
	          detail_document.put("name", user.getUserRealName());
	          detail_document.put("operation", "登录");
	          detail_document.put("time", CommTool.currentDate(0));
	          WriteResult a =  collection.insert(detail_document);*/
	          
			return authcInfo;
    	}
		//没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
		return null;
	}
	
	
	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value){
		Subject currentUser = SecurityUtils.getSubject();
		if(null != currentUser){
			Session session = currentUser.getSession();
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if(null != session){
				session.setAttribute(key, value);
			}
		}
	}
	

}

