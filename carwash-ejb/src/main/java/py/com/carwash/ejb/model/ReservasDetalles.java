package py.com.carwash.ejb.model;

import java.io.Serializable;

public class ReservasDetalles implements Serializable {
    private Integer idReservaDetalle;

    private Long idServicioVehiculo;

    private Integer cantidad;

    private Integer preccio;

    private Long idReserva;

    private static final long serialVersionUID = 1L;

    public Integer getIdReservaDetalle() {
        return idReservaDetalle;
    }

    public void setIdReservaDetalle(Integer idReservaDetalle) {
        this.idReservaDetalle = idReservaDetalle;
    }

    public Long getIdServicioVehiculo() {
        return idServicioVehiculo;
    }

    public void setIdServicioVehiculo(Long idServicioVehiculo) {
        this.idServicioVehiculo = idServicioVehiculo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPreccio() {
        return preccio;
    }

    public void setPreccio(Integer preccio) {
        this.preccio = preccio;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idReservaDetalle=").append(idReservaDetalle);
        sb.append(", idServicioVehiculo=").append(idServicioVehiculo);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", preccio=").append(preccio);
        sb.append(", idReserva=").append(idReserva);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}