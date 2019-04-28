<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload_img</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.1.js" type="text/javascript"></script>

</head>
<body>
<form  id="myform" name="fileForm"  action="${pageContext.request.contextPath}/upload/up_img" method="post" enctype="multipart/form-data">
    <input type="file" name="image" id="tijiao" >
</form>
<input type="button" class="mybutton">



<img class="ddd" src="" alt="">
<p>${totalpath}</p>

</body>
<script type="text/javascript">

    $(".mybutton").click(function () {

        var options={
            type:"post",
            dataType:"json",
            url:"${pageContext.request.contextPath}/upload/up_img",
            success:function (data) {
                console.log(data.imgURL)
                $(".ddd").attr("src",data.imgURL);
            }
        };

        $("#myform").ajaxSubmit(options);
    })
    
    





</script>
</html>
