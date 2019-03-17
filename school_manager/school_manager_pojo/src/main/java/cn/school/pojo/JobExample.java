package cn.school.pojo;

import java.util.ArrayList;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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

        public Criteria andJidIsNull() {
            addCriterion("jid is null");
            return (Criteria) this;
        }

        public Criteria andJidIsNotNull() {
            addCriterion("jid is not null");
            return (Criteria) this;
        }

        public Criteria andJidEqualTo(String value) {
            addCriterion("jid =", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotEqualTo(String value) {
            addCriterion("jid <>", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThan(String value) {
            addCriterion("jid >", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThanOrEqualTo(String value) {
            addCriterion("jid >=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThan(String value) {
            addCriterion("jid <", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThanOrEqualTo(String value) {
            addCriterion("jid <=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLike(String value) {
            addCriterion("jid like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotLike(String value) {
            addCriterion("jid not like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidIn(List<String> values) {
            addCriterion("jid in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotIn(List<String> values) {
            addCriterion("jid not in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidBetween(String value1, String value2) {
            addCriterion("jid between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotBetween(String value1, String value2) {
            addCriterion("jid not between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andPostIsNull() {
            addCriterion("post is null");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("post is not null");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(String value) {
            addCriterion("post =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(String value) {
            addCriterion("post <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(String value) {
            addCriterion("post >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(String value) {
            addCriterion("post >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(String value) {
            addCriterion("post <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(String value) {
            addCriterion("post <=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLike(String value) {
            addCriterion("post like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotLike(String value) {
            addCriterion("post not like", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostIn(List<String> values) {
            addCriterion("post in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<String> values) {
            addCriterion("post not in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(String value1, String value2) {
            addCriterion("post between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(String value1, String value2) {
            addCriterion("post not between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andJdescIsNull() {
            addCriterion("jdesc is null");
            return (Criteria) this;
        }

        public Criteria andJdescIsNotNull() {
            addCriterion("jdesc is not null");
            return (Criteria) this;
        }

        public Criteria andJdescEqualTo(String value) {
            addCriterion("jdesc =", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescNotEqualTo(String value) {
            addCriterion("jdesc <>", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescGreaterThan(String value) {
            addCriterion("jdesc >", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescGreaterThanOrEqualTo(String value) {
            addCriterion("jdesc >=", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescLessThan(String value) {
            addCriterion("jdesc <", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescLessThanOrEqualTo(String value) {
            addCriterion("jdesc <=", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescLike(String value) {
            addCriterion("jdesc like", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescNotLike(String value) {
            addCriterion("jdesc not like", value, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescIn(List<String> values) {
            addCriterion("jdesc in", values, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescNotIn(List<String> values) {
            addCriterion("jdesc not in", values, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescBetween(String value1, String value2) {
            addCriterion("jdesc between", value1, value2, "jdesc");
            return (Criteria) this;
        }

        public Criteria andJdescNotBetween(String value1, String value2) {
            addCriterion("jdesc not between", value1, value2, "jdesc");
            return (Criteria) this;
        }

        public Criteria andLowpayIsNull() {
            addCriterion("lowpay is null");
            return (Criteria) this;
        }

        public Criteria andLowpayIsNotNull() {
            addCriterion("lowpay is not null");
            return (Criteria) this;
        }

        public Criteria andLowpayEqualTo(Double value) {
            addCriterion("lowpay =", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayNotEqualTo(Double value) {
            addCriterion("lowpay <>", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayGreaterThan(Double value) {
            addCriterion("lowpay >", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayGreaterThanOrEqualTo(Double value) {
            addCriterion("lowpay >=", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayLessThan(Double value) {
            addCriterion("lowpay <", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayLessThanOrEqualTo(Double value) {
            addCriterion("lowpay <=", value, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayIn(List<Double> values) {
            addCriterion("lowpay in", values, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayNotIn(List<Double> values) {
            addCriterion("lowpay not in", values, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayBetween(Double value1, Double value2) {
            addCriterion("lowpay between", value1, value2, "lowpay");
            return (Criteria) this;
        }

        public Criteria andLowpayNotBetween(Double value1, Double value2) {
            addCriterion("lowpay not between", value1, value2, "lowpay");
            return (Criteria) this;
        }

        public Criteria andHightpayIsNull() {
            addCriterion("hightpay is null");
            return (Criteria) this;
        }

        public Criteria andHightpayIsNotNull() {
            addCriterion("hightpay is not null");
            return (Criteria) this;
        }

        public Criteria andHightpayEqualTo(Double value) {
            addCriterion("hightpay =", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayNotEqualTo(Double value) {
            addCriterion("hightpay <>", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayGreaterThan(Double value) {
            addCriterion("hightpay >", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayGreaterThanOrEqualTo(Double value) {
            addCriterion("hightpay >=", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayLessThan(Double value) {
            addCriterion("hightpay <", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayLessThanOrEqualTo(Double value) {
            addCriterion("hightpay <=", value, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayIn(List<Double> values) {
            addCriterion("hightpay in", values, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayNotIn(List<Double> values) {
            addCriterion("hightpay not in", values, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayBetween(Double value1, Double value2) {
            addCriterion("hightpay between", value1, value2, "hightpay");
            return (Criteria) this;
        }

        public Criteria andHightpayNotBetween(Double value1, Double value2) {
            addCriterion("hightpay not between", value1, value2, "hightpay");
            return (Criteria) this;
        }

        public Criteria andDemandIsNull() {
            addCriterion("demand is null");
            return (Criteria) this;
        }

        public Criteria andDemandIsNotNull() {
            addCriterion("demand is not null");
            return (Criteria) this;
        }

        public Criteria andDemandEqualTo(String value) {
            addCriterion("demand =", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotEqualTo(String value) {
            addCriterion("demand <>", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandGreaterThan(String value) {
            addCriterion("demand >", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandGreaterThanOrEqualTo(String value) {
            addCriterion("demand >=", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLessThan(String value) {
            addCriterion("demand <", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLessThanOrEqualTo(String value) {
            addCriterion("demand <=", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandLike(String value) {
            addCriterion("demand like", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotLike(String value) {
            addCriterion("demand not like", value, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandIn(List<String> values) {
            addCriterion("demand in", values, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotIn(List<String> values) {
            addCriterion("demand not in", values, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandBetween(String value1, String value2) {
            addCriterion("demand between", value1, value2, "demand");
            return (Criteria) this;
        }

        public Criteria andDemandNotBetween(String value1, String value2) {
            addCriterion("demand not between", value1, value2, "demand");
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