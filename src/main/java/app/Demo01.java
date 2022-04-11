package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		
		// agregar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(11);
		u.setNombre("Eren");
		u.setApellido("Yeager");
		u.setUsuario("eren@mail.com");
		u.setClave("tatakae");
		u.setFchnacim("2000/01/01");
		u.setTipo(1);
		u.setEstado(1);
		
		// proceso de registro
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			
			em.persist(u); // registrar
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al registrar...." + e.getMessage());
		}
		em.close();
		System.out.println("Terminó.....");
	}
}
