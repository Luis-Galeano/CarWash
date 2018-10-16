/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.bean;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static py.com.carwash.ejb.Constantes.*;
import py.com.carwash.ejb.Util.EmailBean;
import py.com.carwash.ejb.dao.QueryDAO;
import py.com.carwash.ejb.dao.ReservasDAO;
import py.com.carwash.ejb.dao.ServiciosVehiculosDAO;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.Reservas;
import py.com.carwash.ejb.model.ReservasExample;
import py.com.carwash.ejb.model.ServiciosVehiculos;
import py.com.carwash.ejb.model.ServiciosVehiculosExample;

/**
 *
 * @author Luis Galeano
 */
@Stateless
public class ReservasBean {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @EJB
    QueryDAO queryDao;
    @Inject
    ReservasDAO reservaDao;
    @Inject
    ServiciosVehiculosDAO svDao;
    @EJB
    EmailBean emailBean;
    
    public GenericResponse registrarReserva(Reservas reserva){
        logger.info("IN: {}",reserva);
        GenericResponse resp = new GenericResponse();
        GenericResponse resp1 = new GenericResponse();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            if (reserva != null){
                logger.info("[INICIANDO REGISTRO DE RESERVA]");
                reserva.setEstadoReserva(1); // estado pendiente
                reservaDao.insertSelective(reserva); //se registra la reserva
                
                ServiciosVehiculosExample svExample = new ServiciosVehiculosExample();
                svExample.createCriteria().andIdServicioVehiculoEqualTo(reserva.getIdServicioVehiculo().intValue());
                ServiciosVehiculos serVehiculo = svDao.selectOneByExample(svExample);
                Map<String,Object> data = queryDao.getVehiculoServicio(serVehiculo.getIdServicio().intValue(), serVehiculo.getIdVehiculo().intValue());
                
                // preparar datos para enviar correo al cliente
                String asunto = "Reserva Carwash";
                String mensaje = "<b>"+reserva.getNombreSolicitante()+"</b> ,<br><br>"+"Su reserva se ha registrado exitosamente. Gracias por su elección.<br><br>Saludos!";
                String to = reserva.getEmailSolicitante();
                String fromAddress = queryDao.getConfigValue(FROM_ADDRESS);
                emailBean.sendEmail(fromAddress, to, asunto, mensaje);
                //preparar datos para enviar correo al admin
                asunto = "Pedido de Reserva";
                mensaje = "El cliente <b>"+reserva.getNombreSolicitante()+"</b> ha solicitado lo siguiente:<br><br>"+
                        "<b>Tipo vehiculo: </b>"+data.get("vehiculo")+"<br>"+
                        "<b>Tipo Servicio: </b>"+data.get("servicio")+"<br>"+
                        "<b>Dia: </b>"+df.format(reserva.getFechaHora())+"<br><br>"+
                        "El precio estimado del trabjo es: <b>"+serVehiculo.getPrecio()+"</b>";
                        
                to = queryDao.getConfigValue(TO_ADDRESS);
                emailBean.sendEmail(fromAddress, to, asunto, mensaje);
                resp.setEstado(ESTADO_EXITO);
                resp.setMensaje(MENSAJE_EXITO);
            }
        } catch (Exception e) {
            resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(MENSAJE_ERROR);
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
    
    public GenericResponse getReservas(){
        GenericResponse resp = new GenericResponse();
        try {
            List<Reservas> reservas = reservaDao.selectByExample(null);
            resp.setDato(reservas);
            resp.setEstado(ESTADO_EXITO);
            resp.setMensaje(MENSAJE_EXITO);
        } catch (Exception e) {
            resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(MENSAJE_ERROR);
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
    
    public GenericResponse eliminarReserva(Integer idReserva){
    	logger.info("IN: {}",idReserva);
        GenericResponse resp = new GenericResponse();
        try {
            reservaDao.deleteByPrimaryKey(idReserva);
            resp.setEstado(ESTADO_EXITO);
            resp.setMensaje(MENSAJE_EXITO);
        } catch (Exception e) {
            resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(MENSAJE_ERROR);
            logger.error("",e);
        }
        logger.info("OUT: {}",resp);
        return resp;
    }
    
    public GenericResponse verificarDisponibilidad(String fechaReserva){
    	logger.info("IN: {}",fechaReserva);
    	GenericResponse resp = new GenericResponse();
    	try {
    		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
    		Date reserva = df.parse(fechaReserva);
    		ReservasExample rExample = new ReservasExample();
    		rExample.createCriteria().andFechaHoraEqualTo(reserva);
    		List<Reservas> reservasList = reservaDao.selectByExample(rExample);
    		int maxReservaManhana = Integer.valueOf(queryDao.getConfigValue(MAX_RESERVA_MANHANA));
    		int maxReservaTarde = Integer.valueOf(queryDao.getConfigValue(MAX_RESERVA_TARDE));
    		int reservaManhana=0;
    		int reservaTarde=0;
    		String disponible="NO";
    		for(Reservas r : reservasList){
    			if (r.getUbicacion().equals("M")){
    				reservaManhana = reservaManhana + r.getEstadoReserva();
    			}
    			else if (r.getUbicacion().equals("T")){
    				reservaTarde = reservaTarde + r.getEstadoReserva();;
    			}
    		}
    		if (reservaManhana < maxReservaManhana & reservaTarde < maxReservaTarde){
    			disponible = "MT";
    		}
    		else if(reservaManhana < maxReservaManhana){
    			disponible = "M";
    		}
    		else if(reservaTarde < maxReservaTarde){
    			disponible = "T";
    		}
    		resp.setDato(disponible);
    		resp.setEstado(ESTADO_EXITO);
            resp.setMensaje(MENSAJE_EXITO);
		} catch (Exception e) {
			resp.setEstado(ESTADO_ERROR);
            resp.setMensaje(MENSAJE_ERROR);
			logger.error("",e);
		}
    	logger.info("OUT: {}",resp);
        return resp;
    }
}
