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
      <!-- 框架协议创建 -->
      <div class="col-xs-12"  id="create_frameWorkAgree">
      <div class="box">
          <div class="box-header" style="margin-top: 12px">
             <h3 class="box-title"><b>用户&nbsp;/&nbsp;创建</b></h3>
          </div>
        <div class="col-md-12" style="font-size: 14px;">
              <hr style="border:none;border-top:1px solid #ccc;margin-bottom: 2px;" />
              <button style="width:48px;height:30px;background-color: #3c8dbc;border:none;border-radius: 2px;color: #fff;" class="submmit_user">保存</button>
             
              <hr style="border:none;border-top:1px solid #ccc;margin-top: 2px;margin-bottom: 30px;" />
         </div>
          <div class="box-body" style="padding-bottom: 20px;">
              <form id="form_addUser" method="post">
              <div class="line_all">
                   <div class="createSpan" style="margin-bottom: 12px;">
                   		<span class="createSpan-1">用户名：</span>                   	
                        <input type="text" class="createSpan-2" id="userName" name="userName" value="">
                  </div>
                   <div class="createSpan" style="margin-bottom: 12px;">
                   		<span class="createSpan-1">用户密码：</span>                   	
                        <input type="text" class="createSpan-2" id="userPassword" name="userPassword" value="">
                  </div>
                  <div class="createSpan" style="margin-bottom: 12px;">
                       <span class="createSpan-1">真实姓名：</span>
                       <input type="text" class="createSpan-2" id="userRealname" name="userRealName" value="">
                       <span style="font-size:12px;color:#f00;margin-left:10px;">*请认真填写用户真实姓名</span>
                  </div>
                
                  <div class="createSpan" style="margin-bottom: 12px;">
                   		<span class="createSpan-1">职位：</span>                   		
                        <input type="text" class="createSpan-2" id="userJob" name="userJob" value="">
                  </div>
                 <div class="createSpan" style="line-height: 30px;">
                       <span class="createSpan-1">性别：</span>
                      <input type="radio" name="userGender" style="margin-left: 16px;" value="男">&nbsp;<label>男</label>&nbsp;&nbsp;
                      <input type="radio" name="userGender" value="女" >&nbsp;<label id="userGenderUnit">女</label>&nbsp;&nbsp;
                  </div>
              <div class="clearfix"></div>
                            		 </div>
              <div class="line_all">
               <div class="createSpan" style="margin-bottom:12px;">
                       <span class="createSpan-1" >电话：</span>
                       <input id="userTel" type="text" class="createSpan-2" id="userTel" name="userTel" >
                  </div>
                  <div class="createSpan" style="margin-bottom:12px;">
                      <span class="createSpan-1">QQ：</span>
                      <input id="userQQ" type="text" class="createSpan-2" name="userQq" value="">
                  </div>
                
                  <div class="createSpan" style="margin-bottom: 12px;">
                      <span class="createSpan-1">邮箱：</span>
                      <input type="text"  id="userEmail" class="createSpan-2" name="userEmail" value="">
                  </div>
              <div class="clearfix"></div>
                            		 </div>
              </form>
         </div>
       </div>
      </div> 
     
</div> 
</body>
</html>