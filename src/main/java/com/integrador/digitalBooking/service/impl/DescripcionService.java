package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Descripcion;
import com.integrador.digitalBooking.model.dto.DescripcionDTO;
import com.integrador.digitalBooking.repository.IDescripcionRepository;
import com.integrador.digitalBooking.service.IDescripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class DescripcionService implements IDescripcionService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    IDescripcionRepository repository;

    @Override
    public DescripcionDTO agregarDescripcion(DescripcionDTO descripcionDTO) {
        Descripcion descripcion = mapper.convertValue(descripcionDTO,Descripcion.class);
        return mapper.convertValue(repository.save(descripcion), DescripcionDTO.class);
    }

    @Override
    public DescripcionDTO buscarDescripcionPorId(Integer id) throws ResourceNotFoundException {
        Optional<Descripcion> descripcion = repository.findById(id);
        if(descripcion.isEmpty()){
            throw new ResourceNotFoundException("No existe una descripción con el ID: " + id+".");
        }
        return mapper.convertValue(descripcion,DescripcionDTO.class);
    }

    @Override
    public DescripcionDTO actualizarDescripcion(DescripcionDTO descripcionDTO) throws BadRequestsExceptions {
        if(repository.findById((descripcionDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la descripción con ID: "+descripcionDTO.getId()+", porque no está registrada.");
        Descripcion descripcion = mapper.convertValue(descripcionDTO,Descripcion.class);
        return mapper.convertValue(repository.save(descripcion),DescripcionDTO.class);
    }

    @Override
    public void eliminarDescripcion(Integer id) throws ResourceNotFoundException {
        if(buscarDescripcionPorId(id) == null){
            throw new ResourceNotFoundException("No existe la descripción con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<DescripcionDTO> listarDescripciones() {
        List<Descripcion> descripciones = repository.findAll();
        Collection<DescripcionDTO> listaDescripcionesDTO = new HashSet<>();

        for (Descripcion d:descripciones) {
            listaDescripcionesDTO.add(mapper.convertValue(d, DescripcionDTO.class));
        }
        return listaDescripcionesDTO;
    }
}
