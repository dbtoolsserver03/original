<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%--标题--%>
        <div class="col-sm-12">
            <div class="page-header">
                <h1>
                    <small>员工信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="rows">
        <%--表格--%>
        <div class="col-sm-12">
            <table class="table table-hover table-bordered table-striped">
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>生日</th>
                    <th>所属部门</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.emps}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.age}</td>
                        <td><fmt:formatDate value="${emp.bir}"/></td>
                        <td>${emp.dept.name}</td>
                        <td>
                            <c:if test="${sessionScope.user.role=='admin'}">
                                <a href="${pageContext.request.contextPath}/emp/findOne?id=${emp.id}" class="btn btn-info btn-sm">修改</a>
                                <a href="${pageContext.request.contextPath}/emp/delete?id=${emp.id}" class="btn btn-danger btn-sm">删除</a>
                            </c:if>
                            <c:if test="${sessionScope.user.role!='admin'}">
                                <h4>暂无权限~</h4>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm-12">
            <c:if test="${sessionScope.user.role=='admin'}">
                <a href="${pageContext.request.contextPath}/dept/findAllForwardEmpAdd" class="btn btn-primary">员工添加</a>
            </c:if>
        </div>
    </div>
</div>
<div></div>
</body>
</html>