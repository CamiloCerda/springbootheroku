package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the familia_prod database table.
 * 
 */
@Entity
@Table(name="familia_prod")
@NamedQuery(name="FamiliaProd.findAll", query="SELECT f FROM FamiliaProd f")
public class FamiliaProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_famprod")
	private int idFamprod;

	@Column(name="nombre_familia")
	private String nombreFamilia;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="familiaProd")
	private List<Categoria> categorias;

	public FamiliaProd() {
	}

	public int getIdFamprod() {
		return this.idFamprod;
	}

	public void setIdFamprod(int idFamprod) {
		this.idFamprod = idFamprod;
	}

	public String getNombreFamilia() {
		return this.nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setFamiliaProd(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setFamiliaProd(null);

		return categoria;
	}

}