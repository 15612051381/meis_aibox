package com.hzzxkj.models;

import java.io.Serializable;
import java.util.Date;

public class DeviceStatus implements Serializable {
    private String id;

    private String officeId;

    private String deviceId;

    private Integer deviceOpen;

    private Integer deviceRun;

    private Integer deviceFault;

    private Integer deviceStudy;

    private Integer devicePower;

    private Integer deviceLi;

    private String deviceDetail;

    private Date deviceUpdateTime;

    private Date deviceFaultUpdateTime;

    private String delFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private Integer reserveInt;

    private String reserveVarchar;

    private Integer deviceOnline;

    private Integer deviceAlertStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Integer getDeviceOpen() {
        return deviceOpen;
    }

    public void setDeviceOpen(Integer deviceOpen) {
        this.deviceOpen = deviceOpen;
    }

    public Integer getDeviceRun() {
        return deviceRun;
    }

    public void setDeviceRun(Integer deviceRun) {
        this.deviceRun = deviceRun;
    }

    public Integer getDeviceFault() {
        return deviceFault;
    }

    public void setDeviceFault(Integer deviceFault) {
        this.deviceFault = deviceFault;
    }

    public Integer getDeviceStudy() {
        return deviceStudy;
    }

    public void setDeviceStudy(Integer deviceStudy) {
        this.deviceStudy = deviceStudy;
    }

    public Integer getDevicePower() {
        return devicePower;
    }

    public void setDevicePower(Integer devicePower) {
        this.devicePower = devicePower;
    }

    public Integer getDeviceLi() {
        return deviceLi;
    }

    public void setDeviceLi(Integer deviceLi) {
        this.deviceLi = deviceLi;
    }

    public String getDeviceDetail() {
        return deviceDetail;
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail == null ? null : deviceDetail.trim();
    }

    public Date getDeviceUpdateTime() {
        return deviceUpdateTime;
    }

    public void setDeviceUpdateTime(Date deviceUpdateTime) {
        this.deviceUpdateTime = deviceUpdateTime;
    }

    public Date getDeviceFaultUpdateTime() {
        return deviceFaultUpdateTime;
    }

    public void setDeviceFaultUpdateTime(Date deviceFaultUpdateTime) {
        this.deviceFaultUpdateTime = deviceFaultUpdateTime;
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

    public Integer getDeviceOnline() {
        return deviceOnline;
    }

    public void setDeviceOnline(Integer deviceOnline) {
        this.deviceOnline = deviceOnline;
    }

    public Integer getDeviceAlertStatus() {
        return deviceAlertStatus;
    }

    public void setDeviceAlertStatus(Integer deviceAlertStatus) {
        this.deviceAlertStatus = deviceAlertStatus;
    }
}