<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<div class="layui-header">
    <div class="layui-logo"><a href="">layui 后台布局</a></div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img" alt="">
                贤心
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">安全退出</a></li>
    </ul>
</div>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a><i class="layui-icon layui-icon-username">&nbsp;&nbsp;</i>用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/users/page">查询用户</a></dd>
                    <dd><a href="${ctx}/users/page2">添加用户</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>仓库管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/warehouse/page">仓库查询</a></dd>
                    <dd><a href="${ctx}/warehouse/addware">仓库添加</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>员工管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/staff/page">查询员工</a></dd>
                    <dd><a href="${ctx}/staff/addstaff">添加员工</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>货物管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/good/page">查询货物</a></dd>
                    <dd><a href="${ctx}/good/addGood">添加货物</a></dd>
                </dl>
            </li>


            <li class="layui-nav-item">
                <a>收货人管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/accept/find">收货人查询</a></dd>
                    <dd><a href="${ctx}/add/addaccept.jsp">添加收货人</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>货单管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/orders/page">货单查询</a></dd>
                    <dd><a href="${ctx}/orders/addorders.jsp">货单添加</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>储存管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/store/page">储存管理</a></dd>
                    <dd><a href="${ctx}/add/addstore.jsp">储存录入</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a>配送管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/delivery/find">查询配送</a></dd>
                    <dd><a href="${ctx}/add/adddelivery.jsp">添加配送</a></dd>
                </dl>
            </li>


        </ul>
    </div>
</div>
</body>
</html>