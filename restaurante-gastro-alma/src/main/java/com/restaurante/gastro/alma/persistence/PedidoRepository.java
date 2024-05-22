package com.restaurante.gastro.alma.persistence;
import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.domain.repository.OrderRepository;
import com.restaurante.gastro.alma.persistence.Mapper.OrderMapper;
import com.restaurante.gastro.alma.persistence.crud.PedidoCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository implements OrderRepository {

    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    @Autowired
    private OrderMapper mapper;
    @Override
    public List<Order> getAll(){
        return mapper.toOrders((List<Pedido>) pedidoCrudRepository.findAll());
    }

    @Override
    public Order save(Order order){
       Pedido pedido = mapper.toPedido(order);
       pedidoCrudRepository.save(pedido);
       return mapper.toOrder(pedido);
    }

    @Override
    public void deleteOrder(int orderId){
        pedidoCrudRepository.deleteById(orderId);
    }

    @Override
    public Optional<Order> getByID(int orderId) {
        return pedidoCrudRepository.findById(orderId).map(pedido -> mapper.toOrder(pedido));

    }

    @Override
    public void calculateOrderPrice(int pID_PEDIDO) {
         pedidoCrudRepository.calcularPrecioPedido(pID_PEDIDO);
    }

    @Override
    public void applyDiscount(int orderId, float discount) {
         pedidoCrudRepository.aplicarDescuento(orderId, discount);
    }


}
