package objetosYArreglos.aerolineas;

import java.util.LinkedList;

public class Aerolinea 
{
	private Vuelo[] vuelos;
	private int cantidadVuelos;
	 
	Aerolinea(int cantidadVuelos)
	{
		this.vuelos=new Vuelo[cantidadVuelos];
		this.cantidadVuelos=0;
	}
	
	void cargarVuelo(Vuelo vuelo)
	{
		vuelos[this.cantidadVuelos]=vuelo;
		this.cantidadVuelos++;
	}
	
	int vuelosEn(Tripulante tripulante, String tipoAvion)
	{
		boolean estaAvion=false;
		boolean estaTripulante=false;
		int cantVuelos=0;
		
		for(int i=0;i<this.vuelos.length;i++)
		{
			estaAvion=false;
			estaTripulante=false;
			
			if(this.vuelos[i].getAvion().getTipo().equals(tipoAvion))
			{
				estaAvion=true;
			}
			
			if(estaAvion)
			{
				for(int j=0;j<this.vuelos[i].getTripulacion().length && !estaTripulante;j++)
				{
					if(this.vuelos[i].getTripulacion()[j].equals(tripulante))
					{
						estaTripulante=true;
					}
				}
			}
			
			if(estaAvion && estaTripulante)
			{
				cantVuelos++;
			}
			
		}
		
		return cantVuelos;
	}
	
	
	int antiguedadPromedio(String tipoAvion)
	{ 
		  int promedioAntiguedad=0;
		  int cantidadAntiguedad=0;
		
			for(int i=0;i<this.vuelos.length;i++)
			{
				 
				if(tipoAvion.equals(vuelos[i].getAvion().getTipo()))
				{
					for(int j=0;j<vuelos[i].getTripulacion().length;j++)
					{
						promedioAntiguedad+=vuelos[i].getTripulacion()[j].getAntiguedad();
						cantidadAntiguedad++;
					}
				}
			}
			
			return promedioAntiguedad/cantidadAntiguedad;
	}
	
	LinkedList<Vuelo> vuelosSobrecargados() 
	{
		LinkedList<Vuelo> vuelosConSobrecarga=new LinkedList<Vuelo>();
		
		float porcentaje=0;
		
	     for(int i=0;i<this.vuelos.length;i++)
		 {
	    	 porcentaje=this.vuelos[i].cantidadAeromozo()*100/this.vuelos[i].getAvion().getCapacidad();
	    	     	 
	    	 if(porcentaje-100>10)
	    	 {
	    		 vuelosConSobrecarga.add(this.vuelos[i]);
	    	 }
	    	 
		 }
		
		return vuelosConSobrecarga;
	}
	  
	
	String masInspeccionado()
	{
		int vueloConMayoresInpectores=0;
		
		String tipoAvion="";
		
		for(int i=0;i<this.vuelos.length;i++)
		{
			
			 if(vueloConMayoresInpectores<this.vuelos[i].cantidadInspectores())
			 {
				 vueloConMayoresInpectores=this.vuelos[i].cantidadInspectores();
				 tipoAvion=vuelos[i].getAvion().getTipo();
			 }
			
		}
		
		return tipoAvion;
		
	}
	
	LinkedList<String> avionesPiloteadosPor(String nombre)
	{
		
		LinkedList<String> aviones=new LinkedList<String>();
		
		int vueloTripulante=0;
		
		for(int i=0;i<this.vuelos.length;i++)
		{
			vueloTripulante=existeTripulante(nombre,i);
			
			if(vueloTripulante!=-1)
			{ 
				 
				if(!perteneceAvion(aviones,this.vuelos[i].getAvion().getTipo()) 
				&& this.vuelos[i].getTripulacion()[vueloTripulante].getCargo().equals("piloto"))
				{
							aviones.add(this.vuelos[i].getAvion().getTipo());
				} 
					
			}
			 
		}
		
		
		return aviones;
	}
	
	int existeTripulante(String nombreTripulante,int vuelo)
	{
		boolean existe=false;
		int vueloTripulante=0;
	
		for(int i=0;i<this.vuelos[vuelo].getTripulacion().length && !existe;i++)
		{
			if(this.vuelos[vuelo].getTripulacion()[i].getNombre().equals(nombreTripulante))
			{
				existe=true;
				vueloTripulante=i;
			}
		}
		
		if(existe)
		{
			return vueloTripulante;
		}
		
		return -1;
		
	}
	
	boolean perteneceAvion(LinkedList<String> aviones,String avion)
	{
		boolean existe=false;
		
		for(int i=0;i<aviones.size() && !existe;i++)
		{
			if(aviones.get(i).equals(avion))
			{
				existe=true;
			}
		}
		
		if(existe)
		{
			return true;
		}
		
		return false;
	}
	
	Tripulante empleadoDelMes()
	{
		
		LinkedList<Tripulante> tripulantes=this.tripulantes();
		LinkedList<Integer> cantidadViajes=new LinkedList<Integer>();
		
		for(int i=0;i<tripulantes.size();i++)
		{
			cantidadViajes.add(this.cantidadViajes(tripulantes, tripulantes.get(i)));
			
		}
		 
		return  this.tripulanteConMayorViajes(tripulantes,cantidadViajes);
		
	}
	
	LinkedList<Tripulante> tripulantes()
	{
		LinkedList<Tripulante> tripulantes=new LinkedList<Tripulante>();
		
		for(int i=0;i<this.vuelos.length;i++)
		{
			for(int j=0;j<this.vuelos[i].getTripulacion().length;j++)
			{
				if(!tripulantes.contains(this.vuelos[i].getTripulacion()[j]))
				{
					tripulantes.add(this.vuelos[i].getTripulacion()[j]);
				}
			}
		}
		
		return tripulantes;
		
	}
	
	int cantidadViajes(LinkedList<Tripulante> tripulantes,Tripulante t)
	{
		int cant=0;
		boolean existe=false;
	
		for(int i=0;i<this.vuelos.length;i++)
		{
			existe=false;
			for(int j=0;j<this.vuelos[i].getTripulacion().length && !existe;j++)
			{
				if(this.vuelos[i].getTripulacion()[j].equals(t))
				{
					existe=true;
					cant++;
				}
			}
		}
		
		return cant;
		
	}
	
	Tripulante tripulanteConMayorViajes(LinkedList<Tripulante> tripulantes,LinkedList<Integer> cantViajes)
	{
		
		int mayor=0;
		Tripulante tripulante = null;
		
		for(int i=0;i<tripulantes.size();i++)
		{
			if(mayor<cantViajes.get(i))
			{
				mayor=cantViajes.get(i);
				tripulante=tripulantes.get(i);
			}
		}
		
		return tripulante;
		 
	}
	  
}
