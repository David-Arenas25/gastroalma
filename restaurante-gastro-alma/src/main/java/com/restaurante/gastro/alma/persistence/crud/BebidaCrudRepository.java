package com.restaurante.gastro.alma.persistence.crud;
import com.restaurante.gastro.alma.persistence.entity.Bebida;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BebidaCrudRepository extends CrudRepository<Bebida,Integer> {

    @Procedure("cambiar_precio_bebida")
    void cambiarPrecioBebida(@Param("id_bebida_cambio") int idBebida, @Param("precio_nuevo") double precioNuevo);


}
