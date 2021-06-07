package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distribuidor database table.
 * 
 */
@Entity
@NamedQuery(name="Distribuidor.findAll", query="SELECT d FROM Distribuidor d")
public class Distribuidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean activo;

	private String codigoPostal;

	private String direccion;

	private String email;

	private String localidad;

	private String nombre;

	private String provincia;

	private String telefono;

	//bi-directional many-to-one association to Mueble
	@OneToMany(mappedBy="distribuidor")
	private List<Mueble> muebles;

	public Distribuidor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Mueble> getMuebles() {
		return this.muebles;
	}

	public void setMuebles(List<Mueble> muebles) {
		this.muebles = muebles;
	}

	public Mueble addMueble(Mueble mueble) {
		getMuebles().add(mueble);
		mueble.setDistribuidor(this);

		return mueble;
	}

	public Mueble removeMueble(Mueble mueble) {
		getMuebles().remove(mueble);
		mueble.setDistribuidor(null);

		return mueble;
	}

}