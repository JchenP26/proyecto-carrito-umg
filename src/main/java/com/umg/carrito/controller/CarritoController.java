package com.umg.carrito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // GET: Obtener todos los ítems del carrito con detalles del producto
    @GetMapping
    public List<Map<String, Object>> obtenerCarrito() {
        String sql = "SELECT sc.idShoppingCart, sc.idProducto, sc.codUsuario, sc.cantidad, " +
                     "p.nombre, p.codigo, CAST(p.imagen AS CHAR) AS imagen, p.precio " +
                     "FROM shopping_cart sc " +
                     "JOIN producto p ON sc.idProducto = p.idProducto";
        return jdbcTemplate.queryForList(sql);
    }

    // POST: Agregar un ítem al carrito
    @PostMapping
    public Map<String, Object> agregarAlCarrito(@RequestBody Map<String, Object> body) {
        String sql = "INSERT INTO shopping_cart (idProducto, codUsuario, cantidad) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, 
            body.get("idProducto"), 
            body.getOrDefault("codUsuario", "USR001"), 
            body.getOrDefault("cantidad", 1)
        );
        return Map.of("status", "OK", "mensaje", "Producto agregado al carrito");
    }

    // DELETE: Eliminar un ítem específico del carrito
    @DeleteMapping("/{id}")
    public Map<String, Object> eliminarItem(@PathVariable Integer id) {
        String sql = "DELETE FROM shopping_cart WHERE idShoppingCart = ?";
        jdbcTemplate.update(sql, id);
        return Map.of("status", "OK", "mensaje", "Producto eliminado del carrito");
    }

    // DELETE: Vaciar todo el carrito
    @DeleteMapping
    public Map<String, Object> vaciarCarrito() {
        jdbcTemplate.update("DELETE FROM shopping_cart");
        return Map.of("status", "OK", "mensaje", "Carrito vaciado");
    }
}
