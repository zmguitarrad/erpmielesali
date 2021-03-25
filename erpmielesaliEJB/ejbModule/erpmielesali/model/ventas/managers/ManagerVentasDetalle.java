package erpmielesali.model.ventas.managers;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import erpmielesali.model.core.managers.ManagerDAO;



/**
 * Session Bean implementation class ManagerVentasCliente
 */
@Stateless
@LocalBean
public class ManagerVentasDetalle {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerVentasDirecciones mDirecciones;

    /**
     * Default constructor. 
     */
    public ManagerVentasDetalle() {
        // TODO Auto-generated constructor stub
    }


}