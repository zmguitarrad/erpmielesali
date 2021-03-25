package erpmielesali.model.ventas.managers;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import erpmielesali.model.core.entities.GastGasto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.VentVenta;
import erpmielesali.model.core.entities.VentVentaDetalle;
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
	private ManagerVentasCliente mClientes;

    /**
     * Default constructor. 
     */
    public ManagerVentasVenta() {
        // TODO Auto-generated constructor stub
    }
    public VentVenta findByIdVentVenta(String idVentVentas) throws Exception {
    	return (VentVenta) mDAO.findById(VentVenta.class, idVentVentas);
    }
    public List<VentVenta> findAllVentVenta(){
    	return mDAO.findAll(VentVenta.class);
    }

 public VentVenta insertarVenta(VentVenta nuevaVenta , Date fecha , String cedulaVentCliente) throws Exception {
    	
    	
    	VentVenta venta = new VentVenta();
    	venta.setIdVentVentas(nuevaVenta.getIdVentVentas());
    	venta.setVentCliente(mClientes.findByIdVentVenta(cedulaVentCliente));
    	venta.setFechaVentas(fecha);
    	venta.setDescuento(nuevaVenta.getDescuento());
    	venta.setTotal(nuevaVenta.getTotal());
    	mDAO.insertar(venta);
    	return venta;
    	
    }
 public void eliminarVenta(int idVentVentas) throws Exception {
 	mDAO.eliminar(VentVenta.class, idVentVentas);
 }
 
 public void actualizarVenta(VentVenta edicionVenta , String idVentVentas , String cedulaVentCliente, Date fecha) throws Exception {
 	
 	VentVenta venta = new VentVenta();
 	venta.setVentCliente(mClientes.findByIdVentVenta(cedulaVentCliente));
 	venta.setFechaVentas(fecha);
 	venta.setDescuento(edicionVenta.getDescuento());
 	venta.setTotal(edicionVenta.getTotal());
 	
 	mDAO.actualizar(venta);
 }

 
}