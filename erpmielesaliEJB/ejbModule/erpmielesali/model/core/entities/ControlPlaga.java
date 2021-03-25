package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the control_plagas database table.
 * 
 */
@Entity
@Table(name="control_plagas")
@NamedQuery(name="ControlPlaga.findAll", query="SELECT c FROM ControlPlaga c")
public class ControlPlaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_control_plagas", unique=true, nullable=false)
	private Integer idControlPlagas;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_aplicacion")
	private Date fechaAplicacion;

	@Column(length=50)
	private String medicacion;

	@Column(name="nombre_plaga", length=50)
	private String nombrePlaga;

	//bi-directional many-to-one association to ControlColmena
	@ManyToOne
	@JoinColumn(name="nombre_colmena")
	private ControlColmena controlColmena;

	public ControlPlaga() {
	}

	public Integer getIdControlPlagas() {
		return this.idControlPlagas;
	}

	public void setIdControlPlagas(Integer idControlPlagas) {
		this.idControlPlagas = idControlPlagas;
	}

	public Date getFechaAplicacion() {
		return this.fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public String getMedicacion() {
		return this.medicacion;
	}

	public void setMedicacion(String medicacion) {
		this.medicacion = medicacion;
	}

	public String getNombrePlaga() {
		return this.nombrePlaga;
	}

	public void setNombrePlaga(String nombrePlaga) {
		this.nombrePlaga = nombrePlaga;
	}

	public ControlColmena getControlColmena() {
		return this.controlColmena;
	}

	public void setControlColmena(ControlColmena controlColmena) {
		this.controlColmena = controlColmena;
	}

}