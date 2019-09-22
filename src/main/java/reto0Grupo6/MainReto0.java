package reto0Grupo6;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class MainReto0 {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
 
		// Declaracion e inicializacion de variables
		LeerDatos leerDatos = new LeerDatos();
		LeerFicheros leerFicheros = new LeerFicheros();
		int opcion = -1;
		Scanner reader = new Scanner(System.in);
		Libro [] libros = null;
		FuncionesMain funciones = new FuncionesMain();

		
		//Inicio de programa
		while (opcion !=0)
		{
			switch (opcion) {
				case 1: libros = funciones.CargarDatos(reader, leerDatos);
					break;
				case 2: if(libros != null) funciones.MostrarDatos(libros);
					break;
				case 3: if(libros != null) funciones.MostrarDatosLibro(libros,reader);
				break;
				case 4: leerFicheros.leerFicheroTXT();
				break;
				case 5: leerFicheros.leerFicheroCSV();
				break;
				case 6: leerFicheros.leerFicheroXML();
				break;
				case 7: leerFicheros.leerFicheroEXCEL();
				break;
	 
			}	
			funciones.MostrarMenu();
			opcion = leerDatos.RecogerOpcionInt(reader,0,7, "Introduce una opción: ");
		}
		
		reader.close();

	}

	

}
