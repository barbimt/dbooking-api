package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.RolDTO;

import java.util.Collection;

public interface IRolService {
    //Agregar Rol
    RolDTO agregarRol(RolDTO rol);

    //Buscar Rol por Id
    RolDTO buscarRolPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Rol
    RolDTO actualizarRol(RolDTO rol) throws BadRequestsExceptions;

    //Eliminar Rol
    void eliminarRol(Integer id) throws ResourceNotFoundException;

    //Listar Roles
    Collection<RolDTO> listarRoles();
}
