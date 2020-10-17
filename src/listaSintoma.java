public class listaSintoma 
{
	nodoSintoma head;
	
	void insertar(Sintoma Sn)
	{
		nodoSintoma nuevoNodo = new nodoSintoma();
		nuevoNodo.sintoma = Sn;
		
		
		if(head == null) //La lista está vacía
		{
			head = nuevoNodo;
		}
		
		else//La lista no está vacía 
		{ 
			nodoSintoma ultimo = head;
			
			while(ultimo.next != null) 
			{
				ultimo = ultimo.next;			
			}
			ultimo.next = nuevoNodo;
		}
	}
}
