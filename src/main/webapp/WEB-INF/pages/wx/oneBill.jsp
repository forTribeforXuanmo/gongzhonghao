<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-7-19
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>详细单据</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/weui.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<div id="contain">
    <%--<div class="page__hd">--%>
    <%--<h1 class="page__title">个人单据列表</h1>--%>
    <%--<p class="page__desc">个人单据列表</p>--%>
    <%--</div>--%>
    <div class="page__bd">

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
                    <label class="weui-form-preview__label">性质</label>
                    <span class="weui-form-preview__value">${item.grainProperty}</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">车船号</label>
                    <span class="weui-form-preview__value">${item.shipId}</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">仓号</label>
                    <span class="weui-form-preview__value">${item.wId}</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">收购价格</label>
                    <span class="weui-form-preview__value">${item.buyPrice}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">检查员</label>
                    <span class="weui-form-preview__value">${item.checker}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">毛重</label>
                    <span class="weui-form-preview__value">${item.grossWeight}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">皮重</label>
                    <span class="weui-form-preview__value">${item.tare}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">总重</label>
                    <span class="weui-form-preview__value">${item.totalWeight}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">其他扣重</label>
                    <span class="weui-form-preview__value">${item.otherReduce}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">总扣重</label>
                    <span class="weui-form-preview__value">${item.totalReduce}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算重量</label>
                    <span class="weui-form-preview__value">${item.trueWeight}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算金额</label>
                    <span class="weui-form-preview__value">${item.sumMoney}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算方式</label>
                    <span class="weui-form-preview__value">${item.payType}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">银行</label>
                    <span class="weui-form-preview__value">${item.bankName}</span>
                </div>


                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">银行卡</label>
                    <span class="weui-form-preview__value">${item.bankId}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算员</label>
                    <span class="weui-form-preview__value">${item.payAuthor}</span>
                </div>


                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算状态</label>
                    <span class="weui-form-preview__value">${item.payStatus}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">结算时间</label>
                    <span class="weui-form-preview__value">${item.payDate}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">资金计划编号</label>
                    <span class="weui-form-preview__value">${item.payPlanId}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">称重完成时间</label>
                    <span class="weui-form-preview__value">${item.weightEndDate}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">收支指标1:出库，2:入库</label>
                    <span class="weui-form-preview__value">${item.inOrOut}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">货位号</label>
                    <span class="weui-form-preview__value">${item.positionNum}</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">是否驳车：1：驳车，2：不驳车</label>
                    <span class="weui-form-preview__value">${item.usedCar}</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">是否补录：1：补录，2：不是补录</label>
                    <span class="weui-form-preview__value">${item.addRecord}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">是否插入实时库存：1：未插入，2：已插入</label>
                    <span class="weui-form-preview__value">${item.isAdd}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">版本</label>
                    <span class="weui-form-preview__value">${item.version}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">凭证打印次数</label>
                    <span class="weui-form-preview__value">${item.printCount}</span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">称重人员</label>
                    <span class="weui-form-preview__value">${item.weightAuthor} </span>
                </div>

                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">报港时间</label>
                    <span class="weui-form-preview__value">${item.addDate} </span>
                </div>

            </div>
        </div>
    </div>
    <ul class="divider"></ul>
    <div class="text-center " style="margin-bottom: 15px">
        <div id="code"></div>

    </div>

</div>

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/jquery.qrcode.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        var id =${item.bId};
        if (id != null && id != '') {
            $("#code").qrcode({
                //  render: "table", //table方式
                width: 250, //宽度
                height: 250, //高度
                correctLevel: 1, //纠错等级
                //	src:rootPath+"/img/logo.png",
                imgWidth: 80,
                imgHeight: 80,
                text: '${item.bId}'
                //  text:"http://www.jszyiot.com" //任意内容

            });
        }
    });

</script>
</body>
</html>
