<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
</head>
<body>
<form action="${ctx}/stu/update" method="post">
    <input type="text" name="stuId" value="${stu.stuId}" readonly="readonly">
    <input type="text" name="stuName" value="${stu.stuName}">
    <input type="text" name="stuPwd" value="${stu.stuPwd}">
    <input type="text" name="stuAddress" value="${stu.stuAddress}">
    <input type="submit" value="提交">
</form>

</body>
</html>
