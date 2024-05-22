package com.restaurante.gastro.alma.persistence.crud;

import com.restaurante.gastro.alma.persistence.entity.Pedido;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.*;



import java.util.List;

public interface PedidoCrudRepository extends CrudRepository<Pedido,Integer> {

    List<Pedido> findByIdMesero(int IdMesero);

    @Query(value = "CALL CALCULAR_PRECIO_PEDIDO(:pID_PEDIDO)", nativeQuery = true)
    void calcularPrecioPedido(@Param("pID_PEDIDO") int idPedido);


    @Query(value = "CALL aplicar_descuento(:p_id_pedido, :descuento)", nativeQuery = true)
    void aplicarDescuento(@Param("p_id_pedido") int idPedido, @Param("descuento") float descuento);
}

