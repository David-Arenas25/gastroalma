package com.restaurante.gastro.alma.domain.repository;

import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.DrinkOrder;

import java.util.List;
import java.util.Optional;

public interface DrinkOrderRepository {

    List<DrinkOrder> getAll();
    DrinkOrder save(DrinkOrder drinkOrder);
    DrinkOrder orderADrink(int idBebida, int idPlato);

}
