package py.com.carwash.ejb.model;

import java.util.ArrayList;
import java.util.List;

public class ServiciosVehiculosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiciosVehiculosExample() {
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

        public Criteria andIdServicioVehiculoIsNull() {
            addCriterion("id_servicio_vehiculo is null");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoIsNotNull() {
            addCriterion("id_servicio_vehiculo is not null");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoEqualTo(Integer value) {
            addCriterion("id_servicio_vehiculo =", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotEqualTo(Integer value) {
            addCriterion("id_servicio_vehiculo <>", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoGreaterThan(Integer value) {
            addCriterion("id_servicio_vehiculo >", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_servicio_vehiculo >=", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoLessThan(Integer value) {
            addCriterion("id_servicio_vehiculo <", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoLessThanOrEqualTo(Integer value) {
            addCriterion("id_servicio_vehiculo <=", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoIn(List<Integer> values) {
            addCriterion("id_servicio_vehiculo in", values, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotIn(List<Integer> values) {
            addCriterion("id_servicio_vehiculo not in", values, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoBetween(Integer value1, Integer value2) {
            addCriterion("id_servicio_vehiculo between", value1, value2, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotBetween(Integer value1, Integer value2) {
            addCriterion("id_servicio_vehiculo not between", value1, value2, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioIsNull() {
            addCriterion("id_servicio is null");
            return (Criteria) this;
        }

        public Criteria andIdServicioIsNotNull() {
            addCriterion("id_servicio is not null");
            return (Criteria) this;
        }

        public Criteria andIdServicioEqualTo(Long value) {
            addCriterion("id_servicio =", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioNotEqualTo(Long value) {
            addCriterion("id_servicio <>", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioGreaterThan(Long value) {
            addCriterion("id_servicio >", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioGreaterThanOrEqualTo(Long value) {
            addCriterion("id_servicio >=", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioLessThan(Long value) {
            addCriterion("id_servicio <", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioLessThanOrEqualTo(Long value) {
            addCriterion("id_servicio <=", value, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioIn(List<Long> values) {
            addCriterion("id_servicio in", values, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioNotIn(List<Long> values) {
            addCriterion("id_servicio not in", values, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioBetween(Long value1, Long value2) {
            addCriterion("id_servicio between", value1, value2, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdServicioNotBetween(Long value1, Long value2) {
            addCriterion("id_servicio not between", value1, value2, "idServicio");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIsNull() {
            addCriterion("id_vehiculo is null");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIsNotNull() {
            addCriterion("id_vehiculo is not null");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoEqualTo(Long value) {
            addCriterion("id_vehiculo =", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotEqualTo(Long value) {
            addCriterion("id_vehiculo <>", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoGreaterThan(Long value) {
            addCriterion("id_vehiculo >", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoGreaterThanOrEqualTo(Long value) {
            addCriterion("id_vehiculo >=", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoLessThan(Long value) {
            addCriterion("id_vehiculo <", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoLessThanOrEqualTo(Long value) {
            addCriterion("id_vehiculo <=", value, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoIn(List<Long> values) {
            addCriterion("id_vehiculo in", values, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotIn(List<Long> values) {
            addCriterion("id_vehiculo not in", values, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoBetween(Long value1, Long value2) {
            addCriterion("id_vehiculo between", value1, value2, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdVehiculoNotBetween(Long value1, Long value2) {
            addCriterion("id_vehiculo not between", value1, value2, "idVehiculo");
            return (Criteria) this;
        }

        public Criteria andPrecioIsNull() {
            addCriterion("precio is null");
            return (Criteria) this;
        }

        public Criteria andPrecioIsNotNull() {
            addCriterion("precio is not null");
            return (Criteria) this;
        }

        public Criteria andPrecioEqualTo(Integer value) {
            addCriterion("precio =", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioNotEqualTo(Integer value) {
            addCriterion("precio <>", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioGreaterThan(Integer value) {
            addCriterion("precio >", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioGreaterThanOrEqualTo(Integer value) {
            addCriterion("precio >=", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioLessThan(Integer value) {
            addCriterion("precio <", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioLessThanOrEqualTo(Integer value) {
            addCriterion("precio <=", value, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioIn(List<Integer> values) {
            addCriterion("precio in", values, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioNotIn(List<Integer> values) {
            addCriterion("precio not in", values, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioBetween(Integer value1, Integer value2) {
            addCriterion("precio between", value1, value2, "precio");
            return (Criteria) this;
        }

        public Criteria andPrecioNotBetween(Integer value1, Integer value2) {
            addCriterion("precio not between", value1, value2, "precio");
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