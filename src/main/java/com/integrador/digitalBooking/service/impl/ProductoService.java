package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Producto;
import com.integrador.digitalBooking.model.dto.ProductoDTO;
import com.integrador.digitalBooking.repository.IProductoRepository;
import com.integrador.digitalBooking.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ObjectMapper mapper;
    @Autowired
    IProductoRepository repository;

    @Override
    public ProductoDTO agregarProducto(ProductoDTO productoDTO) {
        Producto producto = mapper.convertValue(productoDTO,Producto.class);
        return mapper.convertValue(repository.save(producto), ProductoDTO.class);
    }

    @Override
    public ProductoDTO buscarProductoPorId(Integer id) throws ResourceNotFoundException {
        Optional<Producto> producto = repository.findById(id);
        if(producto.isEmpty()){
            throw new ResourceNotFoundException("No existe un producto con el ID: " + id+".");
        }
        return mapper.convertValue(producto,ProductoDTO.class);
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) throws BadRequestsExceptions {
        if(repository.findById((productoDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar el producto con ID: "+productoDTO.getId()+", porque no está registrado.");
        Producto producto = mapper.convertValue(productoDTO,Producto.class);
        return mapper.convertValue(repository.save(producto),ProductoDTO.class);
    }

    @Override
    public void eliminarProducto(Integer id) throws ResourceNotFoundException {
        if(buscarProductoPorId(id) == null){
            throw new ResourceNotFoundException("No existe el producto con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<ProductoDTO> listarProductos() {
        Random listaRandom = new Random();
        List<Producto> productos = repository.findAll();
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();
        for (Producto i:productos) {
            listaProductosDTO.add(mapper.convertValue(i, ProductoDTO.class));
        }
        Collections.shuffle(listaProductosDTO);
        return listaProductosDTO;
    }

    @Override
    public Collection<ProductoDTO> listarProductosPorCategoria(Integer id) {
        List<Producto> productos = repository.listarProductosPorCategoria(id);
        Collection<ProductoDTO> listaProductosDTO = new HashSet<>();
        for (Producto i:productos) {
            listaProductosDTO.add(mapper.convertValue(i, ProductoDTO.class));
        }
        return listaProductosDTO;
    }

    @Override
    public Collection<ProductoDTO> listarProductosPorCiudad(Integer id) {
        List<Producto> productos = repository.listarProductosPorCiudad(id);
        Collection<ProductoDTO> listaProductosDTO = new HashSet<>();
        for (Producto i:productos) {
            listaProductosDTO.add(mapper.convertValue(i, ProductoDTO.class));
        }
        return listaProductosDTO;
    }

    @Override
    public Collection<ProductoDTO> listarProductosPorFechas(Date fechaI, Date fechaF) {
        List<Producto> productos = repository.listarProductosPorFechas(fechaI, fechaF);
        Collection<ProductoDTO> listaProductosDTO = new HashSet<>();
        for (Producto i:productos) {
            listaProductosDTO.add(mapper.convertValue(i, ProductoDTO.class));
        }
        return listaProductosDTO;
    }


    @Override
    public Collection<ProductoDTO> listarProductosPorCiudadesYFechas(Integer id, Date fechaI, Date fechaF) {
        List<Producto> productos = repository.listarProductosPorCiudadesYFechas(fechaI, fechaF, id);
        Collection<ProductoDTO> listaProductosDTO = new HashSet<>();
        for (Producto i:productos) {
            listaProductosDTO.add(mapper.convertValue(i, ProductoDTO.class));
        }
        return listaProductosDTO;
    }


}
