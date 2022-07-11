package com.integrador.digitalBooking.repository;

import com.integrador.digitalBooking.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM productos WHERE CATEGORIA_ID = :id", nativeQuery = true)
    List<Producto> listarProductosPorCategoria(@Param("id") Integer id);

    @Query(value = "SELECT * FROM productos WHERE CIUDAD_ID = :id", nativeQuery = true)
    List<Producto> listarProductosPorCiudad(@Param("id") Integer id);

    //@Query(value = "SELECT * FROM productos, reservas WHERE FECHA_INICIAL = :fechaI and FECHA_FINAL = :fechaF and CIUDAD_ID = :id", nativeQuery = true )
    //List<Producto> listarProductosPorCiudadYFechas(@Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF, @Param("id") Integer id);

    //@Query(value = "SELECT p" +
      //          "FROM productos p" +
        //        "WHERE p.city.id = :id" +
          //      "AND p.id NOT IN (SELECT p.id FROM Product p JOIN Reservation r ON r.products_id = p.id WHERE (r.start_date <= :start_date AND  r.end_date >= :start_date) OR (r.start_date <= :end_date AND r.end_date >= :end_date) OR ( r.start_date >= :start_date AND r.start_date <= :end_date) OR (r.end_date >= :start_date AND r.end_date <= :end_date))", nativeQuery = true)
    //List<Producto> listarProductosPorCiudadYFechas(@Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF, @Param("id") Integer id);






    @Query(value = "SELECT * FROM integrador.productos p\n" +
            "    WHERE NOT EXISTS(SELECT * FROM integrador.reservas r WHERE r.producto_id = p.id\n" +
            "            AND ((:fechaI BETWEEN r.fecha_inicial AND r.fecha_final)\n" +
            "    OR (:fechaF BETWEEN r.fecha_inicial AND r.fecha_final)\n" +
            "    OR (r.fecha_inicial BETWEEN :fechaI AND :fechaF)\n" +
            "    OR (r.fecha_final BETWEEN :fechaI AND :fechaF)));", nativeQuery = true)
    List<Producto> listarProductosPorFechas(@Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF);

    @Query(value = "SELECT * FROM integrador.productos p\n" +
            "    WHERE NOT EXISTS(SELECT * FROM integrador.reservas r WHERE r.producto_id = p.id\n" +
            "            AND ((:fechaI BETWEEN r.fecha_inicial AND r.fecha_final)\n" +
            "    OR (:fechaF BETWEEN r.fecha_inicial AND r.fecha_final)\n" +
            "    OR (r.fecha_inicial BETWEEN :fechaI AND :fechaF)\n" +
            "    OR (r.fecha_final BETWEEN :fechaI AND :fechaF)))" +
            "    AND p.ciudad_id = :id", nativeQuery = true)
    List<Producto> listarProductosPorCiudadesYFechas(@Param("fechaI") Date fechaI, @Param("fechaF") Date fechaF, @Param("id") Integer id);
    }

    // "SELECT * " +
//                "FROM productos p"+
//                "LEFT JOIN reservas r ON p.id = r.producto_id" +
//                "WHERE (p.ciudad_id = :id) " +
//                "AND r.producto_id IS NULL " +
//                "AND (r.fecha_inicial NOT BETWEEN :fechaI AND :fechaF " +
//                "AND r.fecha_final NOT BETWEEN :fechaI AND :fechaF) "