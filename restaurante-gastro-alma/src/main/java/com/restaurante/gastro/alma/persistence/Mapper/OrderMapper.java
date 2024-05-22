package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.Order;
import com.restaurante.gastro.alma.persistence.entity.Pedido;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "idPedido",target = "orderId"),
            @Mapping(source = "fechaPedido",target = "orderDate"),
            @Mapping(source = "precioPedido",target = "orderPrice"),
            @Mapping(source = "idMesero",target = "waiterId"),

    })
    Order toOrder(Pedido pedido);
    List<Order> toOrders(List<Pedido> pedidos);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "mesero",ignore = true),
    })
    Pedido toPedido(Order order);


}
