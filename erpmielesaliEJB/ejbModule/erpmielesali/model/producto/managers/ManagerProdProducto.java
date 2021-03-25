package erpmielesali.model.producto.managers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;



import erpmielesali.model.core.entities.ProdProducto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.ProdTipoProducto;
import erpmielesali.model.core.entities.SegUsuario;
import erpmielesali.model.core.entities.ThmEmpleado;
import erpmielesali.model.core.entities.VentCliente;
import erpmielesali.model.core.entities.VentDireccion;
import erpmielesali.model.core.managers.ManagerDAO;

/**
 * Implementa la logica de manejo producto.
 * Funcionalidades principales:
 * <ul>
 * 	<li>Funcionalidades CRUD Producto.</li>
 * </ul>
 * @author zmguitarra & ehernandez
 */
@Stateless
@LocalBean
public class ManagerProdProducto {
	@EJB
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerProdProducto() {
        // TODO Auto-generated constructor stub
    }
   // tipo producto
    		//listar
    public List<ProdTipoProducto>findAllProdTipo(){
    	return mDAO.findAll(ProdTipoProducto.class);
    }
    		//listar por id tipo
    public ProdTipoProducto findByIdProdTipoProducto(int idProdTipoProducto) throws Exception {
    	return (ProdTipoProducto) mDAO.findById(ProdTipoProducto.class, idProdTipoProducto);
    }

   
        	//crear tipo producto
    public ProdTipoProducto insertarTipo(ProdTipoProducto nuevoTipo) throws Exception {
    	ProdTipoProducto tipo=new ProdTipoProducto();
    	tipo.setNombreTipoProducto(nuevoTipo.getNombreTipoProducto());
    	mDAO.insertar(tipo);
    	return tipo;
    }
    		//eliminar tipo
    public void eliminarTipo(int idProdTipoProducto) throws Exception {
    	mDAO.eliminar(ProdTipoProducto.class, idProdTipoProducto);
    }

    
   //PRODUCTO
    
    	 //listar
    public List<ProdProducto>findAllProdProducto(){
    	return mDAO.findAll(ProdProducto.class,"codigoProdProduct");
    	
    }
    		//listar por byid
    public ProdProducto findByCodigoProdProducto(String codigoProdProduct) throws Exception {
    	return(ProdProducto) mDAO.findById(ProdProducto.class, codigoProdProduct);
    	
    }
 
    
    	//listar para stock
    public List<ProdProducto> findAllAllProductoStock(){
    	return mDAO.findAll(ProdProducto.class, "codigoProdProduct");
    }


    	//crear producto
    public ProdProducto insertarProducto(ProdProducto nuevoProducto, int idProdTipoProducto) throws Exception {
    	ProdProducto producto=new ProdProducto();
    	producto.setCodigoProdProduct(nuevoProducto.getCodigoProdProduct());
    	producto.setProdTipoProducto(findByIdProdTipoProducto(idProdTipoProducto));
    	producto.setNombreProducto(nuevoProducto.getNombreProducto());
    	producto.setDescripcionProducto(nuevoProducto.getDescripcionProducto());
    	producto.setPrecio(nuevoProducto.getPrecio());
    	producto.setActivo(true);
    	mDAO.insertar(producto);
    	return producto;
    	
    }
    
    		// eliminar
    public void eliminarProducto(String ProdCodigoProducto) throws Exception {
    	mDAO.eliminar(ProdProducto.class, ProdCodigoProducto);
    }
    		//editar
    public void actualizarProducto(ProdProducto edicionProducto) throws Exception {
    	ProdProducto producto=(ProdProducto) mDAO.findById(ProdProducto.class, edicionProducto.getCodigoProdProduct());
    	producto.setNombreProducto(edicionProducto.getNombreProducto());
    	producto.setDescripcionProducto(edicionProducto.getDescripcionProducto());
    	producto.setPrecio(edicionProducto.getPrecio());
    	mDAO.actualizar(producto);
    }
    		//Activar Producto
    public void activarDesactivarProducto(String ProdCodigoProducto) throws Exception {
    	ProdProducto producto=(ProdProducto)mDAO.findById(ProdProducto.class, ProdCodigoProducto);
    	producto.setActivo(!producto.getActivo());
    	System.out.println("activar/desactivar "+producto.getActivo());
    	mDAO.actualizar(producto);
    }
    
    // TABLA STOCK
    	//listar 
	 //listar
    public List<ProdStock>findAllProdStock(){
    	return mDAO.findAll(ProdStock.class);
    	
    }
    //crear 
    public ProdStock insertarStock(ProdStock nuevoStock, String producto) throws Exception {
    	
    	ProdProducto producto1=(ProdProducto) mDAO.findById(ProdProducto.class, producto);
    	ProdStock stock=new ProdStock();
    	stock.setProdProducto(producto1);
    	stock.setUnidadesProducidas(nuevoStock.getUnidadesProducidas());
    	stock.setFechaActualizacion(nuevoStock.getFechaActualizacion());
    	mDAO.insertar(stock);
    	return stock;

    	
    }
		//eliminar tipo
    public void eliminarStock(int idProdStock) throws Exception {
    	mDAO.eliminar(ProdStock.class, idProdStock);
    }

    

}
   

