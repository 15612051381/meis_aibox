package com.hzzxkj.models;

import lombok.Data;

import java.util.Date;

@Data
public class MdDeviceStatus {
    private Integer dsId;

    private Integer dsOfficeId;

    private Integer dsDeviceId;

    private Byte dsOpen;

    private Byte dsRun;

    private String dsFault;

    private Byte dsStudy;

    private String dsPower;

    private String dsLi;

    private String dsDetail;

    private Date dsUpdateDt;

    private Date dsFaultupdateDt;

    private String dsDelflag;

    private String dsCreateby;

    private Date dsCreateDt;

    private String dsUpdateby;

    private Date dsUpdatedate;

    private String dsRemarks;

    private Integer dsReserveint;

    private String dsReservevarchar;

    private Byte dsOnline;

}