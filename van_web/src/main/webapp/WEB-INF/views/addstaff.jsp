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
        <!-- 内容主体区域 -->
        <div class="cont">
            <div class="user">
                <div>员工编号</div>
                <input id="id" type="text" name="stId" oninput="value=value.replace(/[^\d]/g,'')" minlength="4" maxlength="4"/>
            </div>
            <div class="user">
                <div>员工姓名</div>
                <input id="name" type="text" name="stName" placeholder="填姓名" maxlength="8">
            </div>
            <div class="radio">
                <input type="radio" name="stSex" value="1" checked="checked"><span>男</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="stSex" value="0"><span>女</span>
            </div>
            <div class="user">
                <div>员工年龄</div>
                <input id="age" oninput="value=value.replace(/[^\d]/g,'')" type="text" name="stAge" maxlength="3" placeholder="填年龄">
            </div>
            <div class="user">
                <div>员工电话</div>
                <input id="phone" type="text" name="stPhone" maxlength="11" minlength="11" placeholder="填电话">
            </div>

            <input type="button" value="增加员工" class="layui-btn layui-btn-primary" style="width: 330px" onclick="check()"/>
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

    function radioCheck() {
        var radio=document.getElementsByName("stSex");
        for (var i=0;i<radio.length;i++){
            if (radio[i].checked){
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
        $("#age").change(function () {
            var agee=$(this).val();
            chkStaffAge(agee);
        });
        $("#phone").change(function () {
            var phonee=$(this).val();
            chkStaffPhone(phonee);
        })
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
    //age
    function chkStaffAge(agee) {
        var ref=/^[1-9]\d{0,2}$/ ;
        if (agee===''){
            layer.msg("不能为空");
        } else if (!ref.test(agee)){
            layer.msg("在2-3位");
            $("#age").css("color","red");
        }else {
            $("#age").css("color","black");
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



    function check() {
        var id=$("#id").val();
        var name=$("#name").val();
        var sex=radioCheck();
        var age=$("#age").val();
        var tel=$("#phone").val();

        if (chkStaffId(id) && chkStaffName(name)&& chkStaffAge(age) && chkStaffPhone(tel)){

            var staff=JSON.stringify({
                "stId":id,
                "stName":name,
                "stSex":sex,
                "stAge":age,
                "stPhone":tel
            });

            $.ajax({
                url:"${ctx}/staff/add",
                type:"post",
                dataType:"json",
                contentType:"application/json;charset=utf-8",
                data:staff,
                success:function () {
                    layer.msg("添加成功");
                    $("#stId").val("");
                    $("#stName").val("");
                    $("#stSex").val("");
                    $("#stAge").val("");
                    $("#stPhone").val("");
                },
                error:function () {
                    layer.msg("添加失败，用户名已有");
                }
            });
        }
        return false;
    }

</script>
</body>
</html>