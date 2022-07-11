package com.integrador.digitalBooking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    @NotNull
    private String nombre;

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol() {
    }
}
