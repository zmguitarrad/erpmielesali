package erpmielesali.controller.producto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import erpmielesali.model.core.entities.ProdProducto;
import erpmielesali.model.core.entities.ProdStock;
import erpmielesali.model.core.entities.ProdTipoProducto;
import erpmielesali.model.producto.managers.ManagerProdAlmacen;
import erpmielesali.model.producto.managers.ManagerProdProducto;


@Named
@SessionScoped
public class BeanProdAlmacen implements Serializable {
	@EJB
	private ManagerProdAlmacen mAlmacen;
	private ManagerProdProducto mProducto;
	private List<ProdProducto>listaProducto;
	private List<ProdTipoProducto>listaTipo;
	private List<ProdStock>listaStock;
	private ProdStock nuevoStock;
	private ProdStock edicionStock;
	private String codigoProdProducto;
	private Date fecha;

	public BeanProdAlmacen() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public void inicializador() {
		listaProducto=mProducto.findAllProdProducto();
		listaTipo=mProducto.findAllProdTipo();
		listaStock=mAlmacen.findAllProdAlmacen();
		
	
	}
	//cargar stock-producto
	public String actionCargarMenuAlmacen() {
		listaStock=mAlmacen.findAllProdAlmacen();
		return "stock";	
	}

	
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
	public String getCodigoProdProducto() {
		return codigoProdProducto;
	}
	public void setCodigoProdProducto(String codigoProdProducto) {
		this.codigoProdProducto = codigoProdProducto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	


}
