<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.stuId }</td>
            <td>${student.stuName }</td>
            <td>${student.stuPwd }</td>
            <td>${student.stuAddress }</td>
            <td><a href="${pageContext.request.contextPath}/stu/findone/${student.stuId}">修改</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
