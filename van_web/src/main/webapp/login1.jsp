<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>jsp</p>
<form action="${ctx}/admin/login" method="post">
    <input type="text" name="admId" >
    <input type="text" name="admPwd" >
    <input type="submit" value="登陆">
</form>

</body>
</html>
