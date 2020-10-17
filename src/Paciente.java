
public class Paciente 
{
	String Nombre;
	int Id;
	int Pago;
	
	listaSintoma SintomaList;
	
	
	public Paciente(String Gnombre, int Gid) 
	{
		Nombre = Gnombre;
		Id = Gid;
		SintomaList = new listaSintoma();
	}
	
	void agregarSintoma(Sintoma sintoma)
	{
		SintomaList.insertar(sintoma);
	}
}
