<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table id="warehouse" lay-filter="test"></table>
    </div>

    <script type="text/html" id="tools">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
            <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        </div>
    </script>

    <script type="text/html" id="action">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <jsp:include page="${ctx}/model/footer.jsp"/>
</div>
<script src="${ctx}/static/common/layui/layui.js"></script>
<script src="${ctx}/static/common/js/jquery-1.8.3.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#warehouse'
            ,height: 500
            ,url: '${ctx}/warehouse/findAllWarehouse' //数据接口
            ,limit:2
            ,toolbar: '#tools'
            ,page: true //开启分页
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}//多选框
                ,{field: 'ckId', title: '仓库编号' ,sort: true, fixed: 'left'}
                ,{field: 'ckName', title: '仓库名称',edit:"text"}
                ,{field: 'ckSize', title: '仓库容量',edit:"text"}
                ,{fixed: 'right', align:'center',title:"操作",toolbar: '#action'}
            ]]

        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
            }
        });


        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值

            if(layEvent === 'del'){
                //向服务端发送删除指令
                alert(data.ckId);//获取当前数据
                layer.confirm('真的删除行么', function(index){

                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);

                    var ckId = data.ckId;

                    $.ajax({
                        url:"${ctx}/warehouse/del/"+ckId,
                        type:"post",
                        success:function () {
                            alert("刪除成功");
                        },
                        error:function () {
                            alert("操作失败，请稍后操作或联系管理员！");
                        }
                    })
                });
            } else if(layEvent === 'edit'){

                layer.confirm('确认修改吗？',function () {

                    var warehouse=JSON.stringify({
                        "ckId":data.ckId,
                        "ckName":data.ckName,
                        "ckSize":data.ckSize
                    });

                    alert(warehouse);

                    $.ajax({
                        url:"${ctx}/warehouse/upd",
                        type:"post",
                        dataType:"json",
                        contentType:"application/json ;charset=utf-8",
                        data:warehouse,
                        success:function () {
                            layer.msg("修改成功");
                        },
                        error:function () {
                            layer.msg("失败");
                        }
                    })
                })
            }
        });

    });
</script>
</body>
</html>