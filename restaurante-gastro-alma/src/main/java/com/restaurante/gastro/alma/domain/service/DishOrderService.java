package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.repository.DishOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void orderADish(int dishId, int orderId, String commentary, int quantity) {
        try {
            dishOrderRepository.orderADish(dishId, orderId, commentary, quantity);
        } catch (Exception e) {

            System.err.println("Error al procesar la orden del platillo: " + e.getMessage());
        }
    }

    public Optional<DishOrder> getByOrderId(int orderId) {
        try {
            return dishOrderRepository.getById(orderId);
        } catch (Exception e) {
            System.err.println("Error al obtener la orden del platillo por ID: " + e.getMessage());
            return null;
        }
    }



}
