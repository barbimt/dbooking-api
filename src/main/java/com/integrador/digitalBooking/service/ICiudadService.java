package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CiudadDTO;
import java.util.Collection;

public interface ICiudadService {

    //Agregar Ciudad
    CiudadDTO agregarCiudad(CiudadDTO ciudad);

    //Buscar Ciudad por Id
    CiudadDTO buscarCiudadPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Ciudad
    CiudadDTO actualizarCiudad(CiudadDTO ciudad) throws BadRequestsExceptions;

    //Eliminar Ciudad
    void eliminarCiudad(Integer id) throws ResourceNotFoundException;

    //Listar Ciudades
    Collection<CiudadDTO> listarCiudades();

}
