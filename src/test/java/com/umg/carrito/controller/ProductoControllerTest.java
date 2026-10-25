package com.umg.carrito.controller;

import com.umg.carrito.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductoControllerTest {

    private ProductoController productoController;

    @BeforeEach
    void setUp() throws Exception {
        productoController = new ProductoController();
        
        // Configurar un JdbcTemplate real desacoplado
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/cc");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Field field = ProductoController.class.getDeclaredField("jdbcTemplate");
        field.setAccessible(true);
        field.set(productoController, jdbcTemplate);
    }

    @Test
    void testInstanciacionController() {
        assertNotNull(productoController);
    }
}
