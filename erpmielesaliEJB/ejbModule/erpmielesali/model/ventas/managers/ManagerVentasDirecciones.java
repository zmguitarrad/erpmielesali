package erpmielesali.model.ventas.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.VentDireccion;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerVentasDirecciones
 */
@Stateless
@LocalBean
public class ManagerVentasDirecciones {
	@EJB
	private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerVentasDirecciones() {
        // TODO Auto-generated constructor stub
    }
    public VentDireccion findByIdVentDireccion(int idVentDireccion) throws Exception {
    	return (VentDireccion) mDAO.findById(VentDireccion.class, idVentDireccion);
    }
    public List<VentDireccion> findAllVentDireccion(){
    	return mDAO.findAll(VentDireccion.class, "nombreDireccion");
    }


}
