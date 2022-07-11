package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class PoliticaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String tipo_politica;
    private Integer producto_id;

    public PoliticaDTO(Integer id, String titulo, String descripcion, String tipo_politica, Integer producto_id) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo_politica = tipo_politica;
        this.producto_id = producto_id;
    }
    public PoliticaDTO(String titulo, String descripcion, String tipo_politica, Integer producto_id) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo_politica = tipo_politica;
        this.producto_id = producto_id;
    }
    public PoliticaDTO() {
    }
}
