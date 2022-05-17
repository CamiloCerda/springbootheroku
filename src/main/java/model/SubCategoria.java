package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sub_categoria database table.
 * 
 */
@Entity
@Table(name="sub_categoria")
@NamedQuery(name="SubCategoria.findAll", query="SELECT s FROM SubCategoria s")
public class SubCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSubCat;

	@Column(name="nombre_subcat")
	private String nombreSubcat;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="subCategoria")
	private List<Producto> productos;

	public SubCategoria() {
	}

	public int getIdSubCat() {
		return this.idSubCat;
	}

	public void setIdSubCat(int idSubCat) {
		this.idSubCat = idSubCat;
	}

	public String getNombreSubcat() {
		return this.nombreSubcat;
	}

	public void setNombreSubcat(String nombreSubcat) {
		this.nombreSubcat = nombreSubcat;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setSubCategoria(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setSubCategoria(null);

		return producto;
	}

}