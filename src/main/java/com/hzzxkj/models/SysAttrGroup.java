package com.hzzxkj.models;

import lombok.Data;

import java.util.Date;

@Data
public class SysAttrGroup {
    private Integer agId;

    private Integer agDeviceId;

    private Integer agHospitalId;

    private Integer agModelId;

    private String agGroupno;

    private String agGrouptitle;

    private Integer agFrequency;

    private Integer agSortby;

    private String agDelflag;

    private String agCreateby;

    private Date agCreateDt;

    private String agUpdateby;

    private Date agUpdateDt;

    private String agRemarks;

    private String agShowtype;

    //根据设备ID查询得到的分子下的通道组合：如1000,1001
    private String sysattrids;


}