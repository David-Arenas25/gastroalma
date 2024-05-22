package com.restaurante.gastro.alma.domain.repository;
import com.restaurante.gastro.alma.domain.DrinkOrder;

import java.util.List;

public interface DrinkOrderRepository {

    List<DrinkOrder> getAll();
    DrinkOrder save(DrinkOrder drinkOrder);
    void orderADrink(int drinId, int orderId, String comentary, int quantity);

}
