package py.com.carwash.ejb.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import py.com.carwash.ejb.model.ReservasDetalles;
import py.com.carwash.ejb.model.ReservasDetallesExample.Criteria;
import py.com.carwash.ejb.model.ReservasDetallesExample.Criterion;
import py.com.carwash.ejb.model.ReservasDetallesExample;

public class ReservasDetallesSqlProvider {

    public String countByExample(ReservasDetallesExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("reservas_detalles");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReservasDetallesExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("reservas_detalles");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReservasDetalles record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("reservas_detalles");
        
        if (record.getIdServicioVehiculo() != null) {
            sql.VALUES("id_servicio_vehiculo", "#{idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getCantidad() != null) {
            sql.VALUES("cantidad", "#{cantidad,jdbcType=INTEGER}");
        }
        
        if (record.getPreccio() != null) {
            sql.VALUES("preccio", "#{preccio,jdbcType=INTEGER}");
        }
        
        if (record.getIdReserva() != null) {
            sql.VALUES("id_reserva", "#{idReserva,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ReservasDetallesExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_reserva_detalle");
        } else {
            sql.SELECT("id_reserva_detalle");
        }
        sql.SELECT("id_servicio_vehiculo");
        sql.SELECT("cantidad");
        sql.SELECT("preccio");
        sql.SELECT("id_reserva");
        sql.FROM("reservas_detalles");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReservasDetalles record = (ReservasDetalles) parameter.get("record");
        ReservasDetallesExample example = (ReservasDetallesExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("reservas_detalles");
        
        if (record.getIdReservaDetalle() != null) {
            sql.SET("id_reserva_detalle = #{record.idReservaDetalle,jdbcType=INTEGER}");
        }
        
        if (record.getIdServicioVehiculo() != null) {
            sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getCantidad() != null) {
            sql.SET("cantidad = #{record.cantidad,jdbcType=INTEGER}");
        }
        
        if (record.getPreccio() != null) {
            sql.SET("preccio = #{record.preccio,jdbcType=INTEGER}");
        }
        
        if (record.getIdReserva() != null) {
            sql.SET("id_reserva = #{record.idReserva,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("reservas_detalles");
        
        sql.SET("id_reserva_detalle = #{record.idReservaDetalle,jdbcType=INTEGER}");
        sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=BIGINT}");
        sql.SET("cantidad = #{record.cantidad,jdbcType=INTEGER}");
        sql.SET("preccio = #{record.preccio,jdbcType=INTEGER}");
        sql.SET("id_reserva = #{record.idReserva,jdbcType=BIGINT}");
        
        ReservasDetallesExample example = (ReservasDetallesExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReservasDetalles record) {
        SQL sql = new SQL();
        sql.UPDATE("reservas_detalles");
        
        if (record.getIdServicioVehiculo() != null) {
            sql.SET("id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getCantidad() != null) {
            sql.SET("cantidad = #{cantidad,jdbcType=INTEGER}");
        }
        
        if (record.getPreccio() != null) {
            sql.SET("preccio = #{preccio,jdbcType=INTEGER}");
        }
        
        if (record.getIdReserva() != null) {
            sql.SET("id_reserva = #{idReserva,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id_reserva_detalle = #{idReservaDetalle,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReservasDetallesExample example, boolean includeExamplePhrase) {
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