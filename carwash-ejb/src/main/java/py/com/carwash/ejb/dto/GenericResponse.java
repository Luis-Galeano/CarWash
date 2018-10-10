/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.carwash.ejb.dto;

/**
 *
 * @author Luis Galeano
 */
public class GenericResponse<T> {
    
    private String mensaje;
    private Long estado;
    private T dato;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "mensaje=" + mensaje + ", estado=" + estado + ", dato=" + dato + '}';
    }
    
    
}
