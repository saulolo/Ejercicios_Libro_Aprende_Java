package uni11_FicherosDeTextos.Teoria.T4_OtrasOperacionesSobreFicheros;

import java.io.File;
import java.util.Scanner;

public class EjemploFile {

    public static void main(String[] args) {

        /* El siguiente programa de ejemplo comprueba si un determinado archivo existe o no mediante exists() y, en caso
        de que exista, lo elimina mediante delete(). Si intentáramos borrar un archivo que no existe obtendríamos un error.*/

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el nombre del archivo que desea borrar: ");
        String archivo = scanner.nextLine();
        String ruta = "src/uni11_FicherosDeTextos/Teoria/T4_OtrasOperacionesSobreFicheros/" + archivo;

        File file = new File(ruta);

        if (file.exists()) {
            file.delete();
            System.out.println("El fichero se ha borrado con exito.");
        } else {
            System.out.println("El fichero " + archivo + " no existe.$");
        }

        System.out.println("Sali del bucle");

        scanner.close();

    }

}
