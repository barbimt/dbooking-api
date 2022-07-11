package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CiudadDTO;
import com.integrador.digitalBooking.service.ICiudadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("ciudades")
public class CiudadController {

    private final ICiudadService service;
    public CiudadController(ICiudadService service){
        this.service = service;
    }

    @Operation(summary = "Crear una ciudad.")
    @PostMapping
    public ResponseEntity<CiudadDTO> guardarCiudad(@RequestBody CiudadDTO ciudad) {
        return ResponseEntity.ok(service.agregarCiudad(ciudad));
    }

    @Operation(summary = "Buscar ciudad por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDTO> buscarCiudadPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        CiudadDTO ciudadDTO = service.buscarCiudadPorId(id);
        return ResponseEntity.ok(ciudadDTO);
    }

    @Operation(summary = "Actualizar los datos de una ciudad.")
    @PutMapping
    public ResponseEntity<CiudadDTO> actualizarCiudad(@RequestBody CiudadDTO ciudadDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarCiudad(ciudadDTO));
    }

    @Operation(summary = "Eliminar una ciudad por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCiudad(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarCiudad(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ciudad eliminada exitosamente.");
    }

    @Operation(summary = "Listar ciudades.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<CiudadDTO>> listarCiudades(){
        Collection<CiudadDTO> listaDeCiudades = service.listarCiudades();
        return ResponseEntity.ok(listaDeCiudades);
    }
}
