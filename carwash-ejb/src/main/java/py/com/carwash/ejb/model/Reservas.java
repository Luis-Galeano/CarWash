package py.com.carwash.ejb.model;

import java.io.Serializable;
import java.util.Date;

public class Reservas implements Serializable {
    private Integer idReserva;

    private Long idServicioVehiculo;

    private Date fechaHora;

    private String ubicacion;

    private String nombreSolicitante;

    private String telefonoSolicitante;

    private String emailSolicitante;

    private Integer estadoReserva;

    private static final long serialVersionUID = 1L;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdServicioVehiculo() {
        return idServicioVehiculo;
    }

    public void setIdServicioVehiculo(Long idServicioVehiculo) {
        this.idServicioVehiculo = idServicioVehiculo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idReserva=").append(idReserva);
        sb.append(", idServicioVehiculo=").append(idServicioVehiculo);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", nombreSolicitante=").append(nombreSolicitante);
        sb.append(", telefonoSolicitante=").append(telefonoSolicitante);
        sb.append(", emailSolicitante=").append(emailSolicitante);
        sb.append(", estadoReserva=").append(estadoReserva);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}