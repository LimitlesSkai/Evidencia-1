package administracion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorDeCitas {
	
	public static Scanner Keyboard = new Scanner(System.in);
	public static Scanner Keyboard2 = new Scanner(System.in);
	
	public static boolean VerificarLogin(String usuario, String contraseña, String filepath, String delimiter) 
	{
		String lineaActual;
		String data[];
		
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			while((lineaActual = br.readLine()) != null)
			{
				data = lineaActual.split(delimiter);
				if(data[0].equals(usuario) && data[1].equals(contraseña)) 
				{
					return true;
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println("ERROR" + e.getMessage());
			System.exit(0);
		}
		
		return false;
	}
	
	public static int Menu(){
		int seleccion;
		System.out.println("Seleccione la operacion a realizar:");
		System.out.println("------------------------------------");
		System.out.println("1: Dar de alta un doctor.");
		System.out.println("2: Dar de alta un paciente.");
		System.out.println("3: Crear una nueva cita.");
		System.out.println("4: Cerrar aplicacion.");
		
		seleccion = Keyboard.nextInt();
		return seleccion;
		}
	

	public static void main(String[] args) 
	{
		String filepath = "logins.csv";
		ArrayList<Doctor> Doctores = new ArrayList<Doctor>();
		ArrayList<Persona> Pacientes = new ArrayList<Persona>();
		ArrayList<Cita> Citas = new ArrayList<Cita>();
		String nombre = "";
		int ID_D = 505269;
		int ID_P = 109865;
		int ID_C = 654123589;
		boolean LoginExitoso = false;
		
		while(LoginExitoso == false)
		{
			System.out.println("Ingrese su nombre de usuario");
			String usuario = Keyboard.nextLine(); 
			System.out.println("Ingrese su contraseña:");
			String contraseña = Keyboard.nextLine();
			LoginExitoso = VerificarLogin(usuario, contraseña, filepath, ",");
			if(LoginExitoso = false) 
			{
				System.out.println("Su usuario o contraseña son incorrectos. Intente denuevo.");
			}
		}
		if(LoginExitoso == true)
		{
			int Eleccion_Usuario;
			do {
				Eleccion_Usuario = Menu();
				switch(Eleccion_Usuario) 
				{
				case 1:
					System.out.println("Ingrese el nombre completo del doctor:");
					nombre = Keyboard2.nextLine(); 
					System.out.println("Ingrese su especialidad:");
					String especialidad = Keyboard2.nextLine();
					Doctor Doc = new Doctor (nombre, ID_D, especialidad);
					Doctores.add(Doc);
					try 
					{
						FileWriter fw = new FileWriter("Doctores.csv",true);
						String ID = Integer.toString(ID_D);
						StringBuilder sb = new StringBuilder(ID);
						sb.append(","+nombre+","+especialidad);
						String result = sb.toString();
						fw.write(result  + "\n");
						fw.close();
					}
					catch(Exception e) 
					{
						System.out.println("ERROR");
						System.exit(0);
					}
					ID_D = ID_D +1;
					break;
				case 2: 
					//dar de alta un paciente
					System.out.println("Ingrese el nombre completo del paciente:");
					nombre = Keyboard2.nextLine(); 
					Persona Paciente = new Persona (nombre, ID_P);
					Pacientes.add(Paciente);
					try 
					{
						FileWriter fw = new FileWriter("Pacientes.csv",true);
						String ID = Integer.toString(ID_P);
						StringBuilder sb = new StringBuilder(ID);
						sb.append(","+nombre);
						String result = sb.toString();
						fw.write(result + "\n");
						fw.close();
					}
					catch(Exception e) 
					{
						System.out.println("ERROR");
						System.exit(0);
					}
					ID_P = ID_P +1;
					break;
				case 3:
					//crear una nueva cita
					System.out.println("Ingrese la fecha de la cita:");
					String fecha = Keyboard2.nextLine();
					System.out.println("Ingrese la hora de la cita:");
					float hora = Keyboard2.nextFloat();
					System.out.println("Ingrese el motivo de la cita:");
					String motivo = Keyboard.nextLine();
					Cita cita = new Cita (ID_C, fecha, hora, motivo);
					Citas.add(cita);
					try 
					{
						FileWriter fw = new FileWriter("Citas.csv",true);
						String ID = Integer.toString(ID_C);
						StringBuilder sb = new StringBuilder(ID);
						sb.append(","+fecha+","+hora+","+motivo);
						String result = sb.toString();
						fw.write(result + "\n");
						fw.close();
					}
					catch(Exception e) 
					{
						System.out.println("ERROR");
						System.exit(0);
					}
					ID_C = ID_C + 1;
					break;
				case 4:
					System.out.println("Muchas gracias y que pase un lindo dia.");
					break;
				default:
					System.out.println("Por favor seleccione una opcion con los numeros 1, 2, 3 o 4.");
					break;
				}
			}
			while(Eleccion_Usuario!=4);
		}	
	}	
}

