package erpmielesali.model.ventas.managers;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.VentCliente;
import erpmielesali.model.core.entities.VentDireccion;
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
    public List<VentCliente> findAllVentCliente(){
    	return mDAO.findAll(VentCliente.class, "nombreCliente");
    }
    
    public VentCliente insertarVentClienteActual(String cedulaCliente,int idVentDireccion, String nombreCiente, String apellidoCliente,
    		String celular, String email, String razon) throws Exception {
    	VentCliente nuevo =  new VentCliente();
    	nuevo.setCedulaVentCliente(cedulaCliente);
    	nuevo.setVentDireccion(mDirecciones.findByIdVentDireccion(idVentDireccion));
    	nuevo.setNombreCliente(nombreCiente);
    	nuevo.setApellidoCliente(apellidoCliente);
    	nuevo.setCelular(celular);
    	nuevo.setEmail(email);
    	nuevo.setRazon(razon);
    	
    	
    	mDAO.insertar(nuevo);
    	return nuevo;
    }
    
    public void eliminarCliente(String idVentDireccion) throws Exception {
    	VentCliente cliente= (VentCliente) mDAO.findById(VentCliente.class, idVentDireccion);
    	
    	mDAO.eliminar(VentCliente.class, cliente.getCedulaVentCliente());
    }
    public void actualizarCliente(VentCliente edicionCliente , int idVentDireccion) throws Exception {
    	VentCliente cliente = (VentCliente) mDAO.findById(VentCliente.class, edicionCliente.getCedulaVentCliente());
    	cliente.setVentDireccion(mDirecciones.findByIdVentDireccion(idVentDireccion));
    	cliente.setNombreCliente(edicionCliente.getNombreCliente());
    	cliente.setApellidoCliente(edicionCliente.getApellidoCliente());
    	cliente.setCelular(edicionCliente.getCedulaVentCliente());
    	cliente.setEmail(edicionCliente.getEmail());
    	cliente.setRazon(edicionCliente.getRazon());

    	mDAO.actualizar(cliente);
    }
    

}