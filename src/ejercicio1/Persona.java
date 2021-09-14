package ejercicio1;

public class Persona implements Comparable<Persona>{
	
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
		
		if(HayLetra==true || DNI.length()==0) {
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
	
	@Override
	public int compareTo(Persona o) {
		int devolver;
		devolver= o.getApellido().compareTo(this.apellido);
		if(devolver >0 ){return -1;}
		else {if(devolver < 0) {return 1;}else{return 0;}}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
