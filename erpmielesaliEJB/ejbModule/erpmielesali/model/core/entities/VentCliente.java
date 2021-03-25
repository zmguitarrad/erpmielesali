package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vent_cliente database table.
 * 
 */
@Entity
@Table(name="vent_cliente")
@NamedQuery(name="VentCliente.findAll", query="SELECT v FROM VentCliente v")
public class VentCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula_vent_cliente", unique=true, nullable=false, length=10)
	private String cedulaVentCliente;

	@Column(name="apellido_cliente", length=20)
	private String apellidoCliente;

	@Column(length=10)
	private String celular;

	@Column(length=50)
	private String email;

	@Column(name="nombre_cliente", length=20)
	private String nombreCliente;

	@Column(length=50)
	private String razon;

	//bi-directional many-to-one association to VentDireccion
	@ManyToOne
	@JoinColumn(name="id_vent_direccion")
	private VentDireccion ventDireccion;

	//bi-directional many-to-one association to VentVenta
	@OneToMany(mappedBy="ventCliente")
	private List<VentVenta> ventVentas;

	public VentCliente() {
	}

	public String getCedulaVentCliente() {
		return this.cedulaVentCliente;
	}

	public void setCedulaVentCliente(String cedulaVentCliente) {
		this.cedulaVentCliente = cedulaVentCliente;
	}

	public String getApellidoCliente() {
		return this.apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getRazon() {
		return this.razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public VentDireccion getVentDireccion() {
		return this.ventDireccion;
	}

	public void setVentDireccion(VentDireccion ventDireccion) {
		this.ventDireccion = ventDireccion;
	}

	public List<VentVenta> getVentVentas() {
		return this.ventVentas;
	}

	public void setVentVentas(List<VentVenta> ventVentas) {
		this.ventVentas = ventVentas;
	}

	public VentVenta addVentVenta(VentVenta ventVenta) {
		getVentVentas().add(ventVenta);
		ventVenta.setVentCliente(this);

		return ventVenta;
	}

	public VentVenta removeVentVenta(VentVenta ventVenta) {
		getVentVentas().remove(ventVenta);
		ventVenta.setVentCliente(null);

		return ventVenta;
	}

}