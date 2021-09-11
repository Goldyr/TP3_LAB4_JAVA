package ejercicio1;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String DNI;
	
	public Persona() {}
	
	public Persona(String nom, String ape, String dni) {
		this.nombre=nom;
		this.apellido=ape;
		this.DNI=dni;
	}
	
	public boolean VerificarDNIinvalido() throws DniInvalido{
		int i;
		Boolean HayLetra=false;
		
		for(i=0; i<DNI.length(); i++) {
			if(Character.isLetter(DNI.charAt(i))==true) {
				HayLetra=true;
			}
		}
		
		if(HayLetra==true) {
			throw new DniInvalido();			
		}
		
		return HayLetra;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Apellido=" + apellido + ", DNI=" + DNI;
	}
	
	
	
}
