package com.restaurante.gastro.alma.persistence.crud;

import com.restaurante.gastro.alma.persistence.entity.Mesero;
import org.springframework.data.repository.CrudRepository;

public interface MeseroCrudRepository extends CrudRepository<Mesero,Integer> {
}
