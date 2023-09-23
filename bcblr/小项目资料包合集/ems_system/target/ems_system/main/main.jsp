<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
</head>
<body>

<div class="jumbotron">
    <div class="container-fluid">

        <div class="row">

            <div class="col-sm-12">
                <h1>Hello, world!</h1>
                <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
            </div>

            <div class="col-sm-12" style="margin-top: 40px;">
                <label>磁盘使用率:(75%)</label>
                <div class="progress">
                    <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 75%">
                        <span class="sr-only">75% Complete</span>
                    </div>
                </div>
                <div class="progress">
                    <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                        <span class="sr-only">45% Complete</span>
                    </div>
                </div>
                <div class="progress">
                    <div class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                        <span class="sr-only">45% Complete</span>
                    </div>
                </div>
                <div class="progress">
                    <div class="progress-bar progress-bar-warning progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                        <span class="sr-only">45% Complete</span>
                    </div>
                </div>
                <div class="progress">
                    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                        <span class="sr-only">45% Complete</span>
                    </div>
                </div>
            </div>

            <div class="col-sm-12">

                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/imgs/a.jpg" alt="...">
                            <div class="caption">
                                <h3>张三</h3>
                                <p>他是本月优秀员工</p>
                                <p>
                                    <a href="#" class="btn btn-danger" style="width: 100%" role="button">查看详细业绩</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/imgs/a.jpg" alt="...">
                            <div class="caption">
                                <h3>张三</h3>
                                <p>他是本月优秀员工</p>
                                <p>
                                    <a href="#" class="btn btn-danger" style="width: 100%" role="button">查看详细业绩</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/imgs/a.jpg" alt="...">
                            <div class="caption">
                                <h3>张三</h3>
                                <p>他是本月优秀员工</p>
                                <p>
                                    <a href="#" class="btn btn-danger" style="width: 100%" role="button">查看详细业绩</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>