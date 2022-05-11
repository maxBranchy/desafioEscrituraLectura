package com.maxBranchy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class EscrituraYLectura {

	public static void main(String[] args) {

		crearArchivo("carpeta", "fichero.txt");
		buscarTexto("carpeta", "fichero.txt", "Camila");

	}

	/*
	 * toma como parametros el nombre de una carpeta a crear/verificar y un
	 * fichero.txt(obligatorio) a ingresar/verificar0
	 * si la carpeto y/o el fichero ya existen, no hace nada, en caso de que ninguno
	 * de los dos exista, los crea y ademas
	 * escribe en el fichero una lista predufinida
	 */
	private static void crearArchivo(String nombreDirectorio, String nombreFichero) {

		// creacion de objetos carpeta y fichero de la clase File
		File carpeta = new File("src/" + nombreDirectorio);
		File fichero = new File("src/" + nombreDirectorio + "/" + nombreFichero);

		// inicializacion de array vacio y agregacion de elementos
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");

		/*
		 * si la carpeta existe, termina, si no, prosigue y crea la carpeta, todo esto
		 * en un try-catch por
		 * si las rutas dadas no son correctas
		 */
		try {
			if (carpeta.exists()) {
				System.out.println("El directorio ya existe, verificar");
			} else {

				carpeta.mkdir();
				System.out.println("Carpeta creada");

				// try catch para controlar posibles errores de path
				try {
					// si el fichero ya existe, termina, si no, prosigue creando el fichero
					if (fichero.exists()) {
						System.out.println("el archivo ya existe");
					} else {
						fichero.createNewFile();
						System.out.println("fichero creado con exito");
					}

					// creacion de FileWriter y BufferedWriter para posterior escritura
					FileWriter escribirFile = new FileWriter(fichero);
					BufferedWriter escribirBuffered = new BufferedWriter(escribirFile);

					// bucle for-each para recorrer la lista y escribir en el fichero
					for (String item : lista) {
						escribirBuffered.write(item);
						escribirBuffered.newLine();
					}
					// cierre de variables FileReader y BufferedWriter
					escribirBuffered.close();
					escribirFile.close();

				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
			}
		} catch (Exception e) {
			System.out.println("Error al crear el archivo: ");
		}

	}

	private static void buscarTexto(String nombreDirectorio, String nombreFichero, String texto) {

		// inicializacion de array vacio y agregacion de elementos
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");

		try {
			// inicializa variable file para posteriormente buscarla
			File archivo = new File("src/" + nombreDirectorio + "/" + nombreFichero);
			// si el archivo existe, prosigue
			if (archivo.exists()) {
				// inicializacion de FileReader y BufferedReader
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				// Inicializacion de acumulador
				int i = 0;
				/*
				 * compara el texto con los items de la lista, si el texto esta en la lista y/o
				 * se repite, el acumulador aumenta su valor
				 */
				for (String item : lista) {
					if (texto.equals(item)) {
						i += 1;
					}
				}
				
				// cierre de FileReader y BufferedReader
				fr.close();
				br.close();

				// entrega de valor final
				System.out.println("cantidad de repeticiones del texto -> " + i);
				// archivo ingresado no existe, por ende no se puede buscar texto => fin
			} else {
				System.out.println("El fichero ingresado no existe");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

}
