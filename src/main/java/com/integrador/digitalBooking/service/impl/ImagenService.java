package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Imagen;
import com.integrador.digitalBooking.model.dto.ImagenDTO;
import com.integrador.digitalBooking.repository.ImagenRepository;
import com.integrador.digitalBooking.service.IImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService implements IImagenService {
    @Autowired
    ImagenRepository repository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public ImagenDTO agregarImagen(ImagenDTO imagenDTO) {
        Imagen imagen = mapper.convertValue(imagenDTO,Imagen.class);
        return mapper.convertValue(repository.save(imagen), ImagenDTO.class);
    }

    @Override
    public ImagenDTO buscarImagenPorId(Integer id) throws ResourceNotFoundException {
        Optional<Imagen> imagen = repository.findById(id);
        if(imagen.isEmpty()){
            throw new ResourceNotFoundException("No existe una imagen con el ID: " + id+".");
        }
        return mapper.convertValue(imagen,ImagenDTO.class);
    }

    @Override
    public ImagenDTO actualizarImagen(ImagenDTO imagenDTO) throws BadRequestsExceptions {
        if(repository.findById((imagenDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la imagen con ID: "+imagenDTO.getId()+", porque no está registrada.");
        Imagen imagen = mapper.convertValue(imagenDTO,Imagen.class);
        return mapper.convertValue(repository.save(imagen),ImagenDTO.class);
    }

    @Override
    public void eliminarImagen(Integer id) throws ResourceNotFoundException {
        if(buscarImagenPorId(id) == null){
            throw new ResourceNotFoundException("No existe la imagen con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    @Override
    public Collection<ImagenDTO> listarImagenes() {
        List<Imagen> imagenes = repository.findAll();
        Collection<ImagenDTO> listaImagenesDTO = new HashSet<>();

        for (Imagen i:imagenes) {
            listaImagenesDTO.add(mapper.convertValue(i, ImagenDTO.class));
        }
        return listaImagenesDTO;
    }
}
