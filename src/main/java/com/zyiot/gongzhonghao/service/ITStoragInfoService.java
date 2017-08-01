package com.zyiot.gongzhonghao.service;

import com.zyiot.gongzhonghao.model.TStoragInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 粮食库存
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-31
 */
public interface ITStoragInfoService extends IService<TStoragInfo> {
    /**
     * 条件查询实时库存
     *
     * @param source    站点
     * @param storageID 仓号
     * @param variety   品种
     * @param year      年度
     * @param quanZhong 粮食性质（权重）
     * @return
     */
    List<TStoragInfo> queryStoragInfoByCondition(String source, String storageID, String variety, String year, String quanZhong);
}
