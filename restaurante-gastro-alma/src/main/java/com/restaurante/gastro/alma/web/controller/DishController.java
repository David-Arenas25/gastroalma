package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.Dish;
import com.restaurante.gastro.alma.domain.service.DishService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @ApiOperation("ver todos los platos disponibles")
    @ApiResponses({
            @ApiResponse(code = 200, message = "platos encontrados"),
            @ApiResponse(code = 500, message = "problema al intentar guardar los platos")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Dish>> getAll(){
        try {
            List<Dish> dishes = dishService.getAll();
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("Guardar un plato")
    @ApiResponses({
            @ApiResponse(code = 200, message = "plato guardado"),
            @ApiResponse(code = 500, message = "el plato no se pudo guardar")
    })
    @PostMapping("/save")
    public ResponseEntity<Dish> save(@RequestBody Dish dish){
        try {
            return new ResponseEntity<>(dishService.save(dish), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("borrar un plato")
    @ApiResponses({
            @ApiResponse(code = 200, message = "plato borrado"),
            @ApiResponse(code = 500, message = "el plato no se borro")
    })
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int dishId){
        try {
            if (dishService.getByID(dishId).isPresent()){
                dishService.deleteDish(dishId);
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("buscar plato por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "plato encontrado"),
            @ApiResponse(code = 500, message = "plato no encontrado")
    })
    @GetMapping("id/{id}")
    public ResponseEntity<Dish> getByID(@PathVariable("id") int idPlato){
        try {
            if (dishService.getByID(idPlato).isPresent()) {
                return ResponseEntity.of(dishService.getByID(idPlato));
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation("cambiar precio de plato")
    @ApiResponses({
            @ApiResponse(code = 200, message = "precio del plato actualizado"),
            @ApiResponse(code = 500, message = "el precio del plato no se cambio")
    })
    @PostMapping("/changeprice")
    public ResponseEntity<String> changeDishPrice(@RequestParam int dishId ,@RequestParam double dishPrice) {
        try {
            dishService.changeDishPrice(dishId,dishPrice);
            return ResponseEntity.ok("Dish price changed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while changing dish price");
        }
    }

}

