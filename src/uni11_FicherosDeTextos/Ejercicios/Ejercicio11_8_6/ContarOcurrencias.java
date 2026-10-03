package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero.
 * @author Saulolo
 */

public class ContarOcurrencias {

  public static void main(String[] args) {

    System.out.println("=== CONTADOR DE OCURRENCIAS ===");

    String fichero = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_6/fichero.txt";
    String palabraBuscada = "tiempo";
    int contador = 0;

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));

      String linea = bufferedReader.readLine();

      while (linea != null) {
        linea = linea.toLowerCase();

        String[] palabras = linea.split(" ");

        for (String palabra : palabras) {
          if (palabra.equals(palabraBuscada)) {
            contador++;
          }
        }

        linea = bufferedReader.readLine();
      }

      bufferedReader.close();

      System.out.println("La palabra 'tiempo' aparece: " + contador + " veces en el archivo fichero.txt.");


    } catch (FileNotFoundException e) {
      System.err.println("Error: No se encuentra el fichero original en la ruta: " + fichero);

    } catch (IOException e) {
      System.err.println("Error de lectura/escritura: " + e.getMessage());
    }

  }
}

