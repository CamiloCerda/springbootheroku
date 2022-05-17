package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrito;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int total;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_idUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DetalleCarro
	@OneToMany(mappedBy="carrito")
	private List<DetalleCarro> detalleCarros;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="carrito")
	private List<Pedido> pedidos;

	public Carrito() {
	}

	public int getIdCarrito() {
		return this.idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleCarro> getDetalleCarros() {
		return this.detalleCarros;
	}

	public void setDetalleCarros(List<DetalleCarro> detalleCarros) {
		this.detalleCarros = detalleCarros;
	}

	public DetalleCarro addDetalleCarro(DetalleCarro detalleCarro) {
		getDetalleCarros().add(detalleCarro);
		detalleCarro.setCarrito(this);

		return detalleCarro;
	}

	public DetalleCarro removeDetalleCarro(DetalleCarro detalleCarro) {
		getDetalleCarros().remove(detalleCarro);
		detalleCarro.setCarrito(null);

		return detalleCarro;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCarrito(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCarrito(null);

		return pedido;
	}

}