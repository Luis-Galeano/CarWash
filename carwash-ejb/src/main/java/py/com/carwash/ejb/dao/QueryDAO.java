/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.dao;

import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;
import py.com.carwash.ejb.mapper.QueryMapper;

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
       return mapper.getVehiculoServicio(idServicio, idVehiculo);
   }
}
