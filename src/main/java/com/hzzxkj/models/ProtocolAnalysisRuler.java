package com.hzzxkj.models;

import java.io.Serializable;

public class ProtocolAnalysisRuler implements Serializable {
    

	private Long id;

	private String protocolType;

	private Integer protocolVersion;

	private Integer segmentid;

	private Integer segmentLength;

	private Integer segmentIndex;

	private Integer segmentType;

	private String segmentNameEn;

	private String segmentNameCh;

	private String sysAttrId;

	private String sysModelId;

	private String segmentBz;

	private Integer bz1;

	private String bz2;
	
	private String len_type;

	public String getLen_type() {
		return len_type;
	}

	public void setLen_type(String len_type) {
		this.len_type = len_type;
	}

	private static final long serialVersionUID = 1L;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType == null ? null : protocolType.trim();
	}

	public Integer getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(Integer protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public Integer getSegmentid() {
		return segmentid;
	}

	public void setSegmentid(Integer segmentid) {
		this.segmentid = segmentid;
	}

	public Integer getSegmentLength() {
		return segmentLength;
	}

	public void setSegmentLength(Integer segmentLength) {
		this.segmentLength = segmentLength;
	}

	public Integer getSegmentIndex() {
		return segmentIndex;
	}

	public void setSegmentIndex(Integer segmentIndex) {
		this.segmentIndex = segmentIndex;
	}

	public Integer getSegmentType() {
		return segmentType;
	}

	public void setSegmentType(Integer segmentType) {
		this.segmentType = segmentType;
	}

	public String getSegmentNameEn() {
		return segmentNameEn;
	}

	public void setSegmentNameEn(String segmentNameEn) {
		this.segmentNameEn = segmentNameEn == null ? null : segmentNameEn.trim();
	}

	public String getSegmentNameCh() {
		return segmentNameCh;
	}

	public void setSegmentNameCh(String segmentNameCh) {
		this.segmentNameCh = segmentNameCh == null ? null : segmentNameCh.trim();
	}

	public String getSysAttrId() {
		return sysAttrId;
	}

	public void setSysAttrId(String sysAttrId) {
		this.sysAttrId = sysAttrId == null ? null : sysAttrId.trim();
	}

	public String getSysModelId() {
		return sysModelId;
	}

	public void setSysModelId(String sysModelId) {
		this.sysModelId = sysModelId == null ? null : sysModelId.trim();
	}

	public String getSegmentBz() {
		return segmentBz;
	}

	public void setSegmentBz(String segmentBz) {
		this.segmentBz = segmentBz == null ? null : segmentBz.trim();
	}

	public Integer getBz1() {
		return bz1;
	}

	public void setBz1(Integer bz1) {
		this.bz1 = bz1;
	}

	public String getBz2() {
		return bz2;
	}

	public void setBz2(String bz2) {
		this.bz2 = bz2 == null ? null : bz2.trim();
	}

}