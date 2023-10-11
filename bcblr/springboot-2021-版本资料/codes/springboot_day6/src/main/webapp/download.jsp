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

    <h1>测试文件下载</h1>

    <a href="${pageContext.request.contextPath}/file/download?fileName=HELP.md">HELP.md</a>
    <a href="${pageContext.request.contextPath}/file/download?fileName=readme.txt">readme.txt</a>
    <a href="${pageContext.request.contextPath}/file/download?fileName=项目介绍.md">项目介绍.md</a>

</body>
</html>