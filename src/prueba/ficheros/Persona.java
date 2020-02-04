package prueba.ficheros;

import java.io.Serializable;

public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected float nota;
	
	public Persona(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public void setDatos(){
		
		System.out.println("Introduce el nombre");
		this.nombre=Util.introducirCadena();
		
		System.out.println("Introduce la nota");
		this.nota=Util.leerfloat();
		
	}
	
	public void getDatos(){
		System.out.println("Nombre: " + nombre
				+ "\tNota: " + nota);
	}
	
}
