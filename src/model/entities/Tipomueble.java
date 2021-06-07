package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipomueble database table.
 * 
 */
@Entity
@NamedQuery(name="Tipomueble.findAll", query="SELECT t FROM Tipomueble t")
public class Tipomueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Mueble
	@OneToMany(mappedBy="tipomueble")
	private List<Mueble> muebles;

	public Tipomueble() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Mueble> getMuebles() {
		return this.muebles;
	}

	public void setMuebles(List<Mueble> muebles) {
		this.muebles = muebles;
	}

	public Mueble addMueble(Mueble mueble) {
		getMuebles().add(mueble);
		mueble.setTipomueble(this);

		return mueble;
	}

	public Mueble removeMueble(Mueble mueble) {
		getMuebles().remove(mueble);
		mueble.setTipomueble(null);

		return mueble;
	}

}