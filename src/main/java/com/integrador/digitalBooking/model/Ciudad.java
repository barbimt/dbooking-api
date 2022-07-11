package com.integrador.digitalBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "ciudades")
@Data
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Column(name = "pais")
    private String pais;
    @NotNull
    @Column(name = "provincia")
    private String provincia;


    //Relacion con Producto
    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private Set<Producto> productos;

    public Ciudad(Integer id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
    public Ciudad(String nombre, String pais, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.pais = pais;
    }
    public Ciudad() {
    }
}
