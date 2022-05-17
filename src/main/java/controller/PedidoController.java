package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidoInterfazService;

@RestController
public class PedidoController {
	
	@Autowired
	PedidoInterfazService service;
	
	
	@GetMapping(value = "pedidosFiltrados", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object[]> findPedidos(){
		return service.findPedidos();
	}
	
	@GetMapping(value = "todosPedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object[]> getAllPedidos(){
		return service.getAllPedidos();
	}
	
	@PutMapping(value = "confirmarEntregaPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public int confirmarEntregaPedido(@RequestBody Pedido datos) {
		return service.confirmarPedidos(datos.getIdPedido());
	}
	
	@PutMapping(value = "confirmarTransferencia", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public int confirmarTransferencia(@RequestBody Pedido datos) {
		return service.confirmarTransferencias(datos.getIdPedido());
	}

}
