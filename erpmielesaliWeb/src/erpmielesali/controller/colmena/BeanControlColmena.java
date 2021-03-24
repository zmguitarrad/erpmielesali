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
import erpmielesali.model.core.entities.ControlPlaga;
import erpmielesali.model.core.entities.ControlTarea;
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
	private ControlTarea nuevaTarea;
	private ControlTarea edicionTarea;
	private List<ControlTarea>listaTarea;
	private String IdControlColmena;
	private List<ControlPlaga>listaPLaga;
	private ControlPlaga nuevaPlaga;
	private ControlPlaga edicionPLaga;
	
	

	public BeanControlColmena() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	private void inicializador() {
		listaColmena=mColmena.findAllControlColmena();
		listaTarea=mColmena.findAllControlTarea();
		listaPLaga=mColmena.findAllControlPlaga();
		nuevoColmena=new ControlColmena();
		nuevaTarea=new ControlTarea();
		nuevaPlaga=new ControlPlaga();
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
	public void actionListenerEliminarColmena(String idControlColmena) {
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
	public void actionLIstenerActivarDesactivarColmena(String idControlColmena) {
		try {
			mColmena.activarDesactivarColmena(idControlColmena);
			listaColmena=mColmena.findAllControlColmena();
			JSFUtil.crearMensajeINFO("Colmena activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//TABLA TAREAS
	
		//listar tarea
		public String actionCargarMenuTarea() {
			listaTarea=mColmena.findAllControlTarea();
			return "tarea";
		}
	
	
		//Iinsertar Tarea
	public void actionLIstenerInsertarNUevaTarea() {
		try {
			mColmena.insertarTarea( nuevaTarea, IdControlColmena);
			listaTarea=mColmena.findAllControlTarea();
			JSFUtil.crearMensajeINFO("Tarea insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//eliminar Tarea
	
	public void actionListenerEliminarTarea(int idControlTarea) {
		try {
			mColmena.eliminarTarea(idControlTarea);
			listaTarea=mColmena.findAllControlTarea();
			JSFUtil.crearMensajeINFO("Tarea eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//editar pagina tarea
	public String actionSeleccionEdicionTarea(ControlTarea tarea) {
		edicionTarea=tarea;
		return "tarea_edicion";
	}
	  	//editar tarea
	public void actionListenerEdicionTarea() {
		try {
			mColmena.actualizarTarea(edicionTarea);
			listaTarea=mColmena.findAllControlTarea();
			JSFUtil.crearMensajeINFO("Tarea actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	//realizado/pendiente tarea
	public void actionListenerREalizadoPendienteTarea(int idControlTarea) {
		try {
			mColmena.activarDesactivarTarea(idControlTarea);
			listaTarea=mColmena.findAllControlTarea();
			JSFUtil.crearMensajeINFO("Tarea realizada/pendiente");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}	
	}
	//TABLA PLAGA
	public String actionCargarMenuPlaga() {
		listaPLaga=mColmena.findAllControlPlaga();
		return "plaga";
	}
		//insertar plaga
	public void actionListenerInsertarNuevaPlaga() {
		try {
			mColmena.insertarPlaga(nuevaPlaga, IdControlColmena);
			listaPLaga=mColmena.findAllControlPlaga();
			JSFUtil.crearMensajeINFO("Plaga y tratamiento insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}
		//eliminar plaga
	public void actionListenerEliminarPlaga(int idControlPlaga) {
		try {
			mColmena.eliminarPlaga(idControlPlaga);
			listaPLaga=mColmena.findAllControlPlaga();
			JSFUtil.crearMensajeINFO("Plaga/Tratamiento eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//editar Plaga
	public String actionSeleccionEdicionPlaga(ControlPlaga plaga) {
		edicionPLaga=plaga;
		return "plaga_edicion";
	
	
	}
		//edicion
	public void actionListenerEdicionPlaga() {
		try {
			mColmena.actualizarPlaga(edicionPLaga);;
			listaPLaga=mColmena.findAllControlPlaga();
			JSFUtil.crearMensajeINFO("Control actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//METODOS ACCESORES

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
	public ControlTarea getNuevaTarea() {
		return nuevaTarea;
	}
	public void setNuevaTarea(ControlTarea nuevaTarea) {
		this.nuevaTarea = nuevaTarea;
	}
	public List<ControlTarea> getListaTarea() {
		return listaTarea;
	}
	public void setListaTarea(List<ControlTarea> listaTarea) {
		this.listaTarea = listaTarea;
	}
	

	public String getIdControlColmena() {
		return IdControlColmena;
	}
	public void setIdControlColmena(String idControlColmena) {
		IdControlColmena = idControlColmena;
	}
	public ControlTarea getEdicionTarea() {
		return edicionTarea;
	}
	public void setEdicionTarea(ControlTarea edicionTarea) {
		this.edicionTarea = edicionTarea;
	}
	public List<ControlPlaga> getListaPLaga() {
		return listaPLaga;
	}
	public void setListaPLaga(List<ControlPlaga> listaPLaga) {
		this.listaPLaga = listaPLaga;
	}
	public ControlPlaga getNuevaPlaga() {
		return nuevaPlaga;
	}
	public void setNuevaPlaga(ControlPlaga nuevaPlaga) {
		this.nuevaPlaga = nuevaPlaga;
	}
	public ControlPlaga getEdicionPLaga() {
		return edicionPLaga;
	}
	public void setEdicionPLaga(ControlPlaga edicionPLaga) {
		this.edicionPLaga = edicionPLaga;
	}
	
	
	

}
