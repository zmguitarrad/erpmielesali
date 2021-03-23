package erpmielesali.controller.colmena;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.colmena.managers.ManagerControlColmena;
import erpmielesali.model.core.entities.ControlColmena;
import erpmielesali.model.core.entities.ProdProducto;


@Named
@SessionScoped
public class BeanControlColmena implements Serializable {
	@EJB
	private ManagerControlColmena mColmena;
	private List<ControlColmena>listaColmena;
	private Date fecha;
	private ControlColmena nuevoColmena;
	private ControlColmena edicionColmena;
	
	

	public BeanControlColmena() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	private void inicializador() {
		listaColmena=mColmena.findAllControlColmena();
		nuevoColmena=new ControlColmena();
		fecha=new Date();
		

	}
	//listar colmena
	public String actionCargarMenuColmena() {
		listaColmena=mColmena.findAllControlColmena();
		return "colmena";
		
	}
	// colmena nuevo
	public String actionMenuNuevoColmena() {
		nuevoColmena=new ControlColmena();
		return "colmena_nuevo";
	}

	
	// insertar colmena
	public void actionListenerNuevoColmena() {
		try {
			mColmena.insertarColmena(nuevoColmena, fecha);
			listaColmena=mColmena.findAllControlColmena();
			JSFUtil.crearMensajeINFO("Colmena insertado.");
			
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//eliminar
	public void actionListenerEliminarColmena(int idControlColmena) {
		try {
			mColmena.eliminarColmena(idControlColmena);
			listaColmena=mColmena.findAllControlColmena();
			JSFUtil.crearMensajeINFO("Colmena eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//editar colmena
	public String actionSeleccionrEdicionColmena(ControlColmena colmena) {
		edicionColmena=colmena;
		return "colmena_edicion";
		
	}
			//editar
	public void actionListenerEdicionColmena() {
		try {
			mColmena.actualizarColmena(edicionColmena);
			listaColmena=mColmena.findAllControlColmena();
			JSFUtil.crearMensajeINFO("Colmena actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//activar/desactivar colmena
	public void actionLIstenerActivarDesactivarColmena(int idControlColmena) {
		try {
			mColmena.activarDesactivarColmena(idControlColmena);
			listaColmena=mColmena.findAllControlColmena();
			JSFUtil.crearMensajeINFO("Colmena activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<ControlColmena> getListaColmena() {
		return listaColmena;
	}
	public void setListaColmena(List<ControlColmena> listaColmena) {
		this.listaColmena = listaColmena;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ControlColmena getNuevoColmena() {
		return nuevoColmena;
	}
	public void setNuevoColmena(ControlColmena nuevoColmena) {
		this.nuevoColmena = nuevoColmena;
	}
	public ControlColmena getEdicionColmena() {
		return edicionColmena;
	}
	public void setEdicionColmena(ControlColmena edicionColmena) {
		this.edicionColmena = edicionColmena;
	}
	
	
	

}
