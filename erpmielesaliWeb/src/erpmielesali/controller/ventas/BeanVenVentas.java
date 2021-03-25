package erpmielesali.controller.ventas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.core.entities.VentCliente;
import erpmielesali.model.core.entities.VentVenta;
import erpmielesali.model.ventas.managers.ManagerVentasCliente;
import erpmielesali.model.ventas.managers.ManagerVentasVenta;

@Named
@SessionScoped
public class BeanVenVentas implements Serializable {
	@EJB
	private ManagerVentasVenta mVentas;
	@EJB
	private ManagerVentasCliente mCliente;
	
	private List<VentVenta> listaVentas; 
	private List<VentCliente> listaClientes;
	private Date fecha;
	private String  idVentVentas;
	private String  cedulaVentCliente;
	private VentVenta nuevaVenta;


	public BeanVenVentas() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializador() {
		listaVentas = mVentas.findAllVentVenta();
		listaClientes = mCliente.findAllVentCliente();
		nuevaVenta = new VentVenta();
		fecha = new Date();
	}
	public String actionCargarMenuVentas() {
		listaVentas = mVentas.findAllVentVenta();
		return "venta";
		
	}
	
	// insertar Venta 
			public void actionListenerNuevaVenta() {
			try {
				mVentas.insertarVenta(nuevaVenta, fecha, cedulaVentCliente);
				listaVentas = mVentas.findAllVentVenta();
				JSFUtil.crearMensajeINFO("Gasto insertado.");
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
			
			}
				
			
	public List<VentVenta> getListaVentas() {
		return listaVentas;
	}


	public void setListaVentas(List<VentVenta> listaVentas) {
		this.listaVentas = listaVentas;
	}


	public List<VentCliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(List<VentCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getIdVentVentas() {
		return idVentVentas;
	}


	public void setIdVentVentas(String idVentVentas) {
		this.idVentVentas = idVentVentas;
	}


	public String getCedulaVentCliente() {
		return cedulaVentCliente;
	}


	public void setCedulaVentCliente(String cedulaVentCliente) {
		this.cedulaVentCliente = cedulaVentCliente;
	}


	public VentVenta getNuevaVenta() {
		return nuevaVenta;
	}


	public void setNuevaVenta(VentVenta nuevaVenta) {
		this.nuevaVenta = nuevaVenta;
	}
	
	

}
