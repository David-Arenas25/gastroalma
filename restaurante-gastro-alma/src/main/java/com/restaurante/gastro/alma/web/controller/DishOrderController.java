package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.service.DishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishorder")
public class DishOrderController {

    @Autowired
    private DishOrderService dishOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<DishOrder>> getAll() {
        try {
            List<DishOrder> orders = dishOrderService.getAll();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al obtener todas las órdenes de platillos: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<DishOrder> save(@RequestBody DishOrder dishOrder) {
        try {
            DishOrder savedOrder = dishOrderService.save(dishOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al guardar la orden de platillo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
