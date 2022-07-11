package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Rol;
import com.integrador.digitalBooking.model.dto.RolDTO;
import com.integrador.digitalBooking.model.dto.RolDTO;
import com.integrador.digitalBooking.repository.IRolRepository;
import com.integrador.digitalBooking.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    IRolRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public RolDTO agregarRol(RolDTO rolDTO) {
        Rol rol = mapper.convertValue(rolDTO,Rol.class);
        return mapper.convertValue(repository.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO buscarRolPorId(Integer id) throws ResourceNotFoundException {
        Optional<Rol> rol = repository.findById(id);
        if(rol.isEmpty()){
            throw new ResourceNotFoundException("No existe un rol con el ID: " + id+".");
        }
        return mapper.convertValue(rol,RolDTO.class);
    }

    @Override
    public RolDTO actualizarRol(RolDTO rolDTO) throws BadRequestsExceptions {
        if(repository.findById((rolDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar el rol con ID: "+rolDTO.getId()+", porque no está registrado.");
        Rol rol = mapper.convertValue(rolDTO,Rol.class);
        return mapper.convertValue(repository.save(rol),RolDTO.class);
    }

    @Override
    public void eliminarRol(Integer id) throws ResourceNotFoundException {
        if(buscarRolPorId(id) == null){
            throw new ResourceNotFoundException("No existe el rol con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<RolDTO> listarRoles() {
        List<Rol> roles = repository.findAll();
        Collection<RolDTO> listaRolesDTO = new HashSet<>();

        for (Rol r:roles) {
            listaRolesDTO.add(mapper.convertValue(r, RolDTO.class));
        }
        return listaRolesDTO;
    }
}
