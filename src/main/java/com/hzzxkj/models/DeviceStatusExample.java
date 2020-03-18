package com.hzzxkj.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceStatusExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIsNull() {
            addCriterion("office_id is null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIsNotNull() {
            addCriterion("office_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeIdEqualTo(String value) {
            addCriterion("office_id =", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotEqualTo(String value) {
            addCriterion("office_id <>", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThan(String value) {
            addCriterion("office_id >", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdGreaterThanOrEqualTo(String value) {
            addCriterion("office_id >=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThan(String value) {
            addCriterion("office_id <", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLessThanOrEqualTo(String value) {
            addCriterion("office_id <=", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdLike(String value) {
            addCriterion("office_id like", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotLike(String value) {
            addCriterion("office_id not like", value, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdIn(List<String> values) {
            addCriterion("office_id in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotIn(List<String> values) {
            addCriterion("office_id not in", values, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdBetween(String value1, String value2) {
            addCriterion("office_id between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andOfficeIdNotBetween(String value1, String value2) {
            addCriterion("office_id not between", value1, value2, "officeId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenIsNull() {
            addCriterion("device_open is null");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenIsNotNull() {
            addCriterion("device_open is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenEqualTo(Integer value) {
            addCriterion("device_open =", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenNotEqualTo(Integer value) {
            addCriterion("device_open <>", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenGreaterThan(Integer value) {
            addCriterion("device_open >", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_open >=", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenLessThan(Integer value) {
            addCriterion("device_open <", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenLessThanOrEqualTo(Integer value) {
            addCriterion("device_open <=", value, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenIn(List<Integer> values) {
            addCriterion("device_open in", values, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenNotIn(List<Integer> values) {
            addCriterion("device_open not in", values, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenBetween(Integer value1, Integer value2) {
            addCriterion("device_open between", value1, value2, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("device_open not between", value1, value2, "deviceOpen");
            return (Criteria) this;
        }

        public Criteria andDeviceRunIsNull() {
            addCriterion("device_run is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRunIsNotNull() {
            addCriterion("device_run is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRunEqualTo(Integer value) {
            addCriterion("device_run =", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunNotEqualTo(Integer value) {
            addCriterion("device_run <>", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunGreaterThan(Integer value) {
            addCriterion("device_run >", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_run >=", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunLessThan(Integer value) {
            addCriterion("device_run <", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunLessThanOrEqualTo(Integer value) {
            addCriterion("device_run <=", value, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunIn(List<Integer> values) {
            addCriterion("device_run in", values, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunNotIn(List<Integer> values) {
            addCriterion("device_run not in", values, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunBetween(Integer value1, Integer value2) {
            addCriterion("device_run between", value1, value2, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceRunNotBetween(Integer value1, Integer value2) {
            addCriterion("device_run not between", value1, value2, "deviceRun");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIsNull() {
            addCriterion("device_fault is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIsNotNull() {
            addCriterion("device_fault is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultEqualTo(Integer value) {
            addCriterion("device_fault =", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultNotEqualTo(Integer value) {
            addCriterion("device_fault <>", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultGreaterThan(Integer value) {
            addCriterion("device_fault >", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_fault >=", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultLessThan(Integer value) {
            addCriterion("device_fault <", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultLessThanOrEqualTo(Integer value) {
            addCriterion("device_fault <=", value, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIn(List<Integer> values) {
            addCriterion("device_fault in", values, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultNotIn(List<Integer> values) {
            addCriterion("device_fault not in", values, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultBetween(Integer value1, Integer value2) {
            addCriterion("device_fault between", value1, value2, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultNotBetween(Integer value1, Integer value2) {
            addCriterion("device_fault not between", value1, value2, "deviceFault");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyIsNull() {
            addCriterion("device_study is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyIsNotNull() {
            addCriterion("device_study is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyEqualTo(Integer value) {
            addCriterion("device_study =", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyNotEqualTo(Integer value) {
            addCriterion("device_study <>", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyGreaterThan(Integer value) {
            addCriterion("device_study >", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_study >=", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyLessThan(Integer value) {
            addCriterion("device_study <", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyLessThanOrEqualTo(Integer value) {
            addCriterion("device_study <=", value, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyIn(List<Integer> values) {
            addCriterion("device_study in", values, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyNotIn(List<Integer> values) {
            addCriterion("device_study not in", values, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyBetween(Integer value1, Integer value2) {
            addCriterion("device_study between", value1, value2, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDeviceStudyNotBetween(Integer value1, Integer value2) {
            addCriterion("device_study not between", value1, value2, "deviceStudy");
            return (Criteria) this;
        }

        public Criteria andDevicePowerIsNull() {
            addCriterion("device_power is null");
            return (Criteria) this;
        }

        public Criteria andDevicePowerIsNotNull() {
            addCriterion("device_power is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePowerEqualTo(Integer value) {
            addCriterion("device_power =", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerNotEqualTo(Integer value) {
            addCriterion("device_power <>", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerGreaterThan(Integer value) {
            addCriterion("device_power >", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_power >=", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerLessThan(Integer value) {
            addCriterion("device_power <", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerLessThanOrEqualTo(Integer value) {
            addCriterion("device_power <=", value, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerIn(List<Integer> values) {
            addCriterion("device_power in", values, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerNotIn(List<Integer> values) {
            addCriterion("device_power not in", values, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerBetween(Integer value1, Integer value2) {
            addCriterion("device_power between", value1, value2, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDevicePowerNotBetween(Integer value1, Integer value2) {
            addCriterion("device_power not between", value1, value2, "devicePower");
            return (Criteria) this;
        }

        public Criteria andDeviceLiIsNull() {
            addCriterion("device_li is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLiIsNotNull() {
            addCriterion("device_li is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLiEqualTo(Integer value) {
            addCriterion("device_li =", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiNotEqualTo(Integer value) {
            addCriterion("device_li <>", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiGreaterThan(Integer value) {
            addCriterion("device_li >", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_li >=", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiLessThan(Integer value) {
            addCriterion("device_li <", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiLessThanOrEqualTo(Integer value) {
            addCriterion("device_li <=", value, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiIn(List<Integer> values) {
            addCriterion("device_li in", values, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiNotIn(List<Integer> values) {
            addCriterion("device_li not in", values, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiBetween(Integer value1, Integer value2) {
            addCriterion("device_li between", value1, value2, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceLiNotBetween(Integer value1, Integer value2) {
            addCriterion("device_li not between", value1, value2, "deviceLi");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailIsNull() {
            addCriterion("device_detail is null");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailIsNotNull() {
            addCriterion("device_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailEqualTo(String value) {
            addCriterion("device_detail =", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailNotEqualTo(String value) {
            addCriterion("device_detail <>", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailGreaterThan(String value) {
            addCriterion("device_detail >", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailGreaterThanOrEqualTo(String value) {
            addCriterion("device_detail >=", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailLessThan(String value) {
            addCriterion("device_detail <", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailLessThanOrEqualTo(String value) {
            addCriterion("device_detail <=", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailLike(String value) {
            addCriterion("device_detail like", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailNotLike(String value) {
            addCriterion("device_detail not like", value, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailIn(List<String> values) {
            addCriterion("device_detail in", values, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailNotIn(List<String> values) {
            addCriterion("device_detail not in", values, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailBetween(String value1, String value2) {
            addCriterion("device_detail between", value1, value2, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceDetailNotBetween(String value1, String value2) {
            addCriterion("device_detail not between", value1, value2, "deviceDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIsNull() {
            addCriterion("device_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIsNotNull() {
            addCriterion("device_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeEqualTo(Date value) {
            addCriterion("device_update_time =", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotEqualTo(Date value) {
            addCriterion("device_update_time <>", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeGreaterThan(Date value) {
            addCriterion("device_update_time >", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_update_time >=", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeLessThan(Date value) {
            addCriterion("device_update_time <", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_update_time <=", value, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeIn(List<Date> values) {
            addCriterion("device_update_time in", values, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotIn(List<Date> values) {
            addCriterion("device_update_time not in", values, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("device_update_time between", value1, value2, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_update_time not between", value1, value2, "deviceUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeIsNull() {
            addCriterion("device_fault_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeIsNotNull() {
            addCriterion("device_fault_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeEqualTo(Date value) {
            addCriterion("device_fault_update_time =", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeNotEqualTo(Date value) {
            addCriterion("device_fault_update_time <>", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeGreaterThan(Date value) {
            addCriterion("device_fault_update_time >", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_fault_update_time >=", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeLessThan(Date value) {
            addCriterion("device_fault_update_time <", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_fault_update_time <=", value, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeIn(List<Date> values) {
            addCriterion("device_fault_update_time in", values, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeNotIn(List<Date> values) {
            addCriterion("device_fault_update_time not in", values, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("device_fault_update_time between", value1, value2, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_fault_update_time not between", value1, value2, "deviceFaultUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andReserveIntIsNull() {
            addCriterion("reserve_int is null");
            return (Criteria) this;
        }

        public Criteria andReserveIntIsNotNull() {
            addCriterion("reserve_int is not null");
            return (Criteria) this;
        }

        public Criteria andReserveIntEqualTo(Integer value) {
            addCriterion("reserve_int =", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntNotEqualTo(Integer value) {
            addCriterion("reserve_int <>", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntGreaterThan(Integer value) {
            addCriterion("reserve_int >", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_int >=", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntLessThan(Integer value) {
            addCriterion("reserve_int <", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_int <=", value, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntIn(List<Integer> values) {
            addCriterion("reserve_int in", values, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntNotIn(List<Integer> values) {
            addCriterion("reserve_int not in", values, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntBetween(Integer value1, Integer value2) {
            addCriterion("reserve_int between", value1, value2, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveIntNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_int not between", value1, value2, "reserveInt");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharIsNull() {
            addCriterion("reserve_varchar is null");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharIsNotNull() {
            addCriterion("reserve_varchar is not null");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharEqualTo(String value) {
            addCriterion("reserve_varchar =", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharNotEqualTo(String value) {
            addCriterion("reserve_varchar <>", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharGreaterThan(String value) {
            addCriterion("reserve_varchar >", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_varchar >=", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharLessThan(String value) {
            addCriterion("reserve_varchar <", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharLessThanOrEqualTo(String value) {
            addCriterion("reserve_varchar <=", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharLike(String value) {
            addCriterion("reserve_varchar like", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharNotLike(String value) {
            addCriterion("reserve_varchar not like", value, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharIn(List<String> values) {
            addCriterion("reserve_varchar in", values, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharNotIn(List<String> values) {
            addCriterion("reserve_varchar not in", values, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharBetween(String value1, String value2) {
            addCriterion("reserve_varchar between", value1, value2, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andReserveVarcharNotBetween(String value1, String value2) {
            addCriterion("reserve_varchar not between", value1, value2, "reserveVarchar");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineIsNull() {
            addCriterion("device_online is null");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineIsNotNull() {
            addCriterion("device_online is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineEqualTo(Integer value) {
            addCriterion("device_online =", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineNotEqualTo(Integer value) {
            addCriterion("device_online <>", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineGreaterThan(Integer value) {
            addCriterion("device_online >", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_online >=", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineLessThan(Integer value) {
            addCriterion("device_online <", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineLessThanOrEqualTo(Integer value) {
            addCriterion("device_online <=", value, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineIn(List<Integer> values) {
            addCriterion("device_online in", values, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineNotIn(List<Integer> values) {
            addCriterion("device_online not in", values, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineBetween(Integer value1, Integer value2) {
            addCriterion("device_online between", value1, value2, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceOnlineNotBetween(Integer value1, Integer value2) {
            addCriterion("device_online not between", value1, value2, "deviceOnline");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusIsNull() {
            addCriterion("device_alert_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusIsNotNull() {
            addCriterion("device_alert_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusEqualTo(Integer value) {
            addCriterion("device_alert_status =", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusNotEqualTo(Integer value) {
            addCriterion("device_alert_status <>", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusGreaterThan(Integer value) {
            addCriterion("device_alert_status >", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_alert_status >=", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusLessThan(Integer value) {
            addCriterion("device_alert_status <", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusLessThanOrEqualTo(Integer value) {
            addCriterion("device_alert_status <=", value, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusIn(List<Integer> values) {
            addCriterion("device_alert_status in", values, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusNotIn(List<Integer> values) {
            addCriterion("device_alert_status not in", values, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusBetween(Integer value1, Integer value2) {
            addCriterion("device_alert_status between", value1, value2, "deviceAlertStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAlertStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("device_alert_status not between", value1, value2, "deviceAlertStatus");
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