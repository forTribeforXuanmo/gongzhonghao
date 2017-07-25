package com.zyiot.gongzhonghao.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;

public class TextMatcher implements WxMessageMatcher {

	public boolean match(WxXmlMessage message) {
		
		String content=message.getContent();
        if (content.matches("\\d{1}")) {
            return true;
        }
		
		return false;
	}

}
