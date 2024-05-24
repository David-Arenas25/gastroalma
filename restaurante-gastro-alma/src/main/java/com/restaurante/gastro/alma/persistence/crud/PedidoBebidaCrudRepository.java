package com.restaurante.gastro.alma.persistence.crud;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PedidoBebidaCrudRepository extends CrudRepository<PedidoBebida,Integer> {

    @Procedure("pedir_bebida")
    void pedirBebida(@Param("id_bebida") int idBebida, @Param("id_pedido")  int idPedido, @Param("comentario") String comentario, @Param("cantidad") int cantidad);



}
