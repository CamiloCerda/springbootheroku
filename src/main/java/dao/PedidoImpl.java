package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Pedido;

@Repository
public class PedidoImpl implements PedidoInterfazDao{
	
	@Autowired
	PedidoJpa jpa;

	@Override
	public List<Object[]> findPedidos() {
		return jpa.findPedidos();
	}

	@Override
	public int confirmarPedidos(int idPedido) {
		try {
			jpa.confirmarPedidos(idPedido);
			return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		} 
	}

	@Override
	public List<Object[]> getAllPedidos() {
		return jpa.getAllPedidos();
	}

	@Override
	public int confirmarTransferencias(int idPedido) {
		try {
			jpa.confirmarTransferencias(idPedido);
			return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		} 
	}

}
