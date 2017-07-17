package com.zyiot.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 政策查询
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-12
 */
@TableName("t_policy_query")
public class TPolicyQuery extends Model<TPolicyQuery> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 文章类型
     */
    private Integer pqType;
    /**
     * 文章标题
     */
    private String pqTitle;
    /**
     * 文章内容
     */
    private String pqContent;
    /**
     * 添加日期
     */
    private Date pqAddDate;
    /**
     * 显示顺序
     */
    private Integer pqLevel;
    /**
     * 数据操作员
     */
    private Integer pqDataOperator;

    private Integer version;

    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPqType() {
        return pqType;
    }

    public void setPqType(Integer pqType) {
        this.pqType = pqType;
    }

    public String getPqTitle() {
        return pqTitle;
    }

    public void setPqTitle(String pqTitle) {
        this.pqTitle = pqTitle;
    }

    public String getPqContent() {
        return pqContent;
    }

    public void setPqContent(String pqContent) {
        this.pqContent = pqContent;
    }

    public Date getPqAddDate() {
        return pqAddDate;
    }

    public void setPqAddDate(Date pqAddDate) {
        this.pqAddDate = pqAddDate;
    }

    public Integer getPqLevel() {
        return pqLevel;
    }

    public void setPqLevel(Integer pqLevel) {
        this.pqLevel = pqLevel;
    }

    public Integer getPqDataOperator() {
        return pqDataOperator;
    }

    public void setPqDataOperator(Integer pqDataOperator) {
        this.pqDataOperator = pqDataOperator;
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
        return "TPolicyQuery{" +
                "id=" + id +
                ", pqType=" + pqType +
                ", pqTitle=" + pqTitle +
                ", pqContent=" + pqContent +
                ", pqAddDate=" + pqAddDate +
                ", pqLevel=" + pqLevel +
                ", pqDataOperator=" + pqDataOperator +
                ", version=" + version +
                "}";
    }
}
