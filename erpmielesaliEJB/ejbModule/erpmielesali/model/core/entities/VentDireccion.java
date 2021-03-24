package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vent_direccion database table.
 * 
 */
@Entity
@Table(name="vent_direccion")
@NamedQuery(name="VentDireccion.findAll", query="SELECT v FROM VentDireccion v")
public class VentDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vent_direccion", unique=true, nullable=false)
	private Integer idVentDireccion;

	@Column(name="nombre_direccion", length=20)
	private String nombreDireccion;

	//bi-directional many-to-one association to VentCliente
	@OneToMany(mappedBy="ventDireccion")
	private List<VentCliente> ventClientes;

	public VentDireccion() {
	}

	public Integer getIdVentDireccion() {
		return this.idVentDireccion;
	}

	public void setIdVentDireccion(Integer idVentDireccion) {
		this.idVentDireccion = idVentDireccion;
	}

	public String getNombreDireccion() {
		return this.nombreDireccion;
	}

	public void setNombreDireccion(String nombreDireccion) {
		this.nombreDireccion = nombreDireccion;
	}

	public List<VentCliente> getVentClientes() {
		return this.ventClientes;
	}

	public void setVentClientes(List<VentCliente> ventClientes) {
		this.ventClientes = ventClientes;
	}

	public VentCliente addVentCliente(VentCliente ventCliente) {
		getVentClientes().add(ventCliente);
		ventCliente.setVentDireccion(this);

		return ventCliente;
	}

	public VentCliente removeVentCliente(VentCliente ventCliente) {
		getVentClientes().remove(ventCliente);
		ventCliente.setVentDireccion(null);

		return ventCliente;
	}

}