package com.integrador.digitalBooking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "reservas")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hora_reserva")
    @NotNull
    private String horaReserva;
    @Column(name = "fecha_inicial")
    @NotNull
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @NotNull
    private Date fechaFinal;

    //Relacion con productos
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    //Relacion con usuarios
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Reserva(Integer id, String horaReserva, Date fechaInicial, Date fechaFinal, Producto producto, Usuario usuario) {
        this.id = id;
        this.horaReserva = horaReserva;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Reserva(String horaReserva, Date fechaInicial, Date fechaFinal, Producto producto, Usuario usuario) {
        this.horaReserva = horaReserva;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Reserva() {
    }
}
