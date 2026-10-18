package com.umg.carrito.repository;

import com.umg.carrito.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT idProducto, nombre, codigo, CAST(imagen AS CHAR) as imagen, precio FROM producto", nativeQuery = true)
    List<Producto> obtenerTodosNativo();
}
