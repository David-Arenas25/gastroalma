package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.repository.DishOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishOrderService {

    @Autowired
    private DishOrderRepository dishOrderRepository;

    public List<DishOrder> getAll() {
        try {
            return dishOrderRepository.getAll();
        } catch (Exception e) {
            // Manejo de la excepción
            System.err.println("Error al obtener todas las órdenes de platillos: " + e.getMessage());
            return null;
        }
    }

    public DishOrder save(DishOrder dishOrder) {
        try {
            return dishOrderRepository.save(dishOrder);
        } catch (Exception e) {
            // Manejo de la excepción
            System.err.println("Error al guardar la orden de platillo: " + e.getMessage());
            return null;
        }
    }

}
