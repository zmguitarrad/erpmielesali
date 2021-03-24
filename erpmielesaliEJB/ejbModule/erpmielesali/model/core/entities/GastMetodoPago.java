package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gast_metodo_pago database table.
 * 
 */
@Entity
@Table(name="gast_metodo_pago")
@NamedQuery(name="GastMetodoPago.findAll", query="SELECT g FROM GastMetodoPago g")
public class GastMetodoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gast_metodo_pago", unique=true, nullable=false)
	private Integer idGastMetodoPago;

	@Column(name="metodo_pago", length=20)
	private String metodoPago;

	//bi-directional many-to-one association to GastGasto
	@OneToMany(mappedBy="gastMetodoPago")
	private List<GastGasto> gastGastos;

	public GastMetodoPago() {
	}

	public Integer getIdGastMetodoPago() {
		return this.idGastMetodoPago;
	}

	public void setIdGastMetodoPago(Integer idGastMetodoPago) {
		this.idGastMetodoPago = idGastMetodoPago;
	}

	public String getMetodoPago() {
		return this.metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public List<GastGasto> getGastGastos() {
		return this.gastGastos;
	}

	public void setGastGastos(List<GastGasto> gastGastos) {
		this.gastGastos = gastGastos;
	}

	public GastGasto addGastGasto(GastGasto gastGasto) {
		getGastGastos().add(gastGasto);
		gastGasto.setGastMetodoPago(this);

		return gastGasto;
	}

	public GastGasto removeGastGasto(GastGasto gastGasto) {
		getGastGastos().remove(gastGasto);
		gastGasto.setGastMetodoPago(null);

		return gastGasto;
	}

}