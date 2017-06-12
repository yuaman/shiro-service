<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${staticURL}"> 
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>中电瑞鼎供应链-首页</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" type="image/x-icon" href="dist/img/favicon.ico">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="dist/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="dist/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" type="text/css" href="plugins/jQueryUI/jquery-ui.css">
  
  <!-- 以上为公共css -->
  <!-- datatable -->
  <link rel="stylesheet" type="text/css" href="plugins/datatables/jquery.dataTables.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="plugins/colorpicker/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="plugins/select2/select2.min.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
  <!-- fullCalendar 2.2.5-->
  <link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.min.css">
  <link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.print.css" media="print">
  <!-- Ion Slider -->
  <link rel="stylesheet" href="plugins/ionslider/ion.rangeSlider.css">
  <!-- ion slider Nice -->
  <link rel="stylesheet" href="plugins/ionslider/ion.rangeSlider.skinNice.css">
  <!-- bootstrap slider -->
  <link rel="stylesheet" href="plugins/bootstrap-slider/slider.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" type="text/css" href="dist/css/style.css">
  <link rel="stylesheet" type="text/css" href="dist/css/reset.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <script>
    function iFrameHeight() {
      var ifm = document.getElementById("content");
      var subWeb = document.frames ? document.frames["content"].document
          : ifm.contentDocument;
      if (ifm != null && subWeb != null) {
        ifm.height = subWeb.body.scrollHeight;
      }
  };
  </script>
  <!-- jquery ui自动完成 -->
  <style>  
    .ui-helper-hidden-accessible {display:none;}  
	.ui-autocomplete { 
  		position: absolute; 
  		cursor: default; 
  		border-radius: 3px; 
  		border: 1px solid #c0c0c0; 
	}    
	.ui-menu {
		list-style: none;
		padding: 0;margin: 0;
		display: block;
		outline: none;
	}  
	.ui-menu .ui-menu-item a {
		text-decoration:none;
		display:block;padding:.2em .4em;
		line-height:1.5;zoom:1;
	}  
 	.ui-state-hover, .ui-widget-content 
 	.ui-state-hover, .ui-widget-header 
 	.ui-state-hover, .ui-state-focus, 
 	.ui-widget-content .ui-state-focus, 
 	.ui-widget-header .ui-state-focus {
 		background: #ff8a00;
 		border: none;
 		color:#000;
 		border-radius:0;
 		font-weight: normal;
 	}  
    </style>  
 
</head>
 <body class="skin-green-light fixed ajax-template" data-spy="scroll" data-target="#scrollspy">
     <!--头部  -->
     <jsp:include page="head.jsp" flush="true" />
      
      <!--导航栏侧栏  -->
      <jsp:include page="authMenu.jsp" flush="true" />
      
      <!-- 内容区 -->
      <!-- 内容区 -->
<div class="content-wrapper" style="overflow: auto;">
      <div class="box">
          <div class="box-header" style="margin-top: 12px">
             <h3 class="box-title"><b>分组列表</b></h3>
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
          
          <!-- 分组添加模态框（Modal） -->
                      <div class="modal fade" id="modal_add_role" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="myModalLabel" style="color: #333;">新增分组</h4>
                            </div>
                            <div class="modal-body" style="padding: 20px 10px 0 10px;">
                            		<div class="modalTop">
                                      <p>分组名称：</p >
                                      <input id="role_name_add" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu">
                                 </div>
                                 <div class="modalTop">
                                        		<p>分组描述：</p >
                                            <textarea style="width: 300px;height: 200px;padding: 4px;" id="role_disc_add"></textarea>
                                 </div>                                
                                 <div class="clearfix"></div>  
                                 <button type="button" class="btn btn-primary" style="margin-left: 152px;" id="role_add_save">保存</button>                              
                            </div>
                            <div class="modal-footer" style="border: none;">                             		
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>
                    
                       <!-- 分组编辑模态框（Modal） -->
                      <div class="modal fade" id="modal_edit_role" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="myModalLabel" style="color: #333;">编辑分组</h4>
                            </div>
                            <div class="modal-body" style="padding: 20px 10px 0 10px;">
                            		<div class="modalTop">
                                      <p>分组名称：</p >
                                      <input id="role_name_edit_input" style="width: 300px;height: 30px;padding: 0 4px;" type="text" list="itemlist_kehu">
                                 </div>
                                 <div class="modalTop">
                                        		<p>分组描述：</p >
                                            <textarea id="role_disc_edit_input" style="width: 300px;height: 200px;padding: 4px;"></textarea>
                                 </div>                                
                                 <div class="clearfix"></div>  
                                 <button type="button" class="btn btn-primary" style="margin-left: 152px;" id="role_edit_save">保存</button>                              
                            </div>
                            <div class="modal-footer" style="border: none;">                             		
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                        </div>
                        <!-- 分组添加用户模态框（Modal） -->
                      <div class="modal fade" id="user_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content" style="width:880px;">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="myModalLabel" style="color: #333;"><span style="padding: 1px 6px;background-color: #fff;border: #aaa solid 1px;margin-right: 6px;">1</span>管理员&nbsp;&gt;&nbsp;成员维护</h4>
                            </div>
                            <div class="modal-body" style="padding-bottom: 30px;">
                                <div style="float: left;width: 200px;border: 1px solid #ddd;margin-right: 20px;padding-bottom:20px;">
                                    <h2 style="background-color: #f1f1f1;padding: 0px 10px;font-weight: bold;font-size: 16px;line-height: 40px;border-bottom: 1px solid #ddd;margin-bottom: 10px;">当前分组</h2>
                                    <p style="margin-left: 10px;line-height: 30px;color: #0033cc;" id="role_current"></p>
                                </div>
                                <div style="float: left;padding: 15px 30px;border: 1px solid #ddd;width: 600px;">
                                    <div style="float: left;margin-right: 20px;">
                                    		<p style="font-weight: bold;line-height: 24px;" id="zu_nei_yonghu">组内用户</p>
                                    		<p style="font-weight: bold;margin-top: 12px;line-height: 24px;" id="zu_wai_yonghu" >组外用户</p>
                                    </div>
                                    <div style="float: left;width:440px ;">
                                    		<ul style="line-height: 24px;float: left;" id="role_user_contain">
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>                                    			
                                    		</ul>                                		
                                    		<ul style="margin-top: 12px;line-height: 24px;float: left;" id="role_user_not_contain">
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                  	  			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">张莹</li>
                                    		</ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="modal-footer" style="text-align: center;">
                              <button type="button" class="btn btn-primary" id="user_add_save">保存</button>
                              <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>


                    <!-- 权限分配模态框（Modal） -->
                      <div class="modal fade" id="auth_manage_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content" style="width:880px;">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title" id="myModalLabel" style="color: #333;">模块</h4>
                            </div>
                            <div class="modal-body" style="padding: 20px;border-color: #ddd;">
                                <table border="1px;" width="100%" height="100px;" class="VerAli table-striped" style="border-color: #ddd;">
	                                	<thead>
	                                		<tr>
		                                    <th class="VerAli">模块</th>
		                                    <th class="VerAli">行为</th>
		                                </tr>	
	                                	</thead>	                                
	                               <!--  <tr>
	                                    <td style="text-align: right;padding-right: 6px;width: 100px;font-weight: bold;">首页</td>
	                                    <td style="text-align: left;padding-left: 6px;">
		                                    	<ul style="line-height: 24px;float: left;">
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">查看</li>                                    			
	                                    		</ul>
	                                    </td>
	                                </tr> -->
	                                <tr>
	                                    <td style="text-align: right;padding-right: 6px;width: 160px;font-weight: bold;">框架协议</td>
	                                    <td style="text-align: left;padding-left: 6px;">
		                                    	<ul style="line-height: 24px;float: left;">
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" name="auth_checkbox"  class="kj_verify" style="margin-right: 6px;">审核</li>
	                                    		<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">终止</li>
	                                    		</ul>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td style="text-align: right;padding-right: 6px;width: 160px;font-weight: bold;">购销合同</td>
	                                    <td style="text-align: left;padding-left: 6px;">
		                                    	<ul style="line-height: 24px;float: left;">
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" name="auth_checkbox"  class="yk_deposit" style="margin-right: 6px;">收取保证金</li>
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" name="auth_checkbox"  class="yk_loan" style="margin-right: 6px;">放款</li>
	                                    		</ul>
	                                    </td>
	                                </tr>
	                                 <tr>
	                                    <td style="text-align: right;padding-right: 6px;width: 160px;font-weight: bold;">仓库租用协议</td>
	                                    <td style="text-align: left;padding-left: 6px;">
		                                    	<ul style="line-height: 24px;float: left;">
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" class="sr_verify" name="auth_checkbox" style="margin-right: 6px;">审核</li>
	                                    		<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">终止</li>
	                                    		</ul>
	                                    </td>
	                                </tr> 
	                               <tr>
	                                    <td style="text-align: right;padding-right: 6px;width: 160px;font-weight: bold;">合作仓库协议</td>
	                                    <td style="text-align: left;padding-left: 6px;">
		                                    	<ul style="line-height: 24px;float: left;">
	                                    			<li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">审核</li>
	                                    		    <li style="float: left; width: 110px;"><input type="checkbox" style="margin-right: 6px;">终止</li>
	                                    		</ul>
	                                    </td>
	                                </tr> 
	                            </table>
                            </div>
                            <div class="modal-footer" style="text-align: center;">
                              <button type="button" class="btn btn-primary" id="auth_manage_save">保存</button>
                              <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>                    
        
          <div class="box-body">
            <div class="box-header" style="width:50%;margin-bottom:-64px;z-index:2;margin-left:-10px;">
              <!-- 框架协议的详情-->
              <button class="btn_blue" id="role_create" data-toggle="modal" data-target="#modal_add_role" modal="lg">创建</button>
              <button class="btn_grey" id="role_edit" >编辑</button>
              <button class="btn_grey" id="role_add_User">用户分配</button> 
              <button class="btn_grey" id="auth_deal">权限分配 </button> 
              <!-- <button class="btn_grey" id="role_delete">删除</button>  -->
              <div class="box-header-right">
	          </div>
          </div>
              <table id="roleList_tab" class="table table-bordered table-striped VerAli">
                 <thead>
                     <tr>
                         <th style="text-align: center;"><input type="checkbox" id="user_selectAll"></th>
                        <th class="VerAli">编号</th>
                        <th class="VerAli">分组名称</th>
                        <th class="VerAli">分组介绍</th>
                      </tr>
                 </thead>
            </table>
         </div>
       </div>
      
		
</div>
      <jsp:include page="footer.jsp" flush="true" />
      <!-- js资源文件 -->
      <jsp:include page="common.jsp" flush="true" />
  
      <!--路径文件  -->
      <script src="js/webUrl.js"></script>
      <!--框架协议前后端交互  -->
      <script src="dataJs/roleList.js"></script>
</body>
</html>

