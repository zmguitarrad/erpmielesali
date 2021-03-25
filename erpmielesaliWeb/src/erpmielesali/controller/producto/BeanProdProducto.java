package erpmielesali.controller.producto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.controller.JSFUtil;
import erpmielesali.model.core.entities.ProdProducto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.ProdTipoProducto;
import erpmielesali.model.core.entities.SegUsuario;
import erpmielesali.model.core.entities.ThmEmpleado;
import erpmielesali.model.producto.managers.ManagerProdProducto;

@Named
@SessionScoped
public class BeanProdProducto implements Serializable {
	@EJB
	private ManagerProdProducto mProducto;
	private List<ProdProducto>listaProducto;
	private List<ProdTipoProducto>listaTipo;
	private List<ProdStock>listaStock;
	private ProdProducto nuevoProducto;
	private ProdProducto edicionProducto;
	private ProdTipoProducto nuevoTipo;
	private ProdTipoProducto edicionTipo;
	private ProdStock nuevoStock;
	private ProdStock edicionStock;
	private int idProdTipoProducto;
	private String codigoProducto;
	private ProdProducto producto;
	
	

	public BeanProdProducto() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializador() {
		listaTipo =mProducto.findAllProdTipo();
		listaProducto=mProducto.findAllProdProducto();
		listaStock=mProducto.findAllProdStock();
		nuevoTipo=new ProdTipoProducto();
		nuevoProducto=new ProdProducto();
		nuevoStock=new ProdStock();
		

	}
	//TIPO PRODUCTO
			//cargar los tipo producto
	public String actionCargarMenuTipo() {
		listaTipo=mProducto.findAllProdTipo();
		return "tipo_nuevo?faces-redirect=true";
	}

		// crear tipo
	public void actionListenerInsertarNuevoTipo() {
		try {
			mProducto.insertarTipo(nuevoTipo);
			listaTipo=mProducto.findAllProdTipo();
			
			JSFUtil.crearMensajeINFO("Tipo insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}		
		
	}
		//eliminar tipo
	public void actionListenerEliminarTipo(int idProdTipoProducto) {
		try {
			mProducto.eliminarTipo(idProdTipoProducto);
			listaTipo=mProducto.findAllProdTipo();
			JSFUtil.crearMensajeINFO("Tipo eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		
	//PRODUCTO
			//cargar los productos
	
	public String actionCargarMenuProductos() {
		listaTipo=mProducto.findAllProdTipo();
		listaProducto=mProducto.findAllProdProducto();
		return "producto?faces-redirect=true";
	}

		//producto nuevo
	public String actionMenuNuevoProducto() {
		nuevoProducto=new ProdProducto();
		return "producto_nuevo";
	}
		//insertar producto
	public void actionListenerInsertarNuevoProducto() {
		try {
			mProducto.insertarProducto(nuevoProducto, idProdTipoProducto);	
			listaProducto=mProducto.findAllProdProducto();
			JSFUtil.crearMensajeINFO("Producto insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
		//eliminar
	public void actionListenerEliminarProducto(String ProdCodigoProducto) {
		try {
			mProducto.eliminarProducto(ProdCodigoProducto);
			listaProducto=mProducto.findAllProdProducto();
			JSFUtil.crearMensajeINFO("Producto eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//editar
	public String actionSeleccionarEdicionProducto(ProdProducto producto) {
		edicionProducto=producto;
		return "producto_edicion";
		
	}
	public void actionListenerEdicionProducto() {
		try {
			mProducto.actualizarProducto(edicionProducto);
			listaProducto=mProducto.findAllProdProducto();
			JSFUtil.crearMensajeINFO("Producto actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
		//activar desactivar producto
	public void actionListenerActivarDesactivarProducto(String ProdCodigoProducto) {
		try {
			mProducto.activarDesactivarProducto(ProdCodigoProducto);
			listaProducto=mProducto.findAllProdProducto();
			JSFUtil.crearMensajeINFO("Producto activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//STOCK
		//listar stock
	public String actionCargarMenuStock() {
		listaTipo=mProducto.findAllProdTipo();
		listaProducto=mProducto.findAllProdProducto();
		listaStock=mProducto.findAllProdStock();
		return "stock?faces-redirect=true";
	}
	
	//insertar 
	public void actionListenerINsertarStock() {
		try {
			mProducto.insertarStock(nuevoStock, producto);
			listaStock=mProducto.findAllProdStock();
			JSFUtil.crearMensajeINFO("Stock insertado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
		//eliminar
	public void actionListenerEliminarStock(int idProdStock) {
		try {
			mProducto.eliminarStock(idProdStock);;
			listaStock=mProducto.findAllProdStock();
			JSFUtil.crearMensajeINFO("eliminado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	//METODOS ACCESORES
	public List<ProdProducto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<ProdProducto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public List<ProdTipoProducto> getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(List<ProdTipoProducto> listaTipo) {
		this.listaTipo = listaTipo;
	}

	public ProdProducto getNuevoProducto() {
		return nuevoProducto;
	}

	public void setNuevoProducto(ProdProducto nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}

	public ProdProducto getEdicionProducto() {
		return edicionProducto;
	}

	public void setEdicionProducto(ProdProducto edicionProducto) {
		this.edicionProducto = edicionProducto;
	}

	public ProdTipoProducto getNuevoTipo() {
		return nuevoTipo;
	}

	public void setNuevoTipo(ProdTipoProducto nuevoTipo) {
		this.nuevoTipo = nuevoTipo;
	}

	public ProdTipoProducto getEdicionTipo() {
		return edicionTipo;
	}

	public void setEdicionTipo(ProdTipoProducto edicionTipo) {
		this.edicionTipo = edicionTipo;
	}

	public int getIdProdTipoProducto() {
		return idProdTipoProducto;
	}

	public void setIdProdTipoProducto(int idProdTipoProducto) {
		this.idProdTipoProducto = idProdTipoProducto;
	}

	public List<ProdStock> getListaStock() {
		return listaStock;
	}

	public void setListaStock(List<ProdStock> listaStock) {
		this.listaStock = listaStock;
	}

	public ProdStock getNuevoStock() {
		return nuevoStock;
	}

	public void setNuevoStock(ProdStock nuevoStock) {
		this.nuevoStock = nuevoStock;
	}

	public ProdStock getEdicionStock() {
		return edicionStock;
	}

	public void setEdicionStock(ProdStock edicionStock) {
		this.edicionStock = edicionStock;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public ProdProducto getProducto() {
		return producto;
	}

	public void setProducto(ProdProducto producto) {
		this.producto = producto;
	}
	
	
	
	






	



	
	
	

	

	
	

}