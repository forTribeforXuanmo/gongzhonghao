package com.zyiot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyiot.mapper.TPolicyQueryMapper;
import com.zyiot.model.TPolicyQuery;
import com.zyiot.service.ITPolicyQueryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 政策查询 服务实现类
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-12
 */
@Service
public class TPolicyQueryServiceImpl extends ServiceImpl<TPolicyQueryMapper, TPolicyQuery> implements ITPolicyQueryService {

}
