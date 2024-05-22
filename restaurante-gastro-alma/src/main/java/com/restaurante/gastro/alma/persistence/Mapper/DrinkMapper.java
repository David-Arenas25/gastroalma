package com.restaurante.gastro.alma.persistence.Mapper;
import com.restaurante.gastro.alma.domain.Drink;
import com.restaurante.gastro.alma.persistence.entity.Bebida;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DrinkMapper {

    @Mappings({
            @Mapping(source = "idBebida",target = "drinkId"),
            @Mapping(source = "nombreBebida",target = "drinkName"),
            @Mapping(source = "descripcionBebida",target = "drinkDescription"),
            @Mapping(source = "precioBebida",target = "drinkPrice"),
            @Mapping(source = "idMesero",target = "waiterId"),

    })
    Drink toDrink(Bebida bebida);
    List<Drink> toDrinks(List<Bebida> bebidas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "meseros",ignore = true),
            @Mapping(target = "bebidas",ignore = true)
    })
    Bebida toBebida(Drink drink);


}
