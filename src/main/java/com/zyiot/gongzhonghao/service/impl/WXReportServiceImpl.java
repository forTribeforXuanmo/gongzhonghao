package com.zyiot.gongzhonghao.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyiot.gongzhonghao.model.WXReport;
import com.zyiot.gongzhonghao.mapper.WXReportMapper;
import com.zyiot.gongzhonghao.service.WXReportServiceI;
import org.springframework.stereotype.Service;
@Service("wXReportService")
public class WXReportServiceImpl extends ServiceImpl<WXReportMapper, WXReport> implements WXReportServiceI {


}
