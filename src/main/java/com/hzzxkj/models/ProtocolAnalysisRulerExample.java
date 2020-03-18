package com.hzzxkj.models;

import java.util.ArrayList;
import java.util.List;

public class ProtocolAnalysisRulerExample {
   

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ProtocolAnalysisRulerExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIsNull() {
			addCriterion("protocol_type is null");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIsNotNull() {
			addCriterion("protocol_type is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeEqualTo(String value) {
			addCriterion("protocol_type =", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotEqualTo(String value) {
			addCriterion("protocol_type <>", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeGreaterThan(String value) {
			addCriterion("protocol_type >", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeGreaterThanOrEqualTo(String value) {
			addCriterion("protocol_type >=", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLessThan(String value) {
			addCriterion("protocol_type <", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLessThanOrEqualTo(String value) {
			addCriterion("protocol_type <=", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLike(String value) {
			addCriterion("protocol_type like", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotLike(String value) {
			addCriterion("protocol_type not like", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIn(List<String> values) {
			addCriterion("protocol_type in", values, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotIn(List<String> values) {
			addCriterion("protocol_type not in", values, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeBetween(String value1, String value2) {
			addCriterion("protocol_type between", value1, value2, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotBetween(String value1, String value2) {
			addCriterion("protocol_type not between", value1, value2, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionIsNull() {
			addCriterion("protocol_version is null");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionIsNotNull() {
			addCriterion("protocol_version is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionEqualTo(Integer value) {
			addCriterion("protocol_version =", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionNotEqualTo(Integer value) {
			addCriterion("protocol_version <>", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionGreaterThan(Integer value) {
			addCriterion("protocol_version >", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("protocol_version >=", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionLessThan(Integer value) {
			addCriterion("protocol_version <", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionLessThanOrEqualTo(Integer value) {
			addCriterion("protocol_version <=", value, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionIn(List<Integer> values) {
			addCriterion("protocol_version in", values, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionNotIn(List<Integer> values) {
			addCriterion("protocol_version not in", values, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionBetween(Integer value1, Integer value2) {
			addCriterion("protocol_version between", value1, value2, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andProtocolVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("protocol_version not between", value1, value2, "protocolVersion");
			return (Criteria) this;
		}

		public Criteria andSegmentidIsNull() {
			addCriterion("segmentId is null");
			return (Criteria) this;
		}

		public Criteria andSegmentidIsNotNull() {
			addCriterion("segmentId is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentidEqualTo(Integer value) {
			addCriterion("segmentId =", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidNotEqualTo(Integer value) {
			addCriterion("segmentId <>", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidGreaterThan(Integer value) {
			addCriterion("segmentId >", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("segmentId >=", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidLessThan(Integer value) {
			addCriterion("segmentId <", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidLessThanOrEqualTo(Integer value) {
			addCriterion("segmentId <=", value, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidIn(List<Integer> values) {
			addCriterion("segmentId in", values, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidNotIn(List<Integer> values) {
			addCriterion("segmentId not in", values, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidBetween(Integer value1, Integer value2) {
			addCriterion("segmentId between", value1, value2, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentidNotBetween(Integer value1, Integer value2) {
			addCriterion("segmentId not between", value1, value2, "segmentid");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthIsNull() {
			addCriterion("segment_length is null");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthIsNotNull() {
			addCriterion("segment_length is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthEqualTo(Integer value) {
			addCriterion("segment_length =", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthNotEqualTo(Integer value) {
			addCriterion("segment_length <>", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthGreaterThan(Integer value) {
			addCriterion("segment_length >", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthGreaterThanOrEqualTo(Integer value) {
			addCriterion("segment_length >=", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthLessThan(Integer value) {
			addCriterion("segment_length <", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthLessThanOrEqualTo(Integer value) {
			addCriterion("segment_length <=", value, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthIn(List<Integer> values) {
			addCriterion("segment_length in", values, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthNotIn(List<Integer> values) {
			addCriterion("segment_length not in", values, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthBetween(Integer value1, Integer value2) {
			addCriterion("segment_length between", value1, value2, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentLengthNotBetween(Integer value1, Integer value2) {
			addCriterion("segment_length not between", value1, value2, "segmentLength");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexIsNull() {
			addCriterion("segment_index is null");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexIsNotNull() {
			addCriterion("segment_index is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexEqualTo(Integer value) {
			addCriterion("segment_index =", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexNotEqualTo(Integer value) {
			addCriterion("segment_index <>", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexGreaterThan(Integer value) {
			addCriterion("segment_index >", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexGreaterThanOrEqualTo(Integer value) {
			addCriterion("segment_index >=", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexLessThan(Integer value) {
			addCriterion("segment_index <", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexLessThanOrEqualTo(Integer value) {
			addCriterion("segment_index <=", value, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexIn(List<Integer> values) {
			addCriterion("segment_index in", values, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexNotIn(List<Integer> values) {
			addCriterion("segment_index not in", values, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexBetween(Integer value1, Integer value2) {
			addCriterion("segment_index between", value1, value2, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentIndexNotBetween(Integer value1, Integer value2) {
			addCriterion("segment_index not between", value1, value2, "segmentIndex");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeIsNull() {
			addCriterion("segment_type is null");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeIsNotNull() {
			addCriterion("segment_type is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeEqualTo(Integer value) {
			addCriterion("segment_type =", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeNotEqualTo(Integer value) {
			addCriterion("segment_type <>", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeGreaterThan(Integer value) {
			addCriterion("segment_type >", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("segment_type >=", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeLessThan(Integer value) {
			addCriterion("segment_type <", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeLessThanOrEqualTo(Integer value) {
			addCriterion("segment_type <=", value, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeIn(List<Integer> values) {
			addCriterion("segment_type in", values, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeNotIn(List<Integer> values) {
			addCriterion("segment_type not in", values, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeBetween(Integer value1, Integer value2) {
			addCriterion("segment_type between", value1, value2, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("segment_type not between", value1, value2, "segmentType");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnIsNull() {
			addCriterion("segment_name_en is null");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnIsNotNull() {
			addCriterion("segment_name_en is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnEqualTo(String value) {
			addCriterion("segment_name_en =", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnNotEqualTo(String value) {
			addCriterion("segment_name_en <>", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnGreaterThan(String value) {
			addCriterion("segment_name_en >", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnGreaterThanOrEqualTo(String value) {
			addCriterion("segment_name_en >=", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnLessThan(String value) {
			addCriterion("segment_name_en <", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnLessThanOrEqualTo(String value) {
			addCriterion("segment_name_en <=", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnLike(String value) {
			addCriterion("segment_name_en like", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnNotLike(String value) {
			addCriterion("segment_name_en not like", value, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnIn(List<String> values) {
			addCriterion("segment_name_en in", values, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnNotIn(List<String> values) {
			addCriterion("segment_name_en not in", values, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnBetween(String value1, String value2) {
			addCriterion("segment_name_en between", value1, value2, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameEnNotBetween(String value1, String value2) {
			addCriterion("segment_name_en not between", value1, value2, "segmentNameEn");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChIsNull() {
			addCriterion("segment_name_ch is null");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChIsNotNull() {
			addCriterion("segment_name_ch is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChEqualTo(String value) {
			addCriterion("segment_name_ch =", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChNotEqualTo(String value) {
			addCriterion("segment_name_ch <>", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChGreaterThan(String value) {
			addCriterion("segment_name_ch >", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChGreaterThanOrEqualTo(String value) {
			addCriterion("segment_name_ch >=", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChLessThan(String value) {
			addCriterion("segment_name_ch <", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChLessThanOrEqualTo(String value) {
			addCriterion("segment_name_ch <=", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChLike(String value) {
			addCriterion("segment_name_ch like", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChNotLike(String value) {
			addCriterion("segment_name_ch not like", value, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChIn(List<String> values) {
			addCriterion("segment_name_ch in", values, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChNotIn(List<String> values) {
			addCriterion("segment_name_ch not in", values, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChBetween(String value1, String value2) {
			addCriterion("segment_name_ch between", value1, value2, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSegmentNameChNotBetween(String value1, String value2) {
			addCriterion("segment_name_ch not between", value1, value2, "segmentNameCh");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdIsNull() {
			addCriterion("sys_attr_id is null");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdIsNotNull() {
			addCriterion("sys_attr_id is not null");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdEqualTo(String value) {
			addCriterion("sys_attr_id =", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdNotEqualTo(String value) {
			addCriterion("sys_attr_id <>", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdGreaterThan(String value) {
			addCriterion("sys_attr_id >", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdGreaterThanOrEqualTo(String value) {
			addCriterion("sys_attr_id >=", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdLessThan(String value) {
			addCriterion("sys_attr_id <", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdLessThanOrEqualTo(String value) {
			addCriterion("sys_attr_id <=", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdLike(String value) {
			addCriterion("sys_attr_id like", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdNotLike(String value) {
			addCriterion("sys_attr_id not like", value, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdIn(List<String> values) {
			addCriterion("sys_attr_id in", values, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdNotIn(List<String> values) {
			addCriterion("sys_attr_id not in", values, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdBetween(String value1, String value2) {
			addCriterion("sys_attr_id between", value1, value2, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysAttrIdNotBetween(String value1, String value2) {
			addCriterion("sys_attr_id not between", value1, value2, "sysAttrId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdIsNull() {
			addCriterion("sys_model_id is null");
			return (Criteria) this;
		}

		public Criteria andSysModelIdIsNotNull() {
			addCriterion("sys_model_id is not null");
			return (Criteria) this;
		}

		public Criteria andSysModelIdEqualTo(String value) {
			addCriterion("sys_model_id =", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdNotEqualTo(String value) {
			addCriterion("sys_model_id <>", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdGreaterThan(String value) {
			addCriterion("sys_model_id >", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdGreaterThanOrEqualTo(String value) {
			addCriterion("sys_model_id >=", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdLessThan(String value) {
			addCriterion("sys_model_id <", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdLessThanOrEqualTo(String value) {
			addCriterion("sys_model_id <=", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdLike(String value) {
			addCriterion("sys_model_id like", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdNotLike(String value) {
			addCriterion("sys_model_id not like", value, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdIn(List<String> values) {
			addCriterion("sys_model_id in", values, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdNotIn(List<String> values) {
			addCriterion("sys_model_id not in", values, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdBetween(String value1, String value2) {
			addCriterion("sys_model_id between", value1, value2, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSysModelIdNotBetween(String value1, String value2) {
			addCriterion("sys_model_id not between", value1, value2, "sysModelId");
			return (Criteria) this;
		}

		public Criteria andSegmentBzIsNull() {
			addCriterion("segment_bz is null");
			return (Criteria) this;
		}

		public Criteria andSegmentBzIsNotNull() {
			addCriterion("segment_bz is not null");
			return (Criteria) this;
		}

		public Criteria andSegmentBzEqualTo(String value) {
			addCriterion("segment_bz =", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzNotEqualTo(String value) {
			addCriterion("segment_bz <>", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzGreaterThan(String value) {
			addCriterion("segment_bz >", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzGreaterThanOrEqualTo(String value) {
			addCriterion("segment_bz >=", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzLessThan(String value) {
			addCriterion("segment_bz <", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzLessThanOrEqualTo(String value) {
			addCriterion("segment_bz <=", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzLike(String value) {
			addCriterion("segment_bz like", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzNotLike(String value) {
			addCriterion("segment_bz not like", value, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzIn(List<String> values) {
			addCriterion("segment_bz in", values, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzNotIn(List<String> values) {
			addCriterion("segment_bz not in", values, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzBetween(String value1, String value2) {
			addCriterion("segment_bz between", value1, value2, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andSegmentBzNotBetween(String value1, String value2) {
			addCriterion("segment_bz not between", value1, value2, "segmentBz");
			return (Criteria) this;
		}

		public Criteria andBz1IsNull() {
			addCriterion("bz1 is null");
			return (Criteria) this;
		}

		public Criteria andBz1IsNotNull() {
			addCriterion("bz1 is not null");
			return (Criteria) this;
		}

		public Criteria andBz1EqualTo(Integer value) {
			addCriterion("bz1 =", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1NotEqualTo(Integer value) {
			addCriterion("bz1 <>", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1GreaterThan(Integer value) {
			addCriterion("bz1 >", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1GreaterThanOrEqualTo(Integer value) {
			addCriterion("bz1 >=", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1LessThan(Integer value) {
			addCriterion("bz1 <", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1LessThanOrEqualTo(Integer value) {
			addCriterion("bz1 <=", value, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1In(List<Integer> values) {
			addCriterion("bz1 in", values, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1NotIn(List<Integer> values) {
			addCriterion("bz1 not in", values, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1Between(Integer value1, Integer value2) {
			addCriterion("bz1 between", value1, value2, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz1NotBetween(Integer value1, Integer value2) {
			addCriterion("bz1 not between", value1, value2, "bz1");
			return (Criteria) this;
		}

		public Criteria andBz2IsNull() {
			addCriterion("bz2 is null");
			return (Criteria) this;
		}

		public Criteria andBz2IsNotNull() {
			addCriterion("bz2 is not null");
			return (Criteria) this;
		}

		public Criteria andBz2EqualTo(String value) {
			addCriterion("bz2 =", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2NotEqualTo(String value) {
			addCriterion("bz2 <>", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2GreaterThan(String value) {
			addCriterion("bz2 >", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2GreaterThanOrEqualTo(String value) {
			addCriterion("bz2 >=", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2LessThan(String value) {
			addCriterion("bz2 <", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2LessThanOrEqualTo(String value) {
			addCriterion("bz2 <=", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2Like(String value) {
			addCriterion("bz2 like", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2NotLike(String value) {
			addCriterion("bz2 not like", value, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2In(List<String> values) {
			addCriterion("bz2 in", values, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2NotIn(List<String> values) {
			addCriterion("bz2 not in", values, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2Between(String value1, String value2) {
			addCriterion("bz2 between", value1, value2, "bz2");
			return (Criteria) this;
		}

		public Criteria andBz2NotBetween(String value1, String value2) {
			addCriterion("bz2 not between", value1, value2, "bz2");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	
	}

    
}