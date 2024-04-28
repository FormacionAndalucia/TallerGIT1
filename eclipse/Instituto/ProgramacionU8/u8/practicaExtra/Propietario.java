package practicaExtra;

public class Propietario {
	private String dni;
	private String nombre;
	private String apodo;
	
	Propietario(String dni, String nombre){
		this.nombre = nombre;
		this.dni = dni;
	}
	Propietario(String dni, String nombre, String apodo){
		this.nombre = nombre;
		this.dni = dni;
		this.apodo=apodo;
	}
	
	Propietario(){}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	String getApodo() {
		return apodo;
	}
	void setApodo(String apodo) {
		this.apodo = apodo;
	}
	@Override
	public String toString() {
		return "Propietario [dni=" + dni + ", nombre=" + nombre + "]";
	};
	
}
