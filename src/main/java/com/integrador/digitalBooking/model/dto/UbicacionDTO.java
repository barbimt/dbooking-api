package com.integrador.digitalBooking.model.dto;

import lombok.Data;
@Data
public class UbicacionDTO {
    private Integer id;
    private String descripcion;
    private Double latitud;
    private Double longitud;
    private String direccion;

    public UbicacionDTO(Integer id, String descripcion, Double latitud, Double longitud, String direccion) {
        this.id = id;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }
    public UbicacionDTO(String descripcion, Double latitud, Double longitud, String direccion) {
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }
    public UbicacionDTO() {
    }
}
