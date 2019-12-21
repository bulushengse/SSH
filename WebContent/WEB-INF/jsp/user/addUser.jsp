<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<br><br><br>
		<form action="addUser.action" method="post">
			用户：<input type="text" name="user.USERNAME"  id="USERNAME"  value="999"/><br>
			密码：<input type="text" name="user.PASSWORD"  id="PASSWORD"  value="999"/><br>
			姓名：<input type="text" name="user.NAME"  id="NAME"  value="999"/><br>
			手机号：<input type="text" name="user.PHONE"  id="PHONE"  value="999"/><br>
			邮箱：<input type="text" name="user.EMAIL"  id="EMAIL"  value="999"/><br>
			<input type="submit" value="新增" >
		</form>
		
		<br><br><br>
		<a href="javascript:history.back(-1)">返回上一页</a>
	</div>
</body>
</html>