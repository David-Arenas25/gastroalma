package com.restaurante.gastro.alma.persistence.crud;
import com.restaurante.gastro.alma.persistence.entity.Plato;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlatoCrudRepository extends CrudRepository<Plato,Integer> {

    @Procedure("cambiar_precio_plato")
    void cambiarPrecioPlato(@Param("id_plato_cambio") int idPlato, @Param("precio_nuevo") double precioNuevo);



}
