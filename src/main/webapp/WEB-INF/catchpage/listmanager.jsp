<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1" width="80%">
			<tr>
				<td>id</td>
				<td>username</td>
			</tr>
			<c:forEach items="${listmanager }" var="m">
				<tr>
					<td>${m.oid }</td>
					<td>${m.username }</td>
				</tr>
			</c:forEach>
		</table>
</body>
</center>
</html>