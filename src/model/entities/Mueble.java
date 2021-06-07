package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mueble database table.
 * 
 */
@Entity
@NamedQuery(name="Mueble.findAll", query="SELECT m FROM Mueble m")
public class Mueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String color;

	private String nombre;

	private String serie;

	//bi-directional many-to-one association to Carpintero
	@ManyToOne
	@JoinColumn(name="idCarpintero")
	private Carpintero carpintero;

	//bi-directional many-to-one association to Distribuidor
	@ManyToOne
	@JoinColumn(name="idDistribuidor")
	private Distribuidor distribuidor;

	//bi-directional many-to-one association to Tipomueble
	@ManyToOne
	@JoinColumn(name="idTipoMueble")
	private Tipomueble tipomueble;

	//bi-directional many-to-one association to Pieza
	@OneToMany(mappedBy="mueble")
	private List<Pieza> piezas;

	public Mueble() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Carpintero getCarpintero() {
		return this.carpintero;
	}

	public void setCarpintero(Carpintero carpintero) {
		this.carpintero = carpintero;
	}

	public Distribuidor getDistribuidor() {
		return this.distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Tipomueble getTipomueble() {
		return this.tipomueble;
	}

	public void setTipomueble(Tipomueble tipomueble) {
		this.tipomueble = tipomueble;
	}

	public List<Pieza> getPiezas() {
		return this.piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}

	public Pieza addPieza(Pieza pieza) {
		getPiezas().add(pieza);
		pieza.setMueble(this);

		return pieza;
	}

	public Pieza removePieza(Pieza pieza) {
		getPiezas().remove(pieza);
		pieza.setMueble(null);

		return pieza;
	}

}