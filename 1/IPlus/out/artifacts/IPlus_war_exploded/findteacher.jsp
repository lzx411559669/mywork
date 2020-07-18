<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查找教师</title>
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
		var tid=$(data).attr("id");
		$.ajax({
			url:'teacher.do?findByTid',//访问地址
			data:'tid='+tid,//传参数
			dataType:'json',//数据类型
			type:'post',//提交方式
			success:function(result){//回调函数
				if(result!=null){
					$("#tid").val(result.tid);
					$("#tname").val(result.tname);
					$("#tpwd").val(result.tpwd);
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
                        <a href="teacher.do?show" class="nav-link active">
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
	<!-- 表格 -->
	<div class="content">
		<div style="height:50px">
			<form class="form-inline" action="teacher.do?findTeacher" method="post">
				<div>
						<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"id="add">
									添加教师
						</button>
				</div>
				<div style="margin-left:800px">
						<input type="text" required="required" class="form-control" id="name" placeholder="请输入搜索内容" name="tname">
						<button class="btn btn-info" type="submit"  id="search">搜姓名</button>
				</div>
			</form>
		</div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                          	  教师信息
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                    <tr class="success">
                                        <th>教师工号</th>
			                            <th>教师姓名</th>
			                            <th>教师性别</th>
			                            <th>教师所教学科</th>
			                            <th>教师所在班级</th>
			                            <th colspan="2">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="t">
				                      <tr>
				                           <td>${t.tid}</td>
				                           <td>${t.tname}</td>
				                           <td>${t.tgender}</td>
				                           <td>${t.sj.suname}</td>
				                           <td>${t.cl.cid}</td>                  
				                           <td colspan="2">
				                           
				                           <a type="button" class="btn btn-danger" href="javascript:if(confirm('是否要删除'))location='teacher.do?delTeacher&tid=${t.tid}'">
				                         	  删除
				                           </a>
				                           
				                           <a onclick="edit(this)" id="${t.tid}" type="button" class="btn btn-info" data-toggle="modal" data-target="#editmo">
				                           	修改
				                           </a>
				                           
				                           </td>
				                      </tr>
				                     </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
	<!-- 表格 -->
	</div>
</div>



 <!-- 添加模态框 -->
            <form action="teacher.do?addTeacher" method="post">
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										&times;
									</button>
									
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" required="required" id="firstname" placeholder="教师姓名" name="tname" > 
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-sm-2 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" required="required" id="lastname" placeholder="请输入密码" name="tpwd">
										</div>
									</div>
									<div class="form-group">
										<label for="name">选择班级</label>
										<select class="form-control" name="cid">
										<c:forEach items="${clist}" var="c">
						                 	<option value="${c.cid}">${c.cid}</option>                
						                 </c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="name">选择学科</label>
										<select class="form-control" name="suid">
										<c:forEach items="${sulist}" var="su">
											<option value="${su.suid}">
												${su.suname}
											</option>
										</c:forEach>
										</select>
									</div>
									<div class="form-group">性别
										<label class="radio-inline">
											<input type="radio" name="tgender" id="optionsRadios3" value="男" checked> 男
										</label>
										<label class="radio-inline">
											<input type="radio" name="tgender" id="optionsRadios4"  value="女"> 女
										</label>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="submit" class="btn btn-primary">
										提交
									</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
					</div>
				</form>
				
				
				
				<!-- 修改模态框 -->
					<form action="teacher.do?updateTeacher" method="post">
            <div class="modal fade" id="editmo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">	
									<h4 class="modal-title" id="myModalLabel">
										修改教师信息
									</h4>
								</div>
								<div class="modal-body">
								<div class="form-group">
										<label for="inputPassword" class="col-sm-4 control-label">
											教师工号
										</label>
										<div class="col-sm-10">
											<input class="form-control" id="tid" type="text" readonly = "readonly"  name="tid">
										</div>
									<label for="firstname" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" required="required" id="tname" placeholder="教师姓名" name="tname" > 
										</div>
									</div>
									<div class="form-group">
										<label for="lastname" class="col-sm-2 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" required="required" id="tpwd" placeholder="请输入密码" name="tpwd">
										</div>
									</div>
									<div class="form-group">
										<label for="name">选择班级</label>
										<select class="form-control" name="cid">
										<c:forEach items="${clist}" var="c">
						                 	<option value="${c.cid}">${c.cid}</option>                
						                 </c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label for="name">选择学科</label>
										<select class="form-control" name="suid">
										<c:forEach items="${sulist}" var="su">
											<option value="${su.suid}">
												${su.suname}
											</option>
										</c:forEach>
										</select>
									</div>
									<div class="form-group">性别
										<label class="radio-inline">
											<input type="radio" required="required" name="tgender" id="optionsRadios3" value="男" > 男
										</label>
										<label class="radio-inline">
											<input type="radio" required="required" name="tgender" id="optionsRadios4"  value="女"> 女
										</label>
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