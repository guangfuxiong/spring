<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/photo.do" method="POST" enctype="multipart/form-data">
    <table width="55%" height="120px" border="1px" align="center">
        <tr align="center">
            <td colspan="2"><h3>文件上传</h3></td>
        </tr>

        <tr align="center">
            <td>照片上传</td>
            <td><input type="file" name="photo"/></td>
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