package objetosYArreglos.universidad;
 

public class Comision
{
	private String materia;
	private int numero;
	private Docente[] docentes;
	private Estudiante[] inscriptos;
	private int[] calificaciones;
	private int cantidadDocente;
	private int cantidadInscriptos;
	
	
	Comision(int cantInscriptos,int cantDocentes,String materia,int numero)
	{
		this.inscriptos=new Estudiante[cantInscriptos];
		this.calificaciones=new int[cantInscriptos];
		this.docentes=new Docente[cantDocentes];
		this.materia=materia;
		this.numero=numero;
		this.cantidadDocente=0;
		this.cantidadInscriptos=0;
	} 
	                                                                              	 
	void cargarDocentes(Docente docente)
	{
		docentes[cantidadDocente]=docente;
		this.cantidadDocente++;
		
	}
  
	void cargarEstudiante(Estudiante e, int nota )
	{
		inscriptos[this.cantidadInscriptos]=e;
		this.calificaciones[this.cantidadInscriptos]=nota;
		this.cantidadInscriptos++;

	}
	
	int mejorNota()
	{
		int mNota=0;
		
		for(int i=0;i<this.calificaciones.length;i++)
		{
			if(mNota<this.calificaciones[i])
			{
				mNota=this.calificaciones[i];
			}
		}
		
		return mNota;
	}
	  
	void imprimirDocentes()
	{
		for(int i=0;i<this.docentes.length;i++)
		{
			this.docentes[i].imprimir();
		}
	}
	
	void imprimirEstudiantes()
	{
		for(int i=0;i<this.inscriptos.length;i++)
		{
			this.inscriptos[i].imprimir();
			System.out.println("Nota:"+this.calificaciones[i]);
			System.out.println("Comision:"+this.numero);
		}
	}
	
	
	Docente[] getDocente()
	{
		return this.docentes;
	}
	
	
	Estudiante[] getInscriptos()
	{
		return this.inscriptos;
	}
	
	int[] getCalificaciones()
	{
		return this.calificaciones;
	}
	
	int getNumero()
	{
		return this.numero;
	}
	
	String getMateria()
	{
		return this.materia;
	}
	
	 boolean suficientesDocentes() 
	 {
		 int alumnos=this.cantidadInscriptos/20;
		 
		 if(this.cantidadDocente>=alumnos)
		 {
			 return true;
		 }
		 
		 return false;
		 
	 }
 
}
