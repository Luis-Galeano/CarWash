/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.QueryMapper;
import py.com.carwash.ejb.model.Reservas;

/**
 *
 * @author Luis Galeano <luis.galeano@konecta.com.py>
 */
@Stateless
public class QueryDAO {

    @Inject
    @Mapper
    QueryMapper mapper;

    private final Logger logger = LogManager.getLogger(this.getClass());
    
    public String getConfigValue(String param){
        logger.info("IN: {}",param);
        String resp = null;
        try {
            resp = mapper.getConfigValue(param);
        } catch (Exception e) {
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
         
   public Map<String,Object> getVehiculoServicio(Integer idServicio, Integer idVehiculo){
       logger.info("IN: {}, {}",idServicio, idVehiculo);
       Map<String,Object> resp = mapper.getVehiculoServicio(idServicio, idVehiculo);
       logger.info("OUT: {}",resp);
       return resp;
       
   }
   
   public List<Reservas> getReservas(Date fecha, String nombre, String turno,
           String telefono, int offset, int limit){
        logger.info("IN: {}, {}, {}, {}, {}, {}",fecha,nombre,turno,telefono,offset,limit);
        List<Reservas> resp = null;
        try {
            resp = mapper.getReservas(fecha, nombre, turno, telefono,offset,limit);
        } catch (Exception e) {
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
   
   public int getReservasCount(Date fecha, String nombre, String turno,
           String telefono){
        logger.info("IN: {}, {}, {}, {}",fecha,nombre,turno,telefono);
        Integer resp = null;
        try {
            resp = mapper.getReservasCount(fecha, nombre, turno, telefono);
        } catch (Exception e) {
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
}
