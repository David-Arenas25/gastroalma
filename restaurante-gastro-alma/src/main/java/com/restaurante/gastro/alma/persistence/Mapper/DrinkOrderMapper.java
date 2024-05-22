package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.DrinkOrder;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrinkOrderMapper {

    @Mappings({
            @Mapping(source = "id.idPedido",target = "orderId"),
            @Mapping(source = "id.idBebida",target = "drinkId"),
            @Mapping(source = "comentario",target = "comentary"),
            @Mapping(source = "cantidad",target = "quantity"),

    })
    DrinkOrder toDrinkOrder(PedidoBebida pedidoBebida);
    List<DrinkOrder> toDrinksOrders(List<PedidoBebida> pedidoBebidas);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedido",ignore = true),
            @Mapping(target = "bebida",ignore = true)

    })
    PedidoBebida toPedidoBebida(DrinkOrder drinkOrder);

}
