/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.mapper;


import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import py.com.carwash.ejb.model.Reservas;



/**
 *
 * @author Luis Galeano <luis.galeano@konecta.com.py>
 */
public interface QueryMapper {
    
    @SelectProvider(type=QuerySqlProvider.class, method="getConfigValue")
    public String getConfigValue(@Param("param") String param);
    
    @SelectProvider(type=QuerySqlProvider.class, method="getVehiculoServicio")
    public Map<String,Object> getVehiculoServicio(@Param("idServicio") Integer idServicio, @Param("idVehiculo") Integer idVehiculo);
    
    @SelectProvider(type=QuerySqlProvider.class, method="getReservas")
    public List<Reservas> getReservas(@Param("fecha") Date fecha, @Param("nombre") String nombre,
            @Param("turno") String turno, @Param("telefono") String telefono, @Param("offset") int offset,@Param("limit") int limit );
    
    @SelectProvider(type=QuerySqlProvider.class, method="getReservasCount")
    public int getReservasCount(@Param("fecha") Date fecha, @Param("nombre") String nombre,
            @Param("turno") String turno, @Param("telefono") String telefono);
    
}
