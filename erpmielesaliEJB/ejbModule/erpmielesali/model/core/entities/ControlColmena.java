package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the control_colmena database table.
 * 
 */
@Entity
@Table(name="control_colmena")
@NamedQuery(name="ControlColmena.findAll", query="SELECT c FROM ControlColmena c")
public class ControlColmena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_colmena", unique=true, nullable=false, length=8)
	private String nombreColmena;

	@Column(name="colmena_activo")
	private Boolean colmenaActivo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(length=30)
	private String productora;

	//bi-directional many-to-one association to ControlPlaga
	@OneToMany(mappedBy="controlColmena")
	private List<ControlPlaga> controlPlagas;

	//bi-directional many-to-one association to ControlTarea
	@OneToMany(mappedBy="controlColmena")
	private List<ControlTarea> controlTareas;

	public ControlColmena() {
	}

	public String getNombreColmena() {
		return this.nombreColmena;
	}

	public void setNombreColmena(String nombreColmena) {
		this.nombreColmena = nombreColmena;
	}

	public Boolean getColmenaActivo() {
		return this.colmenaActivo;
	}

	public void setColmenaActivo(Boolean colmenaActivo) {
		this.colmenaActivo = colmenaActivo;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getProductora() {
		return this.productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public List<ControlPlaga> getControlPlagas() {
		return this.controlPlagas;
	}

	public void setControlPlagas(List<ControlPlaga> controlPlagas) {
		this.controlPlagas = controlPlagas;
	}

	public ControlPlaga addControlPlaga(ControlPlaga controlPlaga) {
		getControlPlagas().add(controlPlaga);
		controlPlaga.setControlColmena(this);

		return controlPlaga;
	}

	public ControlPlaga removeControlPlaga(ControlPlaga controlPlaga) {
		getControlPlagas().remove(controlPlaga);
		controlPlaga.setControlColmena(null);

		return controlPlaga;
	}

	public List<ControlTarea> getControlTareas() {
		return this.controlTareas;
	}

	public void setControlTareas(List<ControlTarea> controlTareas) {
		this.controlTareas = controlTareas;
	}

	public ControlTarea addControlTarea(ControlTarea controlTarea) {
		getControlTareas().add(controlTarea);
		controlTarea.setControlColmena(this);

		return controlTarea;
	}

	public ControlTarea removeControlTarea(ControlTarea controlTarea) {
		getControlTareas().remove(controlTarea);
		controlTarea.setControlColmena(null);

		return controlTarea;
	}

}