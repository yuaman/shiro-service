<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="${staticURL}"> 
 <aside class="main-sidebar">
    
    <!-- sidebar: style can be found in sidebar.less -->
    <div class="sidebar " id="scrollspy" >
        <div>
            <h2>中电瑞鼎供应链</h2>
        </div>
        <ul class="sidebar-menu">
         <!--  公司logo -->
          <div class="Memu_auth">
              <div>
                  <b>组织管理</b>
              </div>
              <ul class="nav nav-pills nav-stacked">
                  <li>
                      <a href="${staticURL}/user/gotoUserList.do" id=""><!-- index页 -->
                          <span>用户管理</span>
                      </a>
                  </li>
                  <li>
                      <a href="${staticURL}/role/gotoRoleList.do" id="">
                          <span>权限管理</span>
                      </a>
                  </li>
                  <li>
                      <a href="${staticURL}/operationRecord/gotoOperation_record_list.do" >
                          <span>动态记录</span>
                      </a>
                  </li>
              </ul>
          </div>      
      </ul>
    </div>
<!-- /.sidebar -->
</aside>
