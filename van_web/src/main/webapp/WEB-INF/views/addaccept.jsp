<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/common/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="${ctx}/model/header.jsp"/>


    <div class="layui-body">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>收货人添加</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">收货人姓名</label>
                <div class="layui-input-inline">
                    <%--正则验证--%>
                    <input type="text" name="cptName" placeholder="请输入" required autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">收货人地址</label>
                <div class="layui-input-inline">
                    <input type="text" name="cptAddr" required   placeholder="请输入" autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">收货人手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="cptPhone" lay-verify="outCount" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">请选择性别</label>
                <div class="layui-input-block">
                    <select name="cptSex" required  lay-filter="">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </div>
            </div>


            <div class="layui-form-item">
                <button class="layui-btn layui-btn-radius" style="margin: 20px 300px;width: 600px;text-align: center"
                        lay-submit="" lay-filter="accept">提交
                </button>
            </div>
        </form>
    </div>

    <jsp:include page="${ctx}/model/footer.jsp"/>
</div>

<script src="${ctx}/static/common/layui/layui.js"></script>
<script src="${ctx}/static/common/layui/layui.all.js"></script>

<script src="${ctx}/static/common/js/jquery-1.8.3.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });

    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
             outCount: function (value) {
                var reg = /^\d{1,11}$/;

                if (!reg.test(value)) {
                    return '只能输入数字，最多11位';
                }
            }
        });


        //监听提交
        form.on('submit(accept)', function (data) {
            var temp = JSON.stringify(data.field);
            console.log(temp)
            var timeback;
            $.ajax({
                url: "${ctx}/accept/add",
                type: "post",
                data: temp,
                dataType: 'json',
                contentType: "application/json",
                success: function (data) {
                    timeback = setInterval(function () {
                        window.location = "${ctx}/accept/page";
                    }, 3000);
                }
            });
            layer.open({
                content: '添加成功,3秒后回到查询界面，关闭或点击继续添加可继续添加货单'
                , btn: ['yes']
                , anim: 1
                ,yes: function(index, layero){
                    clearInterval(timeback);
                    layer.close(index);
                }


            });
            return false;
        });

    })


</script>

</body>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/common/layui/css/layui.css">

</head>
</html>