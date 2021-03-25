package erpmielesali.model.ventas.managers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sun.media.sound.ModelOscillator;

import erpmielesali.model.core.entities.GastGasto;
import erpmielesali.model.core.entities.ProdProducto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.VentVentaDetalle;
import erpmielesali.model.core.managers.ManagerDAO;
import erpmielesali.model.producto.managers.ManagerProdProducto;



/**
 * Session Bean implementation class ManagerVentasCliente
 */
@Stateless
@LocalBean
public class ManagerVentasDetalle {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerVentasVenta mVentas;
	@EJB
	private ManagerProdProducto mStock;

    /**
     * Default constructor. 
     */
    public ManagerVentasDetalle() {
        // TODO Auto-generated constructor stub
    }
    
    public List<VentVentaDetalle> findAllVentVentaDetalle(){
    	return mDAO.findAll(VentVentaDetalle.class);
    }
    
    public VentVentaDetalle insertarVentaDetalle(VentVentaDetalle nuevoDetalle , String idVentVentas , int idProdStock) throws Exception {
    	
    	VentVentaDetalle venta = new VentVentaDetalle();
    	ProdStock stock = (ProdStock) mDAO.findById(ProdStock.class, idProdStock);
    	venta.setVentVenta(mVentas.findByIdVentVenta(idVentVentas));
    	venta.setProdStock(stock);
    	venta.setCantidadVendidas(nuevoDetalle.getCantidadVendidas());
    	double suma= (nuevoDetalle.getCantidadVendidas() * 2);
    	venta.setSubtotal(new BigDecimal(suma));
    	mDAO.insertar(venta);
    	return venta;
    	
    }
    public void eliminarVentaDetalle(int idVentVentaDetalle) throws Exception {
    	mDAO.eliminar(VentVentaDetalle.class, idVentVentaDetalle);
    }
    
    public void actualizarVentaDetalle(VentVentaDetalle edicionVentaDetalle , String idVentVentas , int idProdStock) throws Exception {
    	
    	VentVentaDetalle venta = new VentVentaDetalle();
    	ProdStock stock = (ProdStock) mDAO.findById(ProdStock.class, idProdStock);
    	venta.setVentVenta(mVentas.findByIdVentVenta(idVentVentas));
    	venta.setProdStock(stock);
    	venta.setCantidadVendidas(edicionVentaDetalle.getCantidadVendidas());
    	double suma= (edicionVentaDetalle.getCantidadVendidas() * 0.5);
    	venta.setSubtotal(new BigDecimal(suma));
    	mDAO.actualizar(venta);
    }
   
    
    


}