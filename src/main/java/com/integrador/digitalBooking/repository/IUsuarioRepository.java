package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Producto;
import com.integrador.digitalBooking.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    boolean existsByEmail(String email);
}
