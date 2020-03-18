package com.hzzxkj.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAttrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAttrExample() {
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

        public Criteria andAttrNameIsNull() {
            addCriterion("attr_name is null");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNotNull() {
            addCriterion("attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrNameEqualTo(String value) {
            addCriterion("attr_name =", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotEqualTo(String value) {
            addCriterion("attr_name <>", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThan(String value) {
            addCriterion("attr_name >", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("attr_name >=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThan(String value) {
            addCriterion("attr_name <", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThanOrEqualTo(String value) {
            addCriterion("attr_name <=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLike(String value) {
            addCriterion("attr_name like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotLike(String value) {
            addCriterion("attr_name not like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameIn(List<String> values) {
            addCriterion("attr_name in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotIn(List<String> values) {
            addCriterion("attr_name not in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameBetween(String value1, String value2) {
            addCriterion("attr_name between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotBetween(String value1, String value2) {
            addCriterion("attr_name not between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNull() {
            addCriterion("order_by is null");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNotNull() {
            addCriterion("order_by is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByEqualTo(Integer value) {
            addCriterion("order_by =", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotEqualTo(Integer value) {
            addCriterion("order_by <>", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThan(Integer value) {
            addCriterion("order_by >", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_by >=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThan(Integer value) {
            addCriterion("order_by <", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThanOrEqualTo(Integer value) {
            addCriterion("order_by <=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByIn(List<Integer> values) {
            addCriterion("order_by in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotIn(List<Integer> values) {
            addCriterion("order_by not in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByBetween(Integer value1, Integer value2) {
            addCriterion("order_by between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotBetween(Integer value1, Integer value2) {
            addCriterion("order_by not between", value1, value2, "orderBy");
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

        public Criteria andAttrAddrIsNull() {
            addCriterion("attr_addr is null");
            return (Criteria) this;
        }

        public Criteria andAttrAddrIsNotNull() {
            addCriterion("attr_addr is not null");
            return (Criteria) this;
        }

        public Criteria andAttrAddrEqualTo(String value) {
            addCriterion("attr_addr =", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrNotEqualTo(String value) {
            addCriterion("attr_addr <>", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrGreaterThan(String value) {
            addCriterion("attr_addr >", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrGreaterThanOrEqualTo(String value) {
            addCriterion("attr_addr >=", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrLessThan(String value) {
            addCriterion("attr_addr <", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrLessThanOrEqualTo(String value) {
            addCriterion("attr_addr <=", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrLike(String value) {
            addCriterion("attr_addr like", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrNotLike(String value) {
            addCriterion("attr_addr not like", value, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrIn(List<String> values) {
            addCriterion("attr_addr in", values, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrNotIn(List<String> values) {
            addCriterion("attr_addr not in", values, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrBetween(String value1, String value2) {
            addCriterion("attr_addr between", value1, value2, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrAddrNotBetween(String value1, String value2) {
            addCriterion("attr_addr not between", value1, value2, "attrAddr");
            return (Criteria) this;
        }

        public Criteria andAttrLenIsNull() {
            addCriterion("attr_len is null");
            return (Criteria) this;
        }

        public Criteria andAttrLenIsNotNull() {
            addCriterion("attr_len is not null");
            return (Criteria) this;
        }

        public Criteria andAttrLenEqualTo(Integer value) {
            addCriterion("attr_len =", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenNotEqualTo(Integer value) {
            addCriterion("attr_len <>", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenGreaterThan(Integer value) {
            addCriterion("attr_len >", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("attr_len >=", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenLessThan(Integer value) {
            addCriterion("attr_len <", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenLessThanOrEqualTo(Integer value) {
            addCriterion("attr_len <=", value, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenIn(List<Integer> values) {
            addCriterion("attr_len in", values, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenNotIn(List<Integer> values) {
            addCriterion("attr_len not in", values, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenBetween(Integer value1, Integer value2) {
            addCriterion("attr_len between", value1, value2, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrLenNotBetween(Integer value1, Integer value2) {
            addCriterion("attr_len not between", value1, value2, "attrLen");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishIsNull() {
            addCriterion("attr_english is null");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishIsNotNull() {
            addCriterion("attr_english is not null");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishEqualTo(String value) {
            addCriterion("attr_english =", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishNotEqualTo(String value) {
            addCriterion("attr_english <>", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishGreaterThan(String value) {
            addCriterion("attr_english >", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishGreaterThanOrEqualTo(String value) {
            addCriterion("attr_english >=", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishLessThan(String value) {
            addCriterion("attr_english <", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishLessThanOrEqualTo(String value) {
            addCriterion("attr_english <=", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishLike(String value) {
            addCriterion("attr_english like", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishNotLike(String value) {
            addCriterion("attr_english not like", value, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishIn(List<String> values) {
            addCriterion("attr_english in", values, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishNotIn(List<String> values) {
            addCriterion("attr_english not in", values, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishBetween(String value1, String value2) {
            addCriterion("attr_english between", value1, value2, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrEnglishNotBetween(String value1, String value2) {
            addCriterion("attr_english not between", value1, value2, "attrEnglish");
            return (Criteria) this;
        }

        public Criteria andAttrUnitIsNull() {
            addCriterion("attr_unit is null");
            return (Criteria) this;
        }

        public Criteria andAttrUnitIsNotNull() {
            addCriterion("attr_unit is not null");
            return (Criteria) this;
        }

        public Criteria andAttrUnitEqualTo(String value) {
            addCriterion("attr_unit =", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitNotEqualTo(String value) {
            addCriterion("attr_unit <>", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitGreaterThan(String value) {
            addCriterion("attr_unit >", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitGreaterThanOrEqualTo(String value) {
            addCriterion("attr_unit >=", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitLessThan(String value) {
            addCriterion("attr_unit <", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitLessThanOrEqualTo(String value) {
            addCriterion("attr_unit <=", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitLike(String value) {
            addCriterion("attr_unit like", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitNotLike(String value) {
            addCriterion("attr_unit not like", value, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitIn(List<String> values) {
            addCriterion("attr_unit in", values, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitNotIn(List<String> values) {
            addCriterion("attr_unit not in", values, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitBetween(String value1, String value2) {
            addCriterion("attr_unit between", value1, value2, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andAttrUnitNotBetween(String value1, String value2) {
            addCriterion("attr_unit not between", value1, value2, "attrUnit");
            return (Criteria) this;
        }

        public Criteria andIsAlertIsNull() {
            addCriterion("is_alert is null");
            return (Criteria) this;
        }

        public Criteria andIsAlertIsNotNull() {
            addCriterion("is_alert is not null");
            return (Criteria) this;
        }

        public Criteria andIsAlertEqualTo(String value) {
            addCriterion("is_alert =", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotEqualTo(String value) {
            addCriterion("is_alert <>", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThan(String value) {
            addCriterion("is_alert >", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThanOrEqualTo(String value) {
            addCriterion("is_alert >=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThan(String value) {
            addCriterion("is_alert <", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThanOrEqualTo(String value) {
            addCriterion("is_alert <=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLike(String value) {
            addCriterion("is_alert like", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotLike(String value) {
            addCriterion("is_alert not like", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertIn(List<String> values) {
            addCriterion("is_alert in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotIn(List<String> values) {
            addCriterion("is_alert not in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertBetween(String value1, String value2) {
            addCriterion("is_alert between", value1, value2, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotBetween(String value1, String value2) {
            addCriterion("is_alert not between", value1, value2, "isAlert");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIsNull() {
            addCriterion("alert_level is null");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIsNotNull() {
            addCriterion("alert_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlertLevelEqualTo(String value) {
            addCriterion("alert_level =", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotEqualTo(String value) {
            addCriterion("alert_level <>", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelGreaterThan(String value) {
            addCriterion("alert_level >", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelGreaterThanOrEqualTo(String value) {
            addCriterion("alert_level >=", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLessThan(String value) {
            addCriterion("alert_level <", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLessThanOrEqualTo(String value) {
            addCriterion("alert_level <=", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelLike(String value) {
            addCriterion("alert_level like", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotLike(String value) {
            addCriterion("alert_level not like", value, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelIn(List<String> values) {
            addCriterion("alert_level in", values, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotIn(List<String> values) {
            addCriterion("alert_level not in", values, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelBetween(String value1, String value2) {
            addCriterion("alert_level between", value1, value2, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andAlertLevelNotBetween(String value1, String value2) {
            addCriterion("alert_level not between", value1, value2, "alertLevel");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNull() {
            addCriterion("format_type is null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNotNull() {
            addCriterion("format_type is not null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeEqualTo(String value) {
            addCriterion("format_type =", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotEqualTo(String value) {
            addCriterion("format_type <>", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThan(String value) {
            addCriterion("format_type >", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("format_type >=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThan(String value) {
            addCriterion("format_type <", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThanOrEqualTo(String value) {
            addCriterion("format_type <=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLike(String value) {
            addCriterion("format_type like", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotLike(String value) {
            addCriterion("format_type not like", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIn(List<String> values) {
            addCriterion("format_type in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotIn(List<String> values) {
            addCriterion("format_type not in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeBetween(String value1, String value2) {
            addCriterion("format_type between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotBetween(String value1, String value2) {
            addCriterion("format_type not between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIsNull() {
            addCriterion("format_style is null");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIsNotNull() {
            addCriterion("format_style is not null");
            return (Criteria) this;
        }

        public Criteria andFormatStyleEqualTo(String value) {
            addCriterion("format_style =", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotEqualTo(String value) {
            addCriterion("format_style <>", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleGreaterThan(String value) {
            addCriterion("format_style >", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleGreaterThanOrEqualTo(String value) {
            addCriterion("format_style >=", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLessThan(String value) {
            addCriterion("format_style <", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLessThanOrEqualTo(String value) {
            addCriterion("format_style <=", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleLike(String value) {
            addCriterion("format_style like", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotLike(String value) {
            addCriterion("format_style not like", value, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleIn(List<String> values) {
            addCriterion("format_style in", values, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotIn(List<String> values) {
            addCriterion("format_style not in", values, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleBetween(String value1, String value2) {
            addCriterion("format_style between", value1, value2, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andFormatStyleNotBetween(String value1, String value2) {
            addCriterion("format_style not between", value1, value2, "formatStyle");
            return (Criteria) this;
        }

        public Criteria andIsRrtIsNull() {
            addCriterion("is_rrt is null");
            return (Criteria) this;
        }

        public Criteria andIsRrtIsNotNull() {
            addCriterion("is_rrt is not null");
            return (Criteria) this;
        }

        public Criteria andIsRrtEqualTo(String value) {
            addCriterion("is_rrt =", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtNotEqualTo(String value) {
            addCriterion("is_rrt <>", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtGreaterThan(String value) {
            addCriterion("is_rrt >", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtGreaterThanOrEqualTo(String value) {
            addCriterion("is_rrt >=", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtLessThan(String value) {
            addCriterion("is_rrt <", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtLessThanOrEqualTo(String value) {
            addCriterion("is_rrt <=", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtLike(String value) {
            addCriterion("is_rrt like", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtNotLike(String value) {
            addCriterion("is_rrt not like", value, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtIn(List<String> values) {
            addCriterion("is_rrt in", values, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtNotIn(List<String> values) {
            addCriterion("is_rrt not in", values, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtBetween(String value1, String value2) {
            addCriterion("is_rrt between", value1, value2, "isRrt");
            return (Criteria) this;
        }

        public Criteria andIsRrtNotBetween(String value1, String value2) {
            addCriterion("is_rrt not between", value1, value2, "isRrt");
            return (Criteria) this;
        }

        public Criteria andConvertTypeIsNull() {
            addCriterion("convert_type is null");
            return (Criteria) this;
        }

        public Criteria andConvertTypeIsNotNull() {
            addCriterion("convert_type is not null");
            return (Criteria) this;
        }

        public Criteria andConvertTypeEqualTo(String value) {
            addCriterion("convert_type =", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeNotEqualTo(String value) {
            addCriterion("convert_type <>", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeGreaterThan(String value) {
            addCriterion("convert_type >", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("convert_type >=", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeLessThan(String value) {
            addCriterion("convert_type <", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeLessThanOrEqualTo(String value) {
            addCriterion("convert_type <=", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeLike(String value) {
            addCriterion("convert_type like", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeNotLike(String value) {
            addCriterion("convert_type not like", value, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeIn(List<String> values) {
            addCriterion("convert_type in", values, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeNotIn(List<String> values) {
            addCriterion("convert_type not in", values, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeBetween(String value1, String value2) {
            addCriterion("convert_type between", value1, value2, "convertType");
            return (Criteria) this;
        }

        public Criteria andConvertTypeNotBetween(String value1, String value2) {
            addCriterion("convert_type not between", value1, value2, "convertType");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("is_show like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("is_show not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxIsNull() {
            addCriterion("attr_value_max is null");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxIsNotNull() {
            addCriterion("attr_value_max is not null");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxEqualTo(BigDecimal value) {
            addCriterion("attr_value_max =", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxNotEqualTo(BigDecimal value) {
            addCriterion("attr_value_max <>", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxGreaterThan(BigDecimal value) {
            addCriterion("attr_value_max >", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("attr_value_max >=", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxLessThan(BigDecimal value) {
            addCriterion("attr_value_max <", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("attr_value_max <=", value, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxIn(List<BigDecimal> values) {
            addCriterion("attr_value_max in", values, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxNotIn(List<BigDecimal> values) {
            addCriterion("attr_value_max not in", values, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attr_value_max between", value1, value2, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attr_value_max not between", value1, value2, "attrValueMax");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinIsNull() {
            addCriterion("attr_value_min is null");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinIsNotNull() {
            addCriterion("attr_value_min is not null");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinEqualTo(BigDecimal value) {
            addCriterion("attr_value_min =", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinNotEqualTo(BigDecimal value) {
            addCriterion("attr_value_min <>", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinGreaterThan(BigDecimal value) {
            addCriterion("attr_value_min >", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("attr_value_min >=", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinLessThan(BigDecimal value) {
            addCriterion("attr_value_min <", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("attr_value_min <=", value, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinIn(List<BigDecimal> values) {
            addCriterion("attr_value_min in", values, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinNotIn(List<BigDecimal> values) {
            addCriterion("attr_value_min not in", values, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attr_value_min between", value1, value2, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAttrValueMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attr_value_min not between", value1, value2, "attrValueMin");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNull() {
            addCriterion("alert_time is null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIsNotNull() {
            addCriterion("alert_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlertTimeEqualTo(Integer value) {
            addCriterion("alert_time =", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotEqualTo(Integer value) {
            addCriterion("alert_time <>", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThan(Integer value) {
            addCriterion("alert_time >", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_time >=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThan(Integer value) {
            addCriterion("alert_time <", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeLessThanOrEqualTo(Integer value) {
            addCriterion("alert_time <=", value, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeIn(List<Integer> values) {
            addCriterion("alert_time in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotIn(List<Integer> values) {
            addCriterion("alert_time not in", values, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeBetween(Integer value1, Integer value2) {
            addCriterion("alert_time between", value1, value2, "alertTime");
            return (Criteria) this;
        }

        public Criteria andAlertTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_time not between", value1, value2, "alertTime");
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