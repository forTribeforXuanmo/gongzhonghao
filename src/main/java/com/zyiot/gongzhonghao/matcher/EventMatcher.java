package com.zyiot.gongzhonghao.matcher;

import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;

public class EventMatcher implements WxMessageMatcher {

    public boolean match(WxXmlMessage message) {
        String event = message.getEvent();
        return true;

        // TODO Auto-generated method stub

    }

}
