package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CaracteristicaDTO;
import com.integrador.digitalBooking.service.ICaracteristicaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("caracteristicas")
public class CaracteristicaController {

    private final ICaracteristicaService service;
    public CaracteristicaController(ICaracteristicaService service){
        this.service = service;
    }

    @Operation(summary = "Crear una característica.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<CaracteristicaDTO> guardarCaracteristica(@RequestBody CaracteristicaDTO caracteristica) {
        return ResponseEntity.ok(service.agregarCaracteristica(caracteristica));
    }

    @Operation(summary = "Buscar característica por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaDTO> buscarCaracteristicaPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        CaracteristicaDTO caracteristicaDTO = service.buscarCaracteristicaPorId(id);
        return ResponseEntity.ok(caracteristicaDTO);
    }

    @Operation(summary = "Actualizar los datos de una característica.")
    @PutMapping
    public ResponseEntity<CaracteristicaDTO> actualizarCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarCaracteristica(caracteristicaDTO));
    }

    @Operation(summary = "Eliminar una característica por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCaracteristica(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarCaracteristica(id);
        return ResponseEntity.status(HttpStatus.OK).body("Característica eliminada exitosamente.");
    }

    @Operation(summary = "Listar Características.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<CaracteristicaDTO>> listarCaracteristicas(){
        Collection<CaracteristicaDTO> listaDeCaracteristicas = service.listarCaracteristicas();
        return ResponseEntity.ok(listaDeCaracteristicas);
    }

}
