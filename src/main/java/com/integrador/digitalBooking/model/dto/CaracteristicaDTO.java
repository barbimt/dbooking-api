package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class CaracteristicaDTO {
    private Integer id;
    private String nombre;
    private String urlIcono;
    private Integer producto_id;

    public CaracteristicaDTO() {
    }
    public CaracteristicaDTO(Integer id, String nombre, String urlIcono, Integer producto_id) {
        this.id = id;
        this.nombre = nombre;
        this.urlIcono = urlIcono;
        this.producto_id = producto_id;
    }
    public CaracteristicaDTO(String nombre, String urlIcono, Integer producto_id) {
        this.nombre = nombre;
        this.urlIcono = urlIcono;
        this.producto_id = producto_id;
    }
}

