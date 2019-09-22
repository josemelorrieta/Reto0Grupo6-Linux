package reto0Grupo6;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import reto0Grupo6.FuncionesMain;
import reto0Grupo6.Libro;

public class TestFuncionesMain {

	private String autor = "autor1";
	private String titulo = "titulo1";
	private String editorial = "editorial1";
	private int paginas = 100;
	private float altura = (float) 25.3;
	private String notas = "anotaciones1";
	private String isbn = "978-84-945696-8-5";
	private String materias = "Cuentos";
	
	private Libro libro = new Libro(autor, titulo, editorial, paginas,altura,notas, isbn, materias);
	
	private String autor2 = "autor2";
	private String titulo2 = "titulo2";
	private String editorial2 = "editorial2";
	private int paginas2 = 500;
	private float altura2 = (float) 20.5;
	private String notas2 = "anotaciones2";
	private String isbn2 = "978-84-945696-8-4";
	private String materias2 = "Cuentos2";
	
	private Libro libro2 = new Libro(autor2, titulo2, editorial2, paginas2,altura2,notas2, isbn2, materias2);
	
	
	private FuncionesMain funciones = new FuncionesMain();
	
	private Libro[] libros = new Libro[2];

	/* @Test
	public void testMostrarDatos() {
		libros[0] = libro;
		libros[1] = libro2;
		String resultado = funciones.MostrarDatos(libros);
		String expected ="RESULTADOS DE LA B�SQUEDA DE SU LIBRO:" + "\n"+ 
				" Autor: " + "autor1" + "\n"+
				"T�tulo: " + "titulo1" + "\n"+
				"Editorial: " + "editorial1" + "\n"+ 
				"Descripci�n f�sica: " + 100 + "p. ; " + 25.3 + "cm."+ "\n"+ 
				"Notas: " + "anotaciones1" + "\n"+
				"ISBN: " + "978-84-945696-8-5" + "\n"+
				"Materias: " + "Cuentos";
		assertEquals(resultado,expected);
	}
	 */
	

}
