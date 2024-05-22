package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.Dish;
import com.restaurante.gastro.alma.domain.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAll(){
        try {
            return dishRepository.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Dish save(Dish dish){
        try {
            return dishRepository.save(dish);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteDish(int dishId ){
        try {
            dishRepository.deleteDish(dishId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Dish> getByID(int idPlato){
        try {
            return dishRepository.getByID(idPlato);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void changeDishPrice( int dishId ,double dishPrice){
        try {
            dishRepository.changeDishPrice(dishId,dishPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
