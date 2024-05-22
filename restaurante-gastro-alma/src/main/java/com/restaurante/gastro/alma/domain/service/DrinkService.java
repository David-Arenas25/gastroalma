package com.restaurante.gastro.alma.domain.service;
import com.restaurante.gastro.alma.domain.Drink;
import com.restaurante.gastro.alma.domain.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getAll(){
        try {
            return drinkRepository.getAll();
        } catch (Exception e) {
            System.err.println("Error al obtener todas las bebidas: " + e.getMessage());
            return null;
        }
    }

    public Drink save(Drink drink){
        try {
            return drinkRepository.save(drink);
        } catch (Exception e) {
            System.err.println("Error al guardar la bebida: " + e.getMessage());
            return null;
        }
    }

    public void deleteDrink(int drinkId){
        try {
            drinkRepository.deleteDrink(drinkId);
        } catch (Exception e) {
            System.err.println("Error al eliminar la bebida: " + e.getMessage());
        }
    }

    public Optional<Drink> getByID(int drinkId){
        try {
            return drinkRepository.getByID(drinkId);
        } catch (Exception e) {
            System.err.println("Error al obtener la bebida por ID: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void changeDrinkPrice(int drinkId ,double drinkPrice){
        try {
            drinkRepository.changeDrinkPrice(drinkId,drinkPrice);
        } catch (Exception e) {
            System.err.println("Error al cambiar el precio de la bebida: " + e.getMessage());
        }
    }
}
