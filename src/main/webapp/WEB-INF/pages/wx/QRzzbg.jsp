<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>自助报港</title>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <!-- link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/example.css"/-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/jquery.qrcode.min.js"></script>
</head>

<body ontouchstart>
<div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>
<div class="container" id="container">
<div class="page">
    <div class="page__hd">
        <h1 class="page__title">预约报港</h1>
        <p class="page__desc">微信号:${wxReport.wxName}</p>
        <p class="page__desc">姓名:${wxReport.userName}</p>
        <p class="page__desc">身份证号:${wxReport.IDcardNo}</p>
        <p class="page__desc">手机号:${wxReport.phone}</p>
        <p class="page__desc">品种:${wxReport.grainKind=='111'?'小麦':'玉米'}</p>
        <p class="page__desc">预计数量:${wxReport.weight}</p>
       
    </div>
    <div id="code"></div> 
   
   
</div>
<script type="text/javascript">
    $(function(){
        var $tooltips = $('.js_tooltips');
        $('#showTooltips').on('click',function(){
        	$("#form").submit();
        	
        });
        $("#code").qrcode({ 
			  //  render: "table", //table方式 
			    width: 320, //宽度 
			    height:320, //高度 
			    correctLevel:1, //纠错等级
			   //	src:rootPath+"/img/logo.png",
			    imgWidth:80,
			    imgHeight:80,
            text: '${wxReport.id}'
			    //  text:"http://www.jszyiot.com" //任意内容
			  
			}); 
/*
        $('#showTooltips').on('click', function(){
            if ($tooltips.css('display') != 'none') return;

            // toptips的fixed, 如果有`animation`, `position: fixed`不生效
            $('.page.cell').removeClass('slideIn');

            $tooltips.css('display', 'block');
            setTimeout(function () {
                $tooltips.css('display', 'none');
            }, 2000);
        });
        */
    });
    
</script>
</div>

<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
	
</body>
</html>