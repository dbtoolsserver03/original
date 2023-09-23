<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <ul class="list-group" style="margin-top: 70px">

                <c:if test="${sessionScope.user.role=='admin'}">
                    <li class="list-group-item text-center" style="margin: 10px 0px;"><a href="${pageContext.request.contextPath}/dept/findAll" target="content">部门管理</a></li>
                    <li class="list-group-item text-center"><a href="${pageContext.request.contextPath}/emp/findAll" target="content">员工管理</a></li>
                </c:if>
                <c:if test="${sessionScope.user.role=='emp'}">
                    <li class="list-group-item text-center"><a href="${pageContext.request.contextPath}/emp/findAll" target="content">员工管理</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
</body>