package com.integrador.digitalBooking.model.dto;

import com.integrador.digitalBooking.model.Producto;
import com.integrador.digitalBooking.model.Usuario;
import lombok.Data;


import java.util.Date;

@Data
public class ReservaDTO {
    private Integer id;
    private String horaReserva;
    private Date fechaInicial;
    private Date fechaFinal;
    private Producto producto;
    private Usuario usuario;

    public ReservaDTO(Integer id, String horaReserva, Date fechaInicial, Date fechaFinal, Producto producto, Usuario usuario) {
        this.id = id;
        this.horaReserva = horaReserva;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public ReservaDTO(String horaReserva, Date fechaInicial, Date fechaFinal, Producto producto, Usuario usuario) {
        this.horaReserva = horaReserva;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public ReservaDTO() {
    }
}
