package objetosYArreglos.universidad;

import java.util.LinkedList;

public class ClasePrincipal 
{

	public static void main(String[] args) 
	{
		//Docente(String nombre,int dni)
		Docente carlos=new Docente("Carlos",12343857);
		Docente gerardo=new Docente("Gerardo",23245356);
		
		//Estudiante(String nombre,int legajo)
		Estudiante ariel=new Estudiante("Ariel",1);
		Estudiante marcos=new Estudiante("Marcos",2);
		Estudiante leonarda=new Estudiante("Leonarda",4);
		Estudiante walter=new Estudiante("Walter",5);
		
		//Comision(int cantInscriptos,int cantDocentes,String materia,int numero)
		Comision c1=new Comision(4,2,"Matematica",1);
		c1.cargarDocentes(carlos);
		c1.cargarDocentes(gerardo);
		c1.cargarEstudiante(ariel, 5);
		c1.cargarEstudiante(marcos, 2);
		c1.cargarEstudiante(leonarda,3);
		c1.cargarEstudiante(walter, 4);
		
		
		
		//Docente(String nombre,int dni)
		Docente patricia=new Docente("Patricia",34234534);
		
		//Estudiante(String nombre,int legajo)
		Estudiante mercedez=new Estudiante("mercedez",6);
		Estudiante pamela=new Estudiante("Pamela",7);
		Estudiante charly=new Estudiante("Charly",8);
		//Estudiante walter=new Estudiante("Walter",5);
		Comision c2=new Comision(4,2,"SO",1);
		
		c2.cargarDocentes(patricia);
		c2.cargarDocentes(gerardo);
		c2.cargarEstudiante(mercedez, 3);
		c2.cargarEstudiante(pamela, 3);
		c2.cargarEstudiante(charly, 5);
		c2.cargarEstudiante(walter, 9);
		
		
		
		UNGS u=new UNGS(2);
		
		u.cargarComision(c1);
		u.cargarComision(c2);
		 
		 LinkedList<Estudiante> alumnos=u.alumnosDe(carlos);
		 
		 for(int i=0;i<alumnos.size();i++)
		 {
			 alumnos.get(i).imprimir();
		 }
			 
		
	}
}
