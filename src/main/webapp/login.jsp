<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <meta http-equiv="refresh" content="0;ie.html" /> -->
    <title>中电瑞鼎供应链在线系统 -登录</title>
     <!-- <link rel="shortcut icon" href="favicon.ico">   -->
    <link href="${staticURL}css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${staticURL}css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${staticURL}css/animate.css" rel="stylesheet">
    <link href="${staticURL}css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    <style type="text/css">
    	.tip{display: none;}
    </style>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h2 class="logo-name">SCM</h2>

            </div>
            <h3>欢迎登录</h3>

            <form class="m-t" role="form"    method="post">
                <div class="form-group">
                    <input  class="form-control" placeholder="用户名" required name="username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required name="password">
                </div>
                <!-- 提示 -->
                <div class="form-group tip" id="tip">
                    <input type="text" value="用户名或密码错误请重新输入" disabled="disabled" style="border: none;">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${staticURL}js/jquery.min.js?v=2.1.4"></script>
    <script src="${staticURL}js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript">
    	//邮箱或者密码错误提示
    	$(function(){
    		var $tip = $("#tip");
    		if("${str}" == "error"){
    			$tip.removeClass("tip");
    		}
    		else{
    			$tip.addClass("tip");
    		}
    	})
    </script>
</body>
</html>
