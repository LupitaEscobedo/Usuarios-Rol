package Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String nombre;
	private int edad;
	Rol rol;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad(){
		return edad;
	}
	
	public void setEdad(int edad){
		this.edad = edad;
	}
	
	@ManyToOne
	public Rol getRol(){
		return rol;
	}
	
	public void setRol(Rol rol){
		this.rol = rol;
	}
	
}

