package objetosYArreglos.universidad;

import java.util.LinkedList;

public class UNGS 
{
	private Comision[] comisiones;
	private int cantidadComisiones;
	
	UNGS(int cantComisiones)
	{
		comisiones=new Comision[cantComisiones];
		this.cantidadComisiones=0;
	}
	
	
	void cargarComision(Comision comision)
	{
				  
		 comisiones[this.cantidadComisiones]=comision;
		 this.cantidadComisiones++;
		  
	}
	
	 boolean cursaCon(Estudiante e, Docente d)
	 {   
         boolean estaAlumno=false;
          
         for(int i=0;i<this.comisiones.length;i++)
         {
        	 //Si esta el profesor en una comision determinada, entonces
        	 //se busca al estudiante en tal comision. 
        	 if(this.estaProfesorEnComision(d,i))
        	 {
        		 for(int j=0;j<this.comisiones[i].getInscriptos().length;j++)
        		 {
        			 
        			 if(this.comisiones[i].getInscriptos()[j].mismaPersona(e))
        			 {
        				 estaAlumno=true;
        			 }
        		 }
        	 }
         }
         
         
         if(estaAlumno)
         {
        	 return true;
         }
        
         return false;
     
	 }
	 
	 boolean estaProfesorEnComision(Docente docente, int comisionProfesor)
	 {
		 
		 boolean existe=false;
		 
		 for(int i=0;i<this.comisiones[comisionProfesor].getDocente().length && !existe;i++)
		 {
			 
			 if(this.comisiones[comisionProfesor].getDocente()[i].mismaPersona(docente))
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
	 
	  
	 boolean suficientesDocentes()
	 {
		 boolean suficiente=true;
		 
		 for(int i=0;i<this.comisiones.length && suficiente!=false;i++)
		 {
			 if(!this.comisiones[i].suficientesDocentes())
			 {
				 suficiente=false;
			 }
		 }
		 
		 if(!suficiente)
		 {
			 return false;
		 } 
		 
		 return suficiente;
	 }
	  
	 
	 
	 LinkedList<Estudiante> losMejores()
	 {
		 LinkedList<Estudiante> mejores = new LinkedList<Estudiante>();
		 
		 for(int i=0;i<this.comisiones.length;i++)
		 {
			 //Primero se determina  cual es la nota más alta de una comisión.
			 int mejor=comisiones[i].mejorNota();
			 //Después se carga todos los alumnos que su nota coincida con la nota mayor obtenida
			 //de cada comsión.
			 for(int j=0;j<this.comisiones[i].getInscriptos().length;j++)
			 {
				 //Acá puede que en diferentes comisiones una misma persona sea el "mejor"
				 //por lo tanto, se carga de forma repetida intencionalemente en mejores.
				 if(mejor==comisiones[i].getCalificaciones()[j])
				 {
					 mejores.add(comisiones[i].getInscriptos()[j]);
				 }
			 }
			 
		 }
		 
		 return mejores;
	 }
	 
	 LinkedList<Estudiante> alumnosDe(Docente docente)
	 {
		 LinkedList<Estudiante> alumnos = new LinkedList<Estudiante>();
		  
		 for(int i=0;i<this.comisiones.length;i++)
		 {
			 for(int j=0;j<this.comisiones[i].getInscriptos().length;j++)
			 {
				 if(this.cursaCon(this.comisiones[i].getInscriptos()[j], docente)
				 && !pertenece(this.comisiones[i].getInscriptos()[j],alumnos))
				 {
					 alumnos.add(this.comisiones[i].getInscriptos()[j]); 
					  
				 }
			 }
		 }
		 
		 return alumnos;
		    
	 }
	 
	 //Si no se quiere programar esta función, en la clase LinkedList existe la funcion
	 //contains() que determina si existe o no elemento que se le pasa por parámetro.
	 boolean pertenece(Estudiante estudiante,LinkedList<Estudiante> estudiantes)
	 {
		 boolean encontrado=false;
		 
		 for(int i=0;i<estudiantes.size() && !encontrado;i++)
		 {
			 if(estudiantes.get(i).mismaPersona(estudiante))
			 {
				 encontrado=true;
			 }
		 }
		 
		 if(encontrado)
		 {
			 return encontrado;
		 }
		 
		 return false;
	 }
	 
	 //Si una materia no se encuentra en mas de una comision, ==> se carga.
	 LinkedList<String> unicaComision()
	 {
		 LinkedList<String> materiasConUnicaComision=new LinkedList<String>();
		 
		 for(int i=0;i<this.comisiones.length;i++)
		 {
			 if(!materiaSinRepetidosEnComisiones(this.comisiones[i].getMateria()))
			 {
				 materiasConUnicaComision.add(this.comisiones[i].getMateria());
			 }
		 }
		 
		 
		 return materiasConUnicaComision;
	 }
	 
	 boolean materiaSinRepetidosEnComisiones(String materia)
	 {
		 boolean repetido=false;
		 
		 for(int i=0;i<this.comisiones.length && !repetido;i++)
		 {
			  for(int j=0;j<this.comisiones.length && !repetido;j++)
			  {
				  if(this.comisiones[i].getMateria().equals(materia) && i!=j)
				  {
					  repetido=true;
				  }
			  }
		 }
		 
		 if(repetido)
		 {
			 return true;
		 }
		 
		 return false;
		 
	 }
	 
	 Estudiante elMasEstudioso() 
	 {
		 LinkedList<Estudiante> mejoresEstudiantes=new LinkedList<Estudiante>();
		 LinkedList<Integer> mejoresCalificaciones=new LinkedList<Integer>();  
		 
		 for(int i=0;i<comisiones.length;i++)
		 {
			  
			for(int j=0;j<this.comisiones[i].getInscriptos().length;j++)
			{
				//Se carga a los alumnos y sus respectivas notas.
				if(this.comisiones[i].getCalificaciones()[j]>=4)
				{
					mejoresEstudiantes.add(this.comisiones[i].getInscriptos()[j]);
					mejoresCalificaciones.add(this.comisiones[i].getCalificaciones()[j]);
				}
			}
			 
		 }
		
		return  mayorNota( mejoresEstudiantes, mejoresCalificaciones);
		
		 
	 }
	 
	 
	 Estudiante mayorNota(LinkedList<Estudiante> estudiantes,LinkedList<Integer> calificaciones)
	 {
		 int calificacionesMejor=calificaciones.get(0);
		 Estudiante estudianteConMejorNota=estudiantes.get(0);
		 
		for(int i=0;i<this.comisiones.length;i++)
		{
			 if(calificacionesMejor>calificaciones.get(i))
			 {
				 estudianteConMejorNota=estudiantes.get(i);
				 calificacionesMejor=calificaciones.get(i);
				 
			 }
		}
		 
		return estudianteConMejorNota; 
	 }
	 
	 
}
