package ejercicio1;

import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Persona per = new Persona("Matias", "Flori",JOptionPane.showInputDialog("Ingrese DNI: "));
			per.VerificarDNIinvalido();

		} catch (DniInvalido e) {
			e.printStackTrace();
		}
		
		Archivo a = new Archivo();
		a.setRuta("src\\ejercicio1\\Personas.txt");
		if(!a.existe()) {
			System.out.println("No existe");
		}
		
		Archivo b = new Archivo();
		b.setRuta("src\\ejercicio1\\resultado.txt");
		if(!b.existe()) {
			System.out.println("No existe, por lo tanto lo creamos");
			if(b.CrearArchivo()) {
				System.out.println("se creo correctamente");
			}else	System.out.println("no pudo crearse");
		}
		
		TreeSet<Persona> listapersonas = (a.cargar_TreeSet());
		
		for(Persona x : listapersonas) {
			System.out.println(x.toString());	
		}
		
		b.escribirlineas(listapersonas);
	}
}
