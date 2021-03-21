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
	@Column(name="fecha_revision")
	private Date fechaRevision;

	@Column(name="nombre_plaga", length=30)
	private String nombrePlaga;

	@Column(name="nombre_tratamiento", length=30)
	private String nombreTratamiento;

	//bi-directional many-to-one association to ControlColmena
	@ManyToOne
	@JoinColumn(name="id_control_colmena")
	private ControlColmena controlColmena;

	public ControlPlaga() {
	}

	public Integer getIdControlPlagas() {
		return this.idControlPlagas;
	}

	public void setIdControlPlagas(Integer idControlPlagas) {
		this.idControlPlagas = idControlPlagas;
	}

	public Date getFechaRevision() {
		return this.fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getNombrePlaga() {
		return this.nombrePlaga;
	}

	public void setNombrePlaga(String nombrePlaga) {
		this.nombrePlaga = nombrePlaga;
	}

	public String getNombreTratamiento() {
		return this.nombreTratamiento;
	}

	public void setNombreTratamiento(String nombreTratamiento) {
		this.nombreTratamiento = nombreTratamiento;
	}

	public ControlColmena getControlColmena() {
		return this.controlColmena;
	}

	public void setControlColmena(ControlColmena controlColmena) {
		this.controlColmena = controlColmena;
	}

}