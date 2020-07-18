<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师</title>
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
	function editad(data){
		var tid=$(data).attr("id");
		alert("修改密码后会退出登录");
		$.ajax({
			url:'teacher.do?findByTid',//访问地址
			data:'tid='+tid,//传参数
			dataType:'json',//数据类型
			type:'post',//提交方式
			success:function(result){//回调函数
				if(result!=null){
					$("#tid").val(result.tid);
					$("#tpwd").val(result.tpwd);
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

        <a class="navbar-brand" href="teacher.jsp">
            		欢迎登录
        </a>
		
		<div style="margin-right:100px;">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown">
			
		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="icon icon-user"></i>
                    <span class="small ml-1 d-md-down-none">${t.tname}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">用户操作</div>

                    <a onclick="editad(this)" id="${t.tid}" data-toggle="modal" data-target="#editadmo" class="dropdown-item">
                        <i class="icon icon-options-vertical"></i> 修改密码
                        
                    </a>

                    <a href="teacherlogin.jsp" class="dropdown-item">
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
                        <a href="xzt.do?showxzt" class="nav-link">
                            <i class="icon icon-people"></i> 选择题题库
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="zgt.do?show" class="nav-link">
                            <i class="icon icon-puzzle"></i> 主观题题库
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="correct.do?show" class="nav-link">
                            <i class="icon icon-bell"></i> 批阅试卷
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a href="corrected.do?show" class="nav-link">
                            <i class="icon icon-grid"></i> 查询成绩
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a href="tests.do?show" class="nav-link">
                            <i class="icon icon-grid"></i> 考试安排
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
				<form action="teacher.do?updateTpwd" method="post">
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
											教师工号
										</label>
										<div class="col-sm-10">
											<input class="form-control" id="tid" type="text" readonly = "readonly"  name="tid">
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-4 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="tpwd" required="required" placeholder="密码" name="tpwd"> 
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