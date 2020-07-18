<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/simple-line-icons.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="jquery/jquery.min.js"></script>
<script src="popper.js/popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="chart.js/chart.min.js"></script>
<script src="js/carbon.js"></script>
<script src="js/demo.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<style type="text/css">

	.login_bg{
		background: url("images/background.jpg");
		background-repeat:no-repeat;
		background-size: 100%;
	}
	
</style>
<body class="login_bg">
<div class="page-wrapper flex-row align-items-center">
<div class="container" style="margin-top:200px">
<div style="text-align:center;">
<h1><strong style="color:black">IPlus</strong></h1>
</div>
<div class="row justify-content-center">
<div class="col-md-6">
<div class="card">
<div class="btn-group-vertical">
	<a href="adminlogin.jsp" type="button" class="btn btn-success">管理员入口</a>
	<a href="studentlogin.jsp" type="button" class="btn btn-success">学生入口</a>
	<a href="teacherlogin.jsp" type="button" class="btn btn-success">教师入口</a>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>
