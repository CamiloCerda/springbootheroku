package dao;

import java.util.List;

import model.Pedido;

public interface PedidoInterfazDao {
	
	List<Object[]> findPedidos();
	List<Object[]> getAllPedidos();
	int confirmarTransferencias(int idPedido);
	int confirmarPedidos(int idPedido);
}
