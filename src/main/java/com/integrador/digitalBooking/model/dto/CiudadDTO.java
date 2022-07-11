package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class CiudadDTO {
    private Integer id;
    private String nombre;
    private String pais;
    private String provincia;

    public CiudadDTO(Integer id, String nombre, String pais, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
    }
    public CiudadDTO(String nombre, String pais, String provincia) {
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
    }
    public CiudadDTO() {
    }
}
