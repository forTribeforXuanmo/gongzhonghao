package com.zyiot.gongzhonghao.mapper;

import com.zyiot.gongzhonghao.model.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-18
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("slect  * from test")
    List selectAll();
}