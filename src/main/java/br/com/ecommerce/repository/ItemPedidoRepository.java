package br.com.ecommerce.repository;

import br.com.ecommerce.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {
}
