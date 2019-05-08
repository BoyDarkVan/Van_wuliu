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
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>货单添加</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">货单详情</label>
                <div class="layui-input-inline">
                    <%--正则验证--%>
                    <input type="text" name="orderName" lay-verify="require" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">运费</label>
                <div class="layui-input-inline">
                    <input type="text" name="orderPrice" lay-verify="outCount" placeholder="请输入" autocomplete="off"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">客户</label>
                <div class="layui-input-block">
                    <select name="userId" id="users" lay-verify="require" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收货人</label>
                <div class="layui-input-block">
                    <select name="cptId" id="accept" lay-verify="require" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">运输司机</label>
                <div class="layui-input-block">
                    <select name="stId" id="staff" lay-verify="require" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">货物名称</label>
                <div class="layui-input-block">
                    <select name="gId" id="goods" lay-verify="require"  lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-radius" style="margin: 20px 300px;width: 600px;text-align: center"
                        lay-submit="" lay-filter="orders">提交
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
            //验证编号
            number: function (value) {
                if (value.length < 6) {
                    return '编号至少得6个字符啊';
                }
                //验证入库数量
            }, count: function (value) {
                var reg = /^\d{1,11}$/;

                if (!reg.test(value)) {
                    return '只能输入数字，最多11位';
                }
                //    验证出库数量
            }, outCount: function (value) {
                var reg = /^\d{1,11}$/;

                if (!reg.test(value)) {
                    return '只能输入数字，最多11位';
                }

            },require: function (value) {

                if (value=="") {
                    return '必须填';
                }
            }
        });


        //监听提交
        form.on('submit(orders)', function (data) {
            var temp = JSON.stringify(data.field);
            var timeback;
            $.ajax({
                url: "${ctx}/orders/add",
                type: "post",
                data: temp,
                dataType: 'json',
                contentType: "application/json",
                success: function (data) {
                     timeback = setInterval(function () {
                        window.location = "${ctx}/orders/page";
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

        //下拉框显示客户
        $.ajax({
            url: "${ctx}/orders/get_select_users",
            type: "post",
            success: function (data) {
                for (var p in data) {
                    // alert(data[i].stName);
                    $("#users").append('<option value=' + data[p].userId + '>' + data[p].userName + '</option>');
                }
                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error: function () {
            }
        })

        //下拉框显示收货人
        $.ajax({
            url: "${ctx}/orders/get_select_accept",
            type: "post",
            success: function (data) {
                for (var p in data) {
                    $("#accept").append('<option value=' + data[p].cptId + '>' + data[p].cptName + '</option>');
                }
                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error: function () {
            }
        });

        //下拉框显示司机
        $.ajax({
            url: "${ctx}/orders/get_select_staff",
            type: "post",
            success: function (data) {
                for (var p in data) {
                    // alert(data[i].stName);
                    $("#staff").append('<option value=' + data[p].stId + '>' + data[p].stName + '</option>');

                }

                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error: function () {

            }

        });


        //下拉框显示货物
        $.ajax({
            url: "${ctx}/store/goods",
            type: "post",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    $("#goods").append("<option value='" + data[i].gId + "'>" + data[i].gName + "</option>");
                }
                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error: function () {
            }
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