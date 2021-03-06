/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.web.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import py.com.carwash.ejb.bean.ServiciosBean;
import py.com.carwash.ejb.dto.GenericResponse;

/**
 *
 * @author Luis Galeano
 */
@Path("servicios")
public class ServiciosResource {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @EJB
    ServiciosBean servicioBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse getServicios(){
        return servicioBean.getServicios();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("precio")
    public GenericResponse getPrecioServicioPorVehiculo(@QueryParam("idServicio") long idServicio,
            @QueryParam("idVehiculo") long idVehiculo,@QueryParam("cantidad") int cantidad){
        return servicioBean.getPrecioServicioPorVehiculo(idServicio,idVehiculo,cantidad);
    }
    
}
