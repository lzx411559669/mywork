<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>
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
		var sid=$(data).attr("id");
		alert("修改密码后会退出登录");
		$.ajax({
			url:'student.do?findBySid',//访问地址
			data:'sid='+sid,//传参数
			dataType:'json',//数据类型
			type:'post',//提交方式
			success:function(result){//回调函数
				if(result!=null){
					$("#sid").val(result.sid);
					$("#spwd").val(result.spwd);
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

        <a class="navbar-brand" href="student.jsp">
            		欢迎登录
        </a>
		
		<div style="margin-right:100px;">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown">
			
		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="icon icon-user"></i>
                    <span class="small ml-1 d-md-down-none">${stu.sname}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <div class="dropdown-header">用户操作</div>

                    <a onclick="editad(this)" id="${stu.sid}" data-toggle="modal" data-target="#editadmo" class="dropdown-item">
                        <i class="icon icon-options-vertical"></i> 修改密码
                        
                    </a>

                    <a href="studentlogin.jsp" class="dropdown-item">
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
                        <a href="student.do?showmark&sid=${stu.sid }" class="nav-link">
                            <i class="icon icon-people"></i> 成绩查询
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="tests.do?testList&cid=${stu.cl.cid}&sid=${stu.sid}" class="nav-link">
                            <i class="icon icon-puzzle"></i> 在线考试
                        </a>
                    </li>

                </ul>
            </nav>
        </div>
	<div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                          	  考试安排
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                    <tr class="success">
                                        <th>考试编号</th>
                                        <th>考试学科</th>
                                        <th>状态</th>
			                            <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${slist}" var="t">
				                      <tr>
				                           <td>${t.testsno}</td>
				                           <td>${t.sj.suname}</td>
				                           <td>
				                           <c:if test="${t.condition==1}">
				                           	<i class="text-warning">未参加考试</i>
   											</c:if>
				                           <c:if test="${t.condition==2}">
				                           	<i class="text-success">已参加考试</i>
   											</c:if>
				                           </td>              
				                           <td>
				                           <c:if test="${t.condition==1}">
				                           <a type="button" class="btn btn-danger" href="javascript:if(confirm('是否开始考试'))location='tests.do?start&suid=${t.sj.suid}&testsno=${t.testsno}'">
				                         	  开始考试
				                           </a>
   											</c:if>
				                           </td>
				                      </tr>
				                     </c:forEach>
                                    </tbody>
                                </table>
                                <!-- 翻页 -->
                                <div style="margin-left: 1000px">
		                           <a  href="tests.do?testList&cid=${stu.cl.cid}&index=1">第一页</a>
		                           <c:if test="${total>index}">
		                           <a href="tests.do?testList&cid=${stu.cl.cid}&index=${index+1}">下一页</a>
		                           </c:if>
		                           <c:if test="${index>1}">
		                           <a href="tests.do?testList&cid=${stu.cl.cid}&index=${index-1}">上一页</a>
		                           </c:if>
		                           <a href="tests.do?testList&cid=${stu.cl.cid}&index=${total}">最后一页</a>
		                       </div>
		                       <!-- 翻页 -->
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
	<!-- 表格 -->
	</div>
</div>

<!-- 修改密码模态框 -->
				<form action="student.do?updateSpwd" method="post">
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
											学号
										</label>
										<div class="col-sm-10">
											<input class="form-control" id="sid" type="text" readonly = "readonly"  name="sid">
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-4 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="spwd" required="required" placeholder="密码" name="spwd"> 
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