<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/common/layui/css/layui.css">

    <link rel="stylesheet" href="${ctx}/static/main/adduser.css">
    <script src="${ctx}/static/common/js/jquery-1.8.3.js"></script>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">

        <jsp:include page="${ctx}/model/header.jsp"/>


        <div class="layui-body">

            <div class="cont">

                <div class="user">
                    <div>用户编号</div>
                    <input id="id" type="text" name="userId" minlength="4"/>
                </div>

                <div class="user">
                    <div>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div>
                    <input id="name" type="text" name="userName"  placeholder="-请写下你的用户姓名-" maxlength="10">
                </div>

                <div class="radio">
                    <input type="radio" name="userSex" value="1" checked="checked"><span>男</span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="userSex" value="0"><span>女</span>
                </div>

                <div class="user">
                    <div>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</div>
                    <input id="phone" type="text" name="userPhone" maxlength="11" minlength="11" placeholder="-请留下你的电话吧-">
                </div>

                <div class="user">
                    <div>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</div>
                    <input id="address" type="text" name="userAddr" maxlength="50" placeholder="-请留下下你的住址吧-">
                </div>

                <input type="button" value="添加用户" class="sub" onclick="check()"/>
            </div>


        </div>

        <jsp:include page="${ctx}/model/footer.jsp"/>
    </div>
<script src="${ctx}/static/common/layui/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });

        //单选框选中处理
        function radioCheck(){
            var radio = document.getElementsByName("userSex");
            for(var i = 0; i < radio.length; i ++){
                if(radio[i].checked) {
                    return radio[i].value;
                }

            }
        }

        function check(){
            var id = $("#id").val();
            var name = $("#name").val();
            var sex = radioCheck();
            var phone = $("#phone").val();
            var address = $("#address").val();

            if(id ===''|| name ===''||phone === ''|| address===''){
                alert('操作失败，请规范填写！');
                return null;
            }

            var users = JSON.stringify({
                "userId":id,
                "userName":name,
                "userSex":sex,
                "userPhone":phone,
                "userAddr":address
            });

            $.ajax({
                url:"${ctx}/users/add",
                type:"post",
                dataType:"json",
                contentType: "application/json; charset=utf-8",
                data: users,
                success:function () {
                    alert('添加成功！请继续操作！！！');

                    $("#id").val("");
                    $("#name").val("");
                    $("#phone").val("");
                    $("#address").val("");

                },
                error:function () {
                    alert('操作失败，请稍后操作或联系管理员！');
                }
            })
        }
    </script>
</body>
</html>