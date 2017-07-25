<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-7-18
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>个人单据</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<div id="contain" style="margin: 0 5px">
    <div class="page__hd">
        <h1 class="page__title text-center">个人单据列表</h1>

    </div>
    <div class="page__bd">
        <%--   <c:forEach items="${list}" var="item">
               <div class="weui-form-preview">
                   <div class="weui-form-preview__hd">
                       <div class="weui-form-preview__item">
                           <label class="weui-form-preview__label">单据号</label>
                           <em class="weui-form-preview__value">${item.bId}</em>
                       </div>
                   </div>
                   <div class="weui-form-preview__bd">
                       <div class="weui-form-preview__item">
                           <label class="weui-form-preview__label">品种</label>
                           <span class="weui-form-preview__value">${item.grainVariety}</span>
                       </div>
                       <div class="weui-form-preview__item">
                           <label class="weui-form-preview__label">总重量</label>
                           <span class="weui-form-preview__value">${item.totalWeight}</span>
                       </div>
                       <div class="weui-form-preview__item">
                           <label class="weui-form-preview__label">状态</label>
                           <span class="weui-form-preview__value">${item.payStatus}</span>
                       </div>
                       <div class="weui-form-preview__item">
                           <label class="weui-form-preview__label">报港时间</label>
                           <span class="weui-form-preview__value">${item.addDate} </span>
                       </div>
                   </div>

                   <div class="weui-form-preview__ft ">
                       <a class="weui-form-preview__btn weui-form-preview__btn_default" href="javascript:void(0);"
                          onclick="showQrCode(${item.bId})">二维码</a>
                       <a class="weui-form-preview__btn weui-form-preview__btn_primary"
                          href="${pageContext.servletContext.contextPath}/wx/queryHistoryBillById/${item.id}">查看详情</a>
                   </div>
               </div>
           </c:forEach>--%>

    </div>

</div>

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/jquery.qrcode.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //全局变量
    var page = 1;//当前页
    var pages = 1;//总页数
    var ajax = false;//是否加载中
    var openId = '${openId}';//openid
    //已经来就加载第一页
    $(function () {

        $.ajax({
            url: '${pageContext.servletContext.contextPath}/wx/myHistoryBillPage',
            data: {pageNo: 1, openId: openId},
            dataType: 'json',
            success: function (data) {
                if (data == null || data.records.length == 0) {
                    $('.page__bd').append("不好意思，你没有报港记录");
                    return;
                }
                var records = data.records;
                pages = data.pages;
                page = data.current;
                for (var i = 0; i < records.length; i++) {
                    var div = '<div class="weui-form-preview"> <div class="weui-form-preview__hd"> <div class="weui-form-preview__item"> <label class="weui-form-preview__label">单据号</label> <em class="weui-form-preview__value">' + records[i].bId + '</em> </div> </div>' +
                        '<div class="weui-form-preview__bd"> <div class="weui-form-preview__item"> <label class="weui-form-preview__label">品种</label> <span class="weui-form-preview__value">' + records[i].grainVariety + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">总重量</label> <span class="weui-form-preview__value">' + records[i].totalWeight + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">状态</label> <span class="weui-form-preview__value">' + records[i].payStatus + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">报港时间</label> <span class="weui-form-preview__value">' + records[i].addDate + '</span> </div> </div>' +
                        '<div class="weui-form-preview__ft "> <a class="weui-form-preview__btn weui-form-preview__btn_default" href="javascript:void(0);" onclick="showQrCode(' + records[i].bId + ')" >二维码</a> <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="${pageContext.servletContext.contextPath}/wx/queryHistoryBillById/' + records[i].id + '">查看详情</a> </div> </div>';
                    $('.page__bd').append(div);
                }
            }
        })
    })
    //点击生成二维码
    function showQrCode(id) {
        var divstr = '<div id="dialog">' +
            '<div class="js_dialog" id="qrCodeDialog" style="opacity: 1; display: display;">' +
            '<div class="weui-mask"> </div>' +
            '<div class="weui-dialog"> <div class="weui-dialog__bd" id="qrCode"> </div>' +
            '<div class="weui-dialog__ft"> <Atest href="javascript:void(0);" class="weui-dialog__btn weui-dialog__btn_primary" onclick="removeQrCode();">确认</Atest>' +
            '</div> </div> </div> </div>';

        $('#contain').append(divstr);
        $("#qrCode").qrcode({
            //  render: "table", //table方式
            width: 250, //宽度
            height: 250, //高度
            correctLevel: 1, //纠错等级
            //	src:rootPath+"/img/logo.png",
            imgWidth: 80,
            imgHeight: 80,
            text: id + ''
            //  text:"http://www.jszyiot.com" //任意内容
        });
        $('#dialog').fadeIn(200);
    }
    //移除二维码
    function removeQrCode() {
        $('#dialog').remove();
    }


    //下滑动加载更多，需要 zepto.js支持
    Zepto(function ($) {
        $(window).scroll(function () {
            if (($(window).scrollTop() + $(window).height() > $(document).height() - 10) && !ajax && pages > page) {
                //滚动条拉到离底40像素内，而且没ajax中，而且没超过总页数
                //json_ajax(cla,++page);
                $(".page__bd").append('<div class="weui-form-preview text-center load"><img src="${pageContext.servletContext.contextPath}/resources/img/loading4.gif" style="width: 30px;height: 30px"/></div>');//出现加载图片
                loadMore();
            }
        });
    })
    function loadMore() {
        page++;//当前页增加1
        ajax = true;//注明开始ajax加载中
        $.ajax({
            url: '${pageContext.servletContext.contextPath}/wx/myHistoryBillPage',
            dataType: 'json',
            data: {pageNo: page, openId: openId},
            success: function (data) {
                var records = data.records;
                pages = data.pages;
                page = data.current;
                for (var i = 0; i < records.length; i++) {
                    var div = '<div class="weui-form-preview"> <div class="weui-form-preview__hd"> <div class="weui-form-preview__item"> <label class="weui-form-preview__label">单据号</label> <em class="weui-form-preview__value">' + records[i].bId + '</em> </div> </div>' +
                        '<div class="weui-form-preview__bd"> <div class="weui-form-preview__item"> <label class="weui-form-preview__label">品种</label> <span class="weui-form-preview__value">' + records[i].grainVariety + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">总重量</label> <span class="weui-form-preview__value">' + records[i].totalWeight + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">状态</label> <span class="weui-form-preview__value">' + records[i].payStatus + '</span> </div>' +
                        '<div class="weui-form-preview__item"> <label class="weui-form-preview__label">报港时间</label> <span class="weui-form-preview__value">' + records[i].addDate + '</span> </div> </div>' +
                        '<div class="weui-form-preview__ft "> <a class="weui-form-preview__btn weui-form-preview__btn_default" href="javascript:void(0);" onclick="showQrCode(' + records[i].bId + ')" >二维码</a> <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="${pageContext.servletContext.contextPath}/wx/queryHistoryBillById/' + records[i].id + '">查看详情</a> </div> </div>';
                    $('.page__bd').append(div);
                }

                $('.load').remove();
                ajax = false;//注明已经完成ajax加载
                if (page == pages) {
                    $(".page__bd").append('<div class=" text-center ">加载完了</div> ');//出现加载图片
                }
            },
            error: function (xhr, type) {
                $(".page__bd").html("暂无内容！");
            }
        });
    }
</script>
</body>
</html>
