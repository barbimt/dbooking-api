package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.PoliticaDTO;
import java.util.Collection;

public interface IPoliticaService {

    //Agregar Politica
    PoliticaDTO agregarPolitica(PoliticaDTO politica);

    //Buscar Politica por Id
    PoliticaDTO buscarPoliticaPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Politica
    PoliticaDTO actualizarPolitica(PoliticaDTO politica) throws BadRequestsExceptions;

    //Eliminar Politica
    void eliminarPolitica(Integer id) throws ResourceNotFoundException;

    //Listar Politicas
    Collection<PoliticaDTO> listarPoliticas();
}
