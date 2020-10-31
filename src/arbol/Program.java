package arbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program 
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		Arbol ar = new Arbol();
		BufferedReader bf = new BufferedReader(new FileReader("Data-covid-19-bst.txt"));
		int cantidadPacientes = Integer.parseInt(bf.readLine());
		int cantidadSintomas = 0;
		String [] arrDatosPacientes;
		String [] arrDatosSintomas;
		
		//1. Su sistema debe permitir registrar nuevos pacientes y sus síntomas desde un archivo.
		for(int i = 0 ; i < cantidadPacientes ; i++)
		{
			arrDatosPacientes = bf.readLine().split(",");
			Paciente paciente = new Paciente(arrDatosPacientes[0], Integer.parseInt(arrDatosPacientes[1]));
			
			cantidadSintomas = Integer.parseInt(arrDatosPacientes[2]);
			
			for(int j = 0 ; j < cantidadSintomas ; j++)
			{
				arrDatosSintomas = bf.readLine().split(",");
				Sintoma sintoma = new Sintoma(arrDatosSintomas[0]);
				paciente.agregarSintoma(sintoma);
			}
			ar.agregarPaciente(paciente);
			
		}
		
		//3. mostrar sintomas de paciente especifico
		System.out.println("\n============ 3er requerimiento ===========");
		Paciente PacienteEncontrado = ar.buscador(6);
		System.out.println("\nSe encontró el paciente " + PacienteEncontrado.Nombre + " sus sintomas son: ");
		PacienteEncontrado.imprimirSintoma(PacienteEncontrado.sintomaList);
		
		//4. Todos los pacientes deben pagar una amenaza según el número de síntomas
		System.out.println("\n============ 4to requerimiento ===========\n");
		ar.imprimirArbol(ar.root);
		
		//5. El sistema debe reportar la siguiente información:
		System.out.println("\n============ 5to requerimiento ===========\n");
		// a) ¿Cuántos pacientes tiene fiebre?
		ar.contarPacientesArbol(ar.root, 0);
		// c) Lo que pagan los pacientes en promedio (debe cubrir a todos los pacientes)
		ar.imprimirPromedio(ar.root, 1, 0);
		
		
		System.out.println("\n\n\nFin del programa");
	}
}
