package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prod_stock database table.
 * 
 */
@Entity
@Table(name="prod_stock")
@NamedQuery(name="ProdStock.findAll", query="SELECT p FROM ProdStock p")
public class ProdStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prod_stock", unique=true, nullable=false)
	private Integer idProdStock;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Column(name="unidades_producidas")
	private Integer unidadesProducidas;

	//bi-directional many-to-one association to ProdProducto
	@ManyToOne
	@JoinColumn(name="codigo_prod_product")
	private ProdProducto prodProducto;

	//bi-directional many-to-one association to VentVentaDetalle
	@OneToMany(mappedBy="prodStock")
	private List<VentVentaDetalle> ventVentaDetalles;

	public ProdStock() {
	}

	public Integer getIdProdStock() {
		return this.idProdStock;
	}

	public void setIdProdStock(Integer idProdStock) {
		this.idProdStock = idProdStock;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Integer getUnidadesProducidas() {
		return this.unidadesProducidas;
	}

	public void setUnidadesProducidas(Integer unidadesProducidas) {
		this.unidadesProducidas = unidadesProducidas;
	}

	public ProdProducto getProdProducto() {
		return this.prodProducto;
	}

	public void setProdProducto(ProdProducto prodProducto) {
		this.prodProducto = prodProducto;
	}

	public List<VentVentaDetalle> getVentVentaDetalles() {
		return this.ventVentaDetalles;
	}

	public void setVentVentaDetalles(List<VentVentaDetalle> ventVentaDetalles) {
		this.ventVentaDetalles = ventVentaDetalles;
	}

	public VentVentaDetalle addVentVentaDetalle(VentVentaDetalle ventVentaDetalle) {
		getVentVentaDetalles().add(ventVentaDetalle);
		ventVentaDetalle.setProdStock(this);

		return ventVentaDetalle;
	}

	public VentVentaDetalle removeVentVentaDetalle(VentVentaDetalle ventVentaDetalle) {
		getVentVentaDetalles().remove(ventVentaDetalle);
		ventVentaDetalle.setProdStock(null);

		return ventVentaDetalle;
	}

}