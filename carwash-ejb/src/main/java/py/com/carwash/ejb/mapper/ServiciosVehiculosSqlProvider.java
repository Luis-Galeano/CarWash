package py.com.carwash.ejb.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import py.com.carwash.ejb.model.ServiciosVehiculos;
import py.com.carwash.ejb.model.ServiciosVehiculosExample.Criteria;
import py.com.carwash.ejb.model.ServiciosVehiculosExample.Criterion;
import py.com.carwash.ejb.model.ServiciosVehiculosExample;

public class ServiciosVehiculosSqlProvider {

    public String countByExample(ServiciosVehiculosExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("servicios_vehiculos");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ServiciosVehiculosExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("servicios_vehiculos");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ServiciosVehiculos record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("servicios_vehiculos");
        
        if (record.getIdServicio() != null) {
            sql.VALUES("id_servicio", "#{idServicio,jdbcType=BIGINT}");
        }
        
        if (record.getIdVehiculo() != null) {
            sql.VALUES("id_vehiculo", "#{idVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getPrecio() != null) {
            sql.VALUES("precio", "#{precio,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ServiciosVehiculosExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_servicio_vehiculo");
        } else {
            sql.SELECT("id_servicio_vehiculo");
        }
        sql.SELECT("id_servicio");
        sql.SELECT("id_vehiculo");
        sql.SELECT("precio");
        sql.FROM("servicios_vehiculos");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ServiciosVehiculos record = (ServiciosVehiculos) parameter.get("record");
        ServiciosVehiculosExample example = (ServiciosVehiculosExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("servicios_vehiculos");
        
        if (record.getIdServicioVehiculo() != null) {
            sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=INTEGER}");
        }
        
        if (record.getIdServicio() != null) {
            sql.SET("id_servicio = #{record.idServicio,jdbcType=BIGINT}");
        }
        
        if (record.getIdVehiculo() != null) {
            sql.SET("id_vehiculo = #{record.idVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getPrecio() != null) {
            sql.SET("precio = #{record.precio,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("servicios_vehiculos");
        
        sql.SET("id_servicio_vehiculo = #{record.idServicioVehiculo,jdbcType=INTEGER}");
        sql.SET("id_servicio = #{record.idServicio,jdbcType=BIGINT}");
        sql.SET("id_vehiculo = #{record.idVehiculo,jdbcType=BIGINT}");
        sql.SET("precio = #{record.precio,jdbcType=INTEGER}");
        
        ServiciosVehiculosExample example = (ServiciosVehiculosExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ServiciosVehiculos record) {
        SQL sql = new SQL();
        sql.UPDATE("servicios_vehiculos");
        
        if (record.getIdServicio() != null) {
            sql.SET("id_servicio = #{idServicio,jdbcType=BIGINT}");
        }
        
        if (record.getIdVehiculo() != null) {
            sql.SET("id_vehiculo = #{idVehiculo,jdbcType=BIGINT}");
        }
        
        if (record.getPrecio() != null) {
            sql.SET("precio = #{precio,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id_servicio_vehiculo = #{idServicioVehiculo,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ServiciosVehiculosExample example, boolean includeExamplePhrase) {
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