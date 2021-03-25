package erpmielesali.controller.ventas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.core.entities.GastGasto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.VentVenta;
import erpmielesali.model.core.entities.VentVentaDetalle;
import erpmielesali.model.producto.managers.ManagerProdProducto;
import erpmielesali.model.ventas.managers.ManagerVentasDetalle;
import erpmielesali.model.ventas.managers.ManagerVentasVenta;

@Named
@SessionScoped
public class BeanVentDetalle implements Serializable {
	
	@EJB
	private ManagerVentasVenta mVentas;
	@EJB
	private ManagerVentasDetalle mVentasDetalle; 
	@EJB
	private ManagerProdProducto mStock;
	
	private List<VentVenta> listaVentas;
	private List<ProdStock> listaStock;
	private List<VentVentaDetalle> listaVentasDetalle; 
	private VentVentaDetalle nuevoVentaDetalle;
	private VentVentaDetalle edicionVentaDetalle;
	private String  idVentVentas;
	private int idProdStock;

	public BeanVentDetalle() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct 
	public void inicializador() {
		listaVentasDetalle = mVentasDetalle.findAllVentVentaDetalle();
		nuevoVentaDetalle = new VentVentaDetalle();
		listaStock = mStock.findAllProdStock();
		listaVentas = mVentas.findAllVentVenta();
		
	}

	public String actionCargarMenuVentaDetalle() {
		listaVentasDetalle = mVentasDetalle.findAllVentVentaDetalle();
		return "ventadetalle";
		
	}
	// insertar Gasto
		public void actionListenerNuevaVentaDetalle() {
			
			try {
				mVentasDetalle.insertarVentaDetalle(nuevoVentaDetalle, idVentVentas, idProdStock);
				listaVentasDetalle = mVentasDetalle.findAllVentVentaDetalle();
				JSFUtil.crearMensajeINFO("Venta detalle insertado.");
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
			
			
		}
		
		public void actionListenerEliminarGVentaDetalle(int idVentVentaDetalle) {
			
			try {
				mVentasDetalle.eliminarVentaDetalle(idVentVentaDetalle);
				listaVentasDetalle = mVentasDetalle.findAllVentVentaDetalle();
				JSFUtil.crearMensajeINFO("Venta detalle eliminado.");
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
				
		}
			
		public String actionListenerCargarVentadetalle(VentVentaDetalle ventaDetalle) {
			edicionVentaDetalle = ventaDetalle;
			return "VentaEdicion2";
		}
		
		public void actionListenerGuardarEdicionGasto() {
			
			
			try {
				mVentasDetalle.actualizarVentaDetalle(edicionVentaDetalle, idVentVentas, idProdStock);
				listaVentasDetalle = mVentasDetalle.findAllVentVentaDetalle();
				JSFUtil.crearMensajeINFO("Venta detalle editado.");
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}

		}
		

	public String getIdVentVentas() {
		return idVentVentas;
	}

	public void setIdVentVentas(String idVentVentas) {
		this.idVentVentas = idVentVentas;
	}

	public int getIdProdStock() {
		return idProdStock;
	}

	public void setIdProdStock(int idProdStock) {
		this.idProdStock = idProdStock;
	}

	public List<VentVenta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<VentVenta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<ProdStock> getListaStock() {
		return listaStock;
	}

	public void setListaStock(List<ProdStock> listaStock) {
		this.listaStock = listaStock;
	}

	public List<VentVentaDetalle> getListaVentasDetalle() {
		return listaVentasDetalle;
	}

	public void setListaVentasDetalle(List<VentVentaDetalle> listaVentasDetalle) {
		this.listaVentasDetalle = listaVentasDetalle;
	}

	public VentVentaDetalle getNuevoVentaDetalle() {
		return nuevoVentaDetalle;
	}

	public void setNuevoVentaDetalle(VentVentaDetalle nuevoVentaDetalle) {
		this.nuevoVentaDetalle = nuevoVentaDetalle;
	}

	public VentVentaDetalle getEdicionVentaDetalle() {
		return edicionVentaDetalle;
	}

	public void setEdicionVentaDetalle(VentVentaDetalle edicionVentaDetalle) {
		this.edicionVentaDetalle = edicionVentaDetalle;
	}
	
	
}
