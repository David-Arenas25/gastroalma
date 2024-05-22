package com.restaurante.gastro.alma.domain.repository;

import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.persistence.entity.Bebida;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();
    Order save(Order order);
    void deleteOrder(int orderId);
    Optional<Order> getByID(int orderId);
    void calculateOrderPrice(int pID_PEDIDO);
    void applyDiscount(int orderId, float discount);

}
