/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static py.com.carwash.ejb.Constantes.ESTADO_ERROR;
import static py.com.carwash.ejb.Constantes.ESTADO_EXITO;
import static py.com.carwash.ejb.Constantes.MENSAJE_ERROR;
import static py.com.carwash.ejb.Constantes.MENSAJE_EXITO;
import py.com.carwash.ejb.dao.VehiculosDAO;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.Vehiculos;

/**
 *
 * @author Luis Galeano
 */
@Stateless
public class VehiculosBean {
    
    @Inject
    VehiculosDAO vehiculoDao;
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    
    public GenericResponse getVehiculos(){
        GenericResponse resp = new GenericResponse();
        try {
            List<Vehiculos> servicios = vehiculoDao.selectByExample(null);
            resp.setDato(servicios);
            resp.setMensaje(MENSAJE_EXITO);
            resp.setEstado(ESTADO_EXITO);
        } catch (Exception e) {
            resp.setMensaje(MENSAJE_ERROR);
            resp.setEstado(ESTADO_ERROR);
            logger.error("{}",e);
        }
        logger.info("{}",resp);
        return resp;
    }
}
