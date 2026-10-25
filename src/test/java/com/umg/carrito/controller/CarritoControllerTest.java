package com.umg.carrito.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CarritoControllerTest {

    private CarritoController carritoController;

    @BeforeEach
    void setUp() throws Exception {
        carritoController = new CarritoController();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/cc");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Field field = CarritoController.class.getDeclaredField("jdbcTemplate");
        field.setAccessible(true);
        field.set(carritoController, jdbcTemplate);
    }

    @Test
    void testInstanciacionController() {
        assertNotNull(carritoController);
    }
}
