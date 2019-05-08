
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="static/common/layui/css/amazeui.min.css"/>
    <style>
        .header {text-align: center;}
        .header h1 {font-size: 200%;color: #333;margin-top: 30px;}
        .header p {font-size: 14px;}
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>仓储管理系统</h1>
        <p>Parts Inventory System</p>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <br>
        <form method="post" class="am-form" action="${ctx}/admin/login" onsubmit="return check()">
            <label>账号或邮箱:</label>
            <input type="text" name="admId" id="adm">
            <br>
            <label>密码:</label>
            <input type="password" name="admPwd" id="pwd" >
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <br />
            <div class="am-cf">
                <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl" style="align-content: center">
                <input type="button" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
            </div>
        </form>
        <hr>
        <p>© 2019 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>

<script src="${ctx}/static/common/js/jquery-1.8.3.js"></script>
<script>

    /*用户名验证*/
    function checkUser(){
        var val = $("#adm").val();
        var reg=/[a-zA-Z0-9]{3,15}$/;
        if(!reg.test(val)){
            return false;
        }
        return true;
    }

    function checkPwd(){
        var val = $("#pwd").val();
        var reg=/^[a-zA-Z0-9]{3,10}$/;
        if(!reg.test(val)){
            return false;
        }
        
        return true;
    }

    //两个都通过了才提交表单
    function check(){
        if (checkUser()&&checkPwd()){
            return true;
        }else {
            alert("账号输入3 ~15位！！！,密码不能含有非法字符，长度在4-10之间喔~~~");
            return false;
        }

    }



</script>
</html>
