package com.restaurante.gastro.alma.persistence.crud;

import com.restaurante.gastro.alma.persistence.entity.Pedido;
import com.restaurante.gastro.alma.persistence.entity.PedidoBebida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;




import java.util.List;

public interface PedidoCrudRepository extends CrudRepository<Pedido,Integer> {

    List<Pedido> findByIdMesero(int IdMesero);

    @Procedure("calcular_precio_pedido")
    void calcularPrecioPedido(@Param("pID_PEDIDO") int idPedido);


    @Procedure("aplicar_descuento")
    void aplicarDescuento(@Param("p_id_pedido") int idPedido, @Param("descuento") float descuento);
}

