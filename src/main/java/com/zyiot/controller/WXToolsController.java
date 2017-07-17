package com.zyiot.controller;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.soecode.wxtools.api.*;
import com.soecode.wxtools.bean.WxMenu;
import com.soecode.wxtools.bean.WxUserList.WxUser;
import com.soecode.wxtools.bean.WxUserList.WxUser.WxUserGet;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.bean.result.WxMenuResult;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import com.zyiot.common.enums.SysEnums;
import com.zyiot.handler.EventMessageHandler;
import com.zyiot.handler.UserMessageHandler;
import com.zyiot.matcher.EventMatcher;
import com.zyiot.matcher.TextMatcher;
import com.zyiot.model.TPolicyQuery;
import com.zyiot.model.WXReport;
import com.zyiot.service.ITPolicyQueryService;
import com.zyiot.service.WXReportServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("wx")
@Controller
public class WXToolsController {
    private static final Logger logger = LoggerFactory.getLogger(WXToolsController.class);
    private IService iService = new WxService();
    @Autowired
    private WXReportServiceI wXReportService;
    @Autowired
    private ITPolicyQueryService policyQueryService;
    @Autowired
    private EventMessageHandler eventMessageHandler;

    @RequestMapping(value = "token", method = RequestMethod.GET)
    @ResponseBody
    public String token(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(signature + " " + timestamp + "  " + nonce + "  " + echostr);
        if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            logger.info("成功获取微信服务器上的信息");
            return echostr;
        } else {
            logger.info("没有获取微信服务器上的信息");
            throw new RuntimeException("获取微信上信息失败");
        }

    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    @ResponseBody
    public String tokenPost(HttpServletRequest request, HttpServletResponse response) {
        String encrypt_type = request.getParameter("encrypt_type");
        //System.out.println(encrypt_type);
        try {
            WxMessageRouter router = new WxMessageRouter(iService);
            // 判断消息加解密方式，如果是加密模式。encrypt_type==aes
            if (encrypt_type != null && "aes".equals(encrypt_type)) {
                String timestamp = request.getParameter("timestamp");
                String nonce = request.getParameter("nonce");
                String msg_signature = request.getParameter("msg_signature");
                // 微信服务器推送过来的加密消息是XML格式。使用WxXmlMessage中的decryptMsg()解密得到明文。
                WxXmlMessage wx = WxXmlMessage.decryptMsg(request.getInputStream(), WxConfig.getInstance(), timestamp,
                        nonce, msg_signature);
                System.out.println("消息：\n " + wx.toString());
                // 添加规则；这里的规则是指所有消息都交给交给DemoHandler处理
                // 注意！！每一个规则，必须由end()或者next()结束。不然不会生效。
                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
                router.rule().msgType(WxConsts.MASS_MSG_TEXT).matcher(new TextMatcher()).handler(new UserMessageHandler()).end().rule().msgType(WxConsts.XML_MSG_EVENT).matcher(new EventMatcher()).handler(eventMessageHandler).end();
                // 把消息传递给路由器进行处理，得到最后一个handler处理的结果
                WxXmlOutMessage xmlOutMsg = router.route(wx);
                if (xmlOutMsg != null) {
                    // 将要返回的消息加密，返回
                    return WxXmlOutMessage.encryptMsg(WxConfig.getInstance(), xmlOutMsg.toXml(), timestamp, nonce);// 返回给用户。
                }

            }//如果是明文模式，执行以下语句
            else {
                // 微信服务器推送过来的是XML格式。
                WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
                System.out.println("消息：\n " + wx.toString());
                // 添加规则；这里的规则是指所有消息都交给DemoHandler处理
                // 注意！！每一个规则，必须由end()或者next()结束。不然不会生效。
                // end()是指消息进入该规则后不再进入其他规则。 而next()是指消息进入了一个规则后，如果满足其他规则也能进入，处理。
                //router.rule().matcher(new TextMatcher()).handler(new UserMessageHandler()).end().rule().matcher(new EventMatcher()).handler(new EventMessageHandler()).end();
                router.rule().msgType(WxConsts.MASS_MSG_TEXT).matcher(new TextMatcher()).handler(new UserMessageHandler()).end().rule().msgType("event").matcher(new EventMatcher()).handler(eventMessageHandler).end();
                // 把消息传递给路由器进行处理
                WxXmlOutMessage xmlOutMsg = router.route(wx);
                if (xmlOutMsg != null)
                    return xmlOutMsg.toXml();// 因为是明文，所以不用加密，直接返回给用户。
            }


        } catch (Exception e) {
            logger.error("无法获取用户发送来的信息", e);
            // TODO: handle exception
        }

        return "";
    }

    /**
     * @param menuid
     * @return
     */
    @RequestMapping(value = "menu/{menuid}", method = RequestMethod.GET)
    @ResponseBody
    public String findMenuById(@PathVariable("menuid") String menuid) {
        String ret = "";
        try {
            WxMenuResult result = iService.getMenu();
            ret = result.toString();
            System.out.println(result.toString());
        } catch (WxErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    @ResponseBody
    public String findAllMenu() {
        String ret = "";
        try {
            WxMenuResult result = iService.getMenu();
            ret = result.toString();
            System.out.println(result.toString());
        } catch (WxErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "menu", method = RequestMethod.DELETE)
    @ResponseBody
    public String delMenu() {
        String result = "";
        try {
            result = iService.deleteMenu();
        } catch (WxErrorException e) {
        }
        return result;
    }

    @RequestMapping(value = "menu", method = RequestMethod.POST)
    @ResponseBody
    public String createMenu(@RequestBody WxMenu menu) {
        try {
            iService.createMenu(menu, false);
        } catch (WxErrorException e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }


    //构造 三方认证url
    @RequestMapping(value = "oAuth2/{authorizationUrl}/", method = RequestMethod.GET)
    @ResponseBody
    public String oAuth2(@PathVariable("authorizationUrl") String authorizationUrl) {
        String urlString = "";
        //	System.out.println(URLDecoder.decode(authorizationUrl));
        try {
            urlString = iService.oauth2buildAuthorizationUrl(URLDecoder.decode(authorizationUrl), "snsapi_userinfo", "2");
        } catch (WxErrorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.err.println(urlString);
        return urlString;
    }

    @RequestMapping(value = "redirect/{type}")
    public String yybgRedirectURl(@PathVariable String type, String code, Map model) {
        try {
            WxOAuth2AccessTokenResult token = iService.oauth2ToGetAccessToken(code);
            WxUserGet userget = new WxUserGet(token.getOpenid(), "zh_CN");
            WxUser user = iService.oauth2ToGetUserInfo(token.getAccess_token(), userget);

            WXReport wxReport = new WXReport();
            wxReport.setWxOpenid(user.getOpenid());
            wxReport.setWxName(user.getNickname());

            Map query = new HashMap<String, Object>();
            query.put("wxOpenid", user.getOpenid());
            List<WXReport> list = wXReportService.selectByMap(query);
            if (list != null && list.size() == 1) {
                model.put("wxReport", list.get(0));
                return "wx/QR" + type;
            } else {
                model.put("wxReport", wxReport);
                return "wx/" + type;

            }
        } catch (WxErrorException e) {
            logger.error(type + "失败 ");
        }
        return "wx/" + type;
    }


    @RequestMapping(value = "page/{type}")
    public String redirect(@PathVariable String type) {
        return "wx/" + type;
    }

    /**
     * 政策查询
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "page/zccx/{id}")
    public String seePolicy(@PathVariable int id, Map map) {
        TPolicyQuery tPolicyQuery = policyQueryService.selectById(id);
        map.put("policy", tPolicyQuery);
        return "wx/zccx";
    }

    @RequestMapping(value = "createMenuUI")
    public String createMenuUI() {
        return "wx/createMenu";
    }

    /**
     * 自主报港
     *
     * @param wxReport
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(WXReport wxReport) throws InstantiationException, IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        if (wxReport.getId() == null) {
            String id = String.valueOf(IdWorker.getId());
            wxReport.setId(id);
            wxReport.setCre_time(System.currentTimeMillis());
            wxReport.setUpd_time(System.currentTimeMillis());
            wxReport.setStat(SysEnums.STAT_VALID.getCode());
            boolean flag = wXReportService.insert(wxReport);
            modelAndView.addObject("stat", flag);
            modelAndView.addObject("type", "insert");
            modelAndView.setViewName("wx/zzbg_stat");
            return modelAndView;
        } else {
            wxReport.setUpd_time(System.currentTimeMillis());
            boolean flag = wXReportService.updateById(wxReport);
            modelAndView.addObject("stat", flag);
            modelAndView.addObject("type", "update");
            modelAndView.setViewName("wx/zzbg_stat");
            return modelAndView;
        }
    }

    @RequestMapping("/test/{id}")
    public String test(@PathVariable int id) {
        int a = id + 100;
        return "test";
    }
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
