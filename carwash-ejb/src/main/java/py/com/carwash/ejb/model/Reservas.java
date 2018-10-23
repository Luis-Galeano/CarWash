package py.com.carwash.ejb.model;

import java.io.Serializable;
import java.util.Date;

public class Reservas implements Serializable {
    private Integer idReserva;

    private Date fecha;

    private String ubicacion;

    private String nombreSolicitante;

    private String telefonoSolicitante;

    private String emailSolicitante;

    private Integer estadoReserva;

    private Integer cantidad;

    private String turno;

    private Integer precio;

    private Date fechaSolicitud;

    private String observaciones;

    private static final long serialVersionUID = 1L;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getTelefonoSolicitante() {
        return telefonoSolicitante;
    }

    public void setTelefonoSolicitante(String telefonoSolicitante) {
        this.telefonoSolicitante = telefonoSolicitante;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    public Integer getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Integer estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idReserva=").append(idReserva);
        sb.append(", fecha=").append(fecha);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", nombreSolicitante=").append(nombreSolicitante);
        sb.append(", telefonoSolicitante=").append(telefonoSolicitante);
        sb.append(", emailSolicitante=").append(emailSolicitante);
        sb.append(", estadoReserva=").append(estadoReserva);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", turno=").append(turno);
        sb.append(", precio=").append(precio);
        sb.append(", fechaSolicitud=").append(fechaSolicitud);
        sb.append(", observaciones=").append(observaciones);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}