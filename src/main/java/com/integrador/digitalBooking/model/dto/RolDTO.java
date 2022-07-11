package com.integrador.digitalBooking.model.dto;

import lombok.Data;

@Data
public class RolDTO {
    private Integer id;
    private String nombre;

    public RolDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public RolDTO(String nombre) {
        this.nombre = nombre;
    }

    public RolDTO() {
    }
}
