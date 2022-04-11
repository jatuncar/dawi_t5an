package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		
		// agregar un nuevo usuario a modificar
		Usuario u = new Usuario();
		u.setCodigo(13);
		u.setNombre("Carla");
		u.setApellido("Toro");
		u.setUsuario("U013@gmail.com");  // UNIQUE
		u.setClave("10002");
		u.setFchnacim("2022-03-21");
		u.setTipo(2);
		u.setEstado(1);
		
		// proceso de actualización
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.merge(u);  // si id, existe, actualiza el Usuario, sino lo agrega
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al actualizar...." + e.getMessage());
		}
		em.close();
		System.out.println("Terminó.....");
	}
}
