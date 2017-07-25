package com.zyiot.gongzhonghao.model;

import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 信息类型
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-24
 */
@TableName("t_info_type")
public class TInfoType extends Model<TInfoType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 类型名称
     */
    private String itName;
    /**
     * 所属父类
     */
    private Integer itParentId;
    /**
     * 添加日期
     */
    private Date itAddDate;
    /**
     * 数据操作员
     */
    private Integer itDataOperator;
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItName() {
        return itName;
    }

    public void setItName(String itName) {
        this.itName = itName;
    }

    public Integer getItParentId() {
        return itParentId;
    }

    public void setItParentId(Integer itParentId) {
        this.itParentId = itParentId;
    }

    public Date getItAddDate() {
        return itAddDate;
    }

    public void setItAddDate(Date itAddDate) {
        this.itAddDate = itAddDate;
    }

    public Integer getItDataOperator() {
        return itDataOperator;
    }

    public void setItDataOperator(Integer itDataOperator) {
        this.itDataOperator = itDataOperator;
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
        return "TInfoType{" +
                "id=" + id +
                ", itName=" + itName +
                ", itParentId=" + itParentId +
                ", itAddDate=" + itAddDate +
                ", itDataOperator=" + itDataOperator +
                ", version=" + version +
                "}";
    }
}
