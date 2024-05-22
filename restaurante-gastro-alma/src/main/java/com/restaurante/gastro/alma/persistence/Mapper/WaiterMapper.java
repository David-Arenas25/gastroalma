package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.Waiter;
import com.restaurante.gastro.alma.persistence.entity.Mesero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface WaiterMapper {

    @Mappings({
            @Mapping(source = "idMesero",target = "waiterId"),
            @Mapping(source = "nombreMesero",target = "waiterName"),
            @Mapping(source = "apellidoMesero",target = "waiterLastName"),

    })
    Waiter toWaiter(Mesero mesero);
    List<Waiter> toWaiters(List<Mesero> meseros);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "pedidos",ignore = true),
            @Mapping(target = "bebidas",ignore = true),
            @Mapping(target = "platos",ignore = true)
    })
    Mesero toMesero(Waiter waiter);


}
