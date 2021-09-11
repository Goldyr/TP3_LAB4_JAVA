package ejercicio1;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Persona per = new Persona("Matias", "Flori",JOptionPane.showInputDialog("Ingrese DNI: "));
			per.VerificarDNIinvalido();

		} catch (DniInvalido e) {
			e.printStackTrace();
		}
		
	}

}
