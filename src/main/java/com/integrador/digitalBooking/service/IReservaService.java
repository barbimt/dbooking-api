package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ProductoDTO;
import com.integrador.digitalBooking.model.dto.ReservaDTO;


import java.util.Collection;

public interface IReservaService {
    //Agregar Reserva
    ReservaDTO agregarReserva(ReservaDTO reserva);

    //Buscar Reserva por Id
    ReservaDTO buscarReservaPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Reserva
    ReservaDTO actualizarReserva(ReservaDTO reserva) throws BadRequestsExceptions;

    //Eliminar Reserva
    void eliminarReserva(Integer id) throws ResourceNotFoundException;

    //Listar Reservas
    Collection<ReservaDTO> listarReservas();

    //Listar Reservas por Id de Producto
    Collection<ReservaDTO> listarReservasPorIdProducto(Integer id);

    //Listar Reservas por Id de usuario
    Collection<ReservaDTO> listarReservasPorIdUsuario(Integer id);
}
