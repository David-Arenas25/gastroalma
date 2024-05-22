package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.Dish;
import com.restaurante.gastro.alma.persistence.entity.Plato;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mappings({
            @Mapping(source = "idPlato",target = "dishId"),
            @Mapping(source = "nombrePlato",target = "dishName"),
            @Mapping(source = "descripcionPlato",target = "dishDescription"),
            @Mapping(source = "precioPlato",target = "dishPrice"),
            @Mapping(source = "idMesero",target = "waiterId"),

    })
    Dish toDish(Plato plato);
    List<Dish> toDishes(List<Plato> platos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "meseros",ignore = true),
            @Mapping(target = "platos",ignore = true)
    })
    Plato toPlato(Dish dish);


}
