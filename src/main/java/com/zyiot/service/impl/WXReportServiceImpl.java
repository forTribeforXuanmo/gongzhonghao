package com.zyiot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyiot.mapper.WXReportMapper;
import com.zyiot.model.WXReport;
import com.zyiot.service.WXReportServiceI;
import org.springframework.stereotype.Service;
@Service("wXReportService")
public class WXReportServiceImpl extends ServiceImpl<WXReportMapper, WXReport> implements WXReportServiceI {


}
