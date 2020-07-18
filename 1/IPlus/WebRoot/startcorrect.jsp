<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批改主观题</title>
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script type="text/javascript">
function pingfen(){
	var xztmark=$("#xztmark").val();
	var pf1=$("#pf1").val();
	if(pf1=="请打分"||pf1==""){
        alert("您没有给学生的主观题第一题打分!");
        return false;
    }
	var pf2=$("#pf2").val();
	if(pf2=="请打分"||pf2==""){
        alert("您没有给学生的主观题第二题打分!");
        return false;
    }
	var tid=$("#tid").val();
	var sid=$("#sid").val();
	var suid=$("#suid").val();
	var testsno=$("#testsno").val();
	var fcno=$("#fcno").val();
	alert("提交后结束评分");
	$.ajax({
		url:'correct.do?pingfen',//访问地址
		data:'xztmark='+xztmark+'&pf1='+pf1+'&pf2='+pf2+'&tid='+tid+'&sid='+sid+'&suid='+suid+'&testsno='+testsno+'&fcno='+fcno,
		dataType:'json',
		type:'post',//提交方式
		success:function(result){//回调函数
			location.href="teacher.jsp";
		}
	});
}
</script>
</head>
<body>
<input   id="xztmark" value="${f.xztmark}"  type="hidden">
<input   id="tid" value="${t.tid}"  type="hidden">
<input   id="sid" value="${f.stu.sid}"  type="hidden">
<input   id="suid" value="${f.sj.suid}"  type="hidden">
<input   id="testsno" value="${f.testsno}"  type="hidden">
<input   id="fcno" value="${f.fcno}"  type="hidden">
<h2>评分标准:${z1.standard}</h2>
	<div>
		<h4>${z1.zgtnr}</h4>
		<input   id="z1" value="${f.zgtda1}"  type="hidden">
		<div>
		<input style="width:800px;height:200px;" required="required" readonly = "readonly" value="${f.zgtda1}" class="form-control" rows="3" id="d1"></input>
		</div>
		<select class="form-control" id="pf1" name="pf1">
			<option>请打分</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>  
			<option value="8">8</option>
			<option value="9">9</option>   
			<option value="10">10</option>           
		</select>
	</div>

<h2>评分标准:${z2.standard}</h2>
	<div class="form-group">
		<h4>${z2.zgtnr}</h4>
		<input   id="z2" value="${f.zgtda2}"  type="hidden">
		<div>
		<input style="width:800px;height:200px;" required="required" readonly = "readonly" value="${f.zgtda2}" class="form-control" rows="3" id="d2"></input>
		</div>
		<select class="form-control" id="pf2" name="pf2">
			<option>请打分</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>  
			<option value="8">8</option>
			<option value="9">9</option>   
			<option value="10">10</option>           
		</select>
	</div>
<button class="btn btn-info btn-lg" onclick="pingfen()" >评分</button>
</body>
</html>