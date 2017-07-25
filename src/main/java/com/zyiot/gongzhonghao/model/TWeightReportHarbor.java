package com.zyiot.gongzhonghao.model;

import com.baomidou.mybatisplus.annotations.TableId;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 报港信息
 * </p>
 *
 * @author lishengzhu
 * @since 2017-07-18
 */
@TableName("t_weight_report_harbor")
public class TWeightReportHarbor extends Model<TWeightReportHarbor> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 单据号
     */
    private String bId;
    /**
     * 一卡通
     */
    private String cardId;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 身份证
     */
    private String IDCard;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 车船号
     */
    private String shipId;
    /**
     * 仓号
     */
    private Integer wId;
    /**
     * 粮食品种
     */
    private String grainVariety;
    /**
     * 粮食性质
     */
    private String grainProperty;
    /**
     * 收购价格
     */
    private Float buyPrice;
    /**
     * 检查员
     */
    private String checker;
    /**
     * 毛重
     */
    private BigDecimal grossWeight;
    /**
     * 皮重
     */
    private BigDecimal tare;
    /**
     * 总重
     */
    private BigDecimal totalWeight;
    /**
     * 其他扣重
     */
    private Float otherReduce;
    /**
     * 总扣重
     */
    private Float totalReduce;
    /**
     * 结算重量
     */
    private BigDecimal trueWeight;
    /**
     * 结算金额
     */
    private BigDecimal sumMoney;
    /**
     * 结算方式:转账，现金
     */
    private String payType;
    /**
     * 银行
     */
    private String bankName;
    /**
     * 银行卡
     */
    private String bankId;
    /**
     * 结算员
     */
    private String payAuthor;
    /**
     * 结算状态:待结算，结算完成
     */
    private String payStatus;
    /**
     * 结算时间
     */
    private String payDate;
    /**
     * 资金计划编号
     */
    private String payPlanId;
    /**
     * 报港时间
     */
    private String addDate;
    /**
     * 称重完成时间
     */
    private String weightEndDate;
    /**
     * 收支指标：1:出库，2:入库
     */
    private String inOrOut;
    /**
     * 货位号
     */
    private String positionNum;
    /**
     * 是否驳车：1：驳车，2：不驳车
     */
    private String usedCar;
    /**
     * 是否补录：1：补录，2：不是补录
     */
    private String addRecord;
    /**
     * 是否插入实时库存：1：未插入，2：已插入
     */
    private String isAdd;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 凭证打印次数
     */
    private Integer printCount;
    /**
     * 称重人员
     */
    private String weightAuthor;
    /**
     * 微信报港id
     */
    private String wxId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getGrainVariety() {
        return grainVariety;
    }

    public void setGrainVariety(String grainVariety) {
        this.grainVariety = grainVariety;
    }

    public String getGrainProperty() {
        return grainProperty;
    }

    public void setGrainProperty(String grainProperty) {
        this.grainProperty = grainProperty;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getTare() {
        return tare;
    }

    public void setTare(BigDecimal tare) {
        this.tare = tare;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Float getOtherReduce() {
        return otherReduce;
    }

    public void setOtherReduce(Float otherReduce) {
        this.otherReduce = otherReduce;
    }

    public Float getTotalReduce() {
        return totalReduce;
    }

    public void setTotalReduce(Float totalReduce) {
        this.totalReduce = totalReduce;
    }

    public BigDecimal getTrueWeight() {
        return trueWeight;
    }

    public void setTrueWeight(BigDecimal trueWeight) {
        this.trueWeight = trueWeight;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getPayAuthor() {
        return payAuthor;
    }

    public void setPayAuthor(String payAuthor) {
        this.payAuthor = payAuthor;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayPlanId() {
        return payPlanId;
    }

    public void setPayPlanId(String payPlanId) {
        this.payPlanId = payPlanId;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getWeightEndDate() {
        return weightEndDate;
    }

    public void setWeightEndDate(String weightEndDate) {
        this.weightEndDate = weightEndDate;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(String positionNum) {
        this.positionNum = positionNum;
    }

    public String getUsedCar() {
        return usedCar;
    }

    public void setUsedCar(String usedCar) {
        this.usedCar = usedCar;
    }

    public String getAddRecord() {
        return addRecord;
    }

    public void setAddRecord(String addRecord) {
        this.addRecord = addRecord;
    }

    public String getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(String isAdd) {
        this.isAdd = isAdd;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public String getWeightAuthor() {
        return weightAuthor;
    }

    public void setWeightAuthor(String weightAuthor) {
        this.weightAuthor = weightAuthor;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TWeightReportHarbor{" +
                "id=" + id +
                ", bId=" + bId +
                ", cardId=" + cardId +
                ", userName=" + userName +
                ", IDCard=" + IDCard +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", shipId=" + shipId +
                ", wId=" + wId +
                ", grainVariety=" + grainVariety +
                ", grainProperty=" + grainProperty +
                ", buyPrice=" + buyPrice +
                ", checker=" + checker +
                ", grossWeight=" + grossWeight +
                ", tare=" + tare +
                ", totalWeight=" + totalWeight +
                ", otherReduce=" + otherReduce +
                ", totalReduce=" + totalReduce +
                ", trueWeight=" + trueWeight +
                ", sumMoney=" + sumMoney +
                ", payType=" + payType +
                ", bankName=" + bankName +
                ", bankId=" + bankId +
                ", payAuthor=" + payAuthor +
                ", payStatus=" + payStatus +
                ", payDate=" + payDate +
                ", payPlanId=" + payPlanId +
                ", addDate=" + addDate +
                ", weightEndDate=" + weightEndDate +
                ", inOrOut=" + inOrOut +
                ", positionNum=" + positionNum +
                ", usedCar=" + usedCar +
                ", addRecord=" + addRecord +
                ", isAdd=" + isAdd +
                ", version=" + version +
                ", printCount=" + printCount +
                ", weightAuthor=" + weightAuthor +
                ", wxId=" + wxId +
                "}";
    }
}
