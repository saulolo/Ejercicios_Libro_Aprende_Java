package uni11_FicherosDeTextos.Teoria.T4_OtrasOperacionesSobreFicheros;


import java.io.File;

public class OtrasOperacionesSobreFicheros {

    public static void main(String[] args) {

        System.out.println("== Otras operaciones sobre ficheros ==");
        /* Además de leer desde o escribir en un fichero, hay otras operaciones relacionadas con los archivos que se
        pueden realizar desde un programa escrito en Java.
        */

        //Listado de los archivos del directorio actual

        File file = new File("."); //Directorio actual

        String[] listaArchivos = file.list();

        for (String archivo : listaArchivos) {
            System.out.println(archivo);
        }

    }
}
