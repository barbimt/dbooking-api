package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.RolDTO;
import com.integrador.digitalBooking.service.IRolService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("roles")
public class RolController {
    private final IRolService service;
    public RolController(IRolService service){
        this.service = service;
    }


    @Operation(summary = "Crear un rol.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @PostMapping
    public ResponseEntity<RolDTO> guardarRol(@RequestBody RolDTO rol) {
        return ResponseEntity.ok(service.agregarRol(rol));
    }

    @Operation(summary = "Buscar rol por su ID.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> buscarRolPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        RolDTO rolDTO = service.buscarRolPorId(id);
        return ResponseEntity.ok(rolDTO);
    }

    @Operation(summary = "Actualizar los datos de un rol.")
    @PutMapping
    public ResponseEntity<RolDTO> actualizarRol(@RequestBody RolDTO rolDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarRol(rolDTO));
    }

    @Operation(summary = "Eliminar un rol por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRol(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarRol(id);
        return ResponseEntity.status(HttpStatus.OK).body("Rol eliminado exitosamente.");
    }

    @Operation(summary = "Listar Roles.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping
    public ResponseEntity<Collection<RolDTO>> listarRols(){
        Collection<RolDTO> listaDeRoles = service.listarRoles();
        return ResponseEntity.ok(listaDeRoles);
    }
}
