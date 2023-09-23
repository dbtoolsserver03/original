<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head></head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/editor/editor1">
        UserName<input type="text" name="name" id="name"/><br/>
        UserAge<input type="text" name="age" id="age"/><br/>
        <input type="submit" value="reg">
    </form>
</body>
</html>