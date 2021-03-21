package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vent_venta_detalle database table.
 * 
 */
@Entity
@Table(name="vent_venta_detalle")
@NamedQuery(name="VentVentaDetalle.findAll", query="SELECT v FROM VentVentaDetalle v")
public class VentVentaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vent_venta_detalle", unique=true, nullable=false)
	private Integer idVentVentaDetalle;

	private Integer cantidad;

	@Column(precision=3, scale=2)
	private BigDecimal subtotal;

	//bi-directional many-to-one association to ProdProducto
	@ManyToOne
	@JoinColumn(name="codigo_prod_product", nullable=false)
	private ProdProducto prodProducto;

	//bi-directional many-to-one association to VentVenta
	@ManyToOne
	@JoinColumn(name="id_vent_ventas", nullable=false)
	private VentVenta ventVenta;

	public VentVentaDetalle() {
	}

	public Integer getIdVentVentaDetalle() {
		return this.idVentVentaDetalle;
	}

	public void setIdVentVentaDetalle(Integer idVentVentaDetalle) {
		this.idVentVentaDetalle = idVentVentaDetalle;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public ProdProducto getProdProducto() {
		return this.prodProducto;
	}

	public void setProdProducto(ProdProducto prodProducto) {
		this.prodProducto = prodProducto;
	}

	public VentVenta getVentVenta() {
		return this.ventVenta;
	}

	public void setVentVenta(VentVenta ventVenta) {
		this.ventVenta = ventVenta;
	}

}