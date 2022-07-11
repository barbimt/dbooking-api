package com.integrador.digitalBooking.model.dto;


import com.integrador.digitalBooking.model.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String ciudad;
    private String clave;
   // private String rol;
    private Rol rol;


    public UsuarioDTO(Integer id, String nombre, String apellido, String email, String ciudad, String clave, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }

    public UsuarioDTO(String nombre, String apellido, String email, String ciudad, String clave, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }
/*
    public UsuarioDTO(Integer id, String nombre, String apellido, String email, String ciudad, String clave, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }

    public UsuarioDTO(String nombre, String apellido, String email, String ciudad, String clave, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }
*/
    public UsuarioDTO() {
    }


}
