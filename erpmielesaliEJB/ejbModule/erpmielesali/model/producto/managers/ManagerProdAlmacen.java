package erpmielesali.model.producto.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.VentCliente;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerProdAlmacen
 */
@Stateless
@LocalBean
public class ManagerProdAlmacen {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerProdProducto mProducto;

    /**
     * Default constructor. 
     */
    public ManagerProdAlmacen() {
        // TODO Auto-generated constructor stub
    }
    public List<ProdStock>findAllProdAlmacen(){
    	return mDAO.findAll(ProdStock.class);
    }

}
