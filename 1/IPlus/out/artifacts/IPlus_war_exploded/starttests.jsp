<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答题</title>
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/simple-line-icons.css">
<link rel="stylesheet" href="css/fontawesome-all.min.css">
<script src="popper.js/popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="chart.js/chart.min.js"></script>
<script src="js/carbon.js"></script>
<script src="js/demo.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
var myVar;
window.onload=function(){
	myVar = setInterval(alertFunc, 1800000);
    var countdown=document.getElementById("countdown");
    var time=1799;//30分钟换算成1800秒
   
    setInterval(function(){
        time=time-1;
       var minute=parseInt(time/60);
       var second=parseInt(time%60);
        countdown.innerHTML='还剩'+minute+'分'+second+'秒';
    },1000);
}


function alertFunc() {
	var sid=$("#sid").val();
	var xzt1no=$("#x1").val();
	var xzt2no=$("#x2").val();
	var xzt3no=$("#x3").val();
	var xzt4no=$("#x4").val();
	var xzt5no=$("#x5").val();
	var zgt1no=$("#z1").val();
	var zgt2no=$("#z2").val();
	var testsno=$("#testsno").val();
	var suid=$("#suid").val();
	var xzt1c=$('input[name="chose1"]:checked').val();
	 if(xzt1c==null){
		 xzt1c='未选择';
     }
	var xzt2c=$('input[name="chose2"]:checked').val();
	 if(xzt2c==null){
		 xzt2c='未选择';
     }
	var xzt3c=$('input[name="chose3"]:checked').val();
	 if(xzt3c==null){
		 xzt3c='未选择';
     }
	var xzt4c=$('input[name="chose4"]:checked').val();
	 if(xzt4c==null){
		 xzt4c='未选择';
     }
	var xzt5c=$('input[name="chose5"]:checked').val();
	 if(xzt5c==null){
		 xzt5c='未选择';
     }
	var zgtda1=$("#d1").val();
	 if(zgtda1==""){
		 zgtda1='未作答';
     }
	var zgtda2=$("#d2").val();
	if(zgtda2==""){
		zgtda2='未作答';
    }
	alert("已到达考试结束时间，自动交卷，点击确定后退出考试！");
	$.ajax({
		url:'tests.do?check',//访问地址
		data:'xzt1no='+xzt1no+'&xzt2no='+xzt2no+'&xzt3no='+xzt3no+'&xzt4no='+xzt4no+'&xzt5no='+xzt5no+'&xzt1c='+xzt1c+'&xzt2c='+xzt2c+'&xzt3c='+xzt3c+'&xzt4c='+xzt4c+'&xzt5c='+xzt5c+'&sid='+sid+'&zgt1no='+zgt1no+'&zgt2no='+zgt2no+'&zgtda1='+zgtda1+'&zgtda2='+zgtda2+'&testsno='+testsno+'&suid='+suid,
		dataType:'json',
		type:'post',//提交方式
		success:function(result){//回调函数	
				location.href="student.jsp";
		}
	});
}
function answer(){
	var sid=$("#sid").val();
	var xzt1no=$("#x1").val();
	var xzt2no=$("#x2").val();
	var xzt3no=$("#x3").val();
	var xzt4no=$("#x4").val();
	var xzt5no=$("#x5").val();
	var zgt1no=$("#z1").val();
	var zgt2no=$("#z2").val();
	var testsno=$("#testsno").val();
	var suid=$("#suid").val();
	var xzt1c=$('input[name="chose1"]:checked').val();
	 if(xzt1c==null){
         alert("选择题第一题没做!");
         return false;
     }
	var xzt2c=$('input[name="chose2"]:checked').val();
	 if(xzt2c==null){
         alert("选择题第二题没做!");
         return false;
     }
	var xzt3c=$('input[name="chose3"]:checked').val();
	 if(xzt3c==null){
         alert("选择题第三题没做!");
         return false;
     }
	var xzt4c=$('input[name="chose4"]:checked').val();
	 if(xzt4c==null){
         alert("选择题第四题没做!");
         return false;
     }
	var xzt5c=$('input[name="chose5"]:checked').val();
	 if(xzt5c==null){
         alert("选择题第五题没做!");
         return false;
     }
	var zgtda1=$("#d1").val();
	 if(zgtda1==""){
         alert("主观题第一题没做!");
         return false;
     }
	var zgtda2=$("#d2").val();
	if(zgtda2==""){
        alert("主观题第二题没做!");
        return false;
    }
	alert("交卷后退出考试");
	$.ajax({
		url:'tests.do?check',//访问地址
		data:'xzt1no='+xzt1no+'&xzt2no='+xzt2no+'&xzt3no='+xzt3no+'&xzt4no='+xzt4no+'&xzt5no='+xzt5no+'&xzt1c='+xzt1c+'&xzt2c='+xzt2c+'&xzt3c='+xzt3c+'&xzt4c='+xzt4c+'&xzt5c='+xzt5c+'&sid='+sid+'&zgt1no='+zgt1no+'&zgt2no='+zgt2no+'&zgtda1='+zgtda1+'&zgtda2='+zgtda2+'&testsno='+testsno+'&suid='+suid,
		dataType:'json',
		type:'post',//提交方式
		success:function(result){//回调函数	
				location.href="student.jsp";
		}
	});
}
</script>
</head>
<body>

<div class="form-group">
<div><h1 class="text-warning" id="countdown">作答时间还剩 30 分 00 秒</h1></div>
<input name="testsno" id="testsno" value="${t.testsno}"  type="hidden">
<input name="sid" id="sid" value="${stu.sid}"  type="hidden">
<input name="suid" id="suid" value="${sj.suid}"  type="hidden">
<!--xzt1-->
		<h4>${x1.xztnr}</h4>
		<form action="">
		<label class="radio">
			<input name="chose[]" id="x1" value="${x1.xztno}"  type="hidden">
			<input required="required" type="radio" id="c1" name="chose1" id="optionsRadios3" value="${x1.a}" >A.${x1.a}
			<input required="required" type="radio" id="c1" name="chose1" id="optionsRadios3" value="${x1.b}" >B.${x1.b}
			<input required="required" type="radio" id="c1" name="chose1" id="optionsRadios3" value="${x1.c}" >C.${x1.c}
			<input required="required" type="radio" id="c1" name="chose1" id="optionsRadios3" value="${x1.d}" >D.${x1.d}
		</label>
		</form>
	<!--xzt1-->
	<!--xzt2-->
		<h4>${x2.xztnr}</h4>
		<form action="">
		<label class="radio">
			<input name="chose[]" id="x2" value="${x2.xztno}"  type="hidden">
			<input required="required" type="radio" id="c2" name="chose2" id="optionsRadios3" value="${x2.a}" >A.${x2.a}
			<input required="required" type="radio" id="c2" name="chose2" id="optionsRadios3" value="${x2.b}" >B.${x2.b}
			<input required="required" type="radio" id="c2" name="chose2" id="optionsRadios3" value="${x2.c}" >C.${x2.c}
			<input required="required" type="radio" id="c2" name="chose2" id="optionsRadios3" value="${x2.d}" >D.${x2.d}
		</label>
		</form>
	<!--xzt2-->	
	<!--xzt3-->
		<h4>${x3.xztnr}</h4>
		<form action="">
		<label class="radio">
			<input name="chose[]" id="x3" value="${x3.xztno}"  type="hidden">
			<input required="required" type="radio" id="c3" name="chose3" id="optionsRadios3" value="${x3.a}" >A.${x3.a}
			<input required="required" type="radio" id="c3" name="chose3" id="optionsRadios3" value="${x3.b}" >B.${x3.b}
			<input required="required" type="radio" id="c3" name="chose3" id="optionsRadios3" value="${x3.c}" >C.${x3.c}
			<input required="required" type="radio" id="c3" name="chose3" id="optionsRadios3" value="${x3.d}" >D.${x3.d}
		</label>
		</form>
	<!--xzt3-->	
	<!--xzt4-->
		<h4>${x4.xztnr}</h4>
		<form action="">
		<label class="radio">
			<input name="chose[]" id="x4" value="${x4.xztno}"  type="hidden">
			<input required="required" type="radio" id="c4" name="chose4" id="optionsRadios3" value="${x4.a}" >A.${x4.a}
			<input required="required" type="radio" id="c4" name="chose4" id="optionsRadios3" value="${x4.b}" >B.${x4.b}
			<input required="required" type="radio" id="c4" name="chose4" id="optionsRadios3" value="${x4.c}" >C.${x4.c}
			<input required="required" type="radio" id="c4" name="chose4" id="optionsRadios3" value="${x4.d}" >D.${x5.d}
		</label>
		</form>
	<!--xzt4-->	
	<!--xzt5-->
		<h4>${x5.xztnr}</h4>
		<form action="">
		<label class="radio">
			<input name="chose[]"  id="x5" value="${x5.xztno}"  type="hidden">
			<input required="required" type="radio" id="c5" name="chose5" id="optionsRadios3" value="${x5.a}" >A.${x5.a}
			<input required="required" type="radio" id="c5" name="chose5" id="optionsRadios3" value="${x5.b}" >B.${x5.b}
			<input required="required" type="radio" id="c5" name="chose5" id="optionsRadios3" value="${x5.c}" >C.${x5.c}
			<input required="required" type="radio" id="c5" name="chose5" id="optionsRadios3" value="${x5.d}" >D.${x5.d}
		</label>
		</form>
	<!--xzt5-->		
			
</div>

	<div class="form-group">
		<h4>${z1.zgtnr}</h4>
		<input   id="z1" value="${z1.zgtno}"  type="hidden">
		<textarea required="required" class="form-control" rows="3" id="d1"></textarea>
	</div>
	<div class="form-group">
		<h4>${z2.zgtnr}</h4>
		<input   id="z2" value="${z2.zgtno}"  type="hidden">
		<textarea required="required" class="form-control" rows="3" id="d2"></textarea>
	</div>
<button class="btn btn-info btn-lg" onclick="answer()" >交卷</button>
</body>
</html>