<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-7-24
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>${infoRelease.irTitle}</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<div class="page__hd">
    <h1 class="page__title text-center text-warning">${infoRelease.irTitle}</h1>
</div>
<div class="page__bd">
    <article class="weui-article">
        ${infoRelease.irContent}
        <section>
            <h3>发布时间：<span class="text-muted"><fmt:formatDate value="${infoRelease.irAddDate}"
                                                              type="both"></fmt:formatDate></span></h3>
        </section>
    </article>
</div>

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
