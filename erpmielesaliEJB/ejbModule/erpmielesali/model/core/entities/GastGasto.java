package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the gast_gastos database table.
 * 
 */
@Entity
@Table(name="gast_gastos")
@NamedQuery(name="GastGasto.findAll", query="SELECT g FROM GastGasto g")
public class GastGasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gast_gastos", unique=true, nullable=false)
	private Integer idGastGastos;

	@Column(name="descripcion_gastos", length=100)
	private String descripcionGastos;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="gasto_fecha")
	private Date gastoFecha;

	@Column(name="metodo_pago", length=20)
	private String metodoPago;

	@Column(name="total_gastos", precision=3, scale=2)
	private BigDecimal totalGastos;

	//bi-directional many-to-one association to GastTipoGasto
	@ManyToOne
	@JoinColumn(name="id_gast_tipo_gasto")
	private GastTipoGasto gastTipoGasto;

	public GastGasto() {
	}

	public Integer getIdGastGastos() {
		return this.idGastGastos;
	}

	public void setIdGastGastos(Integer idGastGastos) {
		this.idGastGastos = idGastGastos;
	}

	public String getDescripcionGastos() {
		return this.descripcionGastos;
	}

	public void setDescripcionGastos(String descripcionGastos) {
		this.descripcionGastos = descripcionGastos;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getGastoFecha() {
		return this.gastoFecha;
	}

	public void setGastoFecha(Date gastoFecha) {
		this.gastoFecha = gastoFecha;
	}

	public String getMetodoPago() {
		return this.metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public BigDecimal getTotalGastos() {
		return this.totalGastos;
	}

	public void setTotalGastos(BigDecimal totalGastos) {
		this.totalGastos = totalGastos;
	}

	public GastTipoGasto getGastTipoGasto() {
		return this.gastTipoGasto;
	}

	public void setGastTipoGasto(GastTipoGasto gastTipoGasto) {
		this.gastTipoGasto = gastTipoGasto;
	}

}