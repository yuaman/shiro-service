<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>框架协议</title>
</head>
<base href="${staticURL}"> 
<body>
<!-- 内容区 -->
<div class="content-wrapper" style="overflow: auto;">
      <div class="box">
          <div class="box-header" style="margin-top: 12px">
             <h3 class="box-title"><b>用户列表</b></h3>
             <div class="header-bar" style="float: right;">
              <form  name="formsearch" action="">
                  <div id="header-search" class="search-sort">
                      <span class="search-sort-txt">编号</span><em></em>            
                      <!-- <input type="hidden" name="typeid" id="typeid" value="-1"> -->
                      <ul id="search-sort-list" class="search-sort-list">
                          <li value="-1" class="current"id="kjOrderId">编号</li>
                          <li value="162" id="cusCompanyName">真实姓名</li>
                          <li value="163" id="providerName">用户名</li>
                          <li value="181" id="cusManagerName">职位</li>
                          <li value="182" id="businessItem">电话</li>
                      </ul>
                  </div>
                      <input id="tags" class="search-input"  placeholder="输入搜索内容" >
                      <a class="search-btn" >搜索</a>
                      <a class="search-btn" style="height: 35px;width: 64px;margin-left:10px;border: none;background: none;color: #3C8DBC;font-size: 12px;line-height: 35px;" data-toggle="modal" data-target="#myModal" modal="lg">高级搜索</a>
                      
                      <!-- 模态框（Modal） -->
                      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="myModalLabel" style="color: #333;">查询条件</h4>
                            </div>
                            <div class="modal-body" >
                                <div>
                                    <form>
                                        <div class="modalTop">
                                        		<p>协议编号：</p>
                                            <input id="kj_order_id" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu" curosr="pointer">
                                        </div>
                                        <div class="modalTop">
                                        		<p>客户：</p>
                                            <input id="cus_company_name" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu">
                                        </div>
                                        <div class="modalTop">
                                        		<p>供应商：</p>
                                            <input id="provider_name" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu">
                                        </div>
                                        <div class="modalTop">
                                        		<p>客户经理：</p>
                                            <input id="cus_manager_name" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu">
                                        </div>
                                        <div class="modalTop">
                                        		<p>客户评级：</p>
                                            <input name="customer_grade_first" value="1" type="checkbox" style="width: 20px;height: 20px;float: left;margin-top: 8px;">
                                            <span>一级</span>
                                            <input name="customer_grade_second" value="2" type="checkbox" style="width: 20px;height: 20px;float: left;margin-top: 8px;">
                                            <span>二级</span>
                                            <input name="customer_grade_third" value="3" type="checkbox" style="width: 20px;height: 20px;float: left;margin-top: 8px;">
                                            <span>三级</span>
                                        </div>
                                        <div class="modalTop">
                                        		<p>签约时间：</p>
                                            <input id="kj_signdate_from" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                            <em>至</em>
                                            <input  id="kj_signdate_to" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                        </div>
                                        <div class="modalTop">
                                        		<p>生效时间：</p>
                                            <input id="kj_effectdate_from" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                            <em>至</em>
                                            <input id="kj_effectdate_to" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                        </div>
                                        <div class="modalTop">
                                        		<p>到期时间：</p>
                                            <input id="kj_duedate_from" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                            <em>至</em>
                                            <input id="kj_duedate_to" style="width: 136px;height: 30px;" type="date" list="itemlist_kehu">
                                        </div>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer" style="text-align: center;">
                              <button type="button" class="btn btn-primary" id="filter">查询</button>
                              <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>                      
              </form>
            </div>
          </div>
          
          <div class="box-body">
          <div class="box-header" style="width:50%;margin-bottom:-64px;z-index:2;margin-left:-10px;">
              <!-- 框架协议的详情-->
              <button class="btn_blue" id="user_create">创建</button> 
              <!-- <button class="btn_grey" id="user_delete">删除</button> -->      
              <button class="btn_grey" id="user_import">导入</button>
              <button class="btn_grey" id="user_export">导出</button>
              <div class="box-header-right">
	          </div>
          </div>
              <table id="userList_tab" class="table table-bordered table-striped VerAli">
                 <thead>
                     <tr>
                         <th style="text-align: center;"><input type="checkbox" id="user_selectAll"></th>
                        <th class="VerAli">编号</th>
                        <th class="VerAli">用户名</th>
                        <th class="VerAli">真实姓名</th>
                        <th class="VerAli">职位</th>
                        <th class="VerAli">邮箱</th>
                        <th class="VerAli">性别</th>
                        <th class="VerAli">电话</th>
                        <th class="VerAli">入职日期</th>
                        <th class="VerAli">最后登录</th>
                        <th class="VerAli">访问次数</th>
                      </tr>
                 </thead>
            </table>
         </div>
       </div>
      
		
</div>

</body>
</html>
