package py.com.carwash.ejb.model;

import java.util.ArrayList;
import java.util.List;

public class ReservasDetallesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservasDetallesExample() {
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

        public Criteria andIdReservaDetalleIsNull() {
            addCriterion("id_reserva_detalle is null");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleIsNotNull() {
            addCriterion("id_reserva_detalle is not null");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleEqualTo(Integer value) {
            addCriterion("id_reserva_detalle =", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleNotEqualTo(Integer value) {
            addCriterion("id_reserva_detalle <>", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleGreaterThan(Integer value) {
            addCriterion("id_reserva_detalle >", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_reserva_detalle >=", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleLessThan(Integer value) {
            addCriterion("id_reserva_detalle <", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleLessThanOrEqualTo(Integer value) {
            addCriterion("id_reserva_detalle <=", value, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleIn(List<Integer> values) {
            addCriterion("id_reserva_detalle in", values, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleNotIn(List<Integer> values) {
            addCriterion("id_reserva_detalle not in", values, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleBetween(Integer value1, Integer value2) {
            addCriterion("id_reserva_detalle between", value1, value2, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdReservaDetalleNotBetween(Integer value1, Integer value2) {
            addCriterion("id_reserva_detalle not between", value1, value2, "idReservaDetalle");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoIsNull() {
            addCriterion("id_servicio_vehiculo is null");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoIsNotNull() {
            addCriterion("id_servicio_vehiculo is not null");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoEqualTo(Long value) {
            addCriterion("id_servicio_vehiculo =", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotEqualTo(Long value) {
            addCriterion("id_servicio_vehiculo <>", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoGreaterThan(Long value) {
            addCriterion("id_servicio_vehiculo >", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoGreaterThanOrEqualTo(Long value) {
            addCriterion("id_servicio_vehiculo >=", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoLessThan(Long value) {
            addCriterion("id_servicio_vehiculo <", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoLessThanOrEqualTo(Long value) {
            addCriterion("id_servicio_vehiculo <=", value, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoIn(List<Long> values) {
            addCriterion("id_servicio_vehiculo in", values, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotIn(List<Long> values) {
            addCriterion("id_servicio_vehiculo not in", values, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoBetween(Long value1, Long value2) {
            addCriterion("id_servicio_vehiculo between", value1, value2, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andIdServicioVehiculoNotBetween(Long value1, Long value2) {
            addCriterion("id_servicio_vehiculo not between", value1, value2, "idServicioVehiculo");
            return (Criteria) this;
        }

        public Criteria andCantidadIsNull() {
            addCriterion("cantidad is null");
            return (Criteria) this;
        }

        public Criteria andCantidadIsNotNull() {
            addCriterion("cantidad is not null");
            return (Criteria) this;
        }

        public Criteria andCantidadEqualTo(Integer value) {
            addCriterion("cantidad =", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadNotEqualTo(Integer value) {
            addCriterion("cantidad <>", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadGreaterThan(Integer value) {
            addCriterion("cantidad >", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadGreaterThanOrEqualTo(Integer value) {
            addCriterion("cantidad >=", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadLessThan(Integer value) {
            addCriterion("cantidad <", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadLessThanOrEqualTo(Integer value) {
            addCriterion("cantidad <=", value, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadIn(List<Integer> values) {
            addCriterion("cantidad in", values, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadNotIn(List<Integer> values) {
            addCriterion("cantidad not in", values, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadBetween(Integer value1, Integer value2) {
            addCriterion("cantidad between", value1, value2, "cantidad");
            return (Criteria) this;
        }

        public Criteria andCantidadNotBetween(Integer value1, Integer value2) {
            addCriterion("cantidad not between", value1, value2, "cantidad");
            return (Criteria) this;
        }

        public Criteria andPreccioIsNull() {
            addCriterion("preccio is null");
            return (Criteria) this;
        }

        public Criteria andPreccioIsNotNull() {
            addCriterion("preccio is not null");
            return (Criteria) this;
        }

        public Criteria andPreccioEqualTo(Integer value) {
            addCriterion("preccio =", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioNotEqualTo(Integer value) {
            addCriterion("preccio <>", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioGreaterThan(Integer value) {
            addCriterion("preccio >", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioGreaterThanOrEqualTo(Integer value) {
            addCriterion("preccio >=", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioLessThan(Integer value) {
            addCriterion("preccio <", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioLessThanOrEqualTo(Integer value) {
            addCriterion("preccio <=", value, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioIn(List<Integer> values) {
            addCriterion("preccio in", values, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioNotIn(List<Integer> values) {
            addCriterion("preccio not in", values, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioBetween(Integer value1, Integer value2) {
            addCriterion("preccio between", value1, value2, "preccio");
            return (Criteria) this;
        }

        public Criteria andPreccioNotBetween(Integer value1, Integer value2) {
            addCriterion("preccio not between", value1, value2, "preccio");
            return (Criteria) this;
        }

        public Criteria andIdReservaIsNull() {
            addCriterion("id_reserva is null");
            return (Criteria) this;
        }

        public Criteria andIdReservaIsNotNull() {
            addCriterion("id_reserva is not null");
            return (Criteria) this;
        }

        public Criteria andIdReservaEqualTo(Long value) {
            addCriterion("id_reserva =", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotEqualTo(Long value) {
            addCriterion("id_reserva <>", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaGreaterThan(Long value) {
            addCriterion("id_reserva >", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaGreaterThanOrEqualTo(Long value) {
            addCriterion("id_reserva >=", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaLessThan(Long value) {
            addCriterion("id_reserva <", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaLessThanOrEqualTo(Long value) {
            addCriterion("id_reserva <=", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaIn(List<Long> values) {
            addCriterion("id_reserva in", values, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotIn(List<Long> values) {
            addCriterion("id_reserva not in", values, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaBetween(Long value1, Long value2) {
            addCriterion("id_reserva between", value1, value2, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotBetween(Long value1, Long value2) {
            addCriterion("id_reserva not between", value1, value2, "idReserva");
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