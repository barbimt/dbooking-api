package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ProductoDTO;
import com.integrador.digitalBooking.service.IProductoService;
import com.integrador.digitalBooking.util.Util;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("productos")
public class ProductoController {

    private final IProductoService service;
    public ProductoController(IProductoService service){
        this.service = service;
    }

    @Operation(summary = "Crear un producto.")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(service.agregarProducto(producto));
    }

    @Operation(summary = "Buscar producto por su ID.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ProductoDTO productoDTO = service.buscarProductoPorId(id);
        return ResponseEntity.ok(productoDTO);
    }

    @Operation(summary = "Actualizar los datos de un producto.")
    @PutMapping
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoDTO productoDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarProducto(productoDTO));
    }

    @Operation(summary = "Eliminar un producto por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado exitosamente.");
    }

    @Operation(summary = "Listar Productos.")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Collection<ProductoDTO>> listarProductos(){
        Collection<ProductoDTO> listaDeProductos = service.listarProductos();
        return ResponseEntity.ok(listaDeProductos);
    }

    //Endpoint Lista de Productos por categoria
    @Operation(summary = "Listar Productos por categoría.")
    @GetMapping("/categoria/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Collection<ProductoDTO>> listarProductosPorCategoria(@PathVariable("id") Integer id){
        Collection<ProductoDTO> listaDeProductos = service.listarProductosPorCategoria(id);
        return ResponseEntity.ok(listaDeProductos);
    }

    //Endpoint Lista de Productos por ciudad
    @Operation(summary = "Listar Productos por ciudad.")
    @GetMapping("/ciudad/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Collection<ProductoDTO>> listarProductosPorCiudad(@PathVariable("id") Integer id){
        Collection<ProductoDTO> listaDeProductos = service.listarProductosPorCiudad(id);
        return ResponseEntity.ok(listaDeProductos);
    }

    //Endpoint Lista de Productos por fecha
    @Operation(summary = "Listar Productos por fechas.")
    @GetMapping("/{fechaI}/{fechaF}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Collection<ProductoDTO>> listarProductosPorFechas(@PathVariable("fechaI")
    String fechaI, @PathVariable("fechaF") String fechaF) {
        Collection<ProductoDTO> listaDeProductos = service.listarProductosPorFechas(Date.valueOf(fechaI), Date.valueOf(fechaF));
        return ResponseEntity.ok(listaDeProductos);
    }

    
    //Endpoint lista de Productos por ciudad e intervalo de fechas}
    @Operation(summary = "Listar Productos por ciudad e intervalo de fechas.")
    @GetMapping("/ciudad/{id}/{fechaI}/{fechaF}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Collection<ProductoDTO>> listarProductosPorCiudadesYFechas(@PathVariable("id") Integer id, @PathVariable("fechaI")
            String fechaI, @PathVariable("fechaF") String fechaF) {
        Collection<ProductoDTO> listaDeProductos = service.listarProductosPorCiudadesYFechas(id, Date.valueOf(fechaI), Date.valueOf(fechaF));
        return ResponseEntity.ok(listaDeProductos);
    }
}
