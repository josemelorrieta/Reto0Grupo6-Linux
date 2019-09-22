package reto0Grupo6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerFicheros {

	public void leerFicheroTXT() {
		File fichero = elegirFichero("txt");
		String linea = "";
		try {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));
				
				try {
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void leerFicheroCSV() throws IOException {
		File fichero = elegirFichero("csv");

		final String SEPARADOR = ";";

		BufferedReader bufferLectura = null;
		try {
			// Abrir el .csv en buffer de lectura
			bufferLectura = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));

			// Leer una linea del archivo
			String linea = bufferLectura.readLine();

			while (linea != null) {
				// Sepapar la linea le�da con el separador definido previamente
				String[] campos = linea.split(SEPARADOR);

				System.out.println(Arrays.toString(campos));
				System.out.println(campos.length);

				if (campos.length == 7) {

				}

				// Volver a leer otra l�nea del fichero
				linea = bufferLectura.readLine();
			}
		} catch (FileNotFoundException fnE) {
			System.out.println("Asegúrese de que la ruta de acceso al fichero .csv exista y sea correcta.");
		} finally {
			// Cierro el buffer de lectura
			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void leerFicheroXML() throws ParserConfigurationException, SAXException, IOException {
		File f = elegirFichero("xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = (Document) builder.parse(f);
			System.out.println(f.getAbsolutePath());
			Node raiz = (Node) ((Node) doc).getFirstChild();
			recorrerXML(raiz.getChildNodes(), 0);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void recorrerXML(NodeList lst, int piso) {
		if (lst != null) {
			for (int i = 0; i < lst.getLength(); i++) {
				System.out.println(lst.item(i).getNodeName() + ": " + lst.item(i).getTextContent());

			}
		}
	}

	public void leerFicheroEXCEL() throws IOException {

		String rutaArchivo = "C:\\Reto0Workspace\\Reto0Equipo6\\Ficheros\\CatalogoExcel.xlsx";
		String hoja = "Hoja1";

		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			// obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			// obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();

			Row row;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				// se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en espec�fico y se la imprime
					cell = cellIterator.next();
					System.out.print(cell.getStringCellValue() + " | ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public File elegirFichero(String extension) {
		String ruta = "";
		FileNameExtensionFilter filter = null;
		
		JFileChooser fileChooser = new JFileChooser();
		switch (extension) {
			case "txt": filter = new FileNameExtensionFilter("Archivo de texto", "txt"); break;
			case "csv": filter = new FileNameExtensionFilter("Archivo CSV", "csv"); break;
			case "xml": filter = new FileNameExtensionFilter("Archivo XML", "xml"); break;
			default: filter = new FileNameExtensionFilter("Archivo de texto", "txt");
		}
		
		fileChooser.setFileFilter(filter);
		int seleccion = fileChooser.showDialog(null, "Abrir");
		
		return fileChooser.getSelectedFile();
	}

}
