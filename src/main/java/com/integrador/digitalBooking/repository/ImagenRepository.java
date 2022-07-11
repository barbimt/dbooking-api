package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}
