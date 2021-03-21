package erpmielesali.controller.ventas;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.core.entities.VentCliente;
import erpmielesali.model.core.entities.VentDireccion;
import erpmielesali.model.ventas.managers.ManagerVentasCliente;
import erpmielesali.model.ventas.managers.ManagerVentasDirecciones;


@Named
@SessionScoped
public class BeanVenCliente implements Serializable {
	
	@EJB
	private ManagerVentasCliente managerVentasCliente;
	@EJB
	private ManagerVentasDirecciones managerVentasDirecciones; 
	private int idVentDireccion;
	private List<VentCliente> listaClientes;
	private List<VentDireccion> listaDireccion;
	private VentCliente nuevoCLiente;
	private VentCliente edicionCliente;
	private String idVentCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String celular;
	private String email;
	private String razon;
	

	public BeanVenCliente() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void inicializar() {
		listaDireccion=managerVentasDirecciones.findAllVentDireccion();
	}
	public String actionDirecciones() {
		listaClientes=managerVentasCliente.findAllVentCliente();
		return "cliente2";
	}

	public void actionListenerInsertarNuevoClienteActual() {
		try {
			managerVentasCliente.insertarVentClienteActual(idVentCliente, idVentDireccion, nombreCliente, apellidoCliente, celular, email, razon);
			listaClientes = managerVentasCliente.findAllVentCliente();
			JSFUtil.crearMensajeINFO("Cliente Ingresado Exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarCliente(String idVentCliente) {
		
		
		try {
			managerVentasCliente.eliminarCliente(idVentCliente);
			listaClientes = managerVentasCliente.findAllVentCliente();
			JSFUtil.crearMensajeINFO("Cliente Eliminada Exitosamente.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public String actionListenerCargarClientes(VentCliente cliente) {
		edicionCliente=cliente;
		return "clienteEdicion";
	}
	
	public void actionListenerGuardarEdicionModulo() {
		try {
			managerVentasCliente.actualizarCliente(edicionCliente, idVentDireccion);
			listaClientes =  managerVentasCliente.findAllVentCliente();
			JSFUtil.crearMensajeINFO("Cliente editado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public List<VentCliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<VentCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<VentDireccion> getListaDireccion() {
		return listaDireccion;
	}
	public void setListaDireccion(List<VentDireccion> listaDireccion) {
		this.listaDireccion = listaDireccion;
	}
	public VentCliente getNuevoCLiente() {
		return nuevoCLiente;
	}
	public void setNuevoCLiente(VentCliente nuevoCLiente) {
		this.nuevoCLiente = nuevoCLiente;
	}
	public int getIdVentDireccion() {
		return idVentDireccion;
	}
	public void setIdVentDireccion(int idVentDireccion) {
		this.idVentDireccion = idVentDireccion;
	}
	public String getIdVentCliente() {
		return idVentCliente;
	}
	public void setIdVentCliente(String idVentCliente) {
		this.idVentCliente = idVentCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public VentCliente getEdicionCliente() {
		return edicionCliente;
	}
	public void setEdicionCliente(VentCliente edicionCliente) {
		this.edicionCliente = edicionCliente;
	}


}
