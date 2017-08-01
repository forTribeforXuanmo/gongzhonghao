package com.zyiot.gongzhonghao.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-31
 */
@TableName("t_storag_info")
public class TStoragInfo extends Model<TStoragInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 粮食品种
     */
    private String name;
    private String code;
    /**
     * 粮权,性质
     */
    private String quanZhong;
    /**
     * 仓库货存量
     */
    private String cangKu;
    /**
     * 仓库号
     */
    private String storageID;
    /**
     * 信息来源 1:刘桥，站点
     */
    private String source;
    /**
     * 收获年度
     */
    private String buyYear;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuanZhong() {
        return quanZhong;
    }

    public void setQuanZhong(String quanZhong) {
        this.quanZhong = quanZhong;
    }

    public String getCangKu() {
        return cangKu;
    }

    public void setCangKu(String cangKu) {
        this.cangKu = cangKu;
    }

    public String getStorageID() {
        return storageID;
    }

    public void setStorageID(String storageID) {
        this.storageID = storageID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBuyYear() {
        return buyYear;
    }

    public void setBuyYear(String buyYear) {
        this.buyYear = buyYear;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TStoragInfo{" +
                "id=" + id +
                ", name=" + name +
                ", code=" + code +
                ", quanZhong=" + quanZhong +
                ", cangKu=" + cangKu +
                ", storageID=" + storageID +
                ", source=" + source +
                ", buyYear=" + buyYear +
                "}";
    }
}
