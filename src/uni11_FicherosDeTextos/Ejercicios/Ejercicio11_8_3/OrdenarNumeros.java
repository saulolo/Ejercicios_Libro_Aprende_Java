package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, de tal forma que en el fichero
 * resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, la primera línea será del primer
 * fichero, la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
 * Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como argumentos en la línea
 * de comandos.
 * Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.
 * @author Saulolo
 */

public class OrdenarNumeros {

  public static void main(String[] args) {

    System.out.println("=== CREANDO UN FICHERO A PARTIR DE OTROS DOS ===");

    String rutaA = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_3/ficheroA.txt";
    String rutaB = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_3/ficheroB.txt";

    String rutaDestino = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_3/ficheroResultante.txt";


    try {
      BufferedReader bufferedReaderA = new BufferedReader(new FileReader(rutaA));
      BufferedReader bufferedReaderB = new BufferedReader(new FileReader(rutaB));

      String lineaA = bufferedReaderA.readLine();
      String lineaB = bufferedReaderB.readLine();

      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaDestino));

      while (lineaA != null || lineaB != null) {

        // 1. Si el archivo A todavía tiene líneas, escribimos la de A
        if (lineaA != null) {
          bufferedWriter.write(lineaA);
          bufferedWriter.newLine();
          // Inmediatamente leemos la siguiente línea de A para la próxima vuelta
          lineaA = bufferedReaderA.readLine();
        }

        // 2. Si el archivo B todavía tiene líneas, escribimos la de B
        if (lineaB != null) {
          bufferedWriter.write(lineaB);
          bufferedWriter.newLine();
          // Inmediatamente leemos la siguiente línea de B para la próxima vuelta
          lineaB = bufferedReaderB.readLine();
        }
      }

      System.out.println("Archivo generado con éxito.");

      bufferedReaderA.close();
      bufferedReaderB.close();
      bufferedWriter.close();

    } catch (FileNotFoundException e) {
      System.err.println("Error: No se encuentra el fichero en la ruta especificada ");

    } catch (IOException e) {
      System.err.println("No se ha podido escribir en el fichero.");

    }

  }
}

