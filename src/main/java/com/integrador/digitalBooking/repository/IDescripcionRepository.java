package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Descripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IDescripcionRepository extends JpaRepository<Descripcion, Integer> {
}
