package prueba.ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

	static String introducirCadena(){
		String cadena="";
		InputStreamReader entrada=new InputStreamReader(System.in);
		BufferedReader teclado=new BufferedReader(entrada);
		
		try{
			cadena=teclado.readLine(); 
		}
		
		catch(IOException er){
			System.out.println("error al introducir datos");
		}
		
		return cadena;
	}
	
	
	public static int leerint(){
		int num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Integer.parseInt(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros: ");
				cat=false;
			}
		}while(!cat);
		return num;
	}
	
	
	public static int leerint(int x,int y){
		int num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Integer.parseInt(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros: ");
				num=x;
				cat=false;
			}
			if(num<x||num>y){
		         cat=false;
		         System.out.println("\n\nDato fuera de rango\n\nVuelve a introducir: ");
		    }
		}while(!cat);
		return num;
	}
	
	
	
	public static float leerfloat(){
		float num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Float.parseFloat(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros(deci): ");
				cat=false;
			}
		}while(!cat);
		return num;
	}
	
	
	public static boolean leerafirm(){
		boolean comparar=true, bolfinal=false;
		String elec;
		

		
		do{
			if(!comparar){
				System.out.println("Introduce 's-si' o 'n-no': "); 	//En caso de que se repita el Do con un false
			}
			comparar=false;
			elec=Util.introducirCadena();							//necesario que el principal pregunte con un syso si se esta seguro
			
			if(elec.compareTo("s")==0 || elec.compareTo("si")==0 || elec.compareTo("n")==0 || elec.compareTo("no")==0){
				comparar=true;
			}
			
			else{
				comparar=false;
			}
			
		}while(!comparar);
		
		if(elec.compareTo("s")==0 || elec.compareTo("si")==0){
			bolfinal=true;
		}
		else{
			bolfinal=false;
		}
		
		return bolfinal;
		
	}
	
	
	
	public static float leerfloat(int x,int y){
		float num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Float.parseFloat(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros(deci): ");
				num=x;
				cat=false;
			}
			if(num<x||num>y){
		         cat=false;
		         System.out.println("\n\nDato fuera de rango\n\nVuelve a introducir: ");
		    }
		}while(!cat);
		return num;
	}
	
	
	
	
	public static double leerdoble(){
		double num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Double.parseDouble(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros(deci): ");
				cat=false;
			}
		}while(!cat);
		return num;
	}
	
	public static double leerdoble(int x,int y){
		double num=0;
		boolean cat;
		do{
			cat=true;
			try{
				num=Double.parseDouble(introducirCadena()); 
			}
			
			catch(NumberFormatException e){
				System.out.println("Error, solo numeros(deci): ");
				num=x;
				cat=false;
			}
			if(num<x||num>y){
		         cat=false;
		         System.out.println("\n\nDato fuera de rango\n\nVuelve a introducir: ");
		    }
		}while(!cat);
		return num;
	}
	
	static char leerCarac(){
		boolean error=false;
		String caracter;
		do{
			error=false;
			caracter=introducirCadena();
			if(caracter.length()!=1){
				System.out.println("Introduce un solo caracter.");
				error=true;
			}
		}while(error);
		return caracter.charAt(0);
	}
	
	
	public static char leerCharArray(char caracteres[]) {
		int i=0;
		boolean error = false;
		String letra;
		char aux = 0;
		do {
			error = false;
			letra = introducirCadena();
			if (letra.length() != 1) {
				System.out.println("Error, introduce un caracter: ");
				error = true;
			} else {
				aux = letra.charAt(0);
				for (i=0; i<caracteres.length; i++) {
					if (Character.toUpperCase(caracteres[i]) == Character.toUpperCase(aux)) {
						break;
					}
				}
				if (i == caracteres.length) {
					error = true;
					System.out.println("Error, el caracter introducido no es valido/ Introduce de nuevo: ");
				}
			}
		} while (error);
		return aux;
	}
	
	
	public static char eleccion( char letra1, char letra2) {
		char respuesta;
		do{	
			respuesta=leerCarac();
			respuesta=Character.toUpperCase(respuesta);
			if(respuesta!=letra1 && respuesta!=letra1){
					System.out.print("Elige entre" + letra1 + "o" + letra2 + ": ");
			}
		}while(respuesta!=letra1 && respuesta!=letra2);
		return respuesta;
	}
	
	
	public static LocalDate leerFecha(){
		boolean estaMal;
		String fecha;
		DateTimeFormatter formateador= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate auxfecha=null;
		do{
			estaMal=false;
			fecha=Util.introducirCadena();
			try{
				auxfecha=LocalDate.parse(fecha, formateador);
			}catch(DateTimeException e){
				System.out.println("Introduce una fecha v�lida.(DD-MM-AAAA)");
				estaMal=true;
			}
		}while(estaMal);
		return auxfecha;
	}	
	
	
}

