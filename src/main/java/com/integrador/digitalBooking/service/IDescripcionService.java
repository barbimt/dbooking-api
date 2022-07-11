package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.DescripcionDTO;

import java.util.Collection;

public interface IDescripcionService {

    //Agregar Descripcion
    DescripcionDTO agregarDescripcion(DescripcionDTO descripcion);

    //Buscar Descripcion por Id
    DescripcionDTO buscarDescripcionPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Descripcion
    DescripcionDTO actualizarDescripcion(DescripcionDTO descripcion) throws BadRequestsExceptions;

    //Eliminar Descripcion
    void eliminarDescripcion(Integer id) throws ResourceNotFoundException;

    //Listar Descripciones
    Collection<DescripcionDTO> listarDescripciones();
}
