package com.integrador.digitalBooking.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ubicaciones")
@Data
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    @NotNull
    @Column(name = "latitud")
    private Double latitud;
    @NotNull
    @Column(name = "longitud")
    private Double longitud;
    @NotNull
    @Column(name = "direccion")
    private String direccion;


    public Ubicacion() {
    }

    public Ubicacion(Integer id, String descripcion, Double latitud, Double longitud, String direccion) {
        this.id = id;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }
    public Ubicacion(String descripcion, Double latitud, Double longitud, String direccion) {
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }
}
