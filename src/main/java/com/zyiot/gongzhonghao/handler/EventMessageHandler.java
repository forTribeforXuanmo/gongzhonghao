package com.zyiot.gongzhonghao.handler;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.WxXmlOutNewsMessage.Item;
import com.soecode.wxtools.bean.outxmlbuilder.NewsBuilder;
import com.soecode.wxtools.exception.WxErrorException;
import com.zyiot.gongzhonghao.common.enums.SysEnums;
import com.zyiot.gongzhonghao.model.TPolicyQuery;
import com.zyiot.gongzhonghao.service.ITPolicyQueryService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class EventMessageHandler implements WxMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(EventMessageHandler.class);
    /**
     * 政策查询
     */
    @Autowired
    private ITPolicyQueryService tPolicyQueryService;

    public EventMessageHandler() {

    }

    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {
        String key = wxMessage.getEventKey();
        String event = wxMessage.getEvent();
        WxXmlOutMessage xmlOutMessage = null;
        if ("zzcx".equals(key) && WxConsts.EVT_CLICK.equals(event)) {
            /**        查询政策    **/
            List<TPolicyQuery> tPolicyQueryList = tPolicyQueryService.selectList(new EntityWrapper<TPolicyQuery>(new TPolicyQuery()));
            ImmutableList<TPolicyQuery> tPolicyQueries = ImmutableList.copyOf(tPolicyQueryList);
            NewsBuilder newsBuilder = WxXmlOutMessage.NEWS();
            for (TPolicyQuery policyQuery : tPolicyQueries) {
                Item item = new Item();
                item.setTitle(policyQuery.getPqTitle());
                item.setPicUrl("http://www.jszyiot.com/gongzhonghao/resources/img/" + policyQuery.getPicUrl());
                String a = Jsoup.parse(policyQuery.getPqContent()).text().trim();
                String substring = a.substring(0, 20 > a.length() ? a.length() : 20);
                if (Strings.isNullOrEmpty(substring)) {
                    substring = "there are no word";
                }
                item.setDescription(substring);
                item.setUrl(SysEnums.ZZCX_URL.getValue() + "/" + policyQuery.getId());
                xmlOutMessage = newsBuilder.addArticle(item).fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName()).build();
            }
        } else if (WxConsts.EVT_SUBSCRIBE.equals(event)) {
            String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            xmlOutMessage = WxXmlOutMessage.TEXT().content("欢迎订阅了该公众号！").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
            logger.info("用户<" + wxMessage.getFromUserName() + ">:订阅了一波    时间:" + time);
        } else if (WxConsts.EVT_UNSUBSCRIBE.equals(event)) {
            String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            logger.info("用户<" + wxMessage.getFromUserName() + ">:取消了订阅    时间:" + time);
        } else if (WxConsts.EVT_LOCATION.equals(event)) {
            String fromUserName = wxMessage.getFromUserName();
            double longtitude = wxMessage.getLongitude();
            Double latitude = wxMessage.getLatitude();
            Double precision = wxMessage.getPrecision();
            logger.info("用户<" + fromUserName + ">的地理位置=====》" + "经度：" + longtitude + " 纬度：" + latitude + " 精度：" + precision);
        }
        return xmlOutMessage;
    }
}
