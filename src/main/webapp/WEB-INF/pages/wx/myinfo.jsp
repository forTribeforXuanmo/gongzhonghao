<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>自助报港</title>

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/jquery.qrcode.min.js"></script>
</head>

<body ontouchstart>
<div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>
<div class="container" id="container">
    <div class="page">
        <div class="page__hd">
            <h1 class="title">预约报港</h1>
        </div>

        <div class="page__bd">
            <form id="form" method="post" action="${pageContext.servletContext.contextPath}/wx/save">
                <input type="hidden" name="wxOpenid" value="${wxReport.wxOpenid}"/>

                <div class="weui-cell">
                    <div class="weui-cell_hd">
                        <label class="weui-label">微信昵称:</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" name="wxName" value="${wxReport.wxName}" readonly/>
                    </div>
                </div>
                <c:if test="${wxReport.id==null || wxReport.id==''}">
                    <div class="page__desc text-center">请填写真实信息</div>
                </c:if>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">姓名</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" name="userName" value="${wxReport.userName}"
                               placeholder="请输入姓名"/>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">身份证</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="text" name="IDcardNo" value="${wxReport.IDcardNo}"
                               placeholder="请输入身份证"/>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd">
                        <label class="weui-label">手机号</label>
                    </div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="tel" name="phone" value="${wxReport.phone}"
                               placeholder="请输入手机号"/>
                    </div>
                </div>

                <%-- <div class="weui-cell weui-cell_select weui-cell_select-after">
                     <div class="weui-cell__hd">
                         <label for="" class="weui-label">品种</label>
                     </div>
                     <div class="weui-cell__bd">
                         <select class="weui-select" name="grainKind">
                             <option value="111">小麦</option>
                             <option value="112">玉米</option>
                         </select>
                     </div>
                 </div>

                 <div class="weui-cell">
                     <div class="weui-cell__hd"><label for="" class="weui-label">预计数量</label></div>
                     <div class="weui-cell__bd">
                         <input class="weui-input" type="number" name="weight" pattern="[0-9]*"
                                value="${wxReport.weight}" placeholder="请输入数量"/>
                     </div>
                     <div class="weui-cell__hd">
                         <label for="" class="weui-label">kg</label>
                     </div>
                 </div>--%>

                <!-- label for="weuiAgree" class="weui-agree">
                    <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox"/>
                    <span class="weui-agree__text">
                        阅读Atest同意<a href="javascript:void(0);">《相关条Atest》</a>
                    </span>
                </label-->
                <c:if test="${wxReport.id==null || wxReport.id==''}">
                <div class="weui-btn-area">
                    <a href="javascript:;" class="weui-btn weui-btn_primary" id="submityybg">提交</a>
                </div>
                </c:if>
                <c:if test="${wxReport.id!=null && wxReport.id!=''}">
                    <div class="weui-cell">
                        <div id="code"></div>
                    </div>
                </c:if>
            </form>
        </div>

    </div>
    <script type="text/javascript">
        $(function () {
            var id =${wxReport.id};
            var $tooltips = $('.js_tooltips');
            $('#submityybg').on('click', function () {
                $("#form").submit();
            });
            if (id != null && id != '') {
                $('input').attr("readonly", "readonly");
                $("#code").qrcode({
                    //  render: "table", //table方式
                    width: 320, //宽度
                    height: 320, //高度
                    correctLevel: 1, //纠错等级
                    //	src:rootPath+"/img/logo.png",
                    imgWidth: 80,
                    imgHeight: 80,
                    text: '${wxReport.id}'
                    //  text:"http://www.jszyiot.com" //任意内容

                });
            }
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

    </script>
</div>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/zepto.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

</body>
</html>