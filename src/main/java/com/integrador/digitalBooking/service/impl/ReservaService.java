package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Reserva;
import com.integrador.digitalBooking.model.dto.ReservaDTO;
import com.integrador.digitalBooking.repository.IReservaRepository;
import com.integrador.digitalBooking.service.IReservaService;
import com.integrador.digitalBooking.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {
    @Autowired
    IReservaRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public ReservaDTO agregarReserva(ReservaDTO reservaDTO) {
        Reserva reserva = mapper.convertValue(reservaDTO,Reserva.class);
        reserva.setFechaInicial(Util.utilDateToSqlDate(reserva.getFechaInicial()));
        reserva.setFechaFinal(Util.utilDateToSqlDate(reserva.getFechaFinal()));
        return mapper.convertValue(repository.save(reserva), ReservaDTO.class);
    }

    @Override
    public ReservaDTO buscarReservaPorId(Integer id) throws ResourceNotFoundException {
        Optional<Reserva> reserva = repository.findById(id);
        if(reserva.isEmpty()){
            throw new ResourceNotFoundException("No existe una reserva con el ID: " + id+".");
        }
        return mapper.convertValue(reserva,ReservaDTO.class);
    }

    @Override
    public ReservaDTO actualizarReserva(ReservaDTO reservaDTO) throws BadRequestsExceptions {
        if(repository.findById((reservaDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la reserva con ID: "+reservaDTO.getId()+", porque no está registrada.");
        Reserva reserva = mapper.convertValue(reservaDTO,Reserva.class);
        return mapper.convertValue(repository.save(reserva),ReservaDTO.class);
    }

    @Override
    public void eliminarReserva(Integer id) throws ResourceNotFoundException {
        if(buscarReservaPorId(id) == null){
            throw new ResourceNotFoundException("No existe la reserva con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<ReservaDTO> listarReservas() {
        List<Reserva> reservas = repository.findAll();
        Collection<ReservaDTO> listaReservasDTO = new HashSet<>();

        for (Reserva r:reservas) {
            listaReservasDTO.add(mapper.convertValue(r, ReservaDTO.class));
        }
        return listaReservasDTO;
    }

    @Override
    public Collection<ReservaDTO> listarReservasPorIdProducto(Integer id) {
        List<Reserva> reservas = repository.listarReservasPorIdProducto(id);
        Collection<ReservaDTO> listaReservasDTO = new HashSet<>();
        for (Reserva r:reservas) {
            listaReservasDTO.add(mapper.convertValue(r, ReservaDTO.class));
        }
        return listaReservasDTO;
    }

    @Override
    public Collection<ReservaDTO> listarReservasPorIdUsuario(Integer id) {
        List<Reserva> reservas = repository.listarReservasPorIdUsuario(id);
        Collection<ReservaDTO> listaReservasDTO = new HashSet<>();
        for (Reserva r:reservas) {
            listaReservasDTO.add(mapper.convertValue(r, ReservaDTO.class));
        }
        return listaReservasDTO;
    }

}
