/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     net.youhj.controller
 *
 *    Filename:    MyFormAuthenticationFilter.java
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
 *    Create at:   2017年3月1日 上午11:02:49
 *
 *    Revision:
 *
 *    2017年3月1日 上午11:02:49
 *        - first revision
 *
 *****************************************************************/
package com.service.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * @ClassName MyFormAuthenticationFilter
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author lightSmart
 * @Date 2017年3月1日 上午11:02:49
 * @version 1.0.0
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request, response, "/main/goIndex.do");
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
//		
//		String url = req.getContextPath() + "/main/goIndex.do";
//		if (!"XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With")) || request.getParameter("ajax") == null) {
//			// 不是ajax请求
//			resp.sendRedirect(url);
//		} else {
//			//req.getRequestDispatcher("/login/timeout/success").forward(req, resp);
//		}
//		
		return false;
	}
}
