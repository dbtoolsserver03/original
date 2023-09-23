<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head></head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/encoding/encoding1">
        UserName<input type="text" name="name" id="name"/><br/>
        Password<input type="text" name="password" id="password"/><br/>
        <input type="submit" value="login">
    </form>
</body>
</html>