/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.mapper;

import java.util.Date;
import java.util.Map;


/**
 *
 * @author Luis Galeano <luis.galeano@konecta.com.py>
 */
public class QuerySqlProvider {
    
   
    public String getConfigValue(Map<String, Object> parameters){
        
        String sql = "select C.valor from configuraciones C JOIN\n" +
                     "parametros P on C.id_parametro = P.id_parametro\n" +
                     "where P.descripcion =#{param}";            
        return sql;
    }
    
    public String getVehiculoServicio(){
        
        String sql = "select (select nombre from servicios\n" +
                     "where id_Servicio=#{idServicio}) as servicio,\n" +
                     "(select nombre from vehiculos\n" +
                     "where id_vehiculo = #{idVehiculo}) as vehiculo";            
        return sql;
    }
    
    public String getReservas(Map<String, Object> parameters){
        
        Date fecha = (Date)parameters.get("fecha");
        String nombre = (String)parameters.get("nombre");
        String turno = (String)parameters.get("turno");
        String telefono = (String)parameters.get("telefono");
        
        String sql = "select * from reservas\n" +
                     "where true\n";
        if (fecha != null){
            sql= sql+"and fecha = #{fecha}\n";
        }
        if(nombre != null){
            sql= sql+"and LOWER(nombre_solicitante) like LOWER('%"+nombre+"%')\n";
        }  
        if(turno != null){
            sql= sql+"and turno = #{turno}\n";
        }
        if(telefono != null){
            sql= sql+"and telefono_solicitante = #{telefono}\n";
        }
        sql = sql+"ORDER BY fecha ASC\n";
        sql=sql+ "LIMIT #{limit}\n"
               + "OFFSET #{offset}\n";
       
        return sql;
    }
    
    public String getReservasCount(Map<String, Object> parameters){
        
        Date fecha = (Date)parameters.get("fecha");
        String nombre = (String)parameters.get("nombre");
        String turno = (String)parameters.get("turno");
        String telefono = (String)parameters.get("telefono");
        
        String sql = "select count(*) from reservas\n" +
                     "where true\n";
        if (fecha != null){
            sql= sql+"and fecha = #{fecha}\n";
        }
        if(nombre != null){
            sql= sql+"and LOWER(nombre_solicitante) like LOWER('%"+nombre+"%')\n";
        }   
        if(turno != null){
            sql= sql+"and turno = #{turno}\n";
        }
        if(telefono != null){
            sql= sql+"and telefono_solicitante = #{telefono}\n";
        }
        return sql;
    }
    
    
    
    
}
