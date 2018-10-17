package py.com.carwash.ejb.model;

import java.io.Serializable;
import java.util.List;

public class ReservasRequest implements Serializable {
    private Reservas cabecera;
    private List<ReservasDetalles> detalles;

    private static final long serialVersionUID = 1L;

    public Reservas getCabecera() {
        return cabecera;
    }

    public void setCabecera(Reservas cabecera) {
        this.cabecera = cabecera;
    }

    public List<ReservasDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ReservasDetalles> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "ReservasRequest{" + "cabecera=" + cabecera + ", detalles=" + detalles + '}';
    }

    
}