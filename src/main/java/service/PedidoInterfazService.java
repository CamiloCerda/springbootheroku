package service;

import java.util.List;

import model.Pedido;

public interface PedidoInterfazService {
	
	List<Object[]> findPedidos();
	List<Object[]> getAllPedidos();
	int confirmarTransferencias(int idPedido);
	int confirmarPedidos(int idPedido);
}
