package com.restaurante.gastro.alma.web.controller;

import com.restaurante.gastro.alma.domain.DrinkOrder;
import com.restaurante.gastro.alma.domain.service.DrinkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinkorder")
public class DrinkOrderController {

    @Autowired
    private DrinkOrderService drinkOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<DrinkOrder>> getAll(){
        try {
            List<DrinkOrder> orders = drinkOrderService.getAll();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<DrinkOrder> save(@RequestBody DrinkOrder drinkOrder){
        try {
            DrinkOrder saveOrder = drinkOrderService.save(drinkOrder);
            return new ResponseEntity<>(saveOrder,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orderadrink")
    public ResponseEntity<DrinkOrder> orderADrink(@RequestParam int drinkId ,@RequestParam int orderId, @RequestParam String comentary, @RequestParam int quantity){
        try {
            drinkOrderService.orderADrink(drinkId, orderId, comentary, quantity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
