<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head></head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/user/register">
        UserName<input type="text" name="name"/><br/>
        Password<input type="text" name="password"/><br/>
        <input type="submit" value="reg">
    </form>
</body>
</html>