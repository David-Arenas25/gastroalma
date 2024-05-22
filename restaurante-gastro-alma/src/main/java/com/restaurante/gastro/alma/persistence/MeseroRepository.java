package com.restaurante.gastro.alma.persistence;

import com.restaurante.gastro.alma.domain.Waiter;
import com.restaurante.gastro.alma.domain.repository.WaiterRepository;
import com.restaurante.gastro.alma.persistence.Mapper.WaiterMapper;
import com.restaurante.gastro.alma.persistence.crud.MeseroCrudRepository;
import com.restaurante.gastro.alma.persistence.entity.Mesero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MeseroRepository implements WaiterRepository {
    @Autowired
    private MeseroCrudRepository meseroCrudRepository;

    @Autowired
    private WaiterMapper mapper;

    @Override
    public List<Waiter> getAll() {
        return mapper.toWaiters((List<Mesero>) meseroCrudRepository.findAll());

    }

    @Override
    public Waiter saveWaiter(Waiter waiter) {
        Mesero mesero = mapper.toMesero(waiter);
        meseroCrudRepository.save(mesero);
        return mapper.toWaiter(mesero);
    }

    @Override
    public void deleteWaiter(int waiterId) {
        meseroCrudRepository.deleteById(waiterId);

    }

    @Override
    public Optional<Waiter> getByID(int waiterId) {
        return meseroCrudRepository.findById(waiterId).map(mesero -> mapper.toWaiter(mesero));

    }
}
