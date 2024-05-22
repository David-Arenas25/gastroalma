package com.restaurante.gastro.alma.persistence;
import com.restaurante.gastro.alma.domain.DrinkOrder;
import com.restaurante.gastro.alma.domain.repository.DrinkOrderRepository;
import com.restaurante.gastro.alma.persistence.Mapper.DrinkOrderMapper;
import com.restaurante.gastro.alma.persistence.crud.PedidoBebidaCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class PedidoBebidaRepository implements DrinkOrderRepository {

    @Autowired
    private PedidoBebidaCrudRepository pedidoBebidaCrudRepository;
    @Autowired
    private DrinkOrderMapper mapper;


    @Override
    public List<DrinkOrder> getAll() {
        return mapper.toDrinksOrders((List<PedidoBebida>) pedidoBebidaCrudRepository.findAll());
    }

    @Override
    public DrinkOrder save(DrinkOrder drinkOrder) {
       PedidoBebida pedidoBebida = mapper.toPedidoBebida(drinkOrder);
       pedidoBebidaCrudRepository.save(pedidoBebida);
       return mapper.toDrinkOrder(pedidoBebida);
    }


    @Override
    public DrinkOrder orderADrink(int idBebida, int idPlato) {
        return mapper.toDrinkOrder(pedidoBebidaCrudRepository.pedirBebida(idBebida,idPlato));
    }


}
