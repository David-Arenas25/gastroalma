package com.restaurante.gastro.alma.domain.repository;
import com.restaurante.gastro.alma.domain.Drink;


import java.util.List;
import java.util.Optional;

public interface DrinkRepository {

    List<Drink> getAll();
    Drink save(Drink drink);
    void deleteDrink(int drinkId);
    Optional<Drink> getByID(int drinkId);
    void changeDrinkPrice(int drinkId ,double drinkPrice);

}
