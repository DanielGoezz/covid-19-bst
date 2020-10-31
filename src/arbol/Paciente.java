package arbol;

public class Paciente 
{
	String Nombre;
	int id;

	ListaSintoma sintomaList;
	
	public Paciente(String nombreVlr, int idVlr) 
	{
		Nombre = nombreVlr;
		id = idVlr;
		sintomaList = new ListaSintoma();
	}
	
	void agregarSintoma(Sintoma sintoma)
	{
		sintomaList.insertar(sintoma);
	}
	
	void imprimirSintoma (ListaSintoma sintomalist)
	{
		NodoSintoma tmp = sintomalist.head;
		while(tmp != null)
		{
			System.out.println(tmp.sintoma.Descripcion);
			tmp = tmp.next;
		}
	}
}
