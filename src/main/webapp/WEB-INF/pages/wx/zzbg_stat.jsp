<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Created by IntelliJ IDEA.-->
<!--User: Administrator-->
<!--Date: 2017-7-13-->
<!--Time: 15:48-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">

    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <link href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css">
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/jquery/jquery-2.2.3.min.js"></script>
</head>

<body class="gray-bg">
<div class="col-sm-10 col-sm-offset-1 text-center   animated fadeInDown">

    <a>
        <c:if test="${stat}">
            <h1 class="check-ok"><i class="fa fa-check-circle fa-3x  " aria-hidden="true"></i></h1>
        </c:if>
        <c:if test="${!stat}">
            <h1 class="check-fail"><i class="fa fa-close fa-3x  " aria-hidden="true"></i></h1>
        </c:if>
    </a>
    <c:if test="${type eq 'insert'} ">
        <a><h2 class="btn btn-primary fa-4x">新增操作成功</h2></a>
    </c:if>
    <c:if test="${type eq 'update'}">
        <a><h2 class="btn btn-primary fa-4x">更新操作成功</h2></a>
    </c:if>
</div>


<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/plugins/layer/layer.min.js"></script>
</body>
</html>