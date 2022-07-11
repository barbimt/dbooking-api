package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.PoliticaDTO;
import com.integrador.digitalBooking.service.IPoliticaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("politicas")
public class PoliticaController {
    private final IPoliticaService service;
    public PoliticaController(IPoliticaService service){
        this.service = service;
    }


    @Operation(summary = "Crear una política.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<PoliticaDTO> guardarPolitica(@RequestBody PoliticaDTO politica) {
        return ResponseEntity.ok(service.agregarPolitica(politica));
    }

    @Operation(summary = "Buscar política por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<PoliticaDTO> buscarPoliticaPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        PoliticaDTO politicaDTO = service.buscarPoliticaPorId(id);
        return ResponseEntity.ok(politicaDTO);
    }

    @Operation(summary = "Actualizar los datos de una política.")
    @PutMapping
    public ResponseEntity<PoliticaDTO> actualizarPolitica(@RequestBody PoliticaDTO politicaDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarPolitica(politicaDTO));
    }

    @Operation(summary = "Eliminar una política por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPolitica(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarPolitica(id);
        return ResponseEntity.status(HttpStatus.OK).body("Política eliminada exitosamente.");
    }

    @Operation(summary = "Listar Políticas.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<PoliticaDTO>> listarPoliticas(){
        Collection<PoliticaDTO> listaDePoliticas = service.listarPoliticas();
        return ResponseEntity.ok(listaDePoliticas);
    }
}
