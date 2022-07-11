package com.integrador.digitalBooking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Column(name = "apellido")
    @NotNull
    private String apellido;
    @Column(name = "email", unique = true)
    @NotNull
    private String email;
    @Column(name = "ciudad")
    @NotNull
    private String ciudad;
    @Column(name = "clave")
    @NotNull
    private String clave;

    // @Column(name = "rol")
    //@NotNull
    //private String rol;

    //Relación muchos a uno con Roles
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;


    public Usuario(Integer id, String nombre, String apellido, String email, String ciudad, String clave, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String email, String ciudad, String clave, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }

    /*
    public Usuario(Integer id, String nombre, String apellido, String email, String ciudad, String clave, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String email, String ciudad, String clave, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.ciudad = ciudad;
        this.clave = clave;
        this.rol = rol;
    }
    */


    public Usuario() {
    }
}
