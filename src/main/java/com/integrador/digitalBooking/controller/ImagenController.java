package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ImagenDTO;
import com.integrador.digitalBooking.service.IImagenService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("imagenes")
public class ImagenController {

    private final IImagenService service;
    public ImagenController(IImagenService service){
        this.service = service;
    }

    @Operation(summary = "Crear una imagen.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<ImagenDTO> guardarImagen(@RequestBody ImagenDTO imagen) {
        return ResponseEntity.ok(service.agregarImagen(imagen));
    }

    @Operation(summary = "Buscar imagen por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<ImagenDTO> buscarImagenPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ImagenDTO imagenDTO = service.buscarImagenPorId(id);
        return ResponseEntity.ok(imagenDTO);
    }

    @Operation(summary = "Actualizar los datos de una imagen.")
    @PutMapping
    public ResponseEntity<ImagenDTO> actualizarImagen(@RequestBody ImagenDTO imagenDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarImagen(imagenDTO));
    }

    @Operation(summary = "Eliminar una imagen por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarImagen(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarImagen(id);
        return ResponseEntity.status(HttpStatus.OK).body("Imagen eliminada exitosamente.");
    }

    @Operation(summary = "Listar Imágenes.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<ImagenDTO>> listarImagenes(){
        Collection<ImagenDTO> listaDeImagenes = service.listarImagenes();
        return ResponseEntity.ok(listaDeImagenes);
    }
}
