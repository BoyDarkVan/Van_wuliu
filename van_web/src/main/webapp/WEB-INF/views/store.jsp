<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/static/common/layui/css/layui.css">
</head>
<style>

    .table_order{
        width: 600px;
        height: 300px;
        margin: 60px auto;
        border: 1px solid black;
    }
    .table_order td{
        width: 50px;
        height: 30px;
        border: 1px solid black;
    }
    .bottom{
        margin: 0 auto;
    }
</style>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="${ctx}/model/header.jsp"/>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">储存查询</div>
        <table class="table_order">
            <tr>
                <td>储存编号</td>
                <td>入库时间</td>
                <td>出库时间</td>
                <td>入库数量</td>
                <td>出库数量</td>
                <td>员工编号</td>
                <td>仓库编号</td>
                <td>货物编号</td>
            </tr>

            <c:forEach items="${storelist}" var="sto">
                <tr>
                    <td>${sto.sId}</td>
                    <td>${sto.sTime}</td>
                    <td>${sto.sOutime}</td>
                    <td>${sto.sCount}</td>
                    <td>${sto.sOutcount}</td>
                    <td>${sto.stId}</td>
                    <td>${sto.ckId}</td>
                    <td>${sto.gId}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="bottom">
            <a href="${pageContext.request.contextPath}/store/findAllStore?param=${currentPage-1}">上一页</a>
            <span>${currentPage}</span>
            <span>/</span>
            <span>${totalpage}</span>
            <a href="${pageContext.request.contextPath}/store/findAllStore?param=${currentPage+1}">下一页</a>
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
</script>
</body>
</html>