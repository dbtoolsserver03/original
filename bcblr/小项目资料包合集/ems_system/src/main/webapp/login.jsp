<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.0.min.js"></script>
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center" style="margin-top: 170px;">用户登录</h1>

            <%--form--%>
            <form>
                <div class="form-group">
                    <label for="name">用户名:</label>
                    <input type="email" class="form-control" id="name" placeholder="请输入用户名...">
                </div>
                <div class="form-group">
                    <label for="pwd">密码:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="请输入密码...">
                </div>
                <div class="form-group">
                    <div>
                        <div style="float: left">
                            <label for="code">验证码:</label>
                            <input type="text" style="width:420px;height: 50px;" class="form-control" id="code" placeholder="请输入验证码...">
                        </div>
                        <div style="float: right;">
                            <img style="width:220px;height: 50px;margin-top: 25px;" onclick="changeImg(this)" src="${pageContext.request.contextPath}/user/getImage" alt="">
                        </div>
                    </div>
                </div>

                <button type="submit" style="margin-top: 15px;width: 100%;"  onclick="login()" class="btn btn-danger">点我登录</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function login() {


        // 获取用户名
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        var code = $("#code").val();

        //发送ajax请求
        $.get("${pageContext.request.contextPath}/user/login", "name=" + name + "&pwd=" + pwd + "&code=" + code, function (res) {
            console.log(res);
            if (res.status) {
                alert(res.msg);
                location.href = "${pageContext.request.contextPath}/index.jsp"
            } else {
                alert(res.msg);
            }
        });

    }

    //更换验证码
    function changeImg(img) {
        //给标签设置属性 key:代表设置属性名  value:代表属性值
        $(img).attr("src", "${pageContext.request.contextPath}/user/getImage?age=" + Math.random());
    }
</script>