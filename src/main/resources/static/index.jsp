<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.header{
    background-color: #FFFFFF;
    background-image: url(image/logo.jpg);
    background-position: 0px center;
    background-repeat: no-repeat;
    overflow: hidden;
	margin-bottom:0px;
	margin-top:0px;

}
.header h1{
	color:blue;
	font-family:微软雅黑;
	margin-top:10px;
	margin-bottom:10px;
}
.header h1:hover{
	color:red;

}
tr{
	width:100px;
	height:30px;
}	
.td1{
	width:70px;
	height:30px;
}
.td2{
	width: 389px;
    height: 30px;
}
.submit-button{
	position: relative;
    left: 12px;
}
.delete-button{
	position: relative;
    left: 16px;
}
.checkout{
	position: relative;
    left: 430px;
}
</style>
<body>
	<div class="header">
		<h1 align="center"> 一证五户营业查询系统</h1>
	</div>
	<hr style="height:6px;font-size: 1px;background-color:#D6000F;overflow: hidden;">
	<div class="content">
		<table border="1px solid #000" align="center">
			<tr>
				<td class="td1">用户ID</td>
				<td class="td2">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr>
			<tr>
				<td class="td1">业务号码</td>
				<td class="td2">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr>
			<tr>
				<td class="td1">证件号码</td>
				<td class="td2">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr>
			<tr>
				<td class="td1">证件类别</td>
				<td class="td2">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr>
			<tr>
				<td class="td1">客户名称</td>
				<td class="td2">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr>
			<tr>
				<td class="td1">号码状态</td>
				<td class="td2"style="width:250px;height:25px;">
				<input type="text" class="userid" style="width:250px;height:25px;">
				<input class="submit-button" type="submit" value="修改" href="javacript:void(0)">
				<input class="delete-button" type="submit" value="删除" href="javacript:void(0)">
				</td>
			</tr> 
		</table>
	</div>
	<div>
		<p id="checkout" style="width:470px;height:300px; border:1px solid #000;align:center;text-align:center;position:absolute; left: 438px;">	
			
		</p>
	</div>
	<!-- <script type="text/javascript">
		var request = { 
			QueryString : function(val) { 
			var uri = window.location.search; 
			var re = new RegExp("" +val+ "=([^&?]*)", "ig"); 
			return ((uri.match(re))?(uri.match(re)[0].substr(val.length+1)):null); 
			}, 
			QueryStrings : function() { 
			var uri = window.location.search; 
			var re = /w*=([^&?]*)/ig; 
			var retval=[]; 
			while ((arr = re.exec(uri)) != null) 
			retval.push(arr[0]); 
			return retval; 
			}, 
			setQuery : function(val1, val2) { 
			var a = this.QueryStrings(); 
			var retval = ""; 
			var seted = false; 
			var re = new RegExp("^" +val1+ "=([^&?]*)$", "ig"); 
			for(var i=0; i<a.length; i++) { 
			if (re.test(a[i])) { 
			seted = true; 
			a[i] = val1 +"="+ val2; 
			} 
		} 
			retval = a.join("&"); 
			return "?" +retval+ (seted ? "" : (retval ? "&" : "") +val1+ "=" +val2); 
	} 
	} 
	var USER_ID = request.QueryString("USER_ID");
	//alert(USER_ID);
	//alert(request.QueryString("USER_ID"));
	var USER_ID = request.QueryString("PSPT_ID");
	var USER_ID = request.QueryString("updateinformation");
	
	var allUserValue = request.QueryString("");
	allUserValue="11111111";
	document.getElementById("checkout").value="allUserValue";
	$("#checkout").val("allUserValue");
	//alert(request.setQuery("e","b"));
	</script> -->

</body>
</html>