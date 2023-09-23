<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html lang="en">
<head></head>
<body>
<%--
    <h1>this is request scope ${requestScope.name}</h1>
--%>
<%--
    <h1>this is model request scope ${requestScope.name}</h1>
--%>
    <h1>session attribute is ${sessionScope.name}</h1>
    <h1>request attribute is ${requestScope.age}</h1>
</body>
</html>