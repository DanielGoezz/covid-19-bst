public class Gobierno 
{
	listaPaciente PacienteList;
	
	
	public Gobierno()
	{
		PacienteList = new listaPaciente();
	}
	void agregarPaciente(Paciente paciente)
	{
		PacienteList.insertar(paciente);
	}
	
	int cantidadSintomas (Paciente paciente)
	{
		int i = 0;
		nodoSintoma tmp = paciente.SintomaList.head;
		while(tmp != null) 
		{
			i++;
			tmp = tmp.next;
		}
		return i;
	}
	
	String identificarIgual (listaPaciente pacienteList, int cantidadPacientes)
	{
		nodoPaciente tmp = pacienteList.head;
		int i = 0;
		int contador = 0;
		String [] arrNombres = arrNombres(pacienteList, cantidadPacientes);
		
		while(tmp != null) 
		{
			for(int j = 0 ; j<= cantidadPacientes-1;j++)
			{
				if (tmp.paciente.Nombre.equals(arrNombres[j]))
				{
					contador++;
				}
			}
					
			if (contador > 1)
			{
				
				String resp = arrNombres[i] + " está duplicado, por lo que no se pudo agregar nuevamente al sistema. ";
				return resp;
			}
			else 
				contador = 0;
			i++;
			tmp = tmp.next;
		}
		
		return "";
	}
	String [] arrNombres (listaPaciente pacienteList, int cantidadPacientes)
	{
		nodoPaciente tmp = pacienteList.head;
		String [] arrNombres = new String [cantidadPacientes];
		
		int i = 0;
		while(tmp != null) 
		{
			arrNombres[i] = tmp.paciente.Nombre;
			i++;
			tmp = tmp.next;
		}
		return arrNombres;
	}
	
	String buscarPaciente (listaPaciente pacienteList, int cantidadPacientes, int Id)
	{
		nodoPaciente tmp = pacienteList.head;
		int j = 0;
		String arrNombre [] = arrNombres(pacienteList, cantidadPacientes);
		
		while(tmp != null) 
		{
			
			if(tmp.paciente.Id == Id)
			{
				nodoSintoma tmpSn = tmp.paciente.SintomaList.head;
				String [] arrSintomas = new String [cantidadSintomas(tmp.paciente)];
				
				int i = 0;
				String resp = tmp.paciente.Nombre + " tiene " + cantidadSintomas(tmp.paciente) + " sintomas: ";
				
				while(tmpSn != null) 
				{
					arrSintomas[i] = tmpSn.sintoma.Descripcion;
					resp += "\n" + arrSintomas[i];
					
					tmpSn = tmpSn.next;
					i++;
				}
				return resp;
			}
			j++;
			tmp = tmp.next;
		}
		
		return "No se ha encontrado el paciente";
	}

}
