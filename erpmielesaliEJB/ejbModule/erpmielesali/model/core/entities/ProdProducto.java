package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the prod_producto database table.
 * 
 */
@Entity
@Table(name="prod_producto")
@NamedQuery(name="ProdProducto.findAll", query="SELECT p FROM ProdProducto p")
public class ProdProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_prod_product", unique=true, nullable=false, length=8)
	private String codigoProdProduct;

	private Boolean activo;

	@Column(name="descripcion_producto", length=200)
	private String descripcionProducto;

	@Column(name="nombre_producto", length=30)
	private String nombreProducto;

	@Column(precision=3, scale=2)
	private BigDecimal precio;

	//bi-directional many-to-one association to ProdTipoProducto
	@ManyToOne
	@JoinColumn(name="id_prod_tipo_producto")
	private ProdTipoProducto prodTipoProducto;

	//bi-directional many-to-one association to ProdStock
	@OneToMany(mappedBy="prodProducto")
	private List<ProdStock> prodStocks;

	public ProdProducto() {
	}

	public String getCodigoProdProduct() {
		return this.codigoProdProduct;
	}

	public void setCodigoProdProduct(String codigoProdProduct) {
		this.codigoProdProduct = codigoProdProduct;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public ProdTipoProducto getProdTipoProducto() {
		return this.prodTipoProducto;
	}

	public void setProdTipoProducto(ProdTipoProducto prodTipoProducto) {
		this.prodTipoProducto = prodTipoProducto;
	}

	public List<ProdStock> getProdStocks() {
		return this.prodStocks;
	}

	public void setProdStocks(List<ProdStock> prodStocks) {
		this.prodStocks = prodStocks;
	}

	public ProdStock addProdStock(ProdStock prodStock) {
		getProdStocks().add(prodStock);
		prodStock.setProdProducto(this);

		return prodStock;
	}

	public ProdStock removeProdStock(ProdStock prodStock) {
		getProdStocks().remove(prodStock);
		prodStock.setProdProducto(null);

		return prodStock;
	}

}