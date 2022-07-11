package com.integrador.digitalBooking.repository;



import com.integrador.digitalBooking.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "SELECT * FROM reservas WHERE PRODUCTO_ID = :id", nativeQuery = true)
    List<Reserva> listarReservasPorIdProducto(@Param("id") Integer id);

    @Query(value = "SELECT * FROM reservas WHERE USUARIO_ID = :id", nativeQuery = true)
    List<Reserva> listarReservasPorIdUsuario(@Param("id") Integer id);
}
