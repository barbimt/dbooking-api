package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ProductoDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

public interface IProductoService {

    //Agregar Producto
    ProductoDTO agregarProducto(ProductoDTO producto);

    //Buscar Producto por Id
    ProductoDTO buscarProductoPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Producto
    ProductoDTO actualizarProducto(ProductoDTO producto) throws BadRequestsExceptions;

    //Eliminar Producto
    void eliminarProducto(Integer id) throws ResourceNotFoundException;

    //Listar Productos
    Collection<ProductoDTO> listarProductos();

    //Listar Productos por categoria
    Collection<ProductoDTO> listarProductosPorCategoria(Integer id);

    //Listar Productos por ciudad
    Collection<ProductoDTO> listarProductosPorCiudad(Integer id);

    //Listar Productos por fechas
    Collection<ProductoDTO> listarProductosPorFechas(Date fechaI, Date fechaF);

    //Listar Productos por ciudad y fechas
    Collection<ProductoDTO> listarProductosPorCiudadesYFechas( Integer id, Date fechaI, Date fechaF);
}
