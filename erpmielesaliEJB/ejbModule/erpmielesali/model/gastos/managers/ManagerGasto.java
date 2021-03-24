package erpmielesali.model.gastos.managers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import erpmielesali.model.core.entities.GastGasto;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerGasto
 */
@Stateless
@LocalBean
public class ManagerGasto {

	@EJB
	private ManagerDAO mDAO; 
	@EJB
	private ManagerGastoTipo mGastoTipo;
	@EJB
	private ManagerMetodoPago mMetodoPago;
    /**
     * Default constructor. 
     */
    public ManagerGasto() {
        // TODO Auto-generated constructor stub
    }
    
    public List<GastGasto> findAllGastGasto(){
    	return mDAO.findAll(GastGasto.class);
    }
    
    public GastGasto insertarGasto(GastGasto nuevoGasto , Date fecha , int idGastTipoGasto , int idGastMetodoPago) throws Exception {
    	
    	GastGasto gasto = new GastGasto();
    	
    	gasto.setGastTipoGasto(mGastoTipo.findByIdGastTipoGasto(idGastTipoGasto));
    	gasto.setGastMetodoPago(mMetodoPago.findIdGastMetodoPago(idGastMetodoPago));
    	gasto.setDescripcionGastos(nuevoGasto.getDescripcionGastos());
    	gasto.setGastoFecha(fecha);
    	gasto.setValorGastos(nuevoGasto.getValorGastos());
    	gasto.setEstado(true);
    	mDAO.insertar(gasto);
    	return gasto;
    	
    }
    
    public void eliminarGasto(int idGastGastos) throws Exception {
    	mDAO.eliminar(GastGasto.class, idGastGastos);
    }
    
    public void actualizarGasto(GastGasto edicionGasto , int idGastTipoGasto , int idGastMetodoPago, Date fecha) throws Exception {
    	
    	GastGasto gasto = (GastGasto) mDAO.findById(GastGasto.class, edicionGasto.getIdGastGastos());
    	gasto.setGastTipoGasto(mGastoTipo.findByIdGastTipoGasto(idGastTipoGasto));
    	gasto.setGastMetodoPago(mMetodoPago.findIdGastMetodoPago(idGastMetodoPago));
    	gasto.setDescripcionGastos(edicionGasto.getDescripcionGastos());
    	gasto.setGastoFecha(fecha);
    	gasto.setValorGastos(edicionGasto.getValorGastos());
    	mDAO.actualizar(gasto);
    }
   
    public void activarDesactivarGasto(int idGastGastos) throws Exception {
    	GastGasto gasto = (GastGasto) mDAO.findById(GastGasto.class, idGastGastos);
    	gasto.setEstado(!gasto.getEstado());
    	System.out.println("activar/desactivar "+gasto.getEstado());
    	mDAO.actualizar(gasto);
    }
    
}
