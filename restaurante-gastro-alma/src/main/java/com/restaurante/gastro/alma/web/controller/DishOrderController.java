package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.service.DishOrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishorder")
public class DishOrderController {

    @Autowired
    private DishOrderService dishOrderService;

    @GetMapping("/all")
    @ApiOperation("buscar todas las ventas de platos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ventas encontradas"),
            @ApiResponse(code = 500, message = "error al intentar acceder a las ventas")
    })
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
    @ApiOperation("guardar una venta de plato")
    @ApiResponses({
            @ApiResponse(code = 200, message = "plato guardado correctamente"),
            @ApiResponse(code = 500, message = "el plato no se guardo")
    })
    public ResponseEntity<DishOrder> save(@RequestBody DishOrder dishOrder) {
        try {
            DishOrder savedOrder = dishOrderService.save(dishOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al guardar la orden de platillo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("pedir un plato")
    @ApiResponses({
            @ApiResponse(code = 200, message = "pedido realizado correctamente"),
            @ApiResponse(code = 500, message = "el pedido no se realizo")
    })
    @GetMapping("orderadish")
    public ResponseEntity<DishOrder> orderADish(@RequestParam int dishId, @RequestParam int orderId, @RequestParam String commentary, @RequestParam int quantity) {
        try {
                dishOrderService.orderADish(dishId, orderId, commentary, quantity);
                return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.err.println("Error al procesar la orden del platillo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("buscar venta de plato por id de pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "venta encontrada"),
            @ApiResponse(code = 500, message = "la venta no fue encontrada")
    })

    @GetMapping("id/{id}")
    public ResponseEntity<DishOrder> getById(@PathVariable("id") int orderId) {
        try {
            return ResponseEntity.of(dishOrderService.getByOrderId(orderId));
        } catch (Exception e) {
            System.err.println("Error al obtener la orden del platillo por ID: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
