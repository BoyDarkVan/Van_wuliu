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
                <div>仓库编号</div>
                <input id="ckid" type="text" name="ckId"  placeholder="填写仓库编号" maxlength="10">
            </div>

            <div class="user">
                <div>仓库名称</div>
                <input id="name" type="text" name="ckName" maxlength="11" minlength="11" placeholder="仓库名称">
            </div>

            <div class="user">
                <div>仓库容量</div>
                <input id="cksize" type="text" name="ckSize" maxlength="50" placeholder="仓库容量">
            </div>

            <input type="button" value="添加仓库" class="layui-btn layui-btn-primary" style="width: 330px" onclick="check()"/>
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

    function check() {
        var id=$("#ckid").val();
        var name=$("#name").val();
        var cksize=$("#cksize").val();

        if (id===''|| name===''||cksize===''){
            alert("填写不规范");
            return null;
        }

        var warehouse=JSON.stringify({
            "ckId":id,
            "ckName":name,
            "ckSize":cksize
        });
        alert(warehouse);

        $.ajax({
            url:"${ctx}/warehouse/add",
            type:"post",
            dataType:"json",
            contentType: "application/json; charset=utf-8",
            data:warehouse,
            success:function(){
                alert("添加成功");
                $("#ckid").val("");
                $("#name").val("");
                $("#cksize").val("");
            },
            error:function () {
                alert("添加失败,仓库id已存在")
            }
        })
    }
</script>
</body>
</html>