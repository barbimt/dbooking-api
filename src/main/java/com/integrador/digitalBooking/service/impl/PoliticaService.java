package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Politica;
import com.integrador.digitalBooking.model.dto.PoliticaDTO;
import com.integrador.digitalBooking.repository.IPoliticaRepository;
import com.integrador.digitalBooking.service.IPoliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PoliticaService implements IPoliticaService {
    @Autowired
    IPoliticaRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public PoliticaDTO agregarPolitica(PoliticaDTO politicaDTO) {
        Politica politica = mapper.convertValue(politicaDTO,Politica.class);
        return mapper.convertValue(repository.save(politica), PoliticaDTO.class);
    }

    @Override
    public PoliticaDTO buscarPoliticaPorId(Integer id) throws ResourceNotFoundException {
        Optional<Politica> politica = repository.findById(id);
        if(politica.isEmpty()){
            throw new ResourceNotFoundException("No existe una política con el ID: " + id+".");
        }
        return mapper.convertValue(politica,PoliticaDTO.class);
    }

    @Override
    public PoliticaDTO actualizarPolitica(PoliticaDTO politicaDTO) throws BadRequestsExceptions {
        if(repository.findById((politicaDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la política con ID: "+politicaDTO.getId()+", porque no está registrada.");
        Politica politica = mapper.convertValue(politicaDTO,Politica.class);
        return mapper.convertValue(repository.save(politica), PoliticaDTO.class);
    }

    @Override
    public void eliminarPolitica(Integer id) throws ResourceNotFoundException {
        if(buscarPoliticaPorId(id) == null){
            throw new ResourceNotFoundException("No existe la política con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<PoliticaDTO> listarPoliticas() {
        List<Politica> politicas = repository.findAll();
        Collection<PoliticaDTO> listaPoliticasDTO = new HashSet<>();
        for (Politica i:politicas) {
            listaPoliticasDTO.add(mapper.convertValue(i, PoliticaDTO.class));
        }
        return listaPoliticasDTO;
    }
}
