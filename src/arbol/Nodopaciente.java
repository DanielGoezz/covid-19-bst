package arbol;

public class Nodopaciente 
{
	public Nodopaciente(Paciente paciente) 
	{
		this.paciente = paciente;
	}

	Paciente paciente;
	Nodopaciente left;
	Nodopaciente rigth;
}
