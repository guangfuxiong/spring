<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/addUserToObj.do" method="POST">
			<table width="55%" height="120px" border="1px" align="center">
				<tr align="center">
					<td colspan="2"><h3>用户注册信息</h3></td>
				</tr>
				<tr align="center">
					<td>用户名:</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr align="center">
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr align="center">
					<td>性别:</td>
					<td>
						<input type="radio" name="gender" value="男"/>男
						<input type="radio" name="gender" value="女"/>女
						<input type="radio" name="gender" value="其他"/>其他
						
					</td>
				</tr>
				<tr align="center">
					<td>身高:</td>
					<td><input type="text" name="height"/></td>
				</tr>
				<tr align="center">
					<td>年龄:</td>
					<td><input type="text" name="info.age"/></td>
				</tr>
				<tr align="center">
					<td>生日:</td>
					<td><input type="text" name="birthday"/></td>
				</tr>
				<tr align="center">
					<td>爱好:</td>
					<td>
						<input type="checkbox" name="hobbys" value="踢球"/>踢球
						<input type="checkbox" name="hobbys" value="敲代码"/>敲代码
						<input type="checkbox" name="hobbys" value="玩农药"/>弄农药
						<input type="checkbox" name="hobbys" value="专挑晚上电影"/>专挑晚上电影
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="提交"/>
					</td>
				</tr>
			</table>
		
		
		</form>
	</body>
</html>
