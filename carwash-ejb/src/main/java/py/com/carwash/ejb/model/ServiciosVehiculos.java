package py.com.carwash.ejb.model;

import java.io.Serializable;

public class ServiciosVehiculos implements Serializable {
    private Integer idServicioVehiculo;

    private Long idServicio;

    private Long idVehiculo;

    private Integer precio;

    private static final long serialVersionUID = 1L;

    public Integer getIdServicioVehiculo() {
        return idServicioVehiculo;
    }

    public void setIdServicioVehiculo(Integer idServicioVehiculo) {
        this.idServicioVehiculo = idServicioVehiculo;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idServicioVehiculo=").append(idServicioVehiculo);
        sb.append(", idServicio=").append(idServicio);
        sb.append(", idVehiculo=").append(idVehiculo);
        sb.append(", precio=").append(precio);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}