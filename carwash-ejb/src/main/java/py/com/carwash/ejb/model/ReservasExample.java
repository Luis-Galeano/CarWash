package py.com.carwash.ejb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReservasExample() {
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

        public Criteria andIdReservaIsNull() {
            addCriterion("id_reserva is null");
            return (Criteria) this;
        }

        public Criteria andIdReservaIsNotNull() {
            addCriterion("id_reserva is not null");
            return (Criteria) this;
        }

        public Criteria andIdReservaEqualTo(Integer value) {
            addCriterion("id_reserva =", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotEqualTo(Integer value) {
            addCriterion("id_reserva <>", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaGreaterThan(Integer value) {
            addCriterion("id_reserva >", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_reserva >=", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaLessThan(Integer value) {
            addCriterion("id_reserva <", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaLessThanOrEqualTo(Integer value) {
            addCriterion("id_reserva <=", value, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaIn(List<Integer> values) {
            addCriterion("id_reserva in", values, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotIn(List<Integer> values) {
            addCriterion("id_reserva not in", values, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaBetween(Integer value1, Integer value2) {
            addCriterion("id_reserva between", value1, value2, "idReserva");
            return (Criteria) this;
        }

        public Criteria andIdReservaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_reserva not between", value1, value2, "idReserva");
            return (Criteria) this;
        }

        public Criteria andFechaIsNull() {
            addCriterion("fecha is null");
            return (Criteria) this;
        }

        public Criteria andFechaIsNotNull() {
            addCriterion("fecha is not null");
            return (Criteria) this;
        }

        public Criteria andFechaEqualTo(Date value) {
            addCriterion("fecha =", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotEqualTo(Date value) {
            addCriterion("fecha <>", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThan(Date value) {
            addCriterion("fecha >", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha >=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThan(Date value) {
            addCriterion("fecha <", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaLessThanOrEqualTo(Date value) {
            addCriterion("fecha <=", value, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaIn(List<Date> values) {
            addCriterion("fecha in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotIn(List<Date> values) {
            addCriterion("fecha not in", values, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaBetween(Date value1, Date value2) {
            addCriterion("fecha between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andFechaNotBetween(Date value1, Date value2) {
            addCriterion("fecha not between", value1, value2, "fecha");
            return (Criteria) this;
        }

        public Criteria andUbicacionIsNull() {
            addCriterion("ubicacion is null");
            return (Criteria) this;
        }

        public Criteria andUbicacionIsNotNull() {
            addCriterion("ubicacion is not null");
            return (Criteria) this;
        }

        public Criteria andUbicacionEqualTo(String value) {
            addCriterion("ubicacion =", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionNotEqualTo(String value) {
            addCriterion("ubicacion <>", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionGreaterThan(String value) {
            addCriterion("ubicacion >", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionGreaterThanOrEqualTo(String value) {
            addCriterion("ubicacion >=", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionLessThan(String value) {
            addCriterion("ubicacion <", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionLessThanOrEqualTo(String value) {
            addCriterion("ubicacion <=", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionLike(String value) {
            addCriterion("ubicacion like", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionNotLike(String value) {
            addCriterion("ubicacion not like", value, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionIn(List<String> values) {
            addCriterion("ubicacion in", values, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionNotIn(List<String> values) {
            addCriterion("ubicacion not in", values, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionBetween(String value1, String value2) {
            addCriterion("ubicacion between", value1, value2, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andUbicacionNotBetween(String value1, String value2) {
            addCriterion("ubicacion not between", value1, value2, "ubicacion");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteIsNull() {
            addCriterion("nombre_solicitante is null");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteIsNotNull() {
            addCriterion("nombre_solicitante is not null");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteEqualTo(String value) {
            addCriterion("nombre_solicitante =", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteNotEqualTo(String value) {
            addCriterion("nombre_solicitante <>", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteGreaterThan(String value) {
            addCriterion("nombre_solicitante >", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteGreaterThanOrEqualTo(String value) {
            addCriterion("nombre_solicitante >=", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteLessThan(String value) {
            addCriterion("nombre_solicitante <", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteLessThanOrEqualTo(String value) {
            addCriterion("nombre_solicitante <=", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteLike(String value) {
            addCriterion("nombre_solicitante like", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteNotLike(String value) {
            addCriterion("nombre_solicitante not like", value, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteIn(List<String> values) {
            addCriterion("nombre_solicitante in", values, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteNotIn(List<String> values) {
            addCriterion("nombre_solicitante not in", values, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteBetween(String value1, String value2) {
            addCriterion("nombre_solicitante between", value1, value2, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andNombreSolicitanteNotBetween(String value1, String value2) {
            addCriterion("nombre_solicitante not between", value1, value2, "nombreSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteIsNull() {
            addCriterion("telefono_solicitante is null");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteIsNotNull() {
            addCriterion("telefono_solicitante is not null");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteEqualTo(String value) {
            addCriterion("telefono_solicitante =", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteNotEqualTo(String value) {
            addCriterion("telefono_solicitante <>", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteGreaterThan(String value) {
            addCriterion("telefono_solicitante >", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteGreaterThanOrEqualTo(String value) {
            addCriterion("telefono_solicitante >=", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteLessThan(String value) {
            addCriterion("telefono_solicitante <", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteLessThanOrEqualTo(String value) {
            addCriterion("telefono_solicitante <=", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteLike(String value) {
            addCriterion("telefono_solicitante like", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteNotLike(String value) {
            addCriterion("telefono_solicitante not like", value, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteIn(List<String> values) {
            addCriterion("telefono_solicitante in", values, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteNotIn(List<String> values) {
            addCriterion("telefono_solicitante not in", values, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteBetween(String value1, String value2) {
            addCriterion("telefono_solicitante between", value1, value2, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andTelefonoSolicitanteNotBetween(String value1, String value2) {
            addCriterion("telefono_solicitante not between", value1, value2, "telefonoSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteIsNull() {
            addCriterion("email_solicitante is null");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteIsNotNull() {
            addCriterion("email_solicitante is not null");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteEqualTo(String value) {
            addCriterion("email_solicitante =", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteNotEqualTo(String value) {
            addCriterion("email_solicitante <>", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteGreaterThan(String value) {
            addCriterion("email_solicitante >", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteGreaterThanOrEqualTo(String value) {
            addCriterion("email_solicitante >=", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteLessThan(String value) {
            addCriterion("email_solicitante <", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteLessThanOrEqualTo(String value) {
            addCriterion("email_solicitante <=", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteLike(String value) {
            addCriterion("email_solicitante like", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteNotLike(String value) {
            addCriterion("email_solicitante not like", value, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteIn(List<String> values) {
            addCriterion("email_solicitante in", values, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteNotIn(List<String> values) {
            addCriterion("email_solicitante not in", values, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteBetween(String value1, String value2) {
            addCriterion("email_solicitante between", value1, value2, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEmailSolicitanteNotBetween(String value1, String value2) {
            addCriterion("email_solicitante not between", value1, value2, "emailSolicitante");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaIsNull() {
            addCriterion("estado_reserva is null");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaIsNotNull() {
            addCriterion("estado_reserva is not null");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaEqualTo(Integer value) {
            addCriterion("estado_reserva =", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaNotEqualTo(Integer value) {
            addCriterion("estado_reserva <>", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaGreaterThan(Integer value) {
            addCriterion("estado_reserva >", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaGreaterThanOrEqualTo(Integer value) {
            addCriterion("estado_reserva >=", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaLessThan(Integer value) {
            addCriterion("estado_reserva <", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaLessThanOrEqualTo(Integer value) {
            addCriterion("estado_reserva <=", value, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaIn(List<Integer> values) {
            addCriterion("estado_reserva in", values, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaNotIn(List<Integer> values) {
            addCriterion("estado_reserva not in", values, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaBetween(Integer value1, Integer value2) {
            addCriterion("estado_reserva between", value1, value2, "estadoReserva");
            return (Criteria) this;
        }

        public Criteria andEstadoReservaNotBetween(Integer value1, Integer value2) {
            addCriterion("estado_reserva not between", value1, value2, "estadoReserva");
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

        public Criteria andTurnoIsNull() {
            addCriterion("turno is null");
            return (Criteria) this;
        }

        public Criteria andTurnoIsNotNull() {
            addCriterion("turno is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoEqualTo(String value) {
            addCriterion("turno =", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoNotEqualTo(String value) {
            addCriterion("turno <>", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoGreaterThan(String value) {
            addCriterion("turno >", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoGreaterThanOrEqualTo(String value) {
            addCriterion("turno >=", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoLessThan(String value) {
            addCriterion("turno <", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoLessThanOrEqualTo(String value) {
            addCriterion("turno <=", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoLike(String value) {
            addCriterion("turno like", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoNotLike(String value) {
            addCriterion("turno not like", value, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoIn(List<String> values) {
            addCriterion("turno in", values, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoNotIn(List<String> values) {
            addCriterion("turno not in", values, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoBetween(String value1, String value2) {
            addCriterion("turno between", value1, value2, "turno");
            return (Criteria) this;
        }

        public Criteria andTurnoNotBetween(String value1, String value2) {
            addCriterion("turno not between", value1, value2, "turno");
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

        public Criteria andFechaSolicitudIsNull() {
            addCriterion("fecha_solicitud is null");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudIsNotNull() {
            addCriterion("fecha_solicitud is not null");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudEqualTo(Date value) {
            addCriterion("fecha_solicitud =", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudNotEqualTo(Date value) {
            addCriterion("fecha_solicitud <>", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudGreaterThan(Date value) {
            addCriterion("fecha_solicitud >", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudGreaterThanOrEqualTo(Date value) {
            addCriterion("fecha_solicitud >=", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudLessThan(Date value) {
            addCriterion("fecha_solicitud <", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudLessThanOrEqualTo(Date value) {
            addCriterion("fecha_solicitud <=", value, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudIn(List<Date> values) {
            addCriterion("fecha_solicitud in", values, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudNotIn(List<Date> values) {
            addCriterion("fecha_solicitud not in", values, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudBetween(Date value1, Date value2) {
            addCriterion("fecha_solicitud between", value1, value2, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andFechaSolicitudNotBetween(Date value1, Date value2) {
            addCriterion("fecha_solicitud not between", value1, value2, "fechaSolicitud");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNull() {
            addCriterion("observaciones is null");
            return (Criteria) this;
        }

        public Criteria andObservacionesIsNotNull() {
            addCriterion("observaciones is not null");
            return (Criteria) this;
        }

        public Criteria andObservacionesEqualTo(String value) {
            addCriterion("observaciones =", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotEqualTo(String value) {
            addCriterion("observaciones <>", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThan(String value) {
            addCriterion("observaciones >", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesGreaterThanOrEqualTo(String value) {
            addCriterion("observaciones >=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThan(String value) {
            addCriterion("observaciones <", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLessThanOrEqualTo(String value) {
            addCriterion("observaciones <=", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesLike(String value) {
            addCriterion("observaciones like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotLike(String value) {
            addCriterion("observaciones not like", value, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesIn(List<String> values) {
            addCriterion("observaciones in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotIn(List<String> values) {
            addCriterion("observaciones not in", values, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesBetween(String value1, String value2) {
            addCriterion("observaciones between", value1, value2, "observaciones");
            return (Criteria) this;
        }

        public Criteria andObservacionesNotBetween(String value1, String value2) {
            addCriterion("observaciones not between", value1, value2, "observaciones");
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