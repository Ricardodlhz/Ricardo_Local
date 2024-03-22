package matricula_Examen;

import java.util.ArrayList;
import java.util.Scanner;



import java.io.*;

public class Alumno extends Persona{
	private ArrayList<Nota> notas;

	public Alumno(int codigo, String DNI, String nombre, String apellidos, ArrayList<Nota> notas) {
		super(codigo, DNI, nombre, apellidos);
		this.notas = notas;
	}
	
	public Alumno(int codigo, String DNI, String nombre, String apellidos) {
		super(codigo, DNI, nombre, apellidos);
		this.notas = new ArrayList<Nota>();
	}
	public Alumno() {
		super();
		this.notas = new ArrayList<Nota>();
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	
	public  void cargarNotas()  {
		try {
			Scanner entrada = new Scanner(new File("matricula.csv"));
			//ArrayList<ActividadReservada> reservas = new ArrayList<Nota>();
			String linea[];
			String cadena;
			entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();
				linea = cadena.split(";");
				if(Integer.parseInt(linea[2])==this.getCodigo()) {
					this.notas.add(new Nota(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), Integer.parseInt(linea[3])));
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("No existe el fichero");
		}

		
	}
	
	public static void main(String[] args)  {
		Alumno a=new Alumno(505, "3535","Marta","Sanchez");
		a.cargarNotas();
		double suma=0;
		
		for(Nota n:a.getNotas()) {
			System.out.println(n);
			suma+=n.getNota();
		}
		System.out.println("La nota media es: "+(suma/a.notas.size()));
		
	}
	
}
