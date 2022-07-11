package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Caracteristica;
import com.integrador.digitalBooking.model.dto.CaracteristicaDTO;
import com.integrador.digitalBooking.repository.ICaracteristicaRepository;
import com.integrador.digitalBooking.service.ICaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService implements ICaracteristicaService {
    @Autowired
    ICaracteristicaRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public CaracteristicaDTO agregarCaracteristica(CaracteristicaDTO caracteristicaDTO) {
        Caracteristica caracteristica = mapper.convertValue(caracteristicaDTO,Caracteristica.class);
        return mapper.convertValue(repository.save(caracteristica), CaracteristicaDTO.class);
    }

    @Override
    public CaracteristicaDTO buscarCaracteristicaPorId(Integer id) throws ResourceNotFoundException {
        Optional<Caracteristica> caracteristica = repository.findById(id);
        if(caracteristica.isEmpty()){
            throw new ResourceNotFoundException("No existe una característica con el ID: " + id+".");
        }
        return mapper.convertValue(caracteristica,CaracteristicaDTO.class);
    }

    @Override
    public CaracteristicaDTO actualizarCaracteristica(CaracteristicaDTO caracteristicaDTO) throws BadRequestsExceptions {
        if (repository.findById((caracteristicaDTO.getId())).isEmpty())
        throw new BadRequestsExceptions("No es posible actualizar la característica con ID: "+caracteristicaDTO.getId()+", porque no está registrada.");
        Caracteristica caracteristica = mapper.convertValue(caracteristicaDTO,Caracteristica.class);
        return mapper.convertValue(repository.save(caracteristica),CaracteristicaDTO.class);
    }

    @Override
    public void eliminarCaracteristica(Integer id) throws ResourceNotFoundException {
        if(buscarCaracteristicaPorId(id) == null){
            throw new ResourceNotFoundException("No existe la característica con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<CaracteristicaDTO> listarCaracteristicas() {
        List<Caracteristica> caracteristicas = repository.findAll();
        Collection<CaracteristicaDTO> listaCaracteristicasDTO = new HashSet<>();

        for (Caracteristica c:caracteristicas) {
            listaCaracteristicasDTO.add(mapper.convertValue(c, CaracteristicaDTO.class));
        }
        return listaCaracteristicasDTO;
    }
}
