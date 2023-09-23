<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head></head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/editor/editor2">
        UserName<input type="text" name="name" id="name"/><br/>
        Birthday<input type="text" name="birthday" id="birthday"/><br/>
        <input type="submit" value="reg">
    </form>
</body>
</html>