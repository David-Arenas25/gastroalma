package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.Waiter;
import com.restaurante.gastro.alma.domain.service.WaiterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    @GetMapping("/all")
    @ApiOperation("Obtener todos los camareros")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<List<Waiter>> getAll() {
        try {
            return new ResponseEntity<>(waiterService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Eliminar camarero por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity deleteById(@PathVariable("id") int waiterId) {
        try {
            if (waiterService.findById(waiterId).isPresent()) {
                waiterService.deleteWaiter(waiterId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Obtener camarero por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Waiter> getById(@PathVariable("id") int waiterId) {
        try {
            if (waiterService.findById(waiterId).isPresent()) {
                return ResponseEntity.of(waiterService.findById(waiterId));
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    @ApiOperation("Guardar camarero")
    @ApiResponses({
            @ApiResponse(code = 201, message = "camarero guardado"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<Waiter> save(@RequestBody Waiter waiter) {
        try {
            Waiter savedWaiter = waiterService.save(waiter);
            return new ResponseEntity<>(savedWaiter, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
