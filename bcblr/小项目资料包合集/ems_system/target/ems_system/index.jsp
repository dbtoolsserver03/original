<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>

</head>

<%--使用frameset布局--%>
<frameset rows="50px,*" noresize="noresize" border="2" bordercolor="black">
    <%--第一行--%>
    <frame src="${pageContext.request.contextPath}/main/head.jsp">
    <%--第二行 拆分为两个列--%>
    <frameset cols="13%,*">
        <frame src="${pageContext.request.contextPath}/main/menu.jsp">
        <%--中心页面--%>
        <frame name="content" src="${pageContext.request.contextPath}/main/main.jsp">
    </frameset>
</frameset>

</html>
