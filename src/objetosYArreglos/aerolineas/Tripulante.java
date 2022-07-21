package objetosYArreglos.aerolineas;

public class Tripulante 
{
	
	private String nombre;
	private String cargo;  
	private int antiguedad;

	Tripulante(String nombre,String cargo,int antiguedad)
	{
		this.nombre=nombre;
		this.cargo=cargo;
		this.antiguedad=antiguedad;
	}
	
	 
	String getNombre()
	{
		return this.nombre;
	}
	 
	String getCargo()
	{
		return this.cargo;
	}
	
	int getAntiguedad()
	{
		return this.antiguedad;
	}
	
	void imprimir()
	{
		System.out.println("Nombre:"+this.nombre);
		System.out.println("Cargo:"+this.cargo);
		System.out.println("Antiguedad"+this.antiguedad);
	}
	
	 
	
}
