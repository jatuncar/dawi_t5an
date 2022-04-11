package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// Obj >>> eliminar un Usuario
		
		// fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// manejador de Entidades
		EntityManager em = fabrica.createEntityManager();
		// empieza el proceso --> reg, act o elim
		em.getTransaction().begin();
		// proceso
		// forma 1. eliminación lógica --> actualización de estados
		// forma 2. eliminación física --> delete ...
		Usuario u = new Usuario();
		u.setCodigo(13);
		
		em.remove(u); // !!Ojo..Necesita un objeto que se debe devolver
		// confirmación
		em.getTransaction().commit();
		// cierre
		em.close();
	}
}
