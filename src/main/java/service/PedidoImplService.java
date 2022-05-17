package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Pedido;

import dao.PedidoInterfazDao;

@Service
public class PedidoImplService implements PedidoInterfazService{
	
	@Autowired
	PedidoInterfazDao dao;


	@Override
	public List<Object[]> findPedidos() {
		return dao.findPedidos();
	}


	@Override
	public int confirmarPedidos(int idPedido) {
		return dao.confirmarPedidos(idPedido);
	}


	@Override
	public List<Object[]> getAllPedidos() {
		return dao.getAllPedidos();
	}


	@Override
	public int confirmarTransferencias(int idPedido) {
		return dao.confirmarTransferencias(idPedido);
	}

}
