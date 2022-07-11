package com.integrador.digitalBooking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.Categoria;
import com.integrador.digitalBooking.model.dto.CategoriaDTO;
import com.integrador.digitalBooking.repository.ICategoriaRepository;
import com.integrador.digitalBooking.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    ICategoriaRepository repository;
    @Autowired
    ObjectMapper mapper;

    //Agregar Categoría
    @Override
    public CategoriaDTO agregarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = mapper.convertValue(categoriaDTO,Categoria.class);
        return mapper.convertValue(repository.save(categoria),CategoriaDTO.class);
    }

    //Buscar Categoría por ID
    @Override
    public CategoriaDTO buscarCategoriaPorId(Integer id) throws ResourceNotFoundException {
        Optional<Categoria> categoria = repository.findById(id);
        if(categoria.isEmpty()){
            throw new ResourceNotFoundException("No existe una categoría con el ID: " + id+".");
        }
        return mapper.convertValue(categoria,CategoriaDTO.class);
    }

    //Actualizar Categoría
    @Override
    public CategoriaDTO actualizarCategoria(CategoriaDTO categoriaDTO) throws BadRequestsExceptions {
        if(repository.findById((categoriaDTO.getId())).isEmpty())
            throw new BadRequestsExceptions("No es posible actualizar la categoría con ID: "+categoriaDTO.getId()+", porque no está registrada.");
        Categoria categoria = mapper.convertValue(categoriaDTO,Categoria.class);
        return mapper.convertValue(repository.save(categoria),CategoriaDTO.class);
    }

    //Eliminar Categoría
    @Override
    public void eliminarCategoria(Integer id) throws ResourceNotFoundException {
        if(buscarCategoriaPorId(id) == null){
            throw new ResourceNotFoundException("No existe la categoría con ID: " +id+".");
        }
        repository.deleteById(id);
    }

    //Listar Categorías
    @Override
    public Collection<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = repository.findAll();
        Collection<CategoriaDTO> listaCategoriasDTO = new HashSet<>();

        for (Categoria c:categorias) {
            listaCategoriasDTO.add(mapper.convertValue(c, CategoriaDTO.class));
        }
        return listaCategoriasDTO;
    }
}
