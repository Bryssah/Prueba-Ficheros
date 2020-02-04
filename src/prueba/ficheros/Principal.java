package prueba.ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		int opc=0;
		String ficher="Alums.obj";
		File fich=new File(ficher);
		
		do{
			System.out.println("\n\tMenu de alumnos."
					+ "\n1).Aniadir nuevo alumno."
					+ "\n2).Listar todos los alumnos."
					+ "\n3).Buscar alumno por nombre."
					+ "\n4).Buscar alumnos aprobados."
					+ "\n5).Modificar alumno."
					+ "\n6).Eliminar alumno."
					+ "\n7).Salir.");
			
			opc=Util.leerint();
			
			switch(opc){
			
			case 1:
				addAlum(fich);
				break;
			case 2:
				listAll(fich);
				break;
			case 3:
				searchName(fich);
				break;
			case 4:
				searchApro(fich);
				break;
			case 5:
				modAlum(fich);
				break;
			case 6:
				delAlum(fich);
				break;
			case 100:
				fich.delete();
				break;
			
			}
		
		}while(opc!=7);

	}

	

	private static void delAlum(File fich) throws IOException {
		boolean opc=false;
		if(fich.exists()){
			String nomaux;
			System.out.println("Introduce nombre a eliminar: ");
			nomaux=Util.introducirCadena();
			ObjectInputStream ois=null;
			File auxfich=new File("volcado.temp");
			ObjectOutputStream oos=null;
			oos=new ObjectOutputStream(new FileOutputStream(auxfich));
			try{
				ois=new ObjectInputStream(new FileInputStream(fich));
				Persona aux=(Persona) ois.readObject();
				while(aux!=null){
					if(aux.getNombre()==nomaux){
						aux.getDatos();
						System.out.println("Esta seguro de que desea eliminarlo?(s-si/n-no): ");
						opc=Util.leerafirm();
						if(opc){
							
						}
					}
					else{
						oos.writeObject(aux);
					}
				}
			}
			catch(EOFException e1){
				System.out.println("\n~ ~ ~ ~ ~FINAL DEL FICHERO~ ~ ~ ~ ~");
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
			ois.close();
			oos.close();
		}
		else{
			System.out.println("\nNo existen datos en el fichero.");
		}
		
	}



	private static void modAlum(File fich) throws IOException {
		ArrayList <Persona> auxper=new ArrayList <Persona>();
		String nombre;
		boolean esta=false;
		boolean opc=false;
		if(fich.exists()){
			ObjectInputStream ois=null;
			try{
				ois=new ObjectInputStream(new FileInputStream(fich));
				Persona aux=(Persona) ois.readObject();
				while(aux!=null){
					auxper.add(aux);
					aux=(Persona) ois.readObject();
				}
			}
			catch(EOFException e1){
				System.out.println("\n~ ~ ~ ~ ~FICHERO CARGADO~ ~ ~ ~ ~");
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
			ois.close();
			
			System.out.println("Introduce nombre a modificar: ");
			nombre=Util.introducirCadena();
			
			for(int i=0;i<auxper.size();i++){
				if(auxper.get(i).getNombre().compareToIgnoreCase(nombre)==0){
					esta=true;
					auxper.get(i).getDatos();
					System.out.println("Desea modificar este alumno?(s-si/n-no): ");
					opc=Util.leerafirm();
					if(opc){
						auxper.get(i).setDatos();
					}
					else{
						System.out.println("Saliendo...");
						break;
					}
				}
			}
			if(!esta){
				System.out.println("No se ha encontrado ningun alumno con el nombre "+ nombre + ".");
			}
			
			if(opc){
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fich));
				for(int i=0;i<auxper.size();i++){
					oos.writeObject(auxper.get(i));
				}
				oos.close();
			}
			
			
			
		}
		else{
			System.out.println("\nNo existen datos en el fichero.");
		}
		
	}

	private static void searchApro(File fich) throws IOException {
		if(fich.exists()){
			System.out.println("\nAlumnos aprobados:");
			ObjectInputStream ois=null;
			try{
				ois=new ObjectInputStream(new FileInputStream(fich));
				Object aux=ois.readObject();
				while(aux!=null){
					if(aux instanceof Persona){
						if(((Persona) aux).getNota()>=5){
							((Persona)aux).getDatos();
						}
						aux=ois.readObject();
					}
				}
				
			}
			catch(EOFException e1){
				System.out.println("\n~ ~ ~ ~ ~FINAL DEL FICHERO~ ~ ~ ~ ~");
				ois.close();
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
		}
		else{
			System.out.println("\nNo existen datos en el fichero.");
		}
		
	}

	private static void searchName(File fich) {
		if(fich.exists()){
			String nomaux;
			System.out.println("Introduce nombre a buscar");
			nomaux=Util.introducirCadena();
			try{
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fich));
				Object aux=ois.readObject();
				while(aux!=null){
					if(aux instanceof Persona){
						if(((Persona) aux).getNombre().compareToIgnoreCase(nomaux)==0){
							((Persona)aux).getDatos();
						}
						aux=ois.readObject();
					}
				}
				ois.close();
			}
			catch(EOFException e1){
				System.out.println("\n~ ~ ~ ~ ~FINAL DEL FICHERO~ ~ ~ ~ ~");
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
		}
		else{
			System.out.println("\nNo existen datos en el fichero.");
		}			
		
	}

	private static void listAll(File fich) throws IOException {
		if(fich.exists()){
			try{
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fich));
				Object aux=ois.readObject();
				while(aux!=null){
					if(aux instanceof Persona){
						((Persona)aux).getDatos();
						aux=ois.readObject();
					}
				}
				ois.close();
			}
			catch(EOFException e1){
				System.out.println("\n~ ~ ~ ~ ~FINAL DEL FICHERO~ ~ ~ ~ ~");
			}
			catch(Exception e2){
				e2.printStackTrace();
			}
		
		
		
		}
		else{
			System.out.println("\nNo existen datos en el fichero.");
		}
	}

	private static void addAlum(File fich) throws IOException {
		Persona aux=new Persona();
		
		
		if(fich.exists()){
			FileOutputStream fos=new FileOutputStream(fich,true);
			MyObjectOutputStream moos=new MyObjectOutputStream(fos);
			aux.setDatos();
			moos.writeObject(aux);
			moos.close();
			fos.close();
		}
		
		else{
			FileOutputStream fos=new FileOutputStream(fich);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			aux.setDatos();
			oos.writeObject(aux);
			oos.close();
			fos.close();
			
		}
		
		
		
	}

}
