package matricula_Examen;

public class Profesor extends Persona{
	private String titulacion;

	public Profesor(int codigo, String DNI, String nombre, String apellidos, String titulacion) {
		super(codigo, DNI, nombre, apellidos);
		this.titulacion = titulacion;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	
}
