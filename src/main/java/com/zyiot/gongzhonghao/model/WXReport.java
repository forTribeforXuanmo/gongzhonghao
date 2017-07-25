package com.zyiot.gongzhonghao.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 其实上是用户信息表
 */
@TableName("t_wx_report")
public class WXReport implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;
    /**
     * 昵称
     */
    private String userName;
    /**
     * wx的名字
     */
    private String wxName;

    /**
     * openid
     */
    private String wxOpenid;


    /**
     * 身份证号
     */
    private String IDcardNo;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 粮食物种
     */
    private int grainKind;
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 创建时间
     */
    private long cre_time;
    /**
     * 更新时间
     */
    private long upd_time;
    /**
     * 状态
     */
    private String stat;


    public long getCre_time() {
        return cre_time;
    }

    public void setCre_time(long cre_time) {
        this.cre_time = cre_time;
    }

    public long getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(long upd_time) {
        this.upd_time = upd_time;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIDcardNo() {
        return IDcardNo;
    }

    public void setIDcardNo(String iDcardNo) {
        IDcardNo = iDcardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGrainKind() {
        return grainKind;
    }

    public void setGrainKind(int grainKind) {
        this.grainKind = grainKind;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }


}
