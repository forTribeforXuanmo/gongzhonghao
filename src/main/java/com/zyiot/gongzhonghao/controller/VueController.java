package com.zyiot.gongzhonghao.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyiot.gongzhonghao.common.enums.SysEnums;
import com.zyiot.gongzhonghao.model.SysUser;
import com.zyiot.gongzhonghao.model.TInfoRelease;
import com.zyiot.gongzhonghao.service.ITInfoReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2017-7-25.
 */
@CrossOrigin(origins = "*", maxAge = 60000)
@Controller
@RequestMapping(value = "/vue")
public class VueController {
    @Autowired
    private ITInfoReleaseService tInfoReleaseService;

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ResponseBody
    public SysUser test1(@RequestBody SysUser user) {
        System.out.println(user);
        SysUser sysUser = new SysUser();
        sysUser.setId("123456");
        sysUser.setName("vue lsz");
        sysUser.setAge(18);
        sysUser.setCtime(new Date());
        return sysUser;
    }

    @RequestMapping(value = "/testPage")
    @ResponseBody
    public Page getxxggList(@RequestParam("type") String type, @RequestParam("pageNo") int pageNo) {
        Page page = new Page(pageNo, 10);
        EntityWrapper<TInfoRelease> ew = new EntityWrapper<>();
        ew.where("irType={0}", SysEnums.find(type).getValue()).orderBy("irLevel", false);
        Page<TInfoRelease> returnPage = tInfoReleaseService.selectPage(page, ew);
        return returnPage;
    }
}
