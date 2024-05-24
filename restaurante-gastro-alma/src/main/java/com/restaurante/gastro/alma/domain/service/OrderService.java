package com.restaurante.gastro.alma.domain.service;

import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        try {
            return orderRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las órdenes", e);
        }
    }

    public Order save(Order order) {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la orden", e);
        }
    }

    public void deleteDish(int orderId) {
        try {
            orderRepository.deleteOrder(orderId);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el plato de la orden", e);
        }
    }

    public Optional<Order> getByID(int orderId) {
        try {
            return orderRepository.getByID(orderId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la orden por ID", e);
        }
    }

    public void calculateOrderPrice(int pID_PEDIDO) {
        try {
            orderRepository.calculateOrderPrice(pID_PEDIDO);
        } catch (Exception e) {
            throw new RuntimeException("Error al calcular el precio de la orden", e);
        }
    }

    public void applyDiscount(int orderId, float discount) throws Exception {
        try {
            Optional<Order> order = orderRepository.getByID(orderId);
            if (order.isPresent()) {
                if (discount <= 100 && discount > 0) {
                    orderRepository.applyDiscount(orderId, discount);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error al aplicar el descuento al pedido: " + e.getMessage());
        }
    }


}



