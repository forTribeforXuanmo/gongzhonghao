package com.zyiot.handler;

import com.google.common.base.Objects;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.result.WxMediaUploadResult;
import com.soecode.wxtools.exception.WxErrorException;

import java.io.File;
import java.util.Map;

public class UserMessageHandler  implements WxMessageHandler{

	public WxXmlOutMessage handle(WxXmlMessage wxMessage,
			Map<String, Object> context, IService iService)
			throws WxErrorException {
		WxXmlOutMessage xmlOutMessage = null;
		String content = wxMessage.getContent();
		if (Objects.equal(content, "1")) {
			xmlOutMessage = WxXmlOutMessage.TEXT().content("你猜对了").toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName())
					.build();

		} else if (Objects.equal(content, "2")) {
			//发送图片
			WxMediaUploadResult result = iService.uploadTempMedia(WxConsts.MEDIA_IMAGE, new File("C:\\Users\\Administrator\\Desktop\\zc3.jpg"));
			System.out.println(result.getMedia_id());
			xmlOutMessage = WxXmlOutMessage.IMAGE().mediaId(result.getMedia_id()).toUser(wxMessage.getFromUserName()).
					fromUser(wxMessage.getToUserName())
					.build();
		}
		return xmlOutMessage;
	}

}
