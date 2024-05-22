package com.restaurante.gastro.alma.persistence.crud;

import com.restaurante.gastro.alma.persistence.entity.Bebida;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BebidaCrudRepository extends CrudRepository<Bebida,Integer> {

    @Query(value = "CALL cambiar_precio_bebida(:id_bebida_cambio, :precio_nuevo)", nativeQuery = true)
    void cambiarPrecioBebida(@Param("id_bebida_cambio") int idBebida, @Param("precio_nuevo") double precioNuevo);


}
