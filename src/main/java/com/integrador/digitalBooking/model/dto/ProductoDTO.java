package com.integrador.digitalBooking.model.dto;

import com.integrador.digitalBooking.model.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;
@Data
public class ProductoDTO {
    private Integer id;
    private String titulo;
    private String imagenPrincipalUrl;
    private String puntaje;
    private Set<Descripcion> descripciones;
    private String descripcion_card;
    private Boolean disponible;
    private Set<Politica> politica;
    private Categoria categoria;
    private Ubicacion ubicacion;
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    private Set<Imagen> imagenesSecundarias = new HashSet<>();
    private Ciudad ciudad;

    public ProductoDTO(Integer id, String titulo, String imagenPrincipalUrl, String puntaje, Set<Descripcion> descripciones, String descripcion_card, Boolean disponible, Set<Politica> politica, Categoria categoria, Ubicacion ubicacion, Set<Caracteristica> caracteristicas, Set<Imagen> imagenesSecundarias, Ciudad ciudad) {
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

    public ProductoDTO(String titulo, String imagenPrincipalUrl, String puntaje, Set<Descripcion> descripciones, String descripcion_card, Boolean disponible, Set<Politica> politica, Categoria categoria, Ubicacion ubicacion, Set<Caracteristica> caracteristicas, Set<Imagen> imagenesSecundarias, Ciudad ciudad) {
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

    public ProductoDTO() {
    }
}
