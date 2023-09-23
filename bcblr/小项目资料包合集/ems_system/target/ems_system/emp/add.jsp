<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <h1 class="text-center"><small>员工添加</small></h1>
            </div>
        </div>
        <div class="row">
            <div  class="col-sm-8 col-sm-offset-2">
                <form action="${pageContext.request.contextPath}/emp/save" method="post">
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input type="text" class="form-control" name="name" id="name" >
                    </div>
                    <div class="form-group">
                        <label for="age">年龄</label>
                        <input type="text" class="form-control" name="age" id="age" >
                    </div>

                    <div class="form-group">
                        <label for="bir">生日</label>
                        <input type="text" class="form-control" name="bir" id="bir">
                    </div>
                    <div class="form-group">
                        <label>所属部门:</label>
                        <select class="form-control" name="deptid">
                            <%--遍历部门信息--%>
                            <c:forEach items="${requestScope.depts}" var="dept">
                                <option value="${dept.id}">${dept.name}-->(当前人员总数:${dept.numbers})</option>
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