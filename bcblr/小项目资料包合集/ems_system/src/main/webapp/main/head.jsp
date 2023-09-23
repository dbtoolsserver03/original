<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>


<%--导航条  navbar-inverse --%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">员工管理系统
                <small>v1.2</small>
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                <li><a href="javascript:;">欢迎:
                    <span style="color: red;">
                        <c:if test="${sessionScope.user!=null}">${sessionScope.user.username}</c:if>
                        <c:if test="${sessionScope.user==null}">访客</c:if>
                    </span></a>
                </li>

                <c:if test="${sessionScope.user!=null}">
                    <li><a href="${pageContext.request.contextPath}/user/logout" target="_top">退出登录 </a></li>
                </c:if>

                <c:if test="${sessionScope.user==null}">
                    <li><a href="${pageContext.request.contextPath}/login.jsp" target="_top">点我登录</a></li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>

</body>