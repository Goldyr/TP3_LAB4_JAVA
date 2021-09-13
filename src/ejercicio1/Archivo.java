package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {

	private String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean existe() {
		File archivo = new File(ruta);
		if(archivo.exists()){return true;}
		return false;
	}
	
	public TreeSet<Persona> cargar_TreeSet() { // carga el treeset con el archivo Personas.txt ordenado alfabeticamente
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>();
		FileReader entrada;

		try {
			entrada = new FileReader(ruta);
			BufferedReader mibuffer =  new BufferedReader(entrada);
			String linea;
			linea = mibuffer.readLine();
			while(linea != null) {
				
				
				int cont_guiones=0;
				String Nombre="";
				String Apellido="";
				String Dni="";
				for(int i=0; i<linea.length(); i++)
				{
					if(linea.charAt(i)=='-') cont_guiones++;
					else {
					switch(cont_guiones) {
					case 0:
						Nombre+=linea.charAt(i);
						break;
					case 1:
						Apellido+=linea.charAt(i);
						break;
					case 2:
						Dni+=linea.charAt(i);
						break;
					}
					
					}
				}
//				System.out.println(Nombre);
//				System.out.println(Apellido);
//				System.out.println(Dni);
				try {
					Persona aux = new Persona( Nombre, Apellido, Dni);
					aux.VerificarDNIinvalido();
					listaPersonas.add(aux);
					
				}
				catch(ClassCastException e) {

					e.printStackTrace();
					
				}
				catch(DniInvalido e) {
					e.printStackTrace();
				}
				
				linea = mibuffer.readLine();
			}
			mibuffer.close();
			entrada.close();
			
		}catch(IOException e) {
			System.out.println("No se encontro el archivo");
			e.printStackTrace();
		}
		return listaPersonas;
	}
}
