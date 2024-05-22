package com.restaurante.gastro.alma.domain.repository;
import com.restaurante.gastro.alma.domain.Dish;
import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> getAll();
    Dish save(Dish dish);
    void deleteDish(int dishId);
    Optional<Dish> getByID(int dishId);
    void changeDishPrice( int dishId ,double dishPrice);

}
