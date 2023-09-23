<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <h1 class="text-center">
                <small>员工修改</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form action="${pageContext.request.contextPath}/emp/update" method="post">
                <div class="form-group">
                    <label for="id">编号</label>
                    <input type="text" readonly class="form-control" value="${requestScope.emp.id}" id="id" name="id">
                </div>
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" value="${requestScope.emp.name}" name="name" id="name">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="text" class="form-control" value="${requestScope.emp.age}" name="age" id="age">
                </div>

                <div class="form-group">
                    <label for="bir">生日</label>
                    <input type="text" class="form-control" name="bir" value="<fmt:formatDate value='${emp.bir}'/>" id="bir">
                </div>
                <div class="form-group">
                    <label>所属部门:</label>
                    <select class="form-control" name="deptid">
                        <c:forEach items="${requestScope.depts}" var="dept">
                            <option
                                    <c:if test="${requestScope.emp.deptid == dept.id}">
                                      selected
                                    </c:if>
                                value="${dept.id}">${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>