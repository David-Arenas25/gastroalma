package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<Order> orders = orderService.getAll();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener todas las órdenes: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Order order) {
        try {
            Order savedOrder = orderService.save(order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int orderId) {
        try {
            if (orderService.getByID(orderId).isPresent()) {
                orderService.deleteDish(orderId);
                return new ResponseEntity<>("La orden se ha eliminado correctamente", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("La orden con ID " + orderId + " no existe", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int orderId) {
        try {
            return ResponseEntity.of(orderService.getByID(orderId));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener la orden por ID: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/calc")
    public ResponseEntity<Float> calcularPrecioPedido(@RequestParam("pID_PEDIDO") int pID_PEDIDO) {
        try {
            if (orderService.getByID(pID_PEDIDO).isPresent()){
            orderService.calculateOrderPrice(pID_PEDIDO);
            return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping("/apply")
    public ResponseEntity<?> applyDiscount(@RequestParam("orderId") int orderId, @RequestParam("discount") float discount) {
        try {
            Optional<Order> orderOptional = orderService.getByID(orderId);
            if (orderOptional.isPresent()) {
                Order order = orderOptional.get();
                if (discount > 0 && discount <= 100) {
                    orderService.applyDiscount(orderId, discount);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
