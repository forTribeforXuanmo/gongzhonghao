<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>政策查询</title>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <!-- link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/example.css"/-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
    <style type="text/css">
        .toTop {
            position: fixed;
            right: 1px;
            bottom: 50px;
            display: none;

        }

    </style>
</head>

<body style="background-color:#F8F8F8">
<div class="container">
    <h2 class="col-md-12 text-center text-warning" id="topic" name="topic">${policy.pqTitle}</h2>
</div>
<section>
    ${policy.pqContent}
</section>
<div>
    <button class="toTop btn btn-default"><span class="glyphicon glyphicon-menu-up"></span></button>
</div>
<div class="weui-footer">
    <p class="weui-footer__links">
        <a href="javascript:void(0);" class="weui-footer__link">底部链接</a>
    </p>
    <p class="weui-footer__text">Copyright &copy; 2008-2016 zyiot.com</p>
</div>
<%--<div class="weui-footer weui-footer_fixed-bottom">--%>
<%--<p class="weui-footer__links">--%>
<%--<a href="javascript:home();" class="weui-footer__link ">WeUI首页</a>--%>
<%--</p>--%>
<%--<p class="weui-footer__text">Copyright &copy; 2008-2016 weui.io</p>--%>
<%--</div>--%>

<script type="text/javascript">
    $(function () {
        var wh = $(window).height();
        console.log(wh);
        $(window).scroll(function () {
            var s = wh - $(window).scrollTop();
            console.log(s);
            if (s < 100) {
                $('.toTop').css("display", "block");
            } else {
                $('.toTop').css("display", "none");
            }
        })
    })

    $('.toTop').click(function () {
        $('html,body').animate({scrollTop: '0px'}, 500);
    });
</script>
<script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

</body>
</html>