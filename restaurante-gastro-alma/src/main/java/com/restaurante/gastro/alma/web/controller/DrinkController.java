package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.Drink;
import com.restaurante.gastro.alma.domain.service.DrinkService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @ApiOperation("ver todas las bebidas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "bebidas no encontradas")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Drink>> getAll() {
        try {
            List<Drink> drinks = drinkService.getAll();
            return new ResponseEntity<>(drinks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("guardar una bebida")
    @ApiResponses({
            @ApiResponse(code = 200, message = "bebida guardada correctamente"),
            @ApiResponse(code = 500, message = "la bebida no fue guardada")
    })
    @PostMapping("/save")
    public ResponseEntity<Drink> save(@RequestBody Drink drink) {
        try {
            Drink savedDrink = drinkService.save(drink);
            return new ResponseEntity<>(savedDrink, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("borrar una bebida")
    @ApiResponses({
            @ApiResponse(code = 200, message = "bebida borrada"),
            @ApiResponse(code = 500, message = "la bebida no se borro")
    })
    @DeleteMapping("/delete/{drinkId}")
    public ResponseEntity<Drink> deleteDrink(@PathVariable int drinkId) {
        try {
            if (drinkService.getByID(drinkId).isPresent()) {
                drinkService.deleteDrink(drinkId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("buscar bebida por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "bebida encontrada"),
            @ApiResponse(code = 500, message = "bebida no encontrada")
    })
    @GetMapping("/id/{drinkId}")
    public ResponseEntity<Drink> getByID(@PathVariable int drinkId) {
        try {
            return drinkService.getByID(drinkId)
                    .map(drink -> new ResponseEntity<>(drink, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("cambiar el precio de la bebida")
    @ApiResponses({
            @ApiResponse(code = 200, message = "precio de bebida actualizado"),
            @ApiResponse(code = 500, message = "el precio no se cambio")
    })
    @PostMapping("/changeprice")
    public ResponseEntity<String> changeDrinkPrice(@RequestParam int drinkId, @RequestParam double drinkPrice) {
        try {
            drinkService.changeDrinkPrice(drinkId, drinkPrice);
            return new ResponseEntity<>("Drink price changed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
