package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.CategoriaDTO;
import com.integrador.digitalBooking.service.ICategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private final ICategoriaService service;
    public CategoriaController(ICategoriaService service){
        this.service = service;
    }

    @Operation(summary = "Crear una categoría.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<CategoriaDTO> guardarCategoria(@RequestBody CategoriaDTO categoria) {
        return ResponseEntity.ok(service.agregarCategoria(categoria));
    }

    @Operation(summary = "Buscar categoría por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Integer id) throws ResourceNotFoundException{
        CategoriaDTO categoriaDTO = service.buscarCategoriaPorId(id);
        return ResponseEntity.ok(categoriaDTO);
    }

    @Operation(summary = "Actualizar los datos de una categoría.")
    @PutMapping
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarCategoria(categoriaDTO));
    }

    @Operation(summary = "Eliminar una categoría por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoría eliminada exitosamente.");
    }

    @Operation(summary = "Listar Categorías.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<CategoriaDTO>> listarCategorias(){
        Collection<CategoriaDTO> listaDeCategorias = service.listarCategorias();
        return ResponseEntity.ok(listaDeCategorias);
    }
}
