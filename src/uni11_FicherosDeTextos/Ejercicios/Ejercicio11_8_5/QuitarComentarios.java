package uni11_FicherosDeTextos.Ejercicios.Ejercicio11_8_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribe un programa capaz de quitar los comentarios de un programa de Java. Se utilizaría de la siguiente manera:
 * <em>quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO<em/>
 * Por ejemplo:
 * <em>quita_comentarios hola.java holav2.java<em/>
 * crea un fichero con nombre holav2.java que contiene el código de hola.java pero
 * sin los comentarios.
 * @author Saulolo
 */

public class QuitarComentarios {

  public static void main(String[] args) {

    System.out.println("=== LIMPIADOR DE COMENTARIOS EN JAVA ===");

    if (args.length < 2) {
      System.err.println("Error: Debe de introducir el fichero de origen y el fichero de destino. ");
      System.out.println("Uso Correcto: java QuitaCOmentarios <origen.java> <destino_limpio.java>. ");
      return;
    }

    String ficheroOriginal = args[0];
    String ficheroLimpio = args[1];

    boolean dentroComentarioMultilinea = false;

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(ficheroOriginal));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ficheroLimpio));

      String linea = bufferedReader.readLine();

      while (linea != null) {
        StringBuilder lineaProcesada = new StringBuilder();
        int i = 0;
        int longitud = linea.length();

        while (i < longitud) {

          if (dentroComentarioMultilinea) {
            int finComentario = linea.indexOf("*/", i);
            if (finComentario != -1) {
              dentroComentarioMultilinea = false;
              i = finComentario + 2;
            } else {
              break;
            }
          } else {
            int inicioMultilinea = linea.indexOf("/*", i);
            int inicioUnilinea = linea.indexOf("//", i);

            if (inicioMultilinea != -1 && (inicioUnilinea == -1 || inicioMultilinea < inicioUnilinea)) {
              lineaProcesada.append(linea, i, inicioMultilinea);
              dentroComentarioMultilinea = true;
              i = inicioMultilinea + 2;
            } else if (inicioUnilinea != -1) {
              lineaProcesada.append(linea, i, inicioUnilinea);
              break;
            } else {
              lineaProcesada.append(linea.substring(i));
              break;
            }
          }
        }
        bufferedWriter.write(lineaProcesada.toString());
        bufferedWriter.newLine();

        linea = bufferedReader.readLine();
      }

      bufferedReader.close();
      bufferedWriter.close();

      System.out.println("✅ ¡Fichero limpiado con éxito! Guardado en: " + ficheroLimpio);
    } catch (FileNotFoundException e) {
      System.err.println("Error: No se encuentra el fichero original en la ruta: " + ficheroOriginal);

    } catch (IOException e) {
      System.err.println("Error de lectura/escritura: " + e.getMessage());
    }
  }
}

