<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录界面</title>
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
function check(){
	var aid=document.getElementById("aid").value;
	var apwd=document.getElementById("apwd").value;
	var reg=/^[0-9]{1,6}$/;
	if(!reg.test(aid)){
		alert("账号为数字");
		return false;
	}
	$.ajax({
		url:'admin.do?login&aid='+aid+'&apwd='+apwd,
		type:'post',
		success:function(result){
			if(result!=""){
				location.href="admin.jsp";
			}
			else{
				alert("账号或密码错误！");
				location.href="adminlogin.jsp";
			}
		}
		});
}
</script>
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                      			  管理员登录
                    </div>
					<form action="#" method="post">
                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">账号</label>
                            <input id="aid" required="required" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input id="apwd" required="required" type="password" class="form-control">
                        </div>

                        <div class="custom-control custom-checkbox mt-4">
                            <input type="checkbox" class="custom-control-input" id="login">
                        </div>
                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                            	<input class="btn btn-primary px-5" type="button" onclick="check()" value="登录"/>
                            </div>

                            <div class="col-6">
                                <input type="reset" class="btn btn-primary px-5" value="重置">
                            </div>
                        </div>
                    </div>
                    </form>
                   <div>
                   		<a href="index.jsp" type="button" class="btn btn-success">返回</a>
                   </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>