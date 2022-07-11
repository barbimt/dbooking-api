package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
