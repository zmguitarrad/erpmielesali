package erpmielesali.model.gastos.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import erpmielesali.model.core.entities.GastTipoGasto;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerGastoTipo
 */
@Stateless
@LocalBean
public class ManagerGastoTipo {
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerGastoTipo() {
        // TODO Auto-generated constructor stub
    }
    
    public GastTipoGasto findByIdGastTipoGasto (int idGastTipoGasto) throws Exception { 
    	return (GastTipoGasto) mDAO.findById(GastTipoGasto.class, idGastTipoGasto);
    }
    public List<GastTipoGasto> findAllGastTipoGasto(){
    	return mDAO.findAll(GastTipoGasto.class, "nombreGastos");
    }
   
}
