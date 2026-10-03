package uni11_FicherosDeTextos.Teoria.T1_LecturaFicheroTexto;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicherosDeTexto {

    public static void main(String[] args) {

        System.out.println("=== FICHEROS DE TEXTOS Y PASO DE PARÁMETROS DESDE LÍNEA DE COMANDOS ===");
        /* Mediante un programa en Java se puede acceder al contenido de un fichero grabado en un dispositivo de
        almacenamiento (por ejemplo en el disco duro) tanto para leer como para escribir (grabar) datos.
        Cuando un programa se cierra, se pierde la información almacenada en variables, arrays, objetos o cualquier otra
         estructura. Si queremos conservar ciertos datos, debemos guardarlos en ficheros.
         La creación y uso de ficheros desde un programa en Java se lleva a cabo cuando hay poca información que almacenar
         o cuando esa información es heterogénea. En los casos en que la información es abundante y homogénea es preferible
         usar una base de datos relacional (por ejemplo MySQL) en lugar de ficheros.
        * */


        System.out.println("== Lectura de un fichero de texto ==");
        /* Aunque Java puede manejar también ficheros binarios, vamos a centrarnos exclusivamente en la utilización de
        ficheros de texto.

        Todas las operaciones que se realicen sobre ficheros deberán estar incluidas en un bloque try-catch.
        Esto nos permitirá mostrar mensajes de error y terminar el programa de una forma ordenada en caso de que se
        produzca algun fallo.
        Tanto para leer como para escribir utilizamos lo que en programación se llama un “manejador de fichero”.
        Es algo así como una variable que hace referencia al fichero con el que queremos trabajar.
        */
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/uni11_FicherosDeTextos/Teoria/T1_LecturaFiccheroTexto/Medellin.txt"));

            String linea = "";

            while (linea != null) {
                System.out.println(linea);
                linea = bufferedReader.readLine();
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero Medellin.txt");
        } catch (IOException e) {
            System.out.println("No se puede leer el fichero Medellin.txt");
        }


    }
}
