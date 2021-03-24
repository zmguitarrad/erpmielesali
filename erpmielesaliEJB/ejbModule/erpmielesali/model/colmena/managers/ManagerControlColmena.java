package erpmielesali.model.colmena.managers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.ControlColmena;
import erpmielesali.model.core.entities.ControlPlaga;
import erpmielesali.model.core.entities.ControlTarea;
import erpmielesali.model.core.entities.ProdProducto;
import erpmielesali.model.core.entities.VentDireccion;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerControlColmena
 */
@Stateless
@LocalBean
public class ManagerControlColmena {
	@EJB
	private ManagerDAO mDAO;
	

    /**
     * Default constructor. 
     */
    public ManagerControlColmena() {
        // TODO Auto-generated constructor stub
    }
    // TABLA COLMENA
    	//listar
    public List<ControlColmena>findAllControlColmena(){
    	return mDAO.findAll(ControlColmena.class);
    }
    	//listar byId
    public ControlColmena findByIdControlColmena(String nombreColmena) throws Exception{
    	return (ControlColmena)mDAO.findById(ControlColmena.class, nombreColmena);
    }
    	/////////cargar datos////
    
    public List<ControlColmena> findAllContColmena(){
    	return mDAO.findAll(VentDireccion.class);
    }
    
    	//crear colmena
	
    public ControlColmena insertarColmena(ControlColmena nuevoColmena, Date fecha) throws Exception {
    	ControlColmena colmena=new ControlColmena();
    	colmena.setNombreColmena(nuevoColmena.getNombreColmena());
    	colmena.setProductora(nuevoColmena.getProductora());
    	colmena.setFechaCreacion(fecha);
    	colmena.setColmenaActivo(true);
    	mDAO.insertar(colmena);
    	return colmena;
    }
    
    	//eliminar colmena
    public void eliminarColmena(String nombreColmena) throws Exception {
    	mDAO.eliminar(ControlColmena.class, nombreColmena);
    }
    
    //editar colmena
    public void actualizarColmena(ControlColmena edicionControl) throws Exception {
    	ControlColmena colmena=(ControlColmena)mDAO.findById(ControlColmena.class, edicionControl.getNombreColmena());
    	colmena.setProductora(edicionControl.getProductora());
    	colmena.setFechaCreacion(edicionControl.getFechaCreacion());
    	mDAO.actualizar(colmena);
    	
    }
    	//activar colmena
    public void activarDesactivarColmena(String controlColmena) throws Exception {
    	ControlColmena colmena=(ControlColmena)mDAO.findById(ControlColmena.class, controlColmena);
    	colmena.setColmenaActivo(!colmena.getColmenaActivo());
    	System.out.println("activar/desactivar "+colmena.getColmenaActivo());
    	mDAO.actualizar(colmena);
    }
    
    //TABLA TAREA
    	//listar tarea

    public List<ControlTarea>findAllControlTarea(){
    	return mDAO.findAll(ControlTarea.class);
    }
    
    	//crear tarea
 	public ControlTarea insertarTarea( ControlTarea nuevaTarea, String idControlColmena) throws Exception {
 		ControlTarea tarea=new ControlTarea();
 		tarea.setControlColmena(findByIdControlColmena(idControlColmena));
 		tarea.setDescripcionTarea(nuevaTarea.getDescripcionTarea());
 		tarea.setFechaTarea(nuevaTarea.getFechaTarea());
 		tarea.setEstado(true);
 		mDAO.insertar(tarea);
 		return tarea;
 	
 		}
 		//eliminar tarea
 	public void eliminarTarea(int idControlTarea) throws Exception {
 		mDAO.eliminar(ControlTarea.class, idControlTarea);
 	}
 		//editar tarea
 	public void actualizarTarea(ControlTarea edicionTarea) throws Exception {
 		ControlTarea tarea=(ControlTarea)mDAO.findById(ControlTarea.class, edicionTarea.getIdControlTarea());
 		tarea.setControlColmena(edicionTarea.getControlColmena());
 		tarea.setDescripcionTarea(edicionTarea.getDescripcionTarea());
 		tarea.setFechaTarea(edicionTarea.getFechaTarea());
 		mDAO.actualizar(tarea);
 	}
 		//activar/desactivar

    public void activarDesactivarTarea(int idControlTarea) throws Exception {
    	ControlTarea tarea=(ControlTarea)mDAO.findById(ControlTarea.class, idControlTarea);
    	tarea.setEstado(!tarea.getEstado());
    	System.out.println("realizado/pendiente "+tarea.getEstado());
    	mDAO.actualizar(tarea);
   
    }
    
    //TABLA PLAGAS
    	//listar plaga
    public List<ControlPlaga>findAllControlPlaga(){
    	return mDAO.findAll(ControlPlaga.class);
    }
    	//insertar plaga
	public ControlPlaga insertarPlaga( ControlPlaga nuevaPlaga, String idControlColmena) throws Exception {
		ControlPlaga plaga=new ControlPlaga();
		plaga.setControlColmena(findByIdControlColmena(idControlColmena));
		plaga.setNombrePlaga(nuevaPlaga.getNombrePlaga());
		plaga.setMedicacion(nuevaPlaga.getMedicacion());
		plaga.setFechaAplicacion(nuevaPlaga.getFechaAplicacion());
		mDAO.insertar(plaga);
		return plaga;

 	
 		}
		//eliminar plaga
	public void eliminarPlaga(int idControlPlaga) throws Exception {
		mDAO.eliminar(ControlPlaga.class, idControlPlaga);
 	}
 		//editar plaga
 
	  public void actualizarPlaga(ControlPlaga edicionPlaga) throws Exception {
		  ControlPlaga plaga=(ControlPlaga)mDAO.findById(ControlPlaga.class, edicionPlaga.getIdControlPlagas());
	    	plaga.setControlColmena(edicionPlaga.getControlColmena());
	    	plaga.setNombrePlaga(edicionPlaga.getNombrePlaga());
	    	plaga.setMedicacion(edicionPlaga.getMedicacion());
	    	plaga.setFechaAplicacion(edicionPlaga.getFechaAplicacion());
	    	mDAO.actualizar(plaga);
	    	
	    }
 

   
}
