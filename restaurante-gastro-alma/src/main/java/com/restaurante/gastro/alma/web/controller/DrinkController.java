package com.restaurante.gastro.alma.web.controller;
import com.restaurante.gastro.alma.domain.Drink;
import com.restaurante.gastro.alma.domain.service.DrinkService;
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

    @GetMapping("/all")
    public ResponseEntity<List<Drink>> getAll(){
        return new ResponseEntity<>(drinkService.getAll(), HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<Drink> save(@RequestBody Drink drink){
        return new ResponseEntity<>(drinkService.save(drink),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Drink> deleteDrink(@PathVariable int drinkId){

        if (drinkService.getByID(drinkId).isPresent()) {
            drinkService.deleteDrink(drinkId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<Drink> getByID(@PathVariable int drinkId){
        if (drinkService.getByID(drinkId).isPresent()){
            return ResponseEntity.of(drinkService.getByID(drinkId));
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/changeprice")
    public void changeDrinkPrice(@RequestParam int drinkId ,@RequestParam double drinkPrice){
        drinkService.changeDrinkPrice(drinkId,drinkPrice);
    }
}
