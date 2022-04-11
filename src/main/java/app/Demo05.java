package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// versión mejorada de eliminar
		// fabrica --> DAO

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Manejador de Entidades
		EntityManager em = fabrica.createEntityManager();

		Usuario u = new Usuario();
		u.setCodigo(10);

		if (em.find(Usuario.class, u.getCodigo()) == null)
			System.err.println("Usuario no existe");
		else {
			em.getTransaction().begin();
			em.remove(em.find(Usuario.class, u.getCodigo()));
			em.getTransaction().commit();
			System.out.println("Usuario eliminado correctamente");
		}
		// cierre
		em.close();
	}
}
