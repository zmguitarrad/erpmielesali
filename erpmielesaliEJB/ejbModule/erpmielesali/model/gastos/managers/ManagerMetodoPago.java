package erpmielesali.model.gastos.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.GastMetodoPago;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerMetodoPago
 */
@Stateless
@LocalBean
public class ManagerMetodoPago {
@EJB
 private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerMetodoPago() {
        // TODO Auto-generated constructor stub
    }
    
    public GastMetodoPago findIdGastMetodoPago(int idGastMetodoPago) throws Exception {
    	return (GastMetodoPago) mDAO.findById(GastMetodoPago.class, idGastMetodoPago);
    }
    
    public List<GastMetodoPago> findAllGastMetodoPago(){
    	return mDAO.findAll(GastMetodoPago.class, "metodoPago");
    }
}
