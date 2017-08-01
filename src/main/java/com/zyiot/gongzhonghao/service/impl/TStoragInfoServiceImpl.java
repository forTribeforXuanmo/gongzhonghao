package com.zyiot.gongzhonghao.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyiot.gongzhonghao.mapper.TStoragInfoMapper;
import com.zyiot.gongzhonghao.model.TStoragInfo;
import com.zyiot.gongzhonghao.service.ITStoragInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-31
 */
@Service
public class TStoragInfoServiceImpl extends ServiceImpl<TStoragInfoMapper, TStoragInfo> implements ITStoragInfoService {

    @Override
    public List<TStoragInfo> queryStoragInfoByCondition(String source, String storageID, String variety, String year, String quanZhong) {
        List<TStoragInfo> resultList = new ArrayList<>();
        EntityWrapper ew = new EntityWrapper<TStoragInfo>();
        ew.where("1=1");
        if (!StringUtils.isEmpty(source)) {
            ew.and("source={0}", source);
        }
        if (!StringUtils.isEmpty(storageID)) {
            ew.and("storageID={0}", storageID);
        }
        if (!StringUtils.isEmpty(variety)) {
            ew.and("variety={0}", variety);
        }
        if (!StringUtils.isEmpty(year)) {
            ew.and("buyYear={0}", year);
        }
        if (!StringUtils.isEmpty(quanZhong)) {
            ew.and("quanZhong={0}", quanZhong);
        }
        ew.orderBy("buyYear", false);
        ew.toString();
        resultList = baseMapper.selectList(ew);
        return resultList;
    }

}
