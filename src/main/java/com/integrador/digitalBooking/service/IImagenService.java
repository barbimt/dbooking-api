package com.integrador.digitalBooking.service;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.ImagenDTO;
import java.util.Collection;

public interface IImagenService {

    //Agregar Imagen
    ImagenDTO agregarImagen(ImagenDTO imagen);

    //Buscar Imagen por Id
    ImagenDTO buscarImagenPorId(Integer id) throws ResourceNotFoundException;

    //Actualizar Imagen
    ImagenDTO actualizarImagen(ImagenDTO imagen) throws BadRequestsExceptions;

    //Eliminar Imagen
    void eliminarImagen(Integer id) throws ResourceNotFoundException;

    //Listar Imagenes
    Collection<ImagenDTO> listarImagenes();
}
