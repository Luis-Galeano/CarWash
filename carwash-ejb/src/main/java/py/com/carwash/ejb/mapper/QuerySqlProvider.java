/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.mapper;

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
        
        String sql = "select (select descripcion from servicios\n" +
                     "where id_Servicio=#{idServicio}) as servicio,\n" +
                     "(select nombre from vehiculos\n" +
                     "where id_vehiculo = #{idVehiculo}) as vehiculo";            
        return sql;
    }
    
    
}
