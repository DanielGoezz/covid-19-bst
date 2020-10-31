package arbol;

public class ListaSintoma 
{
	NodoSintoma head;
	
	void insertar(Sintoma s)
	{
		NodoSintoma nuevoNodo = new NodoSintoma();
		nuevoNodo.sintoma = s;
		
		
		if(head == null) //Si la lista est� vac�a
		{
			head = nuevoNodo;
		}
		else//Si la lista no est� vac�a 
		{ 
			NodoSintoma ultimo = head;
			
			while(ultimo.next != null) 
			{
				ultimo = ultimo.next;			
			}
			
			ultimo.next = nuevoNodo;
		}
	}
	
}
