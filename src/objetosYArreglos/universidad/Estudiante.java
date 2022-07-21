package objetosYArreglos.universidad;

public class Estudiante 
{
	private String nombre;
	private int legajo;
	
	
	Estudiante(String nombre,int legajo)
	{
		this.nombre=nombre;
		this.legajo=legajo;
	}
	
	
	void imprimir()
	{
		System.out.println("---------------------");
		System.out.println("Nombre:"+this.nombre);
		System.out.println("Nro. Legajo:"+this.legajo);
	}
	
	
	boolean mismaPersona(Estudiante e)
	{
		if(this.legajo==e.legajo)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
