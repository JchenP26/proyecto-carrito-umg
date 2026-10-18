package com.umg.carrito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> obtenerTodos() {
        String sql = "SELECT idProducto, nombre, codigo, CAST(imagen AS CHAR) AS imagen, precio FROM producto";
        return jdbcTemplate.queryForList(sql);
    }
}
