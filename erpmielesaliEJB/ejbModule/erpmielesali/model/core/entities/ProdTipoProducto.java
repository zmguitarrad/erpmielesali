package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prod_tipo_producto database table.
 * 
 */
@Entity
@Table(name="prod_tipo_producto")
@NamedQuery(name="ProdTipoProducto.findAll", query="SELECT p FROM ProdTipoProducto p")
public class ProdTipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prod_tipo_producto", unique=true, nullable=false)
	private Integer idProdTipoProducto;

	@Column(name="nombre_tipo_producto", length=30)
	private String nombreTipoProducto;

	//bi-directional many-to-one association to ProdProducto
	@OneToMany(mappedBy="prodTipoProducto")
	private List<ProdProducto> prodProductos;

	public ProdTipoProducto() {
	}

	public Integer getIdProdTipoProducto() {
		return this.idProdTipoProducto;
	}

	public void setIdProdTipoProducto(Integer idProdTipoProducto) {
		this.idProdTipoProducto = idProdTipoProducto;
	}

	public String getNombreTipoProducto() {
		return this.nombreTipoProducto;
	}

	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}

	public List<ProdProducto> getProdProductos() {
		return this.prodProductos;
	}

	public void setProdProductos(List<ProdProducto> prodProductos) {
		this.prodProductos = prodProductos;
	}

	public ProdProducto addProdProducto(ProdProducto prodProducto) {
		getProdProductos().add(prodProducto);
		prodProducto.setProdTipoProducto(this);

		return prodProducto;
	}

	public ProdProducto removeProdProducto(ProdProducto prodProducto) {
		getProdProductos().remove(prodProducto);
		prodProducto.setProdTipoProducto(null);

		return prodProducto;
	}

}