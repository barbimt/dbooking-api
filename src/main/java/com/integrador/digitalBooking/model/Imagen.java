package com.integrador.digitalBooking.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "imagenes")
@Data
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "titulo")
    private String titulo;
    @NotNull
    @Column(name = "urlImagen")
    private String urlImagen;
    @NotNull
    @Column(name = "producto_id")
    private Integer producto_id;

    public Imagen(Integer id, String titulo, String urlImagen, Integer producto_id) {
        this.id = id;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.producto_id = producto_id;
    }
    public Imagen(String titulo, String urlImagen, Integer producto_id) {
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.producto_id = producto_id;
    }
    public Imagen() {
    }
}
