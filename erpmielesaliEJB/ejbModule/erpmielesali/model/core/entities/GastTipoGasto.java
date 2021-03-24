package erpmielesali.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gast_tipo_gasto database table.
 * 
 */
@Entity
@Table(name="gast_tipo_gasto")
@NamedQuery(name="GastTipoGasto.findAll", query="SELECT g FROM GastTipoGasto g")
public class GastTipoGasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gast_tipo_gasto", unique=true, nullable=false)
	private Integer idGastTipoGasto;

	@Column(name="nombre_gastos", length=30)
	private String nombreGastos;

	//bi-directional many-to-one association to GastGasto
	@OneToMany(mappedBy="gastTipoGasto")
	private List<GastGasto> gastGastos;

	public GastTipoGasto() {
	}

	public Integer getIdGastTipoGasto() {
		return this.idGastTipoGasto;
	}

	public void setIdGastTipoGasto(Integer idGastTipoGasto) {
		this.idGastTipoGasto = idGastTipoGasto;
	}

	public String getNombreGastos() {
		return this.nombreGastos;
	}

	public void setNombreGastos(String nombreGastos) {
		this.nombreGastos = nombreGastos;
	}

	public List<GastGasto> getGastGastos() {
		return this.gastGastos;
	}

	public void setGastGastos(List<GastGasto> gastGastos) {
		this.gastGastos = gastGastos;
	}

	public GastGasto addGastGasto(GastGasto gastGasto) {
		getGastGastos().add(gastGasto);
		gastGasto.setGastTipoGasto(this);

		return gastGasto;
	}

	public GastGasto removeGastGasto(GastGasto gastGasto) {
		getGastGastos().remove(gastGasto);
		gastGasto.setGastTipoGasto(null);

		return gastGasto;
	}

}