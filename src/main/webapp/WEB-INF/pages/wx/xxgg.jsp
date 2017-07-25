<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-7-24
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>${name}</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/example.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/coolfont.css">
    <style>
        .top_background {
            background: url("${pageContext.servletContext.contextPath}/resources/img/p1.jpg") repeat-x 3px 2px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="page list js_show">
        <div class="page__hd top_background">
            <h1 class='diff1'>${name}</h1>
        </div>
        <div class="page__bd page__bd_spacing">
            <div class="weui-cells">
            </div>
        </div>

    </div>
</div>

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var pageNo = 1;//当前页
    var pages = 1;//总页数
    var ajax = false;//是否加载中
    var type = '${type}';//openid

    //已经来就加载第一页
    $(function () {
        $.ajax({
            url: '${pageContext.servletContext.contextPath}/wx/getxxggPage',
            data: {pageNo: 1, type: type},
            dataType: 'json',
            success: function (data) {
                if (data == null || data.records.length == 0) {
                    $('.weui-cells').append("暂无数据");
                    return;
                }
                var records = data.records;
                pages = data.pages;
                pageNo = data.current;
                for (var i = 0; i < records.length; i++) {
                    var div = ' <a class="weui-cell weui-cell_access" href="${pageContext.servletContext.contextPath}/wx/getxxggById/' + records[i].id + '"> <div class="weui-cell__bd"> <p>' + records[i].irTitle + '</p></div>' +
                        '<div class="weui-cell__ft"> </div> </a>';
                    $('.weui-cells').append(div);
                }
            }
        })
    });

    //下滑动加载更多，需要 zepto.js支持
    Zepto(function ($) {
        $(window).scroll(function () {
            if (($(window).scrollTop() + $(window).height() > $(document).height() - 10) && !ajax && pages > pageNo) {
                //滚动条拉到离底40像素内，而且没ajax中，而且没超过总页数
                //json_ajax(cla,++page);
                $(".weui-cells").append('<div class="weui-form-preview text-center load"><img src="${pageContext.servletContext.contextPath}/resources/img/loading4.gif" style="width: 30px;height: 30px"/></div>');//出现加载图片
                loadMore();
            }
        });
    });

    function loadMore() {
        pageNo++;//当前页增加1
        ajax = true;//注明开始ajax加载中
        $.ajax({
            url: '${pageContext.servletContext.contextPath}/wx/myHistoryBillPage',
            dataType: 'json',
            data: {pageNo: pageNo, type: type},
            success: function (data) {
                var records = data.records;
                pages = data.pages;
                pageNo = data.current;
                for (var i = 0; i < records.length; i++) {
                    var div = ' <a class="weui-cell weui-cell_access" href="${pageContext.servletContext.contextPath}/wx/getxxggById/' + records[i].id + '"> <div class="weui-cell__bd"> <p>' + records[i].irTitle + '</p></div>' +
                        '<div class="weui-cell__ft"> </div> </a>';
                    $('.weui-cells').append(div);
                }
                $('.load').remove();
                ajax = false;//注明已经完成ajax加载
                if (pageNo == pages) {
                    $(".weui-cells").append('<div class=" text-center ">加载完毕</div> ');//出现加载图片
                }
            },
            error: function (xhr, type) {
                $(".weui-cells").html("暂无内容！");
            }
        });
    }

</script>
</body>
</html>
