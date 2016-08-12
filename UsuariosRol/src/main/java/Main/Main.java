package Main;

import Clases.*;
import java.util.*;
import javax.persistence.*;

public class Main {
	
	private static final String PERSISTENCE_UNIT_NAME = "usuarios";
	private static EntityManagerFactory factory;
	private static EntityManager em; 
	
	public static void main(String[] args) {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		
	    em.getTransaction().begin();
	    Rol rol = new Rol();
	    rol.setNombre("Empleado");
	    em.persist(rol);
	    em.getTransaction().commit();
	    
	    em.getTransaction().begin();
	    Rol rol2 = new Rol();
	    rol2.setNombre("Jefe");
	    em.persist(rol2);
	    em.getTransaction().commit();
	    
	    addUser("Lupita", 19, rol);
	    addUser("Antonia", 46, rol2);
	    
	    imprimirDatos();

	    em.close();

	}
	
	public static void imprimirDatos()
	{
		Query query = em.createQuery("SELECT t FROM Usuario t");
		List<Usuario> lista = query.getResultList();
		int tam = lista.size();
		Usuario user;
		for(int i=0; i<tam; i++){
			user = lista.get(i);
			System.out.println("Usuario " + (i+1) + ": ");
			System.out.println("\tNombre: " + user.getNombre());
			System.out.println("\tEdad: " + user.getEdad());
			System.out.println("\tRol: " + user.getRol().getNombre());
		}
	}
	
	public static void addUser(String nombre, int edad, Rol rol){
		em.getTransaction().begin();
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setEdad(edad);
		user.setRol(rol);
		em.persist(user);
		em.getTransaction().commit();
	}

}
