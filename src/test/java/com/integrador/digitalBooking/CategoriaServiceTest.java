package com.integrador.digitalBooking;

import com.integrador.digitalBooking.model.dto.CategoriaDTO;
import com.integrador.digitalBooking.repository.ICategoriaRepository;
import com.integrador.digitalBooking.service.ICategoriaService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    ICategoriaService service;
    @Autowired
    ICategoriaRepository repository;

    @Test
    public void test01_agregarYBuscarCategoriaPorId() throws Exception {
        service.agregarCategoria(new CategoriaDTO("Hoteles","Encuentra la habitación perfecta en el hotel perfecto.", "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870"));
        CategoriaDTO categoriaAgregada = service.buscarCategoriaPorId(1);
        Assert.assertNotNull(categoriaAgregada);
    }

    @Test
    public void test02_actualizarCategoria() throws Exception {
        service.agregarCategoria(new CategoriaDTO("Hostel","Campestre", "https:www.google.com"));
        service.actualizarCategoria(new CategoriaDTO(2,"Hostel","¡El mejor lugar para conocer viajeros!", "https://images.unsplash.com/photo-1555854877-bab0e564b8d5?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869"));
        String descripcionCategoria = service.buscarCategoriaPorId(2).getDescripcion();
        assertEquals("¡El mejor lugar para conocer viajeros!",descripcionCategoria);
    }

    @Test
    public void test03_eliminarCategoria() throws Exception {
        service.eliminarCategoria(2);
        Assert.assertTrue(repository.findById(2).isEmpty());
    }

    @Test
    public void test04_traerTodasLasCategorias() throws Exception {
        CategoriaDTO c3 = service.agregarCategoria(new CategoriaDTO("Departamentos","Altos de Palermo", "https://images.unsplash.com/photo-1617859047452-8510bcf207fd?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870"));
        CategoriaDTO c4 = service.agregarCategoria(new CategoriaDTO("Bed and Breakfast","Home Sweet Home", "https://images.unsplash.com/photo-1555854877-bab0e564b8d5?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=869"));

        service.agregarCategoria(c3);
        service.agregarCategoria(c4);

        Collection<CategoriaDTO> categorias = service.listarCategorias();
        Assert.assertFalse(categorias.isEmpty());
        Assert.assertTrue(true);
        System.out.println(categorias);
    }

}
