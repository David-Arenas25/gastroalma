package com.restaurante.gastro.alma.persistence;
import com.restaurante.gastro.alma.domain.Dish;
import com.restaurante.gastro.alma.domain.repository.DishRepository;
import com.restaurante.gastro.alma.persistence.Mapper.DishMapper;
import com.restaurante.gastro.alma.persistence.crud.PlatoCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository implements DishRepository {

    @Autowired
    private PlatoCrudRepository platoCrudRepository;

    @Autowired
    DishMapper mapper;

    public List<Dish> getAll(){
        return mapper.toDishes((List<Plato>) platoCrudRepository.findAll());
    }

    @Override
    public Dish save(Dish dish) {
        Plato plato = mapper.toPlato(dish);
        platoCrudRepository.save(plato);
        return mapper.toDish(plato);
    }

    @Override
    public void deleteDish(int dishId) {
        platoCrudRepository.deleteById(dishId);

    }

    @Override
    public Optional<Dish> getByID(int dishId) {
        return platoCrudRepository.findById(dishId).map(plato -> mapper.toDish(plato));

    }

    @Override
    public void changeDishPrice(int dishId, double dishPrice) {
        platoCrudRepository.cambiarPrecioPlato(dishId,dishPrice);
    }

    public Plato save(Plato plato){
        return platoCrudRepository.save(plato);
    }


}
