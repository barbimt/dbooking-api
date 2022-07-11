package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CategoriaDTO;

import java.util.Collection;

public interface ICategoriaService {

    //Agregar Categoria
    CategoriaDTO agregarCategoria(CategoriaDTO categoria);

    //Buscar Categoria por Id
    CategoriaDTO buscarCategoriaPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Categoria
    CategoriaDTO actualizarCategoria(CategoriaDTO categoria) throws BadRequestsExceptions;

    //Eliminar Categoria
    void eliminarCategoria(Integer id) throws ResourceNotFoundException;

    //Listar Categorias
    Collection<CategoriaDTO> listarCategorias();
}
