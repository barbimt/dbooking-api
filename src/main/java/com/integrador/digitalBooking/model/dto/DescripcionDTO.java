package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class DescripcionDTO {
    private Integer id;
    private String descripcion;
    private Integer producto_id;

    public DescripcionDTO(Integer id, String descripcion, Integer producto_id) {
        this.id = id;
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public DescripcionDTO(String descripcion, Integer producto_id) {
        this.descripcion = descripcion;
        this.producto_id = producto_id;
    }
    public DescripcionDTO() {
    }
}
