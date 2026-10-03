package uni11_FicherosDeTextos.Teoria.T6_CombinacionFicherosYPasoPorArgumentos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CombinacionFicherosYPasoPorArgumentos {

    public static void main(String[] args) {

        System.out.println("== Combinacion de ficheros y paso por argumentos ==");

        // 1. Validamos que nos hayan pasado el argumento por la línea de comandos
        if (args.length == 0) {
            System.out.println("Error: Debe introducir el nombre del fichero como argumento.");
            return;
        }

        // 2. Capturamos el nombre del fichero desde el primer argumento (args[0])
        String nombreFichero = args[0];

        // 3. Construimos la ruta relativa exacta
        String rutaCompleta = "uni11_FicherosDeTextos/Teoria/T6_CombinacionFicherosYPasoPorArgumentos/" + nombreFichero + ".txt";

        double suma = 0;
        int cantidadElementos = 0;

        // 4. Intentamos leer el fichero
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaCompleta));

            String linea = bufferedReader.readLine();

            while (linea != null) {
                suma += Double.parseDouble(linea);
                cantidadElementos++;
                linea = bufferedReader.readLine();
            }

            bufferedReader.close();

            // 5. Mostramos el resultado
            if (cantidadElementos > 0) {
                double media = suma / cantidadElementos;
                System.out.println("Total de elementos: " + cantidadElementos);
                System.out.println("Suma total: " + suma);
                System.out.println("La media aritmética es: " + media);
            } else {
                System.out.println("El fichero esta vacio.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el fichero en la ruta: " + rutaCompleta);
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: El fichero contiene datos que no son numeros validos.");
        }
    }
}