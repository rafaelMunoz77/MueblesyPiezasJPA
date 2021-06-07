package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Tipomueble;




public class TipoMuebleControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mueblesYPiezas");
	
	// instancia del singleton
	private static TipoMuebleControlador instancia = null;

	/**
	 * 
	 */
	public TipoMuebleControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static TipoMuebleControlador getInstancia() {
		if (instancia == null) {
			instancia = new TipoMuebleControlador();
		}
		return instancia;
	}

	
	public List<Tipomueble> findAll () {
		EntityManager em = factory.createEntityManager();
		List<Tipomueble> resultado = new ArrayList<Tipomueble>();
		Query q = em.createNativeQuery("select * from tipomueble", Tipomueble.class);
		resultado = q.getResultList();
		em.close();
		return resultado;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Tipomueble findPrimero () {
		Tipomueble resultado = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM tipomueble order by id limit 1", Tipomueble.class);
			resultado = (Tipomueble) q.getSingleResult();
			em.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public Tipomueble findSiguiente (int idActual) {
		Tipomueble resultado = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM mueblesypiezas.tipomueble where id > ? order by id limit 1", Tipomueble.class);
			q.setParameter(1, idActual);
			resultado = (Tipomueble) q.getSingleResult();
			em.close();
		}
		catch (NoResultException ex) {
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public Tipomueble findAnterior (int idActual) {
		Tipomueble resultado = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM mueblesypiezas.tipomueble where id < ? order by id desc limit 1", Tipomueble.class);
			q.setParameter(1, idActual);
			resultado = (Tipomueble) q.getSingleResult();
			em.close();
		}
		catch (NoResultException ex) {
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Tipomueble findUltimo () {
		Tipomueble resultado = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM mueblesypiezas.tipomueble order by id desc limit 1", Tipomueble.class);
			resultado = (Tipomueble) q.getSingleResult();
			em.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	
	public boolean guardar (Tipomueble o) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			if (o.getId() == 0) {
				em.persist(o);
			}
			else {
				em.merge(o);
			}
			em.getTransaction().commit();
			return true;
		}
		catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			return false;
		}
		
	}
	
	
	public static void main(String args[]) {
		List<Tipomueble> tipos = TipoMuebleControlador.getInstancia().findAll();
		for (Tipomueble tipo : tipos) {
			System.out.println(tipo.getDescripcion() + " " + tipo.getId());
		}
	}
}
