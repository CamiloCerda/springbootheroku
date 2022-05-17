package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_orden database table.
 * 
 */
@Entity
@Table(name="estado_orden")
@NamedQuery(name="EstadoOrden.findAll", query="SELECT e FROM EstadoOrden e")
public class EstadoOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstado;

	private String estado;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="estadoOrden")
	private List<Pedido> pedidos;

	public EstadoOrden() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setEstadoOrden(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setEstadoOrden(null);

		return pedido;
	}

}