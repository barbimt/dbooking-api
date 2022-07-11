package com.integrador.digitalBooking.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "caracteristicas")
@Data
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Column(name = "urlIcono")
    private String urlIcono;
    @NotNull
    @Column(name = "producto_id")
    private Integer producto_id;

    public Caracteristica() {
    }
    public Caracteristica(Integer id, String nombre, String urlIcono, Integer producto_id) {
        this.id = id;
        this.nombre = nombre;
        this.urlIcono = urlIcono;
        this.producto_id = producto_id;
    }
    public Caracteristica(String nombre, String urlIcono, Integer producto_id) {
        this.nombre = nombre;
        this.urlIcono = urlIcono;
        this.producto_id = producto_id;
    }
}
