package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Pedido;

public interface PedidoJpa extends JpaRepository<Pedido, Integer>{
	
	public static final String FIND_PEDIDOS = "SELECT * FROM pedido where formaPago = 'Transferencia'";
	@Query(value = FIND_PEDIDOS, nativeQuery = true)
	List<Object[]> findPedidos();
	
	public static final String ALL_PEDIDOS = "SELECT * FROM pedido";
	@Query(value = ALL_PEDIDOS, nativeQuery = true)
	List<Object[]> getAllPedidos();
	
	@Transactional
	@Modifying
	@Query(value = "update pedido set pedidoEntregado = 1 where idPedido = ?", nativeQuery = true)
	int confirmarPedidos(int idPedido);
	
	@Transactional
	@Modifying
	@Query(value = "update pedido set trasnfRealizada = 1 where idPedido = ?", nativeQuery = true)
	int confirmarTransferencias(int idPedido);
}
