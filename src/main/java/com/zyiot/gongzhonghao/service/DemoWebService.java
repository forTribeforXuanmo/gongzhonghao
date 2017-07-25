package com.zyiot.gongzhonghao.service;

import com.zyiot.gongzhonghao.model.SysUser;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Administrator on 2017-7-18.
 */
@WebService
public interface DemoWebService {
    List<SysUser> queryUserList();

    SysUser queryUserById(String id);
}
