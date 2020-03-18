package com.hzzxkj.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysAttr implements Serializable {
    private String id;

    private String attrName;

    private String modelId;

    private Integer orderBy;

    private String delFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer reserveInt;

    private String reserveVarchar;

    private String attrAddr;

    private Integer attrLen;

    private String attrEnglish;

    private String attrUnit;

    private String isAlert;

    private String alertLevel;

    private String formatType;

    private String formatStyle;

    private String isRrt;

    private String convertType;

    private String isShow;

    private BigDecimal attrValueMax;

    private BigDecimal attrValueMin;

    private Integer alertTime;
    
    private String groupId;
    
	private String deviceId; 

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getReserveInt() {
        return reserveInt;
    }

    public void setReserveInt(Integer reserveInt) {
        this.reserveInt = reserveInt;
    }

    public String getReserveVarchar() {
        return reserveVarchar;
    }

    public void setReserveVarchar(String reserveVarchar) {
        this.reserveVarchar = reserveVarchar == null ? null : reserveVarchar.trim();
    }

    public String getAttrAddr() {
        return attrAddr;
    }

    public void setAttrAddr(String attrAddr) {
        this.attrAddr = attrAddr == null ? null : attrAddr.trim();
    }

    public Integer getAttrLen() {
        return attrLen;
    }

    public void setAttrLen(Integer attrLen) {
        this.attrLen = attrLen;
    }

    public String getAttrEnglish() {
        return attrEnglish;
    }

    public void setAttrEnglish(String attrEnglish) {
        this.attrEnglish = attrEnglish == null ? null : attrEnglish.trim();
    }

    public String getAttrUnit() {
        return attrUnit;
    }

    public void setAttrUnit(String attrUnit) {
        this.attrUnit = attrUnit == null ? null : attrUnit.trim();
    }

    public String getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(String isAlert) {
        this.isAlert = isAlert == null ? null : isAlert.trim();
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel == null ? null : alertLevel.trim();
    }

    public String getFormatType() {
        return formatType;
    }

    public void setFormatType(String formatType) {
        this.formatType = formatType == null ? null : formatType.trim();
    }

    public String getFormatStyle() {
        return formatStyle;
    }

    public void setFormatStyle(String formatStyle) {
        this.formatStyle = formatStyle == null ? null : formatStyle.trim();
    }

    public String getIsRrt() {
        return isRrt;
    }

    public void setIsRrt(String isRrt) {
        this.isRrt = isRrt == null ? null : isRrt.trim();
    }

    public String getConvertType() {
        return convertType;
    }

    public void setConvertType(String convertType) {
        this.convertType = convertType == null ? null : convertType.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public BigDecimal getAttrValueMax() {
        return attrValueMax;
    }

    public void setAttrValueMax(BigDecimal attrValueMax) {
        this.attrValueMax = attrValueMax;
    }

    public BigDecimal getAttrValueMin() {
        return attrValueMin;
    }

    public void setAttrValueMin(BigDecimal attrValueMin) {
        this.attrValueMin = attrValueMin;
    }

    public Integer getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Integer alertTime) {
        this.alertTime = alertTime;
    }
}