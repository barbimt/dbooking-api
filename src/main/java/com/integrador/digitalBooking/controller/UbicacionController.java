package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.UbicacionDTO;
import com.integrador.digitalBooking.service.IUbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("ubicaciones")
public class UbicacionController {

    private final IUbicacionService service;
    public UbicacionController(IUbicacionService service) {this.service = service; }

    @Operation(summary = "Crear una ubicación.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @PostMapping
    public ResponseEntity<UbicacionDTO> guardarUbicacion(@RequestBody UbicacionDTO ubicacion) {
        return ResponseEntity.ok(service.agregarUbicacion(ubicacion));
    }

    @Operation(summary = "Buscar ubicación por su ID.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDTO> buscarUbicacionPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        UbicacionDTO ubicacionDTO = service.buscarUbicacionPorId(id);
        return ResponseEntity.ok(ubicacionDTO);
    }

    @Operation(summary = "Actualizar los datos de una ubicación.")
    @PutMapping
    public ResponseEntity<UbicacionDTO> actualizarUbicacion(@RequestBody UbicacionDTO ubicacionDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarUbicacion(ubicacionDTO));
    }

    @Operation(summary = "Eliminar una ubicación por su ID.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUbicacion(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarUbicacion(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ubicación eliminada exitosamente.");
    }

    @Operation(summary = "Listar Ubicaciones.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping
    public ResponseEntity<Collection<UbicacionDTO>> listarUbicaciones(){
        Collection<UbicacionDTO> listaDeUbicaciones = service.listarUbicaciones();
        return ResponseEntity.ok(listaDeUbicaciones);
    }
}
