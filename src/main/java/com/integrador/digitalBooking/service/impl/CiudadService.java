package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Ciudad;
import com.integrador.digitalBooking.model.dto.CiudadDTO;
import com.integrador.digitalBooking.repository.ICiudadRepository;
import com.integrador.digitalBooking.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadService implements ICiudadService {
    @Autowired
    ICiudadRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public CiudadDTO agregarCiudad(CiudadDTO ciudadDTO) {
            Ciudad ciudad = mapper.convertValue(ciudadDTO,Ciudad.class);
            return mapper.convertValue(repository.save(ciudad),CiudadDTO.class);
    }

    @Override
    public CiudadDTO buscarCiudadPorId(Integer id) throws ResourceNotFoundException {
            Optional<Ciudad> ciudad = repository.findById(id);
            if(ciudad.isEmpty()){
                throw new ResourceNotFoundException("No existe una ciudad con el ID: " + id+".");
            }
            return mapper.convertValue(ciudad,CiudadDTO.class);
    }

    @Override
    public CiudadDTO actualizarCiudad(CiudadDTO ciudadDTO) throws BadRequestsExceptions {
            if(repository.findById((ciudadDTO.getId())).isEmpty())
                throw new BadRequestsExceptions("No es posible actualizar la ciudad con ID: "+ciudadDTO.getId()+", porque no está registrada.");
            Ciudad ciudad = mapper.convertValue(ciudadDTO,Ciudad.class);
            return mapper.convertValue(repository.save(ciudad),CiudadDTO.class);
    }

    @Override
    public void eliminarCiudad(Integer id) throws ResourceNotFoundException {
            if(buscarCiudadPorId(id) == null){
                throw new ResourceNotFoundException("No existe la ciudad con ID: " +id+".");
            }
            repository.deleteById(id);
    }

    @Override
    public Collection<CiudadDTO> listarCiudades() {
            List<Ciudad> ciudades = repository.findAll();
            Collection<CiudadDTO> listaCiudadesDTO = new HashSet<>();

            for (Ciudad c:ciudades) {
                listaCiudadesDTO.add(mapper.convertValue(c, CiudadDTO.class));
            }
            return listaCiudadesDTO;
    }
}
