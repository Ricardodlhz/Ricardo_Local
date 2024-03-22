package matricula_Examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
public class BoletinNotasDAMW {
	private ArrayList<Alumno>dam;
	
	public BoletinNotasDAMW() {
		dam=new ArrayList<>();
	}
	
	public void cargaInicial() throws IOException {
		try {
			Scanner entrada = new Scanner(new File("Alumnos_Notas.csv"));
			//ArrayList<ActividadReservada> reservas = new ArrayList<Nota>();
			String linea[];
			String cadena;
			entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();
				linea = cadena.split(";");
					this.dam.add(new Alumno(Integer.parseInt(linea[0]), linea[1], linea[2], linea[3]));
			}
		}catch(FileNotFoundException e) {
			System.out.println("No existe el fichero");
		}

		
	}

	public ArrayList<Alumno> getDam() {
		return dam;
	}

	public void setDam(ArrayList<Alumno> dam) {
		this.dam = dam;
	}

	public void generarBoletines(){
		
		
	}
	public void menu() {
		System.out.println("1. Leer notas");
		System.out.println("2. Imprimir boletines");
		System.out.println("3. Salir");
		System.out.println("Elige una opción:");
	}
	
	public void leernotas() {
		for(Alumno a: this.getDam()) {
			a.cargarNotas();
		}
	}
	public void imprimirboletin() {
		/*Vamos a crear el fichero en otro directorio*/
		File dir=new File("boletines");
		dir.mkdir();
		dir.getName();
		//Para cada alumno creamos un archivo
		for(Alumno a: this.getDam()) {
			try {
				PrintWriter salida=new PrintWriter(new File(dir.getName()+"/Boletín"+a.getNombre()+a.getApellidos()+".txt"));
				salida.println("***************IES RIBERAL DEL TAJO***************");
				salida.println(a.getNombre()+" "+a.getApellidos());
				double suma=0;
				for(Nota n:a.getNotas()) {
					salida.println("\t"+n);
					suma+=n.getNota();
				}
				//para escribir en el fichero
				salida.println("La nota media es: "+(suma/a.getNotas().size()));
				salida.flush();
				salida.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BoletinNotasDAMW daw=new BoletinNotasDAMW();
		daw.cargaInicial();
		
		int opcion=0;
		do {
			daw.menu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				daw.leernotas();
				break;
			case 2:
				daw.imprimirboletin();
				break;
			case 3:
				System.out.println("Saliste");
				break;
			}
		}while(opcion!=3);
	}

}
