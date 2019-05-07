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
            <legend style="margin: auto">配送信息添加</legend>
        </fieldset>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">配送编号</label>
                <div class="layui-input-block">
                    <input type="text" name="psId" autocomplete="off" placeholder="请输入编号--" class="layui-input" lay-verify="number">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">接收人</label>
                <div class="layui-input-block">
                    <select name="cptId" id="accept" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">员工姓名</label>
                <div class="layui-input-block">
                    <select name="stId"  id="staff" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">仓库名称</label>
                <div class="layui-input-block">
                    <select name="ckId"  id="wh" lay-filter="">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">接货时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="psPicktime" id="date1" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">发货时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="psDelitime" id="date" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">配送方式</label>
                <div class="layui-input-inline">
                    <%--正则验证--%>
                    <input type="text" name="psType" lay-verify="type" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>

                <label class="layui-form-label">配送名称</label>
                <div class="layui-input-inline">
                    <input type="text"  name="psName" lay-verify="psName" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-radius" style="margin: 20px 300px;width: 600px;text-align: center" lay-submit="" lay-filter="delivery">提交</button>
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
                if(value.length < 6){
                    return '编号至少得6个字符啊';
                }


            }, type: function(value){

                if(value.length >= 20 ){
                    return '最大长度为 20 喔~~';
                }

            }, psName: function(value){


                if(value.length>=20 ){
                    return '最大长度为 20 喔~~';
                }

            }
        });



        //监听提交
        form.on('submit(delivery)', function(data){
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });

            var delivery = JSON.stringify(data.field);

            $.ajax({
                url:"${ctx}/delivery/add",
                type:"post",
                dataType:"json",
                contentType: "application/json",
                data: delivery,

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
            url:"${ctx}/delivery/staff",
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
            url:"${ctx}/delivery/wh",
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

        //下拉框显示
        $.ajax({
            url:"${ctx}/delivery/accept",
            type:"post",
            success:function (data) {
                for (var i = 0; i < data.length; i++) {

                    // alert(data[i].stName);
                    $("#accept").append("<option value='"+data[i].cptId+"'>"+data[i].cptName+"</option>");

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

    })

</script>
</body>
</html>