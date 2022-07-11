package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
