package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestre los números por pantalla.
 * @author Saulolo
 */

public class LeePrimos {

  public static void main(String[] args) {

    System.out.println("=== LEER NÚMEROS PRIMOS ===");

    String ruta = "src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_1/primos.dat";

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta));

      String linea = "";

      while (linea != null) {
        System.out.println(linea);
        linea = bufferedReader.readLine();
      }

      bufferedReader.close();


    } catch (FileNotFoundException e) {
      System.out.println("Error: No se encuentra el fichero en la ruta: " + ruta);

    } catch (IOException e) {
      System.out.println("Error de lectura: " + e.getMessage());
    }

  }
}

