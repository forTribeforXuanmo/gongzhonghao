package com.zyiot.gongzhonghao.model;

import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 信息发布
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-24
 */
@TableName("t_info_release")
public class TInfoRelease extends Model<TInfoRelease> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 信息类型
     */
    private Integer irType;
    /**
     * 信息标题
     */
    private String irTitle;
    /**
     * 信息内容
     */
    private String irContent;
    /**
     * 添加日期
     */
    private Date irAddDate;
    /**
     * 显示顺序
     */
    private Integer irLevel;
    /**
     * 数据操作员
     */
    private Integer irDataOperator;
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIrType() {
        return irType;
    }

    public void setIrType(Integer irType) {
        this.irType = irType;
    }

    public String getIrTitle() {
        return irTitle;
    }

    public void setIrTitle(String irTitle) {
        this.irTitle = irTitle;
    }

    public String getIrContent() {
        return irContent;
    }

    public void setIrContent(String irContent) {
        this.irContent = irContent;
    }

    public Date getIrAddDate() {
        return irAddDate;
    }

    public void setIrAddDate(Date irAddDate) {
        this.irAddDate = irAddDate;
    }

    public Integer getIrLevel() {
        return irLevel;
    }

    public void setIrLevel(Integer irLevel) {
        this.irLevel = irLevel;
    }

    public Integer getIrDataOperator() {
        return irDataOperator;
    }

    public void setIrDataOperator(Integer irDataOperator) {
        this.irDataOperator = irDataOperator;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TInfoRelease{" +
                "id=" + id +
                ", irType=" + irType +
                ", irTitle=" + irTitle +
                ", irContent=" + irContent +
                ", irAddDate=" + irAddDate +
                ", irLevel=" + irLevel +
                ", irDataOperator=" + irDataOperator +
                ", version=" + version +
                "}";
    }
}
