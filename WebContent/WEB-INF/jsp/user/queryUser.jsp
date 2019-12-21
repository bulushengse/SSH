<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<h4>User List Page</h4>
	<%-- <h4>${userList }</h4> --%>
	<s:if test="userList== null || userList.size() == 0">
		没有任何用户信息
	</s:if>
	<s:else>
		<form action="queryPageUser.action" method="post" id="Form">
		查询条件-用户名：<input type="text" name="page.param.USERNAME"  id="USERNAME"  value="${page.param.USERNAME}"/>
		排序字段：
		<select name="page.sort.sortField">
			<option value="USER_ID" <s:if test="page.sort.sortField=='ID'">selected="selected"</s:if>>ID</option>
			<option value="USERNAME" <s:if test="page.sort.sortField=='USERNAME'">selected="selected"</s:if>>USERNAME</option>
			<option value="LAST_LOGIN" <s:if test="page.sort.sortField=='LAST_LOGIN'">selected="selected"</s:if>>LAST_LOGIN</option>
		</select>
		排序方式：
		<select name="page.sort.sortMethod">
			<option value="asc" <s:if test="page.sort.sortMethod=='asc'">selected="selected"</s:if>>升序</option>
			<option value="desc" <s:if test="page.sort.sortMethod=='desc">selected="selected"</s:if>>降序</option>
		</select>
		<input type="button" onclick="query(1)" value="查询">
		<br><br>
		<table border="1" >
			<tr>
				<th>ID</th>
				<th>USERNAME</th>
				<th>NAME</th>
				<th>LAST_LOGIN</th>
				<th>IP</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
			<s:iterator value="userList">
				<tr>
					<td>${USER_ID }</td>
					<td>${USERNAME }</td>
					<td>${NAME }</td>
					<td>${LAST_LOGIN }</td>
					<td>${IP }</td>
					<td>${EMAIL }</td>
					<td>${PHONE }</td>
				</tr>
			</s:iterator>
		</table>
		<br>
		总页数：${page.totalPage }
		当前页：${page.currentPage }
		总条数：${page.totalResult }
		每页显示记录数：${page.showCount }
		
		<br><br>
		<s:bean name="org.apache.struts2.util.Counter" var="counter">
			<s:param name="first" value="1" />
			<s:param name="last" value="page.totalPage" />
			<s:iterator>
				<input type="button"   onclick="query(<s:property value="current-1"/>)"  value="<s:property value="current-1"/>"/>
			</s:iterator>
		</s:bean>
		<input type="hidden" name="page.currentPage"  id="currentPage"  value="${page.currentPage }"/>
		
		</form>
	</s:else>
	
	<br><br><br>
	<a href="javascript:history.back(-1)">返回上一页</a>
	
<script type="text/javascript">
	function query(currentPage){
		$("#currentPage").val(currentPage);
		$("#Form").submit();
	}
</script>
</body>
</html>