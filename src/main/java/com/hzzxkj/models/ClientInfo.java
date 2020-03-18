package com.hzzxkj.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ClientInfo implements Serializable {
    private String id;

    private String seq;

    private String mac;

    private String isOnline;

    private Date lastOnline;

    private String hospitalId;

    private String deviceId;

    private Date lastRtcSysdate;

    private Long lastRtcDate;

    private Long lastRtcDeviate;

    private Integer logRemainder;

    private Date lastUpdateLogDate;

    private String blVersion;

    private String swVersion;

    private String hwVersion;

    private Date setupDate;

    private Date useDate;

    private String clientType;

    private String isFault;

    private String isOpen;

    private String isWork;

    private String serverIp;

    private Integer serverPort;

    private String wifiSsid;

    private String wifiPassword;

    private String clientIp;

    private String apMac;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private BigDecimal a;

    private BigDecimal b;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline == null ? null : isOnline.trim();
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Date getLastRtcSysdate() {
        return lastRtcSysdate;
    }

    public void setLastRtcSysdate(Date lastRtcSysdate) {
        this.lastRtcSysdate = lastRtcSysdate;
    }

    public Long getLastRtcDate() {
        return lastRtcDate;
    }

    public void setLastRtcDate(Long lastRtcDate) {
        this.lastRtcDate = lastRtcDate;
    }

    public Long getLastRtcDeviate() {
        return lastRtcDeviate;
    }

    public void setLastRtcDeviate(Long lastRtcDeviate) {
        this.lastRtcDeviate = lastRtcDeviate;
    }

    public Integer getLogRemainder() {
        return logRemainder;
    }

    public void setLogRemainder(Integer logRemainder) {
        this.logRemainder = logRemainder;
    }

    public Date getLastUpdateLogDate() {
        return lastUpdateLogDate;
    }

    public void setLastUpdateLogDate(Date lastUpdateLogDate) {
        this.lastUpdateLogDate = lastUpdateLogDate;
    }

    public String getBlVersion() {
        return blVersion;
    }

    public void setBlVersion(String blVersion) {
        this.blVersion = blVersion == null ? null : blVersion.trim();
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion == null ? null : swVersion.trim();
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion == null ? null : hwVersion.trim();
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
    }

    public String getIsFault() {
        return isFault;
    }

    public void setIsFault(String isFault) {
        this.isFault = isFault == null ? null : isFault.trim();
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork == null ? null : isWork.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public String getWifiSsid() {
        return wifiSsid;
    }

    public void setWifiSsid(String wifiSsid) {
        this.wifiSsid = wifiSsid == null ? null : wifiSsid.trim();
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword == null ? null : wifiPassword.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getApMac() {
        return apMac;
    }

    public void setApMac(String apMac) {
        this.apMac = apMac == null ? null : apMac.trim();
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }
}