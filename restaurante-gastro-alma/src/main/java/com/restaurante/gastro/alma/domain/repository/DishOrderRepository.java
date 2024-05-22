package com.restaurante.gastro.alma.domain.repository;

import com.restaurante.gastro.alma.domain.DishOrder;

import java.util.List;

public interface DishOrderRepository {

    List<DishOrder> getAll();

    DishOrder save(DishOrder dishOrder);

}
