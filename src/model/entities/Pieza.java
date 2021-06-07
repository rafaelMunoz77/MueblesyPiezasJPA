package model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pieza database table.
 * 
 */
@Entity
@NamedQuery(name="Pieza.findAll", query="SELECT p FROM Pieza p")
public class Pieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int cantidad;

	private String nombre;

	//bi-directional many-to-one association to Mueble
	@ManyToOne
	@JoinColumn(name="idMueble")
	private Mueble mueble;

	public Pieza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Mueble getMueble() {
		return this.mueble;
	}

	public void setMueble(Mueble mueble) {
		this.mueble = mueble;
	}

}