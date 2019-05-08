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
            <legend style="margin: auto">储存信息添加</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">储存编号</label>
                <div class="layui-input-block">
                    <input type="text" name="sId" autocomplete="off" placeholder="请输入编号--" class="layui-input" lay-verify="number">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">入库数量</label>
                <div class="layui-input-inline">
                    <%--正则验证--%>
                    <input type="text" name="sCount" lay-verify="count" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">出库数量</label>
                <div class="layui-input-inline">
                    <input type="text"  name="outCount" lay-verify="outCount" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">入库时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="sTime" id="date1" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">出库时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sOutime" id="date" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">员工姓名</label>
                <div class="layui-input-block">
                    <select name="stId"  id="staff" lay-verify="required">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">仓库名称</label>
                <div class="layui-input-block">
                    <select name="ckId"  id="wh" lay-verify="required">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">货物名称</label>
                <div class="layui-input-block">
                    <select name="gId" id="goods" lay-verify="required">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-radius" style="margin: 20px 300px;width: 600px;text-align: center" lay-submit="" lay-filter="store">提交</button>
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
    layui.use('element', function(){
        var element = layui.element;

    });

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date',
            type:'datetime'
        });
        laydate.render({
            elem: '#date1',
            type:'datetime'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            //验证编号
            number: function(value){
                var reg =/^[A-Za-z0-9]+$/;

                if(!reg.test(value) || value.length<6){
                    return '编号至少得6个字符啊,且不能输入汉字呦~~';
                }
                //验证入库数量
            }, count: function(value){
                var reg =/^\d{1,11}$/;

                if(!reg.test(value)){
                    return '只能输入数字，最多11位';
                }
                //    验证出库数量
            }, outCount: function(value){
                var reg = /^\d{1,11}$/;

                if(!reg.test(value)){
                    return '只能输入数字，最多11位';
                }

            }
        });



        //监听提交
        form.on('submit(store)', function(data){
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });

            var store = JSON.stringify(data.field);

            $.ajax({
                url:"${ctx}/store/add",
                type:"post",
                dataType:"json",
                contentType: "application/json",
                data: store,

                success:function(){
                    layer.msg("信息添加成功！");
                },
                error: function () {
                    layer.msg("操作失败，请重新提交或联系管理员！");
                }

            });


            return false;
        });


        //下拉框显示员工
        $.ajax({
            url:"${ctx}/store/staff",
            type:"post",
            success:function (data) {
                for (var i = 0; i < data.length; i++) {

                    // alert(data[i].stName);
                    $("#staff").append("<option value='"+data[i].stId+"'>"+data[i].stName+"</option>");

                }

                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error:function () {

            }

        })

        //下拉框显示仓库
        $.ajax({
            url:"${ctx}/store/wh",
            type:"post",
            success:function (data) {
                for (var i = 0; i < data.length; i++) {

                    // alert(data[i].stName);
                    $("#wh").append("<option value='"+data[i].ckId+"'>"+data[i].ckName+"</option>");

                }

                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error:function () {

            }

        });

        //下拉框显示货物
        $.ajax({
            url:"${ctx}/store/goods",
            type:"post",
            success:function (data) {
                for (var i = 0; i < data.length; i++) {

                    // alert(data[i].stName);
                    $("#goods").append("<option value='"+data[i].gId+"'>"+data[i].gName+"</option>");

                }

                //回显页面
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            },
            error:function () {

            }

        });

        // //获取员工下拉框选中的值
        // form.on('select(stId)', function(data){
        //
        //     alert(data.value); //得到被选中的值
        //
        // });
        //
        // //获取储存下拉框选中的值
        // form.on('select(ckId)', function(data){
        //
        //     alert(data.value); //得到被选中的值
        //
        // });
        //
        // //获取货物下拉框选中的值
        // form.on('select(gId)', function(data){
        //
        //     alert(data.value); //得到被选中的值
        //
        // });
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