package com.zyiot.gongzhonghao.controller;

import com.zyiot.gongzhonghao.model.TStoragInfo;
import com.zyiot.gongzhonghao.service.ITStoragInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017-7-31.
 */
@RestController
@RequestMapping("/storage")
public class StoragInfoController {
    @Autowired
    private ITStoragInfoService tStoragInfoService;

    public List<TStoragInfo> queryStoragInfoByCondition(String source, String storageID, String variety, String year, String quanZhong) {
        return null;
    }
}