package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the control_tarea database table.
 * 
 */
@Entity
@Table(name="control_tarea")
@NamedQuery(name="ControlTarea.findAll", query="SELECT c FROM ControlTarea c")
public class ControlTarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_control_tarea", unique=true, nullable=false)
	private Integer idControlTarea;

	@Column(name="descripcion_tarea", length=30)
	private String descripcionTarea;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_tarea")
	private Date fechaTarea;

	//bi-directional many-to-one association to ControlColmena
	@ManyToOne
	@JoinColumn(name="id_control_colmena")
	private ControlColmena controlColmena;

	public ControlTarea() {
	}

	public Integer getIdControlTarea() {
		return this.idControlTarea;
	}

	public void setIdControlTarea(Integer idControlTarea) {
		this.idControlTarea = idControlTarea;
	}

	public String getDescripcionTarea() {
		return this.descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaTarea() {
		return this.fechaTarea;
	}

	public void setFechaTarea(Date fechaTarea) {
		this.fechaTarea = fechaTarea;
	}

	public ControlColmena getControlColmena() {
		return this.controlColmena;
	}

	public void setControlColmena(ControlColmena controlColmena) {
		this.controlColmena = controlColmena;
	}

}