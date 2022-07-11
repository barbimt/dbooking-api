package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
}
