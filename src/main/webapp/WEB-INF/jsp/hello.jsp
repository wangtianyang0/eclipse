<%@page import="com.data.redis.usr.User"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>一证五户查询</title>
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
    left: 30px;
}
.delete-button{
	position: relative;
    left: 16px;
}
.checkout{
	position: relative;
    left: 430px;
}
h3{
	padding:0;margin:0;color:blue;
	font-family:微软雅黑;
}
.content h3:hover{
	color:red;
}
.updateuserid-deleteuser h3:hover{
	color:red;
}

</style>
<body>
	<div class="header">
		<h1 align="center"> 一证五户营业查询系统</h1>
	</div>
	<hr style="height:6px;font-size: 1px;background-color:#D6000F;overflow: hidden;">
	</hr>
	<div class ="queryuserid">
		<table align="center" border="1px solid #000">
			<form action="findall">
				<tr>
					<td class="td1">
						用户ID
					</td>
					<td  style="width:389px;height:25px;">
						<input name = "USER_ID" type = "text"  style ="width:250px;height:25px;" required="required" placeholder="请输入用户ID"/>
						<input style="position:relative;left:30px;" class="submit-button" type="submit" value="查询信息" href="javacript:void(0)"/>
					</td>
				</tr>
			</form>
		</table>
	</div>
	<div class ="updateuserid-deleteuser">
		<div finduser>
			<table align="center" border="1px solid #000">
				<tr>
					<td class="td1">
						证件号码
					</td>
					<td style="width:389px;height:25px;">
						<form action = "finduser">
							<input name="PSPT_ID" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户证件号码"/>
							<input style="position:relative;left:30px;" class="submit-button" type="submit" value="查询用户" href="javacript:void(0)"/>
						</form>
					</td>
				</tr>
			</table>
		</div>
		<div class = "findallusernum">
			<table align="center" border="1px solid #000">
			<tr>
				<td class="td1">
					证件号码
				</td>
				<td style="width:389px;height:25px;">
					<form action = "finduserSerialNum">
						<input name="PSPT_ID" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户证件号码"/>
						<input style="position:relative;left:18px;" class="submit-button" type="submit" value="查询用户号码" href="javacript:void(0)"/>
					</form>
				</td>
			</tr>
		</table>
	</div>
		<h3 class ="deletetitle" align="center">删除用户信息</h3>
		<div class= "delete1">
			<table align="center" border="1px solid #000">
					<tr>
						<td class="td1">
								用户ID
						</td>
						<td  style="width:389px;height:25px;">
						<form action = "delete1">
							<input name = "USER_ID" type = "text"  style ="width:250px;height:25px;" required="required" placeholder="请输入用户ID"/>
							<input style="position:relative;left:30px;" class="submit-button" type="submit" value="删除信息" href="javacript:void(0)"/>
						</td>
					</tr>
					<tr>
						<td class="td1">
							证件号码
						</td>
						<td style="width:389px;height:25px;">
							
								<input name="PSPT_ID" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户证件号码"/>
								<input style="position:relative;left:30px;" class="submit-button" type="submit" value="删除信息" href="javacript:void(0)"/>
						</form>	
						</td>
					</tr>
			</table>
		</div>
		<div class="delete">
			<table align="center" border="1px solid #000">
				<tr>
					<td class="td1">
						手机号码
					</td>
					<td style="width:389px;height:25px;">
						<form action ="delete">
							<input name="SERIAL_NUMBER" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户手机号码"/>
							<input style="position:relative;left:30px;" class="submit-button" type="submit" value="删除信息" href="javacript:void(0)"/>
						</form>
					</td>
				</tr>
			</table>
		<div>
	</div>
	<div class="content">
	<h3 class ="updatetitle" align="center">更新用户信息</h3>
		<table border="1px solid #000" align="center">
			<form action = "update">
				<tr>
					<td class="td1">用户ID</td>
					<td class="td2">
						<input name="USER_ID" type="text" class="userid" required="required" placeholder="请输入用户ID" style="width:250px;height:25px;"/>
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)"/>
					</td>
				</tr>
				<tr>
					<td class="td1">业务号码</td>
					<td class="td2">
						<input name="SERIAL_NUMBER" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户业务号码"/>
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)"/>
					</td>
				</tr>
				<tr>
					<td class="td1">证件号码</td>
					<td class="td2">
						<input  name="PSPT_ID" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户证件号码"/>
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)"/>
					</td>
				</tr>
				<tr>
					<td class="td1">证件类别</td>
					<td class="td2">
						<input name="PSPT_TYPE_CODE" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户证件类别"/>
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)"/>
					</td>
				</tr>
				<tr>
					<td class="td1">客户名称</td>
					<td class="td2">
						<input name="CUST_NAME" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入客户名称"/>
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)"/>
					</td>
				</tr>
				<tr>
					<td class="td1">号码状态</td>
					<td class="td2" style="width:250px;height:25px;" >
						<input name="STATUS" type="text" class="userid" style="width:250px;height:25px;" required="required" placeholder="请输入用户ID" />
						<input class="submit-button" type="submit" value="修改" href="javacript:void(0)" />
					</td>
				</tr> 
			</form>
		</table>
	</div>
	<div>
		<p id="checkout" style="width:470px;height:200px; border:1px solid #000;align:center;text-align:center;position:absolute; left: 32.5%;">	
			<ol>
				<c:forEach var="tempMap" items="${AllUserInformation}">                                 
      				<option value="<c:out value="${tempMap.key}"/>"><c:out value="${tempMap.value}"/></option>
				</c:forEach>
			</ol>
		</p>
	</div>
	<div style="position:relative;">
	<table border="1px solid #000" style="position:absolute;left:32.5%;top:222px;">
		<form action = "submitsystem">
			<tr>
				<td style="width:226px;height:25px;" >
				<input style="position:relative;left:78px;width:65px;height:22px;" class="submit-button" type="submit" value="提交" href="javacript:void(0)" />
				</td>
				<td style="width:226px;height:25px;" >
				<input style="position:relative;left:78px;width:65px;height:22px;" class="submit-button" type="submit" value="完成" href="javacript:void(0)" />
				</td>
			</tr>
		</form>
	</table>
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