/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.bean;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
import py.com.carwash.ejb.dao.ReservasDetallesDAO;
import py.com.carwash.ejb.dao.ServiciosDAO;
import py.com.carwash.ejb.dao.ServiciosVehiculosDAO;
import py.com.carwash.ejb.dao.VehiculosDAO;
import py.com.carwash.ejb.dto.GenericResponse;
import py.com.carwash.ejb.model.Reservas;
import py.com.carwash.ejb.model.ReservasDetalles;
import py.com.carwash.ejb.model.ReservasDetallesExample;
import py.com.carwash.ejb.model.ReservasExample;
import py.com.carwash.ejb.model.ReservasRequest;
import py.com.carwash.ejb.model.Servicios;
import py.com.carwash.ejb.model.ServiciosExample;
import py.com.carwash.ejb.model.ServiciosVehiculos;
import py.com.carwash.ejb.model.ServiciosVehiculosExample;
import py.com.carwash.ejb.model.Vehiculos;
import py.com.carwash.ejb.model.VehiculosExample;

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
    ReservasDetallesDAO reservaDetalleDao;
    @Inject
    ServiciosVehiculosDAO svDao;
    @Inject
    ServiciosDAO servicioDao;
    @Inject
    VehiculosDAO vehiculoDao;
    @EJB
    EmailBean emailBean;
    
    public GenericResponse registrarReserva(ReservasRequest reservaRequest){
        logger.info("IN: {}",reservaRequest);
        GenericResponse resp = new GenericResponse();
        GenericResponse resp1 = new GenericResponse();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
   
        try {
            if (reservaRequest != null){
                logger.info("[INICIANDO REGISTRO DE RESERVA]");
                
                Reservas cabecera = reservaRequest.getCabecera();
                cabecera.setEstadoReserva(1); // estado pendiente
                cabecera.setFechaSolicitud(Calendar.getInstance().getTime());
                //agregar reserva cabecera
                reservaDao.insertSelective(cabecera); 
                // agregar detalles de la reserva
                String detalle="";
                for (ReservasDetalles d : reservaRequest.getDetalles()){
                    d.setIdReserva(cabecera.getIdReserva().longValue());
                    ServiciosVehiculosExample svexample = new ServiciosVehiculosExample();
                    svexample.createCriteria().andIdServicioVehiculoEqualTo(d.getIdServicioVehiculo()
                    .intValue());
                    ServiciosVehiculos sv = svDao.selectOneByExample(svexample);
                    Map<String,Object> mapDetalle = queryDao.getVehiculoServicio(sv.getIdServicio().intValue(),sv.getIdVehiculo().intValue());
                    detalle = detalle + "<b>Servicio: </b>"+mapDetalle.get("servicio")+"<br>"
                             +"<b>Vehiculo: </b>"+mapDetalle.get("vehiculo")+"<br>"
                            + "<b>Cantidad: </b>"+d.getCantidad()+"<br>"
                            + "<b>Precio: </b>"+d.getPreccio()+"<br>"
                            + "*********************************************************<br>";
                    reservaDetalleDao.insertSelective(d);
                }
                
                
                // preparar datos para enviar correo al cliente
                String asunto = "Reserva Carwash";
                String mensaje = "<b>Estimado cliente</b> ,<br><br>Su reserva se ha registrado exitosamente. Estos son los detalles de su reserva:<br><br>"
                        +detalle+"<br><br>Saludos Cordiales.";
                String to = cabecera.getEmailSolicitante();
                String fromAddress = queryDao.getConfigValue(FROM_ADDRESS);
                emailBean.sendEmail(fromAddress, to, asunto, mensaje);
                //preparar datos para enviar correo al admin
                asunto = "Pedido de Reserva";
                mensaje = "Hay una nueva reserva solicitada por <b>"
                        +cabecera.getNombreSolicitante()+".</b><br><br>Revise la pagina web para mas detalles<br></br><br></br>"+
                        "Saludos";
                        
                        
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
    
    public GenericResponse getReservas(Date fecha, String nombre,String turno,String telefono,int offset,int limit){
        GenericResponse resp = new GenericResponse();
        Map<String,Object> data = new HashMap<>();
        try {
            List<Reservas> reservas = queryDao.getReservas(fecha, nombre, turno, telefono,offset,limit);
            int totalRows = queryDao.getReservasCount(fecha, nombre, turno, telefono);
            data.put("reservas",reservas);
            data.put("totalRows",totalRows);
            resp.setDato(data);
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
            ReservasExample rexample = new ReservasExample();
            ReservasDetallesExample rdexample = new ReservasDetallesExample();
            rexample.createCriteria().andIdReservaEqualTo(idReserva);
            rdexample.createCriteria().andIdReservaEqualTo(idReserva.longValue());
            reservaDetalleDao.deleteByExample(rdexample);
            reservaDao.deleteByExample(rexample);
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
    		rExample.createCriteria().andFechaEqualTo(reserva);
    		List<Reservas> reservasList = reservaDao.selectByExample(rExample);
    		int maxReservaManhana = Integer.valueOf(queryDao.getConfigValue(MAX_RESERVA_MANHANA));
    		int maxReservaTarde = Integer.valueOf(queryDao.getConfigValue(MAX_RESERVA_TARDE));
                int maxReservaNoche = Integer.valueOf(queryDao.getConfigValue(MAX_RESERVA_NOCHE));
    		int reservaManhana=0;
    		int reservaTarde=0;
                int reservaNoche=0;
    		String disponible="NO";
                
                if (reservasList != null){
                    for(Reservas r : reservasList){
                        switch (r.getTurno()) {
                            case "M":
                                reservaManhana = reservaManhana + r.getCantidad();
                                break;
                            case "T":
                                reservaTarde = reservaTarde + r.getCantidad();
                                break;
                            case "N":
                                reservaNoche = reservaNoche + r.getCantidad();
                                break;
                            default:
                                break;
                        }
                    }
                }
    		
    		if (reservaManhana < maxReservaManhana & reservaTarde < maxReservaTarde & reservaNoche < maxReservaNoche){
    			disponible = "MTN";
    		}
    		else if(reservaManhana < maxReservaManhana & reservaTarde < maxReservaTarde){
    			disponible = "MT";
    		}
    		else if(reservaManhana < maxReservaManhana){
    			disponible = "M";
    		}
                else if(reservaManhana < maxReservaManhana & reservaNoche < maxReservaNoche){
    			disponible = "MN";
    		}
                else if(reservaTarde < maxReservaTarde & reservaNoche < maxReservaNoche){
    			disponible = "TN";
    		}
                else if(reservaTarde < maxReservaTarde){
    			disponible = "T";
    		}
                else if(reservaNoche < maxReservaNoche){
    			disponible = "N";
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
    
    public GenericResponse obtenerDetallesReserva(long idReserva){
        logger.info("IN : {}",idReserva);
        GenericResponse resp = new GenericResponse();
        try {
            ReservasDetallesExample dexample = new ReservasDetallesExample();
            dexample.createCriteria().andIdReservaEqualTo(idReserva);
            List<ReservasDetalles> detalles = reservaDetalleDao.selectByExample(dexample);
            List<Map<String,Object>> data = new ArrayList<>();
            for(ReservasDetalles detalle : detalles){
                ServiciosVehiculosExample svexample = new ServiciosVehiculosExample();
                
                svexample.createCriteria()
                        .andIdServicioVehiculoEqualTo(detalle.getIdServicioVehiculo().intValue());
                ServiciosVehiculos sv = svDao.selectOneByExample(svexample);
                
                Map<String,Object> mapDetalle = queryDao.getVehiculoServicio(sv.getIdServicio().intValue(),sv.getIdVehiculo().intValue());
                Map<String,Object> det = new HashMap<>();
                det.put("servicio", mapDetalle.get("servicio"));
                det.put("vehiculo", mapDetalle.get("vehiculo"));
                det.put("cantidad",detalle.getCantidad());
                det.put("precio",detalle.getPreccio());
                data.add(det);
            }
            resp.setDato(data);
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
