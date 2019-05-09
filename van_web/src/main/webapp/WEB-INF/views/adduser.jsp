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
                    <input id="id" type="text" name="userId" minlength="4" maxlength="4"/>
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
    <script src="${ctx}/static/common/layui/layui.all.js"></script>
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

        $(function () {
            $("#id").change(function () {
                var idd=$(this).val();
                chkStaffId(idd);
            });
            $("#name").change(function () {
                var namee=$(this).val();
                chkStaffName(namee);
            });
            $("#phone").change(function () {
                var phonee=$(this).val();
                chkStaffPhone(phonee);
            });
            $("#address").change(function () {
                var addre=$(this).val();
                chkStaffId(addre);
            });
        });

        //id
        function chkStaffId(idd) {
            var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
                regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
            if (idd===''){
                layer.msg("不能为空")

            }else if (regCn.test(idd)||regEn.test(idd)){
                layer.msg("请勿输入特殊字符");
                $("#id").css("color","red");
            }else if (!(idd.length===4) && idd.length===''){
                layer.msg("请输入4位数字");
                $("#id").css("color","red");
            }else {
                $("#id").css("color","black");
                return true
            }
            return false;
        }
        //name
        function chkStaffName(namee) {
            var ref=/^[\u4E00-\u9FA5]{2,4}$/ ;
            if (namee===''){
                layer.msg("不能为空");
            } else if (!ref.test(namee)){
                layer.msg("输入姓名");
                $("#name").css("color","red");
            }else {
                $("#name").css("color","black");
                return true;
            }
            return false;
        }

        //phone
        function chkStaffPhone(phonee) {
            var ref=/^1[34578]\d{9}$/ ;
            if (phonee===''){
                layer.msg("不能为空");
            } else if (!ref.test(phonee)){
                layer.msg("请输入正确号码");
                $("#phone").css("color","red");
            }else {
                $("#phone").css("color","black");
                return true;
            }
            return false;
        }


        function check(){
            var id = $("#id").val();
            var name = $("#name").val();
            var sex = radioCheck();
            var phone = $("#phone").val();
            var address = $("#address").val();

            if (chkStaffId(id) && chkStaffName(name)&& chkStaffAge(phone) && chkStaffId(address)){

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
                        alert('操作失败,用户id已存在，请稍后操作或联系管理员！');
                    }
                })
            }
            return false;
        }
    </script>
</body>
</html>