package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;

	private String empresaDespacho;

	private String formaEntrega;

	private String formaPago;

	private String localRetiro;

	private int pedidoEntregado;

	private int total;

	private int trasnfRealizada;

	//bi-directional many-to-one association to Carrito
	@ManyToOne
	@JoinColumn(name="fk_idCarrito")
	private Carrito carrito;

	//bi-directional many-to-one association to EstadoOrden
	@ManyToOne
	@JoinColumn(name="estadoPedido")
	private EstadoOrden estadoOrden;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getEmpresaDespacho() {
		return this.empresaDespacho;
	}

	public void setEmpresaDespacho(String empresaDespacho) {
		this.empresaDespacho = empresaDespacho;
	}

	public String getFormaEntrega() {
		return this.formaEntrega;
	}

	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getLocalRetiro() {
		return this.localRetiro;
	}

	public void setLocalRetiro(String localRetiro) {
		this.localRetiro = localRetiro;
	}

	public int getPedidoEntregado() {
		return this.pedidoEntregado;
	}

	public void setPedidoEntregado(int pedidoEntregado) {
		this.pedidoEntregado = pedidoEntregado;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTrasnfRealizada() {
		return this.trasnfRealizada;
	}

	public void setTrasnfRealizada(int trasnfRealizada) {
		this.trasnfRealizada = trasnfRealizada;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public EstadoOrden getEstadoOrden() {
		return this.estadoOrden;
	}

	public void setEstadoOrden(EstadoOrden estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

}