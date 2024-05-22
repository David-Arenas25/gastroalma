package com.restaurante.gastro.alma.persistence;

import com.restaurante.gastro.alma.domain.Drink;
import com.restaurante.gastro.alma.domain.repository.DrinkRepository;
import com.restaurante.gastro.alma.persistence.Mapper.DrinkMapper;
import com.restaurante.gastro.alma.persistence.crud.BebidaCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BebidaRepository implements DrinkRepository {
    @Autowired
    private BebidaCrudRepository bebidaCrudRepository;

    @Autowired
    private DrinkMapper mapper;


    @Override
    public List<Drink> getAll() {
        return mapper.toDrinks((List<Bebida>) bebidaCrudRepository.findAll());
    }

    @Override
    public Drink save(Drink drink) {
        Bebida bebida = mapper.toBebida(drink);
        bebidaCrudRepository.save(bebida);
        return mapper.toDrink(bebida);
    }

    @Override
    public void deleteDrink(int drinkId) {
        bebidaCrudRepository.deleteById(drinkId);

    }

    @Override
    public Optional<Drink> getByID(int drinkId) {
        Optional<Bebida> bebida = bebidaCrudRepository.findById(drinkId);
        return bebida.map(bebida1 -> mapper.toDrink(bebida1));

    }

    @Override
    public void changeDrinkPrice(int drinkId ,double drinkPrice) {
        bebidaCrudRepository.cambiarPrecioBebida(drinkId,drinkPrice);

    }
}
