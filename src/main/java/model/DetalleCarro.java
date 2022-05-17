package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_carro database table.
 * 
 */
@Entity
@Table(name="detalle_carro")
@NamedQuery(name="DetalleCarro.findAll", query="SELECT d FROM DetalleCarro d")
public class DetalleCarro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private int idDetalle;

	private int cantidad;

	//bi-directional many-to-one association to Carrito
	@ManyToOne
	@JoinColumn(name="fk_idCarrito")
	private Carrito carrito;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="fk_idProducto")
	private Producto producto;

	public DetalleCarro() {
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}