package matricula_Examen;

public class Persona {
	protected int codigo;
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	
	public Persona(int codigo, String DNI, String nombre, String apellidos) {
		this.codigo = codigo;
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Persona() {
		this.codigo = 0;
		this.DNI = "";
		this.nombre = "";
		this.apellidos = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	

}
