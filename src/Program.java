import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Program 
{

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException 
	{
		Gobierno Gob = new Gobierno();
		
		BufferedReader bf = new BufferedReader(new FileReader("Data-covid-19-bst.txt"));
		
		int cantidadPacientes = Integer.parseInt(bf.readLine());
		
		String [] arrDatosPacientes;
		String [] arrDatosSintomas;
		
		for (int i = 0 ; i < cantidadPacientes ; i++)
		{
			arrDatosPacientes = bf.readLine().split(",");
			
			Paciente paciente = new Paciente(arrDatosPacientes[0], Integer.parseInt(arrDatosPacientes[1]));
		
			int cantSintomas = Integer.parseInt(arrDatosPacientes[2]);
			
			for(int j = 0 ; j < cantSintomas ; j++)
			{
				arrDatosSintomas = bf.readLine().split(",");
				
				Sintoma sintoma = new Sintoma(arrDatosSintomas[0]);
				
				paciente.agregarSintoma(sintoma);
			}
			
			Gob.agregarPaciente(paciente);
		}
		
		System.out.println(Gob.identificarIgual(Gob.PacienteList, cantidadPacientes) + "\n");
		

		System.out.println(Gob.buscarPaciente(Gob.PacienteList, cantidadPacientes, 02 ));
		System.out.println("\nFuncionó");
	}
}
