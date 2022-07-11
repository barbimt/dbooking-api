package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CaracteristicaDTO;

import java.util.Collection;

public interface ICaracteristicaService {

    //Agregar Caracteristica
    CaracteristicaDTO agregarCaracteristica(CaracteristicaDTO caracteristica);

    //Buscar Caracteristica por Id
    CaracteristicaDTO buscarCaracteristicaPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Caracteristica
    CaracteristicaDTO actualizarCaracteristica(CaracteristicaDTO caracteristica) throws BadRequestsExceptions;

    //Eliminar Caracteristica
    void eliminarCaracteristica(Integer id) throws ResourceNotFoundException;

    //Listar Caracteristicas
    Collection<CaracteristicaDTO> listarCaracteristicas();
}
