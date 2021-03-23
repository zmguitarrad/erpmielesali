package erpmielesali.model.colmena.managers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.ControlColmena;
import erpmielesali.model.core.entities.ProdProducto;
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
    
   //listar
    public List<ControlColmena>findAllControlColmena(){
    	return mDAO.findAll(ControlColmena.class);
    }
    //crear colmena
	//crear producto
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
    public void eliminarColmena(int idControlColmena) throws Exception {
    	mDAO.eliminar(ControlColmena.class, idControlColmena);
    }
    
    //editar colmena
    public void actualizarColmena(ControlColmena edicionControl) throws Exception {
    	ControlColmena colmena=(ControlColmena)mDAO.findById(ControlColmena.class, edicionControl.getIdControlColmena());
    	colmena.setNombreColmena(edicionControl.getNombreColmena());
    	colmena.setProductora(edicionControl.getProductora());
    	//colmena.setFechaCreacion(new Date());
    	mDAO.actualizar(colmena);
    	
    }
    	//activar colmena
    public void activarDesactivarColmena(int idControlColmena) throws Exception {
    	ControlColmena colmena=(ControlColmena)mDAO.findById(ControlColmena.class, idControlColmena);
    	colmena.setColmenaActivo(!colmena.getColmenaActivo());
    	System.out.println("activar/desactivar "+colmena.getColmenaActivo());
    	mDAO.actualizar(colmena);
    }
    
   
}
