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
                <input id="ckid" type="text" name="ckId"  placeholder="填写仓库编号" maxlength="10" lay-verify="bh">
            </div>

            <div class="user">
                <div>仓库名称</div>
                <input id="name" type="text" name="ckName" maxlength="11" minlength="11" placeholder="仓库名称" lay-verify="mc">
            </div>

            <div class="user">
                <div>仓库容量</div>
                <input id="cksize" type="text" name="ckSize" maxlength="50" placeholder="仓库容量" lay-verify="liang">
            </div>

            <input type="button" value="添加仓库" class="layui-btn layui-btn-primary" style="width: 330px" onclick="check()"/>
        </div>
    </div>

    <jsp:include page="${ctx}/model/footer.jsp"/>
</div>
<script src="${ctx}/static/common/layui/layui.all.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });

    $(function () {
        $("#ckid").change(function () {
            var idd=$(this).val();
            chkIdd(idd);
        });

        $("#name").change(function () {
            var namee=$(this).val();
            chkName(namee);
        });
        
        $("#cksize").change(function () {
            var size=$(this).val();
            chkSize(size);
        })
    });

    function chkIdd(idd) {
        var ref= /^[A-Z][A-z0-9]*$/;
        if (idd===''){
            layer.msg("不能为空");
        }else if (!ref.test(idd)){
            layer.msg("首字母请大写");
            $("#ckid").css("color","red");
        }else if (!(idd.length===4)){
            layer.msg("编号为首字母大写+3位数");
            $("#ckid").css("color","red");
        }else {
            $("#ckid").css("color","black");
            return true;
        }
        return false;
    }
    function chkName(namee) {
        var ref=/^[a-zA-Z0-9_-]{2,8}$/ ;
        if (namee===''){
            layer.msg("不能为空");
        } else if (ref.test(namee)){
            layer.msg("仓库名在2-8位");
            $("#name").css("color","red");
        }else {
            $("#name").css("color","black");
            return true;
        }
        return false;
    }
    function chkSize(size) {
        var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
            regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
        if (regCn.test(size)||regEn.test(size)){
            layer.msg("请勿输入特殊字符");
            $("#cksize").css("color","red");
        }else if (size.length<9&&size.length>0){
            $("#cksize").css("color","black");
            return true;
        }else {
            layer.msg("请输入9位以内，且不能为空");
            $("#cksize").css("color","red");
        }
        return false;
    }

    function check() {
        var id=$("#ckid").val();
        var name=$("#name").val();
        var cksize=$("#cksize").val();

        if (chkIdd(id) && chkName(name) && chkSize(cksize)){

            var warehouse=JSON.stringify({
                "ckId":id,
                "ckName":name,
                "ckSize":cksize
            });
            $.ajax({
                url:"${ctx}/warehouse/add",
                type:"post",
                dataType:"json",
                contentType: "application/json; charset=utf-8",
                data:warehouse,
                success:function(){
                    layer.msg("添加成功");
                    $("#ckid").val("");
                    $("#name").val("");
                    $("#cksize").val("");
                },
                error:function () {
                    alert("添加失败,仓库id已存在")
                }
            });
        }
        return false;

    }
</script>
</body>
</html>