package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Escribe un programa que guarde en un fichero con nombre primos.dat los números primos que hay entre 1 y 500.
 * @author Saulolo
 */

public class GuardandoPrimos {

  public static void main(String[] args) {

    System.out.println("=== GUARDAR NÚMEROS PRIMO'S ENTRE 1 Y 500 ===");

    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/uni11_FicherosDeTextos/Ejercicios/Ejercicio11_8_1/primos.dat"));

      boolean esPrimo = true;
      for (int n = 2; n <= 500; n++) {
        // comprueba si n es primo
        esPrimo = true;
        for (int i = 2; i < n; i++) {
          if (n % i == 0) {
            esPrimo = false;
          }
        }

        if (esPrimo) {
          bufferedWriter.write(String.valueOf(n));
          bufferedWriter.newLine();
        }
      }

      bufferedWriter.close();
      System.out.println("Fichero generado con exito.");

    } catch (IOException e) {
      System.err.println("No se ha podido escribir en el fichero.");
    }

  }
}

