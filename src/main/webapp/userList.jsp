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
      <jsp:include page="userListDetail.jsp" flush="true" />
      <jsp:include page="footer.jsp" flush="true" />
      <!-- js资源文件 -->
      <jsp:include page="common.jsp" flush="true" />
  
      <!--路径文件  -->
      <script src="js/webUrl.js"></script>
      <!--框架协议前后端交互  -->
      <script src="dataJs/userList.js"></script>
</body>
</html>

