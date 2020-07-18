<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
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
<script type="text/javascript">
	function edit(data){
		var cid=$(data).attr("id");
		$.ajax({
			url:'class.do?findByCid',//访问地址
			data:'cid='+cid,//传参数
			dataType:'json',//数据类型
			type:'post',//提交方式
			success:function(result){//回调函数
				if(result!=null){
					$("#num").val(result.num);
					$("#cid").val(result.cid);
				}
			}
		});
	}
	function editad(data){
		var aid=$(data).attr("id");
		alert("修改密码后会退出登录");
		$.ajax({
			url:'admin.do?findAdminById',//访问地址
			data:'aid='+aid,//传参数
			dataType:'json',//数据类型
			type:'post',//提交方式
			success:function(result){//回调函数
				if(result!=null){
					$("#aid").val(result.aid);
					$("#apwd").val(result.apwd);
				}
			}
		});
	}	
</script>



</head>
<style type="text/css">
</style>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="admin.jsp">
            		IPlus
        </a>
		
		<div style="margin-right:100px;">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown">
			
		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="icon icon-user"></i>
                    <span class="small ml-1 d-md-down-none">${ad.aname}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">用户操作</div>

                     <a onclick="editad(this)" id="${ad.aid}" data-toggle="modal" data-target="#editadmo" class="dropdown-item">
                        <i class="icon icon-options-vertical"></i> 修改密码
                        
                    </a>

                    <a href="adminlogin.jsp" class="dropdown-item">
                        <i class="icon icon-logout"></i> 退出登录
                    </a>
                 </div>
				</li>
			</ul>
                    
        </div>
    </nav>
<div class="main-container">
 <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="teacher.do?show" class="nav-link">
                            <i class="icon icon-people"></i> 教师信息
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="student.do?showallstu" class="nav-link">
                            <i class="icon icon-puzzle"></i> 学生信息
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="class.do?showallcl" class="nav-link">
                            <i class="icon icon-bell"></i> 班级信息
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a href="subject.do?showallsub" class="nav-link">
                            <i class="icon icon-grid"></i> 学科信息
                        </a>
                    </li>

                </ul>
            </nav>
        </div>
	<!-- 图片 -->
	<div class="content">

        </div>
	<!-- 图片 -->
	</div>
</div>




<!-- 修改密码模态框 -->
				<form action="admin.do?updateAdminPwd" method="post">
					<div class="modal fade" id="editadmo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title pull-left" id="myModalLabel">
										修改密码
									</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">
											管理员工号
										</label>
										<div class="col-sm-10">
											<input class="form-control" id="aid" type="text" readonly = "readonly"  name="aid">
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-4 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="apwd" required="required" placeholder="密码" name="apwd"> 
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="submit" class="btn btn-primary">
										提交更改
									</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
					</div>
				</form>
  </body>
</html>