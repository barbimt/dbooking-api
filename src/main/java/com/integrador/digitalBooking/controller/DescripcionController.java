package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.DescripcionDTO;
import com.integrador.digitalBooking.service.IDescripcionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("descripciones")
public class DescripcionController {

    private final IDescripcionService service;
    public DescripcionController(IDescripcionService service){
        this.service = service;
    }

    @Operation(summary = "Crear una descripción.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<DescripcionDTO> guardarDescripcion(@RequestBody DescripcionDTO descripcion) {
        return ResponseEntity.ok(service.agregarDescripcion(descripcion));
    }

    @Operation(summary = "Buscar descripción por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<DescripcionDTO> buscarDescripcionPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        DescripcionDTO descripcionDTO = service.buscarDescripcionPorId(id);
        return ResponseEntity.ok(descripcionDTO);
    }

    @Operation(summary = "Actualizar los datos de una descripción.")
    @PutMapping
    public ResponseEntity<DescripcionDTO> actualizarDescripcion(@RequestBody DescripcionDTO descripcionDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarDescripcion(descripcionDTO));
    }

    @Operation(summary = "Eliminar una descripción por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDescripcion(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarDescripcion(id);
        return ResponseEntity.status(HttpStatus.OK).body("Descripción eliminada exitosamente.");
    }

    @Operation(summary = "Listar Descripciones.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<DescripcionDTO>> listarDescripciones(){
        Collection<DescripcionDTO> listaDeDescripciones = service.listarDescripciones();
        return ResponseEntity.ok(listaDeDescripciones);
    }
}
