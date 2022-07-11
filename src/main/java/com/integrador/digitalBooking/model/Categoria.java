package com.integrador.digitalBooking.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "titulo")
    private String titulo;
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;
    @NotNull
    @Column(name = "url_imagen")
    private String urlImagen;

    public Categoria() {
    }
    public Categoria(Integer id, String titulo, String descripcion, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    public Categoria(String titulo, String descripcion, String urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
}

