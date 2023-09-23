<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<body>
<h1>部门列表</h1>

<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>成立时间</th>
        <th>当前人数</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.depts}" var="dept">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.name}</td>
            <td><fmt:formatDate value="${dept.uptime}" pattern="yyyy-MM-dd"/></td>
            <td>${dept.numbers}</td>
            <td>
                <a href="">删除</a>
                <a href="">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<form action="${pageContext.request.contextPath}/dept/save" method="post">
    部门名称: <input type="text" name="name"> <input type="submit" value="添加部门">
</form>
</body>