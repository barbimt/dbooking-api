package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class CategoriaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String urlImagen;

    public CategoriaDTO(String titulo, String descripcion, String urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    public CategoriaDTO(Integer id, String titulo, String descripcion, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    public CategoriaDTO() {
    }
}
