package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.domain.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("ver todos los pedidos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "pedidos encontrados"),
            @ApiResponse(code = 500, message = "error al encontrar los pedidos")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<Order> orders = orderService.getAll();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener todas las órdenes: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("crear un pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "pedido creado"),
            @ApiResponse(code = 500, message = "error al crear el pedido")
    })
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Order order) {
        try {
            Order savedOrder = orderService.save(order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("borrar pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "pedido borrado"),
            @ApiResponse(code = 500, message = "el pedido no se borró")
    })
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

    @ApiOperation("encontrar pedido por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "pedido encontrado"),
            @ApiResponse(code = 500, message = "el pedido no fue encontrado")
    })
    @GetMapping("id/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int orderId) {
        try {
            return ResponseEntity.of(orderService.getByID(orderId));
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener la orden por ID: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("calcular precio de pedido por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "el precio fue calculado correctamente"),
            @ApiResponse(code = 500, message = "error al calcular el precio")
    })
    @PostMapping("/calculate")
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

    @ApiOperation("aplicar descuento al precio del pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "descuento aplicado"),
            @ApiResponse(code = 500, message = "error al aplicar el descuento")
    })
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
