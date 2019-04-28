<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/stu/findAll">显示全部学生</a></p>

<a href="javascript:;" class="temp1">测试单个JSON</a>
<a href="javascript:;" class="temp2">测试Json数组</a>
<a href="javascript:;" class="temp3">测试复杂Json数组</a>
<a href="${pageContext.request.contextPath}/stu/RequestParam">测试RequestParam</a>

</body>
<script type="text/javascript">


    $(".temp1").click(function () {
        var temp = JSON.stringify({stuId: "1200", stuName: "Bob", stuPwd: "123456", stuAddress: "Japan"});
        $.ajax({
            url: "${pageContext.request.contextPath}/stu/testJson.action",
            type: "post",
            dataType: 'json',
            contentType: "application/json",
            data: temp,
            cache: false,
            success: function (data) {
                console.log(data);
            }
        });
    });


    $(".temp2").click(function () {
        var temp = JSON.stringify([
            {stuId: "1200", stuName: "Bob", stuPwd: "123456", stuAddress: "Japan"},
            {stuId: "1566", stuName: "Saber", stuPwd: "123456", stuAddress: "Japan"}
        ]);
        $.ajax({
            url: "${pageContext.request.contextPath}/stu/testJsonArry.action",
            type: "post",
            dataType: 'json',
            contentType: "application/json",
            data: temp,
            cache: false,
            success: function (data) {
                console.log(data);
            }
        });
    });

    $(".temp3").click(function () {
        var temp = JSON.stringify({
            "name": "三班",
            "students": [
                {
                    "age": 25,
                    "gender": "female",
                    "grades": "三班",
                    "name": "露西",
                    "score": {
                        "网络协议": 98,
                        "JavaEE": 92,
                        "计算机基础": 93
                    },
                    "weight": 51.3
                },
                {
                    "age": 26,
                    "gender": "male",
                    "grades": "三班",
                    "name": "杰克",
                    "score": {
                        "网络安全": 75,
                        "Linux操作系统": 81,
                        "计算机基础": 92
                    },
                    "weight": 66.5
                },
                {
                    "age": 25,
                    "gender": "female",
                    "grades": "三班",
                    "name": "莉莉",
                    "score": {
                        "网络安全": 95,
                        "Linux操作系统": 98,
                        "SQL数据库": 88,
                        "数据结构": 89
                    },
                    "weight": 55
                }
            ]
        });

        $.ajax({
            url: "${pageContext.request.contextPath}/stu/testComplexJsonArry.action",
            type: "post",
            dataType: 'json',
            contentType: "application/json",
            data: temp,
            cache: false,
            success: function (data) {
            }
        });
    });

</script>


</html>
