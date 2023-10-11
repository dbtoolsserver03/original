<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>springboot系列课程</title>
</head>
<body>
    
    <h1>测试文件上传</h1>

    <form action="${pageContext.request.contextPath}/file/uploadByJarDeploy" method="post" enctype="multipart/form-data">

        <input type="file" name="file">
        <input type="submit" value="上传文件">

    </form>

</body>
</html>