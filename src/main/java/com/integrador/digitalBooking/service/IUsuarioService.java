package com.integrador.digitalBooking.service;


import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;

import com.integrador.digitalBooking.model.Usuario;
import com.integrador.digitalBooking.model.dto.UsuarioDTO;

import java.util.Collection;

public interface IUsuarioService {
    //Agregar Usuario
    UsuarioDTO agregarUsuario(UsuarioDTO usuario);

    //Buscar Usuario por Id
    UsuarioDTO buscarUsuarioPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Usuario
    UsuarioDTO actualizarUsuario(UsuarioDTO usuario) throws BadRequestsExceptions;

    //Eliminar Usuario
    void eliminarUsuario(Integer id) throws ResourceNotFoundException;

    //Listar Usuarios
    Collection<UsuarioDTO> listarUsuarios();

    boolean existsByEmail(String email);

    UsuarioDTO listarPorEmail(String email) throws ResourceNotFoundException;
}
