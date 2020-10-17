

public class listaPaciente
{
	nodoPaciente head;
	
	void insertar(Paciente Pa)
	{
		nodoPaciente nuevoNodo = new nodoPaciente();
		nuevoNodo.paciente = Pa;
		
		
		if(head == null) //La lista est� vac�a
		{
			head = nuevoNodo;
		}
		
		else//La lista no est� vac�a 
		{ 
			nodoPaciente ultimo = head;
			
			while(ultimo.next != null) 
			{
				ultimo = ultimo.next;			
			}
			ultimo.next = nuevoNodo;
		}
	}
}
