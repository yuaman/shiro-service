/** 


*　　　┏┓　　　┏┓ 
*　　┏┛┻━━━┛┻┓ 
*　　┃　　　　　　　┃ 
*　　┃　　　━　　　┃ 
*　　┃　┳┛　┗┳　┃ 
*　　┃　　　　　　　┃ 
*　　┃　　　┻　　　┃ 
*　　┃　　　　　　　┃ 
*　　┗━┓　　　┏━┛ 
*　　　　┃　　　┃神兽保佑 
*　　　　┃　　　┃代码无BUG！ 
*　　　　┃　　　┗━━━┓ 
*　　　　┃　　　　　　　┣┓ 
*　　　　┃　　　　　　　┏┛ 
*　　　　┗┓┓┏━┳┓┏┛ 
*　　　　　┃┫┫　┃┫┫ 
*　　　　　┗┻┛　┗┻┛   
* @Title: UserLogin.java 
* @Package net.youhj.controller 
* @Description: TODO[]
* @author [于霆霖]    
* @date 2016年12月22日 下午1:25:04 
* @version V1.0   
*/
package com.service.controller;

import net.youhj.domain.Storage;
import net.youhj.service.StorageService;
import net.youhj.service.UserService;
import net.youhj.util.CommTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * @ClassName: UserLogin
 * @Description: TODO[]
 * @author yutinglin
 * @date 2016年12月22日 下午1:25:04
 */
@Controller
@RequestMapping("/goIndex")
public class UserLogin extends FormAuthenticationFilter {
	//控制台打印
	Log logger = LogFactory.getLog(getClass());
	@Resource
	private UserService userService;
	@Resource
	private StorageService storageService;
	String staticURL = GetUrl.STATICURL;

	@RequestMapping("/index")
	public ModelAndView getIndex() {
		ModelAndView mView = new ModelAndView();
		mView.addObject("staticURL", GetUrl.STATICURL);
		mView.setViewName("/index.jsp");
		return mView;
	}
	
	/**
	* @Title: logout 
	* @Description: TODO[用户退出] 
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("/logout")
	public ModelAndView logout() {
		Subject user = SecurityUtils.getSubject();
		//登出
	/*	DBCollection dbCollection = MongoUtil.getCol("operation_record");
        BasicDBObject detail_document = new BasicDBObject();
        detail_document.put("name", user.getPrincipal());
        detail_document.put("operation", "退出");
        detail_document.put("time", CommTool.currentDate(0));
        WriteResult a =  dbCollection.insert(detail_document);*/
		
		user.logout();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/goIndex/goLogin.do");
		mv.addObject("staticURL", GetUrl.STATICURL);
		return mv;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(
			HttpServletRequest request
			) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		// shiro在认证过程中出现错误后将异常类路径通过request返回
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
				
		System.out.println("============"+username);
		if(exceptionClassName!=null){
			System.out.println("error================");
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				mv.addObject("errorInfo", "该账户不存在！");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				mv.addObject("errorInfo", "用户名或密码错误！");
			} else if("randomCodeError".equals(exceptionClassName)){
				mv.addObject("errorInfo", "验证码错误！");
			} else{
				mv.addObject("errorInfo", "我特么也不知道什么错误！");//最终在异常处理器生成未知错误
			}
		}else {
			//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			//每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			currentUser.login(token);
			System.out.println("=======================");
			mv.setViewName("index.jsp");
		}
		System.out.println("8888888888888888");
		mv.setViewName("index.jsp");
		if(currentUser.isAuthenticated()){
			System.out.println("========");
			mv.setViewName("index.jsp");
		}else{
			System.out.println("=======");
			token.clear();
		}
		
		mv.addObject("staticURL", GetUrl.STATICURL);
		return mv;
	}
	
	
	@RequestMapping("/warehouse-info-add")
	public ModelAndView warehouseInfoAdd(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/WEB-INF/storage/storage_Add.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}

	@RequestMapping("/warehouse-info-edit")
	public ModelAndView warehouseInfoEdit(
			@RequestParam(value="stoid",required=true)Integer stoid){
		Storage storage = storageService.selectByPrimaryKey(stoid);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/WEB-INF/storage/storage_Edit.jsp");
		mView.addObject("storage", storage);
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}

	
	@RequestMapping("/warehouse-info")
	public ModelAndView warehouseInfo(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/WEB-INF/storage/storage_Info.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}

	@RequestMapping("/goToDo")
	public ModelAndView goToDo(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/Building.html");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	@RequestMapping("/goLogin")
	public ModelAndView goLogin(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/login.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	/**
	 * 
	 * @Description 去往放款协议模块
	 * @return
	 */
	
	@RequestMapping("/goAgreement")
	@RequiresRoles("admin")
	public ModelAndView goAgreement(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/index.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	/**
	 * 
	 * @Description 去往权限管理模块
	 * @return
	 */
	@RequestMapping("/goAuth")
	@RequiresRoles("admin")
	public ModelAndView goAuth(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/userList.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	@RequestMapping("/goPurchase")
	@RequiresRoles("admin")
	public ModelAndView goPurchase(){
		//取出订单信息
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/purchaseList.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request, response, "/goIndex/goLogin.do");
		return false;
	}
	/**
	 * 
	 * @Description 去往合作伙伴模块
	 * @return
	 */
	@RequestMapping("/goCooperation")
	public ModelAndView goCooperation(@RequestParam(value="type",required=false) String type){
		ModelAndView mView = new ModelAndView();
		
		if(CommTool.checkStr(type)) {
			if("clt".equals(type)) {
				mView.addObject("type", "客户");
				mView.setViewName("/coopList.jsp");
			}
			if("sup".equals(type)) {
				mView.addObject("type", "供应商");
				mView.setViewName("/coopList.jsp");
			}
			if("stor".equals(type)) {
				mView.addObject("type", "合作仓库");
				mView.addObject("menu_type", "stor");
				mView.setViewName("/coopStorList.jsp");
			}
		}
		mView.addObject("menu_type", type);
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
	
	@RequestMapping("/goItem")
	public ModelAndView goItem() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/itemList.jsp");
		mView.addObject("staticURL", GetUrl.STATICURL);
		return mView;
	}
}