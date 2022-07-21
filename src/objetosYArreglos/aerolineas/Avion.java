package objetosYArreglos.aerolineas;

public class Avion 
{
	private String tipo;
	private int capacidad;
	
	
	Avion()
	{
		this.tipo="";
		this.capacidad=0;
	}
	
	Avion(String tipo,int capacidad)
	{
		this.tipo=tipo;
		this.capacidad=capacidad;
	}
	
	String getTipo()
	{
		return this.tipo;
	}
	
	int getCapacidad()
	{
		return this.capacidad;
	}

}
