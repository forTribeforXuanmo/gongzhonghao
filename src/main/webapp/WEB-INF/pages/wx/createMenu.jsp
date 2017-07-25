<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>



</body>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.8.3.js"></script>
<script >

window.onload=function(){
    var yybg_myinfo_url = "http://www.jszyiot.com/gongzhonghao/wx/myinfo";
    var yybg_myHistoryBill_url = "http://www.jszyiot.com/gongzhonghao/wx/toMyHistoryBill";
    var xxgg_qyxx_url = "http://www.jszyiot.com/gongzhonghao/wx/toXxgg/qyxx";
    var xxgg_sggg_url = "http://www.jszyiot.com/gongzhonghao/wx/toXxgg/sggg";
    var xxgg_pmgg_url = "http://www.jszyiot.com/gongzhonghao/wx/toXxgg/pmgg";


    yybg_myinfo_url = oauth2buildurl(yybg_myinfo_url);
    yybg_myHistoryBill_url = oauth2buildurl(yybg_myHistoryBill_url);
	xxgg_qyxx_url =oauth2buildurl(xxgg_qyxx_url);
	xxgg_sggg_url =oauth2buildurl(xxgg_sggg_url);
	xxgg_pmgg_url =oauth2buildurl(xxgg_pmgg_url);
	var json={
			button:[
			        {
			        name:"预约报港",
					sub_button:[{
                        name: "我的信息",
						type:"view",
                        url: yybg_myinfo_url
					},{
						name:"个人单据",
						type:"view",
                        url: yybg_myHistoryBill_url
					}]
					},
					{
						name:"信息公告",
					sub_button:[{
						name:"企业信息",
						type:"view",
						url:xxgg_qyxx_url
					},{
						name:"收购公告",
						type:"view",
						url:xxgg_sggg_url
					},{
						name:"拍卖公告",
						type:"view",
						url:xxgg_pmgg_url
					}]
					},
					{
						"type":"click",
						"name":"政策查询",
                        "key": "zzcx"
                    }
					]
			}
	

	$.ajax({
		url:"${pageContext.servletContext.contextPath}/wx/menu",
		type:"post",
		async: false,//同步
		cache:false,
		data:JSON.stringify(json),
		contentType:"application/json",
		dataType:"text/json",
		success:function(data){
			console.debug(data);
		}
	});
}

function oauth2buildurl(url){
	oauth2url="";
	encodeone=encodeURIComponent(url);
	encodetwo=encodeURIComponent(encodeone);
	$.ajax({// 获得三方认证url
		url:"${pageContext.servletContext.contextPath}/wx/oAuth2/"+encodetwo+"/",
		type:"get",
		async: false,//同步
		cache:false,
		contentType:"application/json",
		dataType:"text",
		success:function(data){
			oauth2url=decodeURIComponent(data);
		}
	});
	return oauth2url;
}

</script>

</html>