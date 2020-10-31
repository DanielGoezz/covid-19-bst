package arbol;

public class Arbol
{
	Nodopaciente root;
	
	public void agregarPaciente( Paciente nuevoPaciente) 
	{
		if (root == null)
		{
			root = new Nodopaciente(nuevoPaciente);
			return;
		}
		
		if(encontrarRepetido(nuevoPaciente))
		{
			System.out.println("============ 2do requerimiento ===========\n\n " + "el usuario " + nuevoPaciente.Nombre + " esta duplicado, por lo que no se pudo agregar nuevamente al programa.");
		}
		else 
			agregarPaciente(root, nuevoPaciente);
	}
	
	private void agregarPaciente (Nodopaciente nodo, Paciente nuevoPaciente)
	{
		if (nodo == null)
		{
			return;
		}
		
		if (nuevoPaciente.id > nodo.paciente.id)
		{
			if (nodo.rigth == null)
			{
				nodo.rigth = new Nodopaciente(nuevoPaciente);
			}
			else 
			{
				agregarPaciente(nodo.rigth, nuevoPaciente);
			}
		}
		else 
		{
			if(nodo.left == null)
			{
				nodo.left = new Nodopaciente(nuevoPaciente);
			}
			else
			{
				agregarPaciente(root.left, nuevoPaciente);
			}
		}
	}
	
	public Paciente buscador(int id) 
    {
        return buscador(root, id);
    }

    private Paciente buscador(Nodopaciente node, int id) 
    {

        if(node == null) {
            return null;
        }

        if(node.paciente.id == id){
            return node.paciente;
        }

        if(node.paciente.id < id) {
            return buscador(node.rigth, id);
        }

        return buscador(node.left, id);
    }
	
    public boolean encontrarRepetido(Paciente paciente) //2. El sistema no debe permitir registrar al mismo paciente dos veces.
    {
    	Paciente encontrar = buscador(paciente.id);
    	
    	if (encontrar != null)
    	{
			return true;
		}
    	
    	return false;
	}
	
    public void imprimirArbol (Nodopaciente root) 
    {
    	
    	System.out.println(root.paciente.Nombre + " tiene " + contarSintomas(root.paciente.sintomaList) + " sintomas, " + root.paciente.Nombre + " debería pagar: " + ValorPagar(root.paciente.sintomaList));
    	
    	if (root.left != null) 
    	{
			imprimirArbol(root.left);
		}
    	if (root.rigth!= null) 
    	{
			imprimirArbol(root.rigth);
		}
	}
    
    private int contarSintomas (ListaSintoma lS)
    {
    	int contador = 0;
    	NodoSintoma tmp = lS.head;
		while(tmp != null)
		{
			contador++;
			tmp = tmp.next;
		}
		return contador;
    }
    
    private int ValorPagar (ListaSintoma lS)
    {
    	int contador = 0;
    	NodoSintoma tmp = lS.head;
		while(tmp != null)
		{
			contador++;
			tmp = tmp.next;
		}
		return contador * 100;
    }
    
    //===============================================================================================================
    

     
    //===============================================================================================================
    public void contarPacientesArbol (Nodopaciente root, int contador) 
    {
    	String sintoma = "Tos";
    	contador += contarSintomaEspecifico(root.paciente.sintomaList, sintoma);
    	
    	
    	if (root.left != null) 
    	{
    		contarPacientesArbol(root.left, contador);
		}
    	if (root.rigth!= null) 
    	{
    		contarPacientesArbol(root.rigth, contador);
		}
    	if (root.left == null && root.rigth == null) 
    	{
    		System.out.println("En total hay " + contador + " pacientes con " + sintoma);
    	}
    	
	}
    
    int contarSintomaEspecifico(ListaSintoma lS, String sintoma)
    {
    	int contador = 0;
    	NodoSintoma tmp = lS.head;
		while(tmp != null)
		{
			if(tmp.sintoma.Descripcion.equals(sintoma) )
				contador++;
			tmp = tmp.next;
		}
		return contador;
    }
    
    
    
    public void imprimirPromedio (Nodopaciente root, int contador,  int valorPagar) 
    {
    	valorPagar += ValorPagar(root.paciente.sintomaList);
    	
    	if (root.left != null) 
    	{
    		imprimirPromedio(root.left, contador + 1, valorPagar);
		}
    	if (root.rigth!= null) 
    	{
    		imprimirPromedio(root.rigth, contador + 1, valorPagar);
		}
    	if (root.left == null && root.rigth == null) 
    	{
			valorPagar= valorPagar / contador;
    		System.out.println("El promedio es: $" + valorPagar);
    		contador++;
    	}
	}
}
