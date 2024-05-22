package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.DrinkOrder;
import com.restaurante.gastro.alma.domain.repository.DrinkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkOrderService {

    @Autowired
    private DrinkOrderRepository drinkOrderRepository;

    public List<DrinkOrder> getAll() {
        try {
            return drinkOrderRepository.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las órdenes de bebidas.", e);
        }
    }

    public DrinkOrder save(DrinkOrder drinkOrder) {
        try {
            return drinkOrderRepository.save(drinkOrder);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la orden de bebida.", e);
        }
    }

    public DrinkOrder orderADrink(int idBebida, int idPlato) {
        try {
            return drinkOrderRepository.orderADrink(idBebida, idPlato);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al ordenar una bebida.", e);
        }
    }

}
