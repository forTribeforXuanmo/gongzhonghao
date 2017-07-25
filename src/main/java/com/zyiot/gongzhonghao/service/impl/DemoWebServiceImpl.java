package com.zyiot.gongzhonghao.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyiot.gongzhonghao.mapper.SysUserMapper;
import com.zyiot.gongzhonghao.model.SysUser;
import com.zyiot.gongzhonghao.service.DemoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2017-7-18.
 */
@WebService(endpointInterface = "com.zyiot.gongzhonghao.service.DemoWebService")
public class DemoWebServiceImpl implements DemoWebService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> queryUserList() {
        List<SysUser> sysUserList = sysUserMapper.selectByMap(null);
        return sysUserList;
    }

    @Override
    public SysUser queryUserById(String id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        return sysUser;
    }
}
