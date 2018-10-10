package py.com.carwash.ejb.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import py.com.carwash.ejb.model.Reservas;
import py.com.carwash.ejb.model.ReservasExample.Criteria;
import py.com.carwash.ejb.model.ReservasExample.Criterion;
import py.com.carwash.ejb.model.ReservasExample;

public class ReservasSqlProvider {

    public String countByExample(ReservasExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("reservas");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReservasExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("reservas");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Reservas record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("reservas");
        
        if (record.getIdServicioVehiculo() != null) {
            sql.VALUES("id_servicio_vehiculo", "#{idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getFechaHora() != null) {
            sql.VALUES("fecha_hora", "#{fechaHora,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUbicacion() != null) {
            sql.VALUES("ubicacion", "#{ubicacion,jdbcType=VARCHAR}");
        }
        
        if (record.getNombreSolicitante() != null) {
            sql.VALUES("nombre_solicitante", "#{nombreSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getTelefonoSolicitante() != null) {
            sql.VALUES("telefono_solicitante", "#{telefonoSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailSolicitante() != null) {
            sql.VALUES("email_solicitante", "#{emailSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEstadoReserva() != null) {
            sql.VALUES("estado_reserva", "#{estadoReserva,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ReservasExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_reserva");
        } else {
            sql.SELECT("id_reserva");
        }
        sql.SELECT("id_servicio_vehiculo");
        sql.SELECT("fecha_hora");
        sql.SELECT("ubicacion");
        sql.SELECT("nombre_solicitante");
        sql.SELECT("telefono_solicitante");
        sql.SELECT("email_solicitante");
        sql.SELECT("estado_reserva");
        sql.FROM("reservas");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Reservas record = (Reservas) parameter.get("record");
        ReservasExample example = (ReservasExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("reservas");
        
        if (record.getIdReserva() != null) {
            sql.SET("id_reserva = #{record.idReserva,jdbcType=INTEGER}");
        }
        
        if (record.getIdServicioVehiculo() != null) {
            sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getFechaHora() != null) {
            sql.SET("fecha_hora = #{record.fechaHora,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUbicacion() != null) {
            sql.SET("ubicacion = #{record.ubicacion,jdbcType=VARCHAR}");
        }
        
        if (record.getNombreSolicitante() != null) {
            sql.SET("nombre_solicitante = #{record.nombreSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getTelefonoSolicitante() != null) {
            sql.SET("telefono_solicitante = #{record.telefonoSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailSolicitante() != null) {
            sql.SET("email_solicitante = #{record.emailSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEstadoReserva() != null) {
            sql.SET("estado_reserva = #{record.estadoReserva,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("reservas");
        
        sql.SET("id_reserva = #{record.idReserva,jdbcType=INTEGER}");
        sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=BIGINT}");
        sql.SET("fecha_hora = #{record.fechaHora,jdbcType=TIMESTAMP}");
        sql.SET("ubicacion = #{record.ubicacion,jdbcType=VARCHAR}");
        sql.SET("nombre_solicitante = #{record.nombreSolicitante,jdbcType=VARCHAR}");
        sql.SET("telefono_solicitante = #{record.telefonoSolicitante,jdbcType=VARCHAR}");
        sql.SET("email_solicitante = #{record.emailSolicitante,jdbcType=VARCHAR}");
        sql.SET("estado_reserva = #{record.estadoReserva,jdbcType=INTEGER}");
        
        ReservasExample example = (ReservasExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Reservas record) {
        SQL sql = new SQL();
        sql.UPDATE("reservas");
        
        if (record.getIdServicioVehiculo() != null) {
            sql.SET("id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getFechaHora() != null) {
            sql.SET("fecha_hora = #{fechaHora,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUbicacion() != null) {
            sql.SET("ubicacion = #{ubicacion,jdbcType=VARCHAR}");
        }
        
        if (record.getNombreSolicitante() != null) {
            sql.SET("nombre_solicitante = #{nombreSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getTelefonoSolicitante() != null) {
            sql.SET("telefono_solicitante = #{telefonoSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailSolicitante() != null) {
            sql.SET("email_solicitante = #{emailSolicitante,jdbcType=VARCHAR}");
        }
        
        if (record.getEstadoReserva() != null) {
            sql.SET("estado_reserva = #{estadoReserva,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id_reserva = #{idReserva,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReservasExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}