/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.web.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static py.com.carwash.ejb.Constantes.DEFAULT_COUNT;
import static py.com.carwash.ejb.Constantes.DEFAULT_PAGE;

import py.com.carwash.ejb.bean.ReservasBean;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.ReservasRequest;

/**
 *
 * @author Luis Galeano
 */
@Path("reservas")
public class ReservasResource {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @EJB
    ReservasBean reservaBean;
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registrar")
    public GenericResponse registrarReserva(ReservasRequest reservaRequest){
        return reservaBean.registrarReserva(reservaRequest);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse getReservas(@QueryParam("page") int offset,
            @QueryParam("count") int limit, @QueryParam("fecha") String fechaStr,
            @QueryParam("nombre") String nombre,@QueryParam("turno") String turno,
            @QueryParam("telefono") String telefono){
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date fecha = null;
        try {
            if(fechaStr != null){
                fecha = df.parse(fechaStr);
            }
        } catch (ParseException ex) {
            logger.error("",ex);
        }
        if (offset == 0 ){
            offset = DEFAULT_PAGE;  
        }
        if (limit == 0){
            limit= DEFAULT_COUNT;
        }
        offset = (offset-1)*limit;
        return reservaBean.getReservas(fecha,nombre,turno,telefono,offset,limit);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar")
    public GenericResponse eliminarReserva(@QueryParam("idReserva") int idReserva){
        return reservaBean.eliminarReserva(idReserva);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("verificar")
    public GenericResponse verificarReserva(@QueryParam("fecha") String fecha){
        return reservaBean.verificarDisponibilidad(fecha);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("detalles")
    public GenericResponse obtenerDetalles(@QueryParam("idReserva") long idReserva){
        return reservaBean.obtenerDetallesReserva(idReserva);
    }
}
