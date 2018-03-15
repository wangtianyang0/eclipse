<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>TestPspt</title>
</head>
<body>
<form name="form" action="testTable.jsp" method="post">
		<input type="hidden" name="action" value="register" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户查询</td>
			</tr>
			<tr>
				<td>证件号：</td>
				<td><input type=text name="psptId" size="30" maxlength="25">
				<input type="submit" value="查询">
				</td>
		</table>
	</form>
</body>
</html>