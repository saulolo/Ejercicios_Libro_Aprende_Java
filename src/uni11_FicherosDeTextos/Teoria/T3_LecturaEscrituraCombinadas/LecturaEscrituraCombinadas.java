package uni11_FicherosDeTextos.Teoria.T3_LecturaEscrituraCombinadas;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscrituraCombinadas {

    public static void main(String[] args) {

        System.out.println("== Escritura y Lectura Combinadas sobre un fichero de texto ==");
        /* Las operaciones de lectura y escritura sobre ficheros se pueden combinar de tal forma que haya un flujo de
        lectura y otro de escritura, uno de lectura y dos de escritura, tres de lectura, etc.
        */

        /*Ejemplo:
        En el ejemplo que presentamos a continuación hay dos flujos de lectura y uno de escritura. Observa que se
        declaran en total tres manejadores de fichero (dos para lectura y uno para escritura). El programa va leyendo,
        de forma alterna, una línea de cada fichero - una línea de fichero1.txt y otra línea de fichero2.txt - mientras
        queden líneas por leer en alguno de los ficheros; y al mismo tiempo va guardando esas líneas en otro fichero con
        nombre mezcla.txt.
        * */

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("src/uni11_FicherosDeTextos/Teoria/T3_LecturaEscrituraCombinadas/fichero1.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("src/uni11_FicherosDeTextos/Teoria/T3_LecturaEscrituraCombinadas/fichero2.txt"));

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/uni11_FicherosDeTextos/Teoria/T3_LecturaEscrituraCombinadas/mezcla.txt"));

            String linea1 = "";
            String linea2 = "";

            while (linea1 != null || linea2 != null) {
                linea1 = reader1.readLine();
                linea2 = reader2.readLine();

                if (linea1 != null) {
                    writer.write(linea1 + "\n");
                }

                if (linea2 != null) {
                    writer.write(linea2 + "\n");
                }
            }

            reader1.close();
            reader2.close();
            writer.close();

            System.out.println("Archivo mezcla.txt creado satisfactoriamiente");

        } catch (FileNotFoundException e) {
            System.err.println("No se encuentran los ficheros fichero.txt");
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println("No se puede leer los ficheros fichero.txt");
            System.err.println(e.getMessage());
        }

    }
}
