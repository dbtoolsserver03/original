<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h2>this is Back Directory Hello World!</h2>

<h1>获取项目名: ${requestScope.name}  ${name}</h1>

<c:forEach items="${requestScope.users}" var="user">
    ${user.id} ==== ${user.name} ==== ${user.age}  ==== ${user.bir} <br>
</c:forEach>

this is xiaochen
</body>
</html>
