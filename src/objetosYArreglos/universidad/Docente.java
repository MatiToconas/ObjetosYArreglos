package objetosYArreglos.universidad;

public class Docente 
{
	private String nombre;
	private int dni;
	
	Docente(String nombre,int dni)
	{
		this.nombre=nombre;
		this.dni=dni;
	}
	
	boolean mismaPersona(Docente d)
	{
		if(this.dni==d.dni)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	void imprimir()
	{
		System.out.println("---------------------");
		System.out.println("Nombre:"+this.nombre);
		System.out.println("Nro. DNI:"+this.dni);
	}

}
