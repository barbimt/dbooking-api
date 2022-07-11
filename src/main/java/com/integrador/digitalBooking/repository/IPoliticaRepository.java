package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Politica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPoliticaRepository extends JpaRepository<Politica, Integer> {
}
