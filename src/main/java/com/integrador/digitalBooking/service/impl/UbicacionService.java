package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Ubicacion;
import com.integrador.digitalBooking.model.dto.UbicacionDTO;
import com.integrador.digitalBooking.repository.IUbicacionRepository;
import com.integrador.digitalBooking.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements IUbicacionService {
    @Autowired
    IUbicacionRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public UbicacionDTO agregarUbicacion(UbicacionDTO ubicacionDTO) {
        Ubicacion ubicacion = mapper.convertValue(ubicacionDTO,Ubicacion.class);
        return mapper.convertValue(repository.save(ubicacion), UbicacionDTO.class);
    }

    @Override
    public UbicacionDTO buscarUbicacionPorId(Integer id) throws ResourceNotFoundException {
        Optional<Ubicacion> ubicacion = repository.findById(id);
        if(ubicacion.isEmpty()){
            throw new ResourceNotFoundException("No existe una ubicación con el ID: " + id+".");
        }
        return mapper.convertValue(ubicacion,UbicacionDTO.class);
    }

    @Override
    public UbicacionDTO actualizarUbicacion(UbicacionDTO ubicacionDTO) throws BadRequestsExceptions {
        if(repository.findById((ubicacionDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la ubicación con ID: "+ubicacionDTO.getId()+", porque no está registrada.");
        Ubicacion ubicacion = mapper.convertValue(ubicacionDTO,Ubicacion.class);
        return mapper.convertValue(repository.save(ubicacion),UbicacionDTO.class);
    }

    @Override
    public void eliminarUbicacion(Integer id) throws ResourceNotFoundException {
        if(buscarUbicacionPorId(id) == null){
            throw new ResourceNotFoundException("No existe la ubicación con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<UbicacionDTO> listarUbicaciones() {
        List<Ubicacion> ubicaciones = repository.findAll();
        Collection<UbicacionDTO> listaUbicacionesDTO = new HashSet<>();

        for (Ubicacion u:ubicaciones) {
            listaUbicacionesDTO.add(mapper.convertValue(u, UbicacionDTO.class));
        }
        return listaUbicacionesDTO;
    }
}
