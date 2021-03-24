package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vent_ventas database table.
 * 
 */
@Entity
@Table(name="vent_ventas")
@NamedQuery(name="VentVenta.findAll", query="SELECT v FROM VentVenta v")
public class VentVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vent_ventas", unique=true, nullable=false, length=10)
	private String idVentVentas;

	@Column(precision=3, scale=2)
	private BigDecimal descuento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ventas")
	private Date fechaVentas;

	@Column(precision=3, scale=2)
	private BigDecimal total;

	//bi-directional many-to-one association to VentVentaDetalle
	@OneToMany(mappedBy="ventVenta")
	private List<VentVentaDetalle> ventVentaDetalles;

	//bi-directional many-to-one association to VentCliente
	@ManyToOne
	@JoinColumn(name="cedula_vent_cliente")
	private VentCliente ventCliente;

	public VentVenta() {
	}

	public String getIdVentVentas() {
		return this.idVentVentas;
	}

	public void setIdVentVentas(String idVentVentas) {
		this.idVentVentas = idVentVentas;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFechaVentas() {
		return this.fechaVentas;
	}

	public void setFechaVentas(Date fechaVentas) {
		this.fechaVentas = fechaVentas;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<VentVentaDetalle> getVentVentaDetalles() {
		return this.ventVentaDetalles;
	}

	public void setVentVentaDetalles(List<VentVentaDetalle> ventVentaDetalles) {
		this.ventVentaDetalles = ventVentaDetalles;
	}

	public VentVentaDetalle addVentVentaDetalle(VentVentaDetalle ventVentaDetalle) {
		getVentVentaDetalles().add(ventVentaDetalle);
		ventVentaDetalle.setVentVenta(this);

		return ventVentaDetalle;
	}

	public VentVentaDetalle removeVentVentaDetalle(VentVentaDetalle ventVentaDetalle) {
		getVentVentaDetalles().remove(ventVentaDetalle);
		ventVentaDetalle.setVentVenta(null);

		return ventVentaDetalle;
	}

	public VentCliente getVentCliente() {
		return this.ventCliente;
	}

	public void setVentCliente(VentCliente ventCliente) {
		this.ventCliente = ventCliente;
	}

}