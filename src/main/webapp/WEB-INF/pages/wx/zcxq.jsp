<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>政策详情</title>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <!-- link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/example.css"/-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
</head>

<body >
  <div class="page article js_show">
        <div class="page__hd">
            <h1 class="page__title">Article</h1>
            <p class="page__desc">文章</p>
        </div>
        <div class="page__bd">
            <article class="weui-article">
                <h1>大标题</h1>
                <section>
                    <h2 class="title">章标题</h2>
                    <section>
                        <h3>1.1 节标题</h3>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                            consequat.
                        </p>
                    </section>
                    <img src="${pageContext.servletContext.contextPath}/resources/img/zc1.jpg" alt="">
                    <section>
                        <h3>1.2 节标题</h3>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                    </section>
                </section>
            </article>
        </div>
    </div>
  <script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
	
</body>
</html>