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
                <input id="id" type="text" name="stId" minlength="4"/>
            </div>
            <div class="user">
                <div>员工姓名</div>
                <input id="name" type="text" name="stName"  placeholder="填姓名" maxlength="10">
            </div>
            <div class="radio">
                <input type="radio" name="stSex" value="1" checked="checked"><span>男</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="stSex" value="0"><span>女</span>
            </div>
            <div class="user">
                <div>员工年龄</div>
                <input id="age" type="text" name="stAge" maxlength="50" placeholder="填年龄">
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

    function check() {
        var id=$("#id").val();
        var name=$("#name").val();
        var sex=radioCheck();
        var age=$("#age").val();
        var tel=$("#phone").val();

        if (id===''||name===''||sex===''||age===''||tel===''){
            alert("请不要空白");
        }

        var staff=JSON.stringify({
            "stId":id,
            "stName":name,
            "stSex":sex,
            "stAge":age,
            "stPhone":tel
        });

        alert(staff);
        $.ajax({
            url:"${ctx}/staff/add",
            type:"post",
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:staff,
            success:function () {
                alert("添加成功");
                $("#stId").val("");
                $("#stName").val("");
                $("#stSex").val("");
                $("#stAge").val("");
                $("#stPhone").val("");
            },
            error:function () {
                alert("添加失败，用户名已有");
            }

        })
    }

</script>
</body>
</html>