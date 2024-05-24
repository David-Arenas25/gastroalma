package com.restaurante.gastro.alma.persistence.crud;

import com.restaurante.gastro.alma.persistence.entity.PedidoPlato;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PedidoPlatoCrudRepository extends CrudRepository<PedidoPlato,Integer> {

@Procedure("pedir_plato")
void pedirPlato(@Param("id_plato") int idPlato, @Param("id_pedido")int idPedido, @Param("comentario") String comentario, @Param("cantidad") int cantidad);
Optional<PedidoPlato> findById(int idPedido);



}
