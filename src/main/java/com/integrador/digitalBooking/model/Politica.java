package com.integrador.digitalBooking.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "politicas")
@Data
public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo_politica;
    private String titulo;
    private String descripcion;
    private Integer producto_id;

    public Politica(Integer id, String tipo_politica, String titulo, String descripcion, Integer producto_id) {
        this.id = id;
        this.tipo_politica = tipo_politica;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public Politica(String tipo_politica, String titulo, String descripcion, Integer producto_id) {
        this.tipo_politica = tipo_politica;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public Politica() {
    }
}
