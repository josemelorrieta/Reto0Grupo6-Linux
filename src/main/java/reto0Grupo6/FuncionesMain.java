package reto0Grupo6;

import java.util.Scanner;

public class FuncionesMain {
	 
	public void MostrarDatosLibro(Libro[] libros,Scanner reader) {
		// Declaracion e inicializacion de variables
		String autor = "";
		boolean encontrado = false;
		//Inicio de programa
		System.out.println("Introduce en nombre completo del autor: ");
		autor = reader.nextLine();
		for(int i = 0;i<libros.length;i++)
		{
			if(libros[i].getAutor().equalsIgnoreCase(autor))
			{
				System.out.println(libros[i].toString());
				encontrado = true;
			}
		}
		if(!encontrado)
			System.out.println("Libro no encontrado");
		
		 
	}

	public void MostrarDatos(Libro[] libros) {
		//Inicio de programa
		System.out.println("\t Listado de Libros");
		System.out.println("---------------------------");
		System.out.println("Autor    \t Título \tEditorial\t Descripción física\t Notas \t ISBN \t Materias \t ");
		System.out.println("----------\t-----\t -----\t ---------\t---------\t ");
		
		for(int i = 0;i<libros.length;i++)
		{
			System.out.println(libros[i].getAutor()+"\t "+libros[i].getTitulo()+"\t "+libros[i].getEditorial() 
					+"\t "+libros[i].getPaginas()+"p. ;"+libros[i].getAltura() +"cm. \t " + libros[i].getNotas() 
					+ "\t \t" + libros[i].getIsbn() +"\t \t" + libros[i].getMaterias());
		}
		
	}

	
	public Libro[] CargarDatos(Scanner reader, LeerDatos leerDatos) {
		
		//Declaracion e inicialización de variables
		Libro [] libros = null;
		String autor;
		String titulo;
		String editorial;
		int paginas;
		float altura;
		String notas;
		String isbn;
		String materias;
		int numeroLibros = 0;
		
		//Inicio de programa
		numeroLibros = leerDatos.RecogerOpcionInt(reader,0,100,"Introduce la cantidad de libros que desea cargar: ");
		libros = new Libro[numeroLibros];
		
		for(int i = 0;i<numeroLibros;i++)
		{
			autor = leerDatos.IntroducirTexto(reader, "Introduzca el autor:");
			titulo = leerDatos.IntroducirTexto(reader, "Introduzca el título:");
			editorial = leerDatos.IntroducirTexto(reader, "Introduzca la editorial:");
			paginas= leerDatos.RecogerOpcionInt(reader,0,5000,"Introduzca el número de páginas: ");
			altura= leerDatos.RecogerOpcionFloat(reader,0,(float) 100,"Introduce la altura (cm): ");
			notas = leerDatos.IntroducirTexto(reader, "Introduzca alguna anotación del libro:");
			isbn = leerDatos.IntroducirTexto(reader, "Introduzca el ISBN:");
			materias = leerDatos.IntroducirTexto(reader, "Introduzca la temática (Ej. Novela clásica, cuentos,...):");
			
			Libro libro = new Libro(autor, titulo, editorial, paginas, altura, notas, isbn, materias);
			libros[i] = libro;
		}
		
		return libros;
	}

	

	

	public void MostrarMenu() {
		//Inicio de programa
		System.out.println("\t Menu Principal");
		System.out.println("1.- Cargar datos libros");
		System.out.println("2.- Mostrar catálogo");
		System.out.println("3.- Búsqueda de un libro (por autor)");
		System.out.println("4.- Mostrar catálogo (.TXT)");
		System.out.println("5.- Mostrar catálogo (.CSV)");
		System.out.println("6.- Mostrar catálogo (.XML)");
		System.out.println("7.- Mostrar catálogo (.EXCEL)");
		System.out.println("0.- Fin");
	}
	
	

}
