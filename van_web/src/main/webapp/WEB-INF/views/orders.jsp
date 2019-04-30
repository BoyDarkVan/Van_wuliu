<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">货单查询</div>

        <table>
            <c:forEach items="${orderlist}" var="ooo">
                <tr>
                    <td>${ooo.orderId}</td>
                    <td>${ooo.orderName}</td>
                    <td>${ooo.orderPrice}</td>
                    <td>${ooo.userId}</td>
                    <td>${ooo.aptId}</td>
                    <td>${ooo.stId}</td>
                    <%--<td>${ooo.gId}</td>--%>
                </tr>
            </c:forEach>
            <a href="${pageContext.request.contextPath}/find/findAllOrder?param=${currentPage-1}">上一页</a>
            <span>${currentPage}</span>
            <span>/</span>
            <span>${totalpage}</span>
            <a href="${pageContext.request.contextPath}/find/findAllOrder?param=${currentPage+1}">下一页</a>
        </table>



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