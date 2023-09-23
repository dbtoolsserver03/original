<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head></head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/param/param7">
        UserName1<input type="text" name="users[0].name"/><br/>
        UserPassword1<input type="text" name="users[0].password"/><br/>
        UserAge1<input type="text" name="users[0].age"/><br/>
        <hr/>
        UserName2<input type="text" name="users[1].name"/><br/>
        UserPassword2<input type="text" name="users[1].password"/><br/>
        UserAge2<input type="text" name="users[1].age"/><br/>
        <input type="submit" value="submit">
    </form>
</body>
</html>