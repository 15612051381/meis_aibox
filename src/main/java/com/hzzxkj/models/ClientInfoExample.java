package com.hzzxkj.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientInfoExample() {
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

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(String value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(String value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(String value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(String value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(String value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(String value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLike(String value) {
            addCriterion("seq like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotLike(String value) {
            addCriterion("seq not like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<String> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<String> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(String value1, String value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(String value1, String value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIsNull() {
            addCriterion("is_online is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIsNotNull() {
            addCriterion("is_online is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineEqualTo(String value) {
            addCriterion("is_online =", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotEqualTo(String value) {
            addCriterion("is_online <>", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThan(String value) {
            addCriterion("is_online >", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("is_online >=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThan(String value) {
            addCriterion("is_online <", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThanOrEqualTo(String value) {
            addCriterion("is_online <=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLike(String value) {
            addCriterion("is_online like", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotLike(String value) {
            addCriterion("is_online not like", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIn(List<String> values) {
            addCriterion("is_online in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotIn(List<String> values) {
            addCriterion("is_online not in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineBetween(String value1, String value2) {
            addCriterion("is_online between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotBetween(String value1, String value2) {
            addCriterion("is_online not between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineIsNull() {
            addCriterion("last_online is null");
            return (Criteria) this;
        }

        public Criteria andLastOnlineIsNotNull() {
            addCriterion("last_online is not null");
            return (Criteria) this;
        }

        public Criteria andLastOnlineEqualTo(Date value) {
            addCriterion("last_online =", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineNotEqualTo(Date value) {
            addCriterion("last_online <>", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineGreaterThan(Date value) {
            addCriterion("last_online >", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineGreaterThanOrEqualTo(Date value) {
            addCriterion("last_online >=", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineLessThan(Date value) {
            addCriterion("last_online <", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineLessThanOrEqualTo(Date value) {
            addCriterion("last_online <=", value, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineIn(List<Date> values) {
            addCriterion("last_online in", values, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineNotIn(List<Date> values) {
            addCriterion("last_online not in", values, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineBetween(Date value1, Date value2) {
            addCriterion("last_online between", value1, value2, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andLastOnlineNotBetween(Date value1, Date value2) {
            addCriterion("last_online not between", value1, value2, "lastOnline");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNull() {
            addCriterion("hospital_id is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIsNotNull() {
            addCriterion("hospital_id is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalIdEqualTo(String value) {
            addCriterion("hospital_id =", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotEqualTo(String value) {
            addCriterion("hospital_id <>", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThan(String value) {
            addCriterion("hospital_id >", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdGreaterThanOrEqualTo(String value) {
            addCriterion("hospital_id >=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThan(String value) {
            addCriterion("hospital_id <", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLessThanOrEqualTo(String value) {
            addCriterion("hospital_id <=", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdLike(String value) {
            addCriterion("hospital_id like", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotLike(String value) {
            addCriterion("hospital_id not like", value, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdIn(List<String> values) {
            addCriterion("hospital_id in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotIn(List<String> values) {
            addCriterion("hospital_id not in", values, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdBetween(String value1, String value2) {
            addCriterion("hospital_id between", value1, value2, "hospitalId");
            return (Criteria) this;
        }

        public Criteria andHospitalIdNotBetween(String value1, String value2) {
            addCriterion("hospital_id not between", value1, value2, "hospitalId");
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

        public Criteria andLastRtcSysdateIsNull() {
            addCriterion("last_rtc_sysdate is null");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateIsNotNull() {
            addCriterion("last_rtc_sysdate is not null");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateEqualTo(Date value) {
            addCriterion("last_rtc_sysdate =", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateNotEqualTo(Date value) {
            addCriterion("last_rtc_sysdate <>", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateGreaterThan(Date value) {
            addCriterion("last_rtc_sysdate >", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_rtc_sysdate >=", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateLessThan(Date value) {
            addCriterion("last_rtc_sysdate <", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateLessThanOrEqualTo(Date value) {
            addCriterion("last_rtc_sysdate <=", value, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateIn(List<Date> values) {
            addCriterion("last_rtc_sysdate in", values, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateNotIn(List<Date> values) {
            addCriterion("last_rtc_sysdate not in", values, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateBetween(Date value1, Date value2) {
            addCriterion("last_rtc_sysdate between", value1, value2, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcSysdateNotBetween(Date value1, Date value2) {
            addCriterion("last_rtc_sysdate not between", value1, value2, "lastRtcSysdate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateIsNull() {
            addCriterion("last_rtc_date is null");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateIsNotNull() {
            addCriterion("last_rtc_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateEqualTo(Long value) {
            addCriterion("last_rtc_date =", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateNotEqualTo(Long value) {
            addCriterion("last_rtc_date <>", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateGreaterThan(Long value) {
            addCriterion("last_rtc_date >", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateGreaterThanOrEqualTo(Long value) {
            addCriterion("last_rtc_date >=", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateLessThan(Long value) {
            addCriterion("last_rtc_date <", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateLessThanOrEqualTo(Long value) {
            addCriterion("last_rtc_date <=", value, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateIn(List<Long> values) {
            addCriterion("last_rtc_date in", values, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateNotIn(List<Long> values) {
            addCriterion("last_rtc_date not in", values, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateBetween(Long value1, Long value2) {
            addCriterion("last_rtc_date between", value1, value2, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDateNotBetween(Long value1, Long value2) {
            addCriterion("last_rtc_date not between", value1, value2, "lastRtcDate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateIsNull() {
            addCriterion("last_rtc_deviate is null");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateIsNotNull() {
            addCriterion("last_rtc_deviate is not null");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateEqualTo(Long value) {
            addCriterion("last_rtc_deviate =", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateNotEqualTo(Long value) {
            addCriterion("last_rtc_deviate <>", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateGreaterThan(Long value) {
            addCriterion("last_rtc_deviate >", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateGreaterThanOrEqualTo(Long value) {
            addCriterion("last_rtc_deviate >=", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateLessThan(Long value) {
            addCriterion("last_rtc_deviate <", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateLessThanOrEqualTo(Long value) {
            addCriterion("last_rtc_deviate <=", value, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateIn(List<Long> values) {
            addCriterion("last_rtc_deviate in", values, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateNotIn(List<Long> values) {
            addCriterion("last_rtc_deviate not in", values, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateBetween(Long value1, Long value2) {
            addCriterion("last_rtc_deviate between", value1, value2, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLastRtcDeviateNotBetween(Long value1, Long value2) {
            addCriterion("last_rtc_deviate not between", value1, value2, "lastRtcDeviate");
            return (Criteria) this;
        }

        public Criteria andLogRemainderIsNull() {
            addCriterion("log_remainder is null");
            return (Criteria) this;
        }

        public Criteria andLogRemainderIsNotNull() {
            addCriterion("log_remainder is not null");
            return (Criteria) this;
        }

        public Criteria andLogRemainderEqualTo(Integer value) {
            addCriterion("log_remainder =", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderNotEqualTo(Integer value) {
            addCriterion("log_remainder <>", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderGreaterThan(Integer value) {
            addCriterion("log_remainder >", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_remainder >=", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderLessThan(Integer value) {
            addCriterion("log_remainder <", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderLessThanOrEqualTo(Integer value) {
            addCriterion("log_remainder <=", value, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderIn(List<Integer> values) {
            addCriterion("log_remainder in", values, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderNotIn(List<Integer> values) {
            addCriterion("log_remainder not in", values, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderBetween(Integer value1, Integer value2) {
            addCriterion("log_remainder between", value1, value2, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLogRemainderNotBetween(Integer value1, Integer value2) {
            addCriterion("log_remainder not between", value1, value2, "logRemainder");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateIsNull() {
            addCriterion("last_update_log_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateIsNotNull() {
            addCriterion("last_update_log_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateEqualTo(Date value) {
            addCriterion("last_update_log_date =", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateNotEqualTo(Date value) {
            addCriterion("last_update_log_date <>", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateGreaterThan(Date value) {
            addCriterion("last_update_log_date >", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_log_date >=", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateLessThan(Date value) {
            addCriterion("last_update_log_date <", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_log_date <=", value, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateIn(List<Date> values) {
            addCriterion("last_update_log_date in", values, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateNotIn(List<Date> values) {
            addCriterion("last_update_log_date not in", values, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateBetween(Date value1, Date value2) {
            addCriterion("last_update_log_date between", value1, value2, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLogDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_log_date not between", value1, value2, "lastUpdateLogDate");
            return (Criteria) this;
        }

        public Criteria andBlVersionIsNull() {
            addCriterion("bl_version is null");
            return (Criteria) this;
        }

        public Criteria andBlVersionIsNotNull() {
            addCriterion("bl_version is not null");
            return (Criteria) this;
        }

        public Criteria andBlVersionEqualTo(String value) {
            addCriterion("bl_version =", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionNotEqualTo(String value) {
            addCriterion("bl_version <>", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionGreaterThan(String value) {
            addCriterion("bl_version >", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionGreaterThanOrEqualTo(String value) {
            addCriterion("bl_version >=", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionLessThan(String value) {
            addCriterion("bl_version <", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionLessThanOrEqualTo(String value) {
            addCriterion("bl_version <=", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionLike(String value) {
            addCriterion("bl_version like", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionNotLike(String value) {
            addCriterion("bl_version not like", value, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionIn(List<String> values) {
            addCriterion("bl_version in", values, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionNotIn(List<String> values) {
            addCriterion("bl_version not in", values, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionBetween(String value1, String value2) {
            addCriterion("bl_version between", value1, value2, "blVersion");
            return (Criteria) this;
        }

        public Criteria andBlVersionNotBetween(String value1, String value2) {
            addCriterion("bl_version not between", value1, value2, "blVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionIsNull() {
            addCriterion("sw_version is null");
            return (Criteria) this;
        }

        public Criteria andSwVersionIsNotNull() {
            addCriterion("sw_version is not null");
            return (Criteria) this;
        }

        public Criteria andSwVersionEqualTo(String value) {
            addCriterion("sw_version =", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotEqualTo(String value) {
            addCriterion("sw_version <>", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionGreaterThan(String value) {
            addCriterion("sw_version >", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sw_version >=", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLessThan(String value) {
            addCriterion("sw_version <", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLessThanOrEqualTo(String value) {
            addCriterion("sw_version <=", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionLike(String value) {
            addCriterion("sw_version like", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotLike(String value) {
            addCriterion("sw_version not like", value, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionIn(List<String> values) {
            addCriterion("sw_version in", values, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotIn(List<String> values) {
            addCriterion("sw_version not in", values, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionBetween(String value1, String value2) {
            addCriterion("sw_version between", value1, value2, "swVersion");
            return (Criteria) this;
        }

        public Criteria andSwVersionNotBetween(String value1, String value2) {
            addCriterion("sw_version not between", value1, value2, "swVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionIsNull() {
            addCriterion("hw_version is null");
            return (Criteria) this;
        }

        public Criteria andHwVersionIsNotNull() {
            addCriterion("hw_version is not null");
            return (Criteria) this;
        }

        public Criteria andHwVersionEqualTo(String value) {
            addCriterion("hw_version =", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotEqualTo(String value) {
            addCriterion("hw_version <>", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionGreaterThan(String value) {
            addCriterion("hw_version >", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionGreaterThanOrEqualTo(String value) {
            addCriterion("hw_version >=", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLessThan(String value) {
            addCriterion("hw_version <", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLessThanOrEqualTo(String value) {
            addCriterion("hw_version <=", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionLike(String value) {
            addCriterion("hw_version like", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotLike(String value) {
            addCriterion("hw_version not like", value, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionIn(List<String> values) {
            addCriterion("hw_version in", values, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotIn(List<String> values) {
            addCriterion("hw_version not in", values, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionBetween(String value1, String value2) {
            addCriterion("hw_version between", value1, value2, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andHwVersionNotBetween(String value1, String value2) {
            addCriterion("hw_version not between", value1, value2, "hwVersion");
            return (Criteria) this;
        }

        public Criteria andSetupDateIsNull() {
            addCriterion("setup_date is null");
            return (Criteria) this;
        }

        public Criteria andSetupDateIsNotNull() {
            addCriterion("setup_date is not null");
            return (Criteria) this;
        }

        public Criteria andSetupDateEqualTo(Date value) {
            addCriterion("setup_date =", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotEqualTo(Date value) {
            addCriterion("setup_date <>", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateGreaterThan(Date value) {
            addCriterion("setup_date >", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateGreaterThanOrEqualTo(Date value) {
            addCriterion("setup_date >=", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateLessThan(Date value) {
            addCriterion("setup_date <", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateLessThanOrEqualTo(Date value) {
            addCriterion("setup_date <=", value, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateIn(List<Date> values) {
            addCriterion("setup_date in", values, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotIn(List<Date> values) {
            addCriterion("setup_date not in", values, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateBetween(Date value1, Date value2) {
            addCriterion("setup_date between", value1, value2, "setupDate");
            return (Criteria) this;
        }

        public Criteria andSetupDateNotBetween(Date value1, Date value2) {
            addCriterion("setup_date not between", value1, value2, "setupDate");
            return (Criteria) this;
        }

        public Criteria andUseDateIsNull() {
            addCriterion("use_date is null");
            return (Criteria) this;
        }

        public Criteria andUseDateIsNotNull() {
            addCriterion("use_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseDateEqualTo(Date value) {
            addCriterion("use_date =", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotEqualTo(Date value) {
            addCriterion("use_date <>", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThan(Date value) {
            addCriterion("use_date >", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("use_date >=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThan(Date value) {
            addCriterion("use_date <", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThanOrEqualTo(Date value) {
            addCriterion("use_date <=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateIn(List<Date> values) {
            addCriterion("use_date in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotIn(List<Date> values) {
            addCriterion("use_date not in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateBetween(Date value1, Date value2) {
            addCriterion("use_date between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotBetween(Date value1, Date value2) {
            addCriterion("use_date not between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("client_type is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("client_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("client_type =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("client_type <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("client_type >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_type >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("client_type <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("client_type <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("client_type like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("client_type not like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<String> values) {
            addCriterion("client_type in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<String> values) {
            addCriterion("client_type not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("client_type between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("client_type not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andIsFaultIsNull() {
            addCriterion("is_fault is null");
            return (Criteria) this;
        }

        public Criteria andIsFaultIsNotNull() {
            addCriterion("is_fault is not null");
            return (Criteria) this;
        }

        public Criteria andIsFaultEqualTo(String value) {
            addCriterion("is_fault =", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultNotEqualTo(String value) {
            addCriterion("is_fault <>", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultGreaterThan(String value) {
            addCriterion("is_fault >", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultGreaterThanOrEqualTo(String value) {
            addCriterion("is_fault >=", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultLessThan(String value) {
            addCriterion("is_fault <", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultLessThanOrEqualTo(String value) {
            addCriterion("is_fault <=", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultLike(String value) {
            addCriterion("is_fault like", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultNotLike(String value) {
            addCriterion("is_fault not like", value, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultIn(List<String> values) {
            addCriterion("is_fault in", values, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultNotIn(List<String> values) {
            addCriterion("is_fault not in", values, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultBetween(String value1, String value2) {
            addCriterion("is_fault between", value1, value2, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsFaultNotBetween(String value1, String value2) {
            addCriterion("is_fault not between", value1, value2, "isFault");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(String value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(String value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(String value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(String value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(String value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(String value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLike(String value) {
            addCriterion("is_open like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotLike(String value) {
            addCriterion("is_open not like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<String> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<String> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(String value1, String value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(String value1, String value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsWorkIsNull() {
            addCriterion("is_work is null");
            return (Criteria) this;
        }

        public Criteria andIsWorkIsNotNull() {
            addCriterion("is_work is not null");
            return (Criteria) this;
        }

        public Criteria andIsWorkEqualTo(String value) {
            addCriterion("is_work =", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotEqualTo(String value) {
            addCriterion("is_work <>", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkGreaterThan(String value) {
            addCriterion("is_work >", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkGreaterThanOrEqualTo(String value) {
            addCriterion("is_work >=", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkLessThan(String value) {
            addCriterion("is_work <", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkLessThanOrEqualTo(String value) {
            addCriterion("is_work <=", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkLike(String value) {
            addCriterion("is_work like", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotLike(String value) {
            addCriterion("is_work not like", value, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkIn(List<String> values) {
            addCriterion("is_work in", values, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotIn(List<String> values) {
            addCriterion("is_work not in", values, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkBetween(String value1, String value2) {
            addCriterion("is_work between", value1, value2, "isWork");
            return (Criteria) this;
        }

        public Criteria andIsWorkNotBetween(String value1, String value2) {
            addCriterion("is_work not between", value1, value2, "isWork");
            return (Criteria) this;
        }

        public Criteria andServerIpIsNull() {
            addCriterion("server_ip is null");
            return (Criteria) this;
        }

        public Criteria andServerIpIsNotNull() {
            addCriterion("server_ip is not null");
            return (Criteria) this;
        }

        public Criteria andServerIpEqualTo(String value) {
            addCriterion("server_ip =", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotEqualTo(String value) {
            addCriterion("server_ip <>", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpGreaterThan(String value) {
            addCriterion("server_ip >", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("server_ip >=", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLessThan(String value) {
            addCriterion("server_ip <", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLessThanOrEqualTo(String value) {
            addCriterion("server_ip <=", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpLike(String value) {
            addCriterion("server_ip like", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotLike(String value) {
            addCriterion("server_ip not like", value, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpIn(List<String> values) {
            addCriterion("server_ip in", values, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotIn(List<String> values) {
            addCriterion("server_ip not in", values, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpBetween(String value1, String value2) {
            addCriterion("server_ip between", value1, value2, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerIpNotBetween(String value1, String value2) {
            addCriterion("server_ip not between", value1, value2, "serverIp");
            return (Criteria) this;
        }

        public Criteria andServerPortIsNull() {
            addCriterion("server_port is null");
            return (Criteria) this;
        }

        public Criteria andServerPortIsNotNull() {
            addCriterion("server_port is not null");
            return (Criteria) this;
        }

        public Criteria andServerPortEqualTo(Integer value) {
            addCriterion("server_port =", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotEqualTo(Integer value) {
            addCriterion("server_port <>", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortGreaterThan(Integer value) {
            addCriterion("server_port >", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_port >=", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortLessThan(Integer value) {
            addCriterion("server_port <", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortLessThanOrEqualTo(Integer value) {
            addCriterion("server_port <=", value, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortIn(List<Integer> values) {
            addCriterion("server_port in", values, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotIn(List<Integer> values) {
            addCriterion("server_port not in", values, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortBetween(Integer value1, Integer value2) {
            addCriterion("server_port between", value1, value2, "serverPort");
            return (Criteria) this;
        }

        public Criteria andServerPortNotBetween(Integer value1, Integer value2) {
            addCriterion("server_port not between", value1, value2, "serverPort");
            return (Criteria) this;
        }

        public Criteria andWifiSsidIsNull() {
            addCriterion("wifi_ssid is null");
            return (Criteria) this;
        }

        public Criteria andWifiSsidIsNotNull() {
            addCriterion("wifi_ssid is not null");
            return (Criteria) this;
        }

        public Criteria andWifiSsidEqualTo(String value) {
            addCriterion("wifi_ssid =", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidNotEqualTo(String value) {
            addCriterion("wifi_ssid <>", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidGreaterThan(String value) {
            addCriterion("wifi_ssid >", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidGreaterThanOrEqualTo(String value) {
            addCriterion("wifi_ssid >=", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidLessThan(String value) {
            addCriterion("wifi_ssid <", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidLessThanOrEqualTo(String value) {
            addCriterion("wifi_ssid <=", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidLike(String value) {
            addCriterion("wifi_ssid like", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidNotLike(String value) {
            addCriterion("wifi_ssid not like", value, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidIn(List<String> values) {
            addCriterion("wifi_ssid in", values, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidNotIn(List<String> values) {
            addCriterion("wifi_ssid not in", values, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidBetween(String value1, String value2) {
            addCriterion("wifi_ssid between", value1, value2, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiSsidNotBetween(String value1, String value2) {
            addCriterion("wifi_ssid not between", value1, value2, "wifiSsid");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordIsNull() {
            addCriterion("wifi_password is null");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordIsNotNull() {
            addCriterion("wifi_password is not null");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordEqualTo(String value) {
            addCriterion("wifi_password =", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordNotEqualTo(String value) {
            addCriterion("wifi_password <>", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordGreaterThan(String value) {
            addCriterion("wifi_password >", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("wifi_password >=", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordLessThan(String value) {
            addCriterion("wifi_password <", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordLessThanOrEqualTo(String value) {
            addCriterion("wifi_password <=", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordLike(String value) {
            addCriterion("wifi_password like", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordNotLike(String value) {
            addCriterion("wifi_password not like", value, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordIn(List<String> values) {
            addCriterion("wifi_password in", values, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordNotIn(List<String> values) {
            addCriterion("wifi_password not in", values, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordBetween(String value1, String value2) {
            addCriterion("wifi_password between", value1, value2, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andWifiPasswordNotBetween(String value1, String value2) {
            addCriterion("wifi_password not between", value1, value2, "wifiPassword");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andApMacIsNull() {
            addCriterion("ap_mac is null");
            return (Criteria) this;
        }

        public Criteria andApMacIsNotNull() {
            addCriterion("ap_mac is not null");
            return (Criteria) this;
        }

        public Criteria andApMacEqualTo(String value) {
            addCriterion("ap_mac =", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacNotEqualTo(String value) {
            addCriterion("ap_mac <>", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacGreaterThan(String value) {
            addCriterion("ap_mac >", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacGreaterThanOrEqualTo(String value) {
            addCriterion("ap_mac >=", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacLessThan(String value) {
            addCriterion("ap_mac <", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacLessThanOrEqualTo(String value) {
            addCriterion("ap_mac <=", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacLike(String value) {
            addCriterion("ap_mac like", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacNotLike(String value) {
            addCriterion("ap_mac not like", value, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacIn(List<String> values) {
            addCriterion("ap_mac in", values, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacNotIn(List<String> values) {
            addCriterion("ap_mac not in", values, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacBetween(String value1, String value2) {
            addCriterion("ap_mac between", value1, value2, "apMac");
            return (Criteria) this;
        }

        public Criteria andApMacNotBetween(String value1, String value2) {
            addCriterion("ap_mac not between", value1, value2, "apMac");
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

        public Criteria andAIsNull() {
            addCriterion("a is null");
            return (Criteria) this;
        }

        public Criteria andAIsNotNull() {
            addCriterion("a is not null");
            return (Criteria) this;
        }

        public Criteria andAEqualTo(BigDecimal value) {
            addCriterion("a =", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotEqualTo(BigDecimal value) {
            addCriterion("a <>", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThan(BigDecimal value) {
            addCriterion("a >", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a >=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThan(BigDecimal value) {
            addCriterion("a <", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThanOrEqualTo(BigDecimal value) {
            addCriterion("a <=", value, "a");
            return (Criteria) this;
        }

        public Criteria andAIn(List<BigDecimal> values) {
            addCriterion("a in", values, "a");
            return (Criteria) this;
        }

        public Criteria andANotIn(List<BigDecimal> values) {
            addCriterion("a not in", values, "a");
            return (Criteria) this;
        }

        public Criteria andABetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andANotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a not between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("b is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("b is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(BigDecimal value) {
            addCriterion("b =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(BigDecimal value) {
            addCriterion("b <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(BigDecimal value) {
            addCriterion("b >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("b >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(BigDecimal value) {
            addCriterion("b <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("b <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<BigDecimal> values) {
            addCriterion("b in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<BigDecimal> values) {
            addCriterion("b not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("b not between", value1, value2, "b");
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