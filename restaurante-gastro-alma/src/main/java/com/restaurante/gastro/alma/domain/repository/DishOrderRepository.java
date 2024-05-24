package com.restaurante.gastro.alma.domain.repository;

import com.restaurante.gastro.alma.domain.DishOrder;

import java.util.List;
import java.util.Optional;

public interface DishOrderRepository {

    List<DishOrder> getAll();

    DishOrder save(DishOrder dishOrder);
    void orderADish(int dishId, int orderId, String comentary, int quantity);
    Optional<DishOrder> getById(int orderId);

}
