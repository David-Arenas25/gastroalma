package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.DishOrder;
import com.restaurante.gastro.alma.persistence.entity.Pedido;
import com.restaurante.gastro.alma.persistence.entity.PedidoPlato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { DishMapper.class,OrderMapper.class,WaiterMapper.class})
public interface DishOrderMapper {

            @Mappings({
                @Mapping(source = "id.idPedido",target = "orderId"),
                @Mapping(source = "id.idPlato",target = "dishId"),
                @Mapping(source = "comentario",target = "comentary"),
                @Mapping(source = "cantidad",target = "quantity"),



        })
        DishOrder toDishOrder(PedidoPlato pedidoPlato);
        List<DishOrder> toDishesOrders(List<PedidoPlato> pedidoPlatos);
        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "pedido",ignore = true),
                @Mapping(target = "plato", ignore = true),

        })
        PedidoPlato toPedidoPlato(DishOrder dishOrder);


    }
