package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Usuario;
import com.integrador.digitalBooking.model.dto.UsuarioDTO;
import com.integrador.digitalBooking.repository.IUsuarioRepository;
import com.integrador.digitalBooking.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.convertValue(usuarioDTO,Usuario.class);
        return mapper.convertValue(repository.save(usuario), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO buscarUsuarioPorId(Integer id) throws ResourceNotFoundException {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("No existe un usuario con el ID: " + id+".");
        }
        return mapper.convertValue(usuario,UsuarioDTO.class);
    }

    public UsuarioDTO listarPorEmail(String email) throws ResourceNotFoundException {
        Optional<Usuario> usuario = Optional.ofNullable(repository.findByEmail(email));
        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("No existe un usuario con el email: " + email+".");
        }
        return mapper.convertValue(usuario,UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) throws BadRequestsExceptions {
        if(repository.findById((usuarioDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar el usuario con ID: "+usuarioDTO.getId()+", porque no está registrado.");
        Usuario usuario = mapper.convertValue(usuarioDTO,Usuario.class);
        return mapper.convertValue(repository.save(usuario),UsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(Integer id) throws ResourceNotFoundException {
        if(buscarUsuarioPorId(id) == null){
            throw new ResourceNotFoundException("No existe el usuario con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        Collection<UsuarioDTO> listaUsuarioesDTO = new HashSet<>();

        for (Usuario u:usuarios) {
            listaUsuarioesDTO.add(mapper.convertValue(u, UsuarioDTO.class));
        }
        return listaUsuarioesDTO;
    }


    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
