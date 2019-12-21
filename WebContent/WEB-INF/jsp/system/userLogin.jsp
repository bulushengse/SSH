<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>

</head>
<body>
	<div style="text-align: center;">
		<br><br><br>
		<form action="checkLogin.action" method="post">
			用户：<input type="text" name="USERNAME"  id="USERNAME"  value="zhoubc"/>
			密码：<input type="text" name="PASSWORD"  id="PASSWORD"  value="999"/>
			<input type="button" value="登录" onclick="severCheck()">
		</form>
	</div>
	
	
	
<script type="text/javascript">
	function severCheck(){
		var USERNAME = $("#USERNAME").val();
		var PASSWORD = $("#PASSWORD").val();
		
		$.ajax({
			type: "POST",
			url: '<%=basePath%>checkLogin.action',
	    	data: {USERNAME:USERNAME,PASSWORD:PASSWORD,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.retCode==1){
					 window.location.href = "<%=basePath%>goIndex.action"
				}else{
					alert("账号或密码错误！");
				}
			}
		});
		
	}
</script>
</body>
</html>