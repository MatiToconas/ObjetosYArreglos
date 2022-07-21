package objetosYArreglos.aerolineas;

public class Vuelo 
{
	
	private Avion avion;
	private Tripulante[] tripulacion;
	private int cantidad;
	
	Vuelo(int tamanio)
	{
		tripulacion=new Tripulante [tamanio];
		this.cantidad=0;
	}
	
	void tripulante(Tripulante tripulante)
	{
		this.tripulacion[this.cantidad]=tripulante;
		this.cantidad++;
	}
	
	void cargarAvion(Avion avion)
	{
		this.avion=avion;
	}
	
	Avion getAvion()
	{
		return this.avion;
	}
	
	Tripulante[] getTripulacion()
	{
		return this.tripulacion;
	}
	
	int cantidadAeromozo()
	{
		int cant=0;
		for(int i=0;i<this.tripulacion.length;i++)
		{
			if(this.tripulacion[i].getCargo().equals("aeromozo"))
			{
				cant++;
			}
		}
		
		return cant;
	}
	
	int cantidadInspectores()
	{
		int cant=0;
		for(int i=0;i<this.tripulacion.length;i++)
		{
			if(this.tripulacion[i].getCargo().equals("inspector"))
			{
				cant++;
			}
		}
		
		return cant;
	}
	
	
	int cantidadTripulantes()
	{
		return this.getTripulacion().length;
	}
	

}
