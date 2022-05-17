package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;

	private int descuento;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	@Lob
	private byte[] imgProducto;

	private String nombreProd;

	private int precio;

	private int stock;

	//bi-directional many-to-one association to DetalleCarro
	@OneToMany(mappedBy="producto")
	private List<DetalleCarro> detalleCarros;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="fk_idCategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="fk_idMarca")
	private Marca marca;

	//bi-directional many-to-one association to SubCategoria
	@ManyToOne
	@JoinColumn(name="fk_idSubcat")
	private SubCategoria subCategoria;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public byte[] getImgProducto() {
		return this.imgProducto;
	}

	public void setImgProducto(byte[] imgProducto) {
		this.imgProducto = imgProducto;
	}

	public String getNombreProd() {
		return this.nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<DetalleCarro> getDetalleCarros() {
		return this.detalleCarros;
	}

	public void setDetalleCarros(List<DetalleCarro> detalleCarros) {
		this.detalleCarros = detalleCarros;
	}

	public DetalleCarro addDetalleCarro(DetalleCarro detalleCarro) {
		getDetalleCarros().add(detalleCarro);
		detalleCarro.setProducto(this);

		return detalleCarro;
	}

	public DetalleCarro removeDetalleCarro(DetalleCarro detalleCarro) {
		getDetalleCarros().remove(detalleCarro);
		detalleCarro.setProducto(null);

		return detalleCarro;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public SubCategoria getSubCategoria() {
		return this.subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

}