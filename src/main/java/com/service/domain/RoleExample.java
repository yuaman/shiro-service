package com.service.domain;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public RoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_role
     *
     * @mbggenerated
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_role
     *
     * @mbggenerated
     */
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDiscIsNull() {
            addCriterion("role_disc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDiscIsNotNull() {
            addCriterion("role_disc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDiscEqualTo(String value) {
            addCriterion("role_disc =", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscNotEqualTo(String value) {
            addCriterion("role_disc <>", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscGreaterThan(String value) {
            addCriterion("role_disc >", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscGreaterThanOrEqualTo(String value) {
            addCriterion("role_disc >=", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscLessThan(String value) {
            addCriterion("role_disc <", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscLessThanOrEqualTo(String value) {
            addCriterion("role_disc <=", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscLike(String value) {
            addCriterion("role_disc like", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscNotLike(String value) {
            addCriterion("role_disc not like", value, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscIn(List<String> values) {
            addCriterion("role_disc in", values, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscNotIn(List<String> values) {
            addCriterion("role_disc not in", values, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscBetween(String value1, String value2) {
            addCriterion("role_disc between", value1, value2, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDiscNotBetween(String value1, String value2) {
            addCriterion("role_disc not between", value1, value2, "roleDisc");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagIsNull() {
            addCriterion("role_dis_flag is null");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagIsNotNull() {
            addCriterion("role_dis_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagEqualTo(String value) {
            addCriterion("role_dis_flag =", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagNotEqualTo(String value) {
            addCriterion("role_dis_flag <>", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagGreaterThan(String value) {
            addCriterion("role_dis_flag >", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagGreaterThanOrEqualTo(String value) {
            addCriterion("role_dis_flag >=", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagLessThan(String value) {
            addCriterion("role_dis_flag <", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagLessThanOrEqualTo(String value) {
            addCriterion("role_dis_flag <=", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagLike(String value) {
            addCriterion("role_dis_flag like", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagNotLike(String value) {
            addCriterion("role_dis_flag not like", value, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagIn(List<String> values) {
            addCriterion("role_dis_flag in", values, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagNotIn(List<String> values) {
            addCriterion("role_dis_flag not in", values, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagBetween(String value1, String value2) {
            addCriterion("role_dis_flag between", value1, value2, "roleDisFlag");
            return (Criteria) this;
        }

        public Criteria andRoleDisFlagNotBetween(String value1, String value2) {
            addCriterion("role_dis_flag not between", value1, value2, "roleDisFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_role
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_role
     *
     * @mbggenerated
     */
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