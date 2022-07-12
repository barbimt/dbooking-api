package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ReservaDTO;

import com.integrador.digitalBooking.service.IReservaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.Collection;

@RestController
@RequestMapping("reservas")
public class ReservaController {
    private final IReservaService service;
    public ReservaController(IReservaService service){
        this.service = service;
    }


    @Operation(summary = "Crear una reserva.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @PostMapping
    public ResponseEntity<ReservaDTO> guardarReserva(@RequestBody ReservaDTO reserva) {
        return ResponseEntity.ok(service.agregarReserva(reserva));
    }

    @Operation(summary = "Buscar reserva por su ID.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarReservaPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ReservaDTO reservaDTO = service.buscarReservaPorId(id);
        return ResponseEntity.ok(reservaDTO);
    }

    @Operation(summary = "Actualizar los datos de una reserva.")
    @PutMapping
    public ResponseEntity<ReservaDTO> actualizarReserva(@RequestBody ReservaDTO reservaDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarReserva(reservaDTO));
    }

    @Operation(summary = "Eliminar una reserva por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarReserva(id);
        return ResponseEntity.status(HttpStatus.OK).body("Reserva eliminada exitosamente.");
    }

    @Operation(summary = "Listar Reservas.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping
    public ResponseEntity<Collection<ReservaDTO>> listarReservas(){
        Collection<ReservaDTO> listaDeReservas = service.listarReservas();
        return ResponseEntity.ok(listaDeReservas);
    }

    //Endpoint Lista de Reservas por ID de Producto
    @Operation(summary = "Listar Reservas por ID de producto.")
    @GetMapping("/productos/{id}")
    @CrossOrigin(origins = "https://barbimt.github.io")
    public ResponseEntity<Collection<ReservaDTO>> listarReservasPorIdProducto(@PathVariable("id") Integer id){
        Collection<ReservaDTO> listaDeReservasPorIdProducto = service.listarReservasPorIdProducto(id);
        return ResponseEntity.ok(listaDeReservasPorIdProducto);
    }

    //Endpoint Lista de Reservas por ID de Usuario
    @Operation(summary = "Listar Reservas por ID de producto.")
    @GetMapping("/usuarios/{id}")
    @CrossOrigin(origins = "https://barbimt.github.io")
    public ResponseEntity<Collection<ReservaDTO>> listarReservasPorIdUsuario(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        Collection<ReservaDTO> listaDeReservasPorIdUsuario = service.listarReservasPorIdUsuario(id);
        if (listaDeReservasPorIdUsuario.isEmpty()){
            throw new ResourceNotFoundException("El usuario no tiene reservas registradas");
        }
        return ResponseEntity.ok(listaDeReservasPorIdUsuario);
    }
}
