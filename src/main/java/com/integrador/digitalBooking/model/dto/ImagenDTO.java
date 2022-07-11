package com.integrador.digitalBooking.model.dto;

import lombok.Data;

@Data
public class ImagenDTO {
    private Integer id;
    private String titulo;
    private String urlImagen;
    private Integer producto_id;

    public ImagenDTO(Integer id, String titulo, String urlImagen, Integer producto_id) {
        this.id = id;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.producto_id = producto_id;
    }
    public ImagenDTO(String titulo, String urlImagen, Integer producto_id) {
        this.titulo = titulo;
        this.urlImagen = urlImagen;
        this.producto_id = producto_id;
    }
    public ImagenDTO() {
    }
}
