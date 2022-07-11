package com.integrador.digitalBooking.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "titulo")
    private String titulo;
    @NotNull
    @Column(name = "imagenPrincipalUrl")
    private String imagenPrincipalUrl;
    @NotNull
    @Column(name = "puntaje")
    private String puntaje;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Descripcion> descripciones;
    @NotNull
    @Column(name = "descripcion_card")
    private String descripcion_card;
    @NotNull
    @Column(name = "disponibilidad")
    private Boolean disponible;

    //Relación con Politica
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Politica> politica;

    //Relación con Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    //Relación con Ubicación
    @OneToOne
    private Ubicacion ubicacion;

    //Relación con Característica
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    //Relación con Imagenes Secundarias
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private Set<Imagen> imagenesSecundarias = new HashSet<>();

    //Relación con Ciudad
    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    public Producto(Integer id, String titulo, String imagenPrincipalUrl, String puntaje, Set<Descripcion> descripciones, String descripcion_card, Boolean disponible, Set<Politica> politica, Categoria categoria, Ubicacion ubicacion, Set<Caracteristica> caracteristicas, Set<Imagen> imagenesSecundarias, Ciudad ciudad) {
        this.id = id;
        this.titulo = titulo;
        this.imagenPrincipalUrl = imagenPrincipalUrl;
        this.puntaje = puntaje;
        this.descripciones = descripciones;
        this.descripcion_card = descripcion_card;
        this.disponible = disponible;
        this.politica = politica;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.caracteristicas = caracteristicas;
        this.imagenesSecundarias = imagenesSecundarias;
        this.ciudad = ciudad;
    }
    public Producto(String titulo, String imagenPrincipalUrl, String puntaje, Set<Descripcion> descripciones, String descripcion_card, Boolean disponible, Set<Politica> politica, Categoria categoria, Ubicacion ubicacion, Set<Caracteristica> caracteristicas, Set<Imagen> imagenesSecundarias, Ciudad ciudad) {
        this.titulo = titulo;
        this.imagenPrincipalUrl = imagenPrincipalUrl;
        this.puntaje = puntaje;
        this.descripciones = descripciones;
        this.descripcion_card = descripcion_card;
        this.disponible = disponible;
        this.politica = politica;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.caracteristicas = caracteristicas;
        this.imagenesSecundarias = imagenesSecundarias;
        this.ciudad = ciudad;
    }
    public Producto() {
    }
}
