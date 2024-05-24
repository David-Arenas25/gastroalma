package com.restaurante.gastro.alma.persistence;
import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.domain.repository.DishOrderRepository;
import com.restaurante.gastro.alma.persistence.Mapper.DishOrderMapper;
import com.restaurante.gastro.alma.persistence.crud.PedidoPlatoCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.PedidoPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoPlatoRepository implements DishOrderRepository {

    @Autowired
    private PedidoPlatoCrudRepository pedidoPlatoCrudRepository;

    @Autowired
    private DishOrderMapper mapper;


    @Override
    public List<DishOrder> getAll() {
        return mapper.toDishesOrders((List<PedidoPlato>) pedidoPlatoCrudRepository.findAll());
    }

    @Override
    public DishOrder save(DishOrder dishOrder) {

        PedidoPlato pedidoPlato = mapper.toPedidoPlato(dishOrder);
        pedidoPlatoCrudRepository.save(pedidoPlato);
        return mapper.toDishOrder(pedidoPlato);
    }

    @Override
    public void orderADish(int dishId, int orderId, String comentary, int quantity) {
        pedidoPlatoCrudRepository.pedirPlato(dishId,orderId,comentary,quantity);
    }

    @Override
    public Optional<DishOrder> getById(int orderId) {
        Optional<PedidoPlato> pedidoPlato = pedidoPlatoCrudRepository.findById(orderId);
        return pedidoPlato.map(pedidoPlato1 -> mapper.toDishOrder(pedidoPlato1));
    }
}
