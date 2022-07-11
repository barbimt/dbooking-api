package com.integrador.digitalBooking.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "descripciones")
public class Descripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    @NotNull
    @Column(name = "producto_id")
    private Integer producto_id;

    public Descripcion(Integer id, String descripcion, Integer producto_id) {
        this.id = id;
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public Descripcion(String descripcion, Integer producto_id) {
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public Descripcion() {
    }
}
