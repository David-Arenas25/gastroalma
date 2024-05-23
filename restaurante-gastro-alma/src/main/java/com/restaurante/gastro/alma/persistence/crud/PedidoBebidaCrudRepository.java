package com.restaurante.gastro.alma.persistence.crud;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PedidoBebidaCrudRepository extends CrudRepository<PedidoBebida,Integer> {

    @Procedure(name = "pedir_bebida")
    PedidoBebida pedirBebida(@Param("idBebida") int idBebida, @Param("idPedido") int idPedido);



}
