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
        <table id="delivery" lay-filter="test"></table>
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
            elem: '#delivery'
            ,height: 500
            ,url: '${ctx}/delivery/find' //数据接口
            ,limit:10
            ,toolbar: '#tools'
            ,page: true //开启分页
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}//多选框
                ,{field: 'psId', title: '配送编号' ,sort: true, fixed: 'left'}
                ,{field: 'accept', title: '收货人',width:80,templet:'<div>{{ d.accept.cptName }}</div>'}
                ,{field: 'accept', title: '收货人电话',width:120,templet:'<div>{{ d.accept.cptPhone }}</div>'}
                ,{field: 'staff', title: '员工姓名',templet:'<div>{{ d.staff.stName }}</div>'}
                ,{field: 'warehouse', title: '仓库名称',templet:'<div>{{ d.warehouse.ckName }}</div>'}
                ,{field: 'psPicktime', title: '接货时间',templet: "<div>{{layui.util.toDateString(d.psPicktime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                ,{field: 'psDelitime', title: '发货时间',templet: "<div>{{layui.util.toDateString(d.psDelitime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                ,{field: 'psType', title: '配送方式',width:120,edit:"text"}
                ,{field: 'psName', title: '配送名称',edit:"text"}
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
                // alert(data.psId);//获取当前数据
                layer.confirm('真的删除行么', function(index){

                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);

                    var psId = data.psId;

                    $.ajax({
                        url:"${ctx}/delivery/del/"+psId,
                        type:"post",
                        success:function () {
                            layer.msg("刪除成功");
                        },
                        error:function () {
                            layer.msg("操作失败，请稍后操作或联系管理员！");
                        }
                    })
                });
            } else if(layEvent === 'edit'){

                layer.confirm('真的更新该行么', function(){

                    var delivery = JSON.stringify({
                        "psId":data.psId,
                        "psType":data.psType,
                        "psName":data.psName,
                    });

                    $.ajax({
                        url:"${ctx}/delivery/upd",
                        type:"post",
                        dataType:"json",
                        contentType: "application/json; charset=utf-8",
                        data: delivery,
                        success:function () {
                            layer.msg('更新成功');
                        },
                        error:function () {
                            layer.msg('操作失败，请稍后操作或联系管理员！');
                        }
                    })
                })

            }
        });

    });
</script>
</body>
</html>