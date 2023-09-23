<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   <body>
      <form method="post" action="${pageContext.request.contextPath}/reg.action">
           UserName<input type="text" name="user.name"/><br/>
           Password<input type="password" name="user.password"/><br/>
           <input type="submit" value="reg">
      </form>
   </body>
</html>