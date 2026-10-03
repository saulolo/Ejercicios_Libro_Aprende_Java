package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un fichero de texto.
 * El nombre del fichero que contiene las palabras se debe pasar como argumento en la línea de comandos. El nombre del
 * fichero resultado debe ser el mismo que el original añadiendo la coletilla
 * <b>sort</b>, por ejemplo <b>palabras_sort.txt.</b> Suponemos que cada palabra ocupa una línea.
 * @author Saulolo
 */

public class OrdenarPalabrasEnFichero {

  public static void main(String[] args) {

    System.out.println("=== ORDENAR PALABRAS EN UN FICHERO ===");

    String rutaOrigen = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_4/palabras.txt";
    String rutaDestino = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_4/palabras_sort.txt";

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaOrigen));
      ArrayList<String> listaPalabras = new ArrayList<>();
      String linea = bufferedReader.readLine();

      while (linea != null) {
        listaPalabras.add(linea);
        linea = bufferedReader.readLine();
      }
      bufferedReader.close();
      Collections.sort(listaPalabras, String.CASE_INSENSITIVE_ORDER);

      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaDestino));

      for (String palabra : listaPalabras) {
        bufferedWriter.write(palabra);
        bufferedWriter.newLine();
      }

      bufferedWriter.close();

      System.out.println("Fichero ordenado alfabeticamente con éxito.");


    } catch (FileNotFoundException e) {
      System.err.println("Error: No se encuentra el fichero en la ruta especificada ");

    } catch (IOException e) {
      System.err.println("No se ha podido escribir en el fichero.");

    }

  }
}

