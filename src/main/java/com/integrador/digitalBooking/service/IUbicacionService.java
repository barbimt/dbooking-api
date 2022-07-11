package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.UbicacionDTO;
import java.util.Collection;

public interface IUbicacionService {

    //Agregar Ubicacion
    UbicacionDTO agregarUbicacion(UbicacionDTO ubicacion);

    //Buscar Ubicacion por Id
    UbicacionDTO buscarUbicacionPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Ubicacion
    UbicacionDTO actualizarUbicacion(UbicacionDTO ubicacion) throws BadRequestsExceptions;

    //Eliminar Ubicacion
    void eliminarUbicacion(Integer id) throws ResourceNotFoundException;

    //Listar Ubicaciones
    Collection<UbicacionDTO> listarUbicaciones();
}
