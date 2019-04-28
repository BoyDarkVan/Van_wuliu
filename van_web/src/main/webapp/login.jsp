<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>jsp</p>
<form action="${pageContext.request.contextPath}/admin/login" method="post">
    <input type="text" name="admin_id" >
    <input type="text" name="admin_pwd" >
    <input type="submit" value="登陆"><span>${failMessage}</span>
</form>

</body>
</html>
