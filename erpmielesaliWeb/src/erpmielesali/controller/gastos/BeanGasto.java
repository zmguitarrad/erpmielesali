package erpmielesali.controller.gastos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.core.entities.GastGasto;
import erpmielesali.model.core.entities.GastMetodoPago;
import erpmielesali.model.core.entities.GastTipoGasto;
import erpmielesali.model.gastos.managers.ManagerGasto;
import erpmielesali.model.gastos.managers.ManagerGastoTipo;
import erpmielesali.model.gastos.managers.ManagerMetodoPago;

@Named
@SessionScoped
public class BeanGasto implements Serializable {
	@EJB
	private ManagerGasto mGasto;
	@EJB
	private ManagerGastoTipo mGastoTipo;
	@EJB
	private ManagerMetodoPago mMetodoPago;
	
	private List<GastGasto> listaGastos; 
	private List<GastTipoGasto> listaTiposGasto;
	private List<GastMetodoPago> listaMetodoPago; 
	private Date fecha;
	private int  idGastTipoGasto;
	private int  idGastMetodoPago;
	private GastGasto nuevoGasto;
	private GastGasto edicionGasto;


	public BeanGasto() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct 
	public void inicializador() {
		listaGastos = mGasto.findAllGastGasto();
		nuevoGasto = new GastGasto();
		listaMetodoPago = mMetodoPago.findAllGastMetodoPago();
		listaTiposGasto = mGastoTipo.findAllGastTipoGasto();
		fecha = new Date();
	}
	public String actionCargarMenuGasto() {
		listaGastos = mGasto.findAllGastGasto();
		return "gasto";
		
	}
	// insertar Gasto
		public void actionListenerNuevoGasto() {
			try {
				mGasto.insertarGasto(nuevoGasto, fecha, idGastTipoGasto, idGastMetodoPago);
				listaGastos = mGasto.findAllGastGasto();
				JSFUtil.crearMensajeINFO("Gasto insertado.");
			} catch (Exception e) {
				JSFUtil.crearMensajeERROR(e.getMessage());
				e.printStackTrace();
			}
			
		}
		
	public void actionListenerEliminarGasto(int idGastGastos) {
		try {
			mGasto.eliminarGasto(idGastGastos);
			listaGastos = mGasto.findAllGastGasto();
			JSFUtil.crearMensajeINFO("Gasto eliminado correctamente");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		
	public String actionListenerCargarGastos(GastGasto gasto) {
		edicionGasto = gasto;
		return "gastoEdicion";
	}
	
	public void actionListenerGuardarEdicionGasto() {
		
		try {
			mGasto.actualizarGasto(edicionGasto, idGastTipoGasto, idGastMetodoPago, fecha);
			listaGastos = mGasto.findAllGastGasto();
			JSFUtil.crearMensajeINFO("Gasto editado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void actionLIstenerActivarDesactivarGasto(int idGastGastos) {
		try {
			mGasto.activarDesactivarGasto(idGastGastos);
			listaGastos = mGasto.findAllGastGasto();
			JSFUtil.crearMensajeINFO("Gasto activado/desactivo");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
		
		
		
		
		public List<GastGasto> getListaGastos() {
			return listaGastos;
		}
		public void setListaGastos(List<GastGasto> listaGastos) {
			this.listaGastos = listaGastos;
		}
		public List<GastTipoGasto> getListaTiposGasto() {
			return listaTiposGasto;
		}
		public void setListaTiposGasto(List<GastTipoGasto> listaTiposGasto) {
			this.listaTiposGasto = listaTiposGasto;
		}
		public List<GastMetodoPago> getListaMetodoPago() {
			return listaMetodoPago;
		}
		public void setListaMetodoPago(List<GastMetodoPago> listaMetodoPago) {
			this.listaMetodoPago = listaMetodoPago;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public int getIdGastTipoGasto() {
			return idGastTipoGasto;
		}
		public void setIdGastTipoGasto(int idGastTipoGasto) {
			this.idGastTipoGasto = idGastTipoGasto;
		}
		public int getIdGastMetodoPago() {
			return idGastMetodoPago;
		}
		public void setIdGastMetodoPago(int idGastMetodoPago) {
			this.idGastMetodoPago = idGastMetodoPago;
		}
		public GastGasto getNuevoGasto() {
			return nuevoGasto;
		}
		public void setNuevoGasto(GastGasto nuevoGasto) {
			this.nuevoGasto = nuevoGasto;
		}
		public GastGasto getEdicionGasto() {
			return edicionGasto;
		}
		public void setEdicionGasto(GastGasto edicionGasto) {
			this.edicionGasto = edicionGasto;
		}

	
	
	

}
