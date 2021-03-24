package erpmielesali.model.ventas.managers;



import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import erpmielesali.model.core.managers.ManagerDAO;



/**
 * Session Bean implementation class ManagerVentasCliente
 */
@Stateless
@LocalBean
public class ManagerVentasVenta {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerVentasCliente mClientes;;

    /**
     * Default constructor. 
     */
    public ManagerVentasVenta() {
        // TODO Auto-generated constructor stub
    }

}