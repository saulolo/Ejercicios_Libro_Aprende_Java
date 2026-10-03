package uni11_FicherosDeTextos.Teoria.T2_EscrituraSobreFicheroDeTexto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraSobreFicherosDeTexto {

    public static void main(String[] args) {

        System.out.println("== Escritura sobre un fichero de texto ==");
        /* La escritura en un fichero de texto es, si cabe, más fácil que la lectura. Solo hay que cambiar
        System.out.print("texto") por manejador.write("texto"). Se pueden incluir saltos de línea, tabuladores y
        espacios igual que al mostrar un mensaje por pantalla.

        Es importante ejecutar close() después de realizar la escritura; de esta manera nos aseguramos que se graba toda
        la información en el disco.
        */

        System.out.println("- Primero a pantalla y luego a fichero -");
        /*Envía primero a la pantalla tod lo que quieras escribir en el fichero. Cuando compruebes que lo que se ve por
        pantalla es realmente lo que quieres grabar en el fichero, entonces y solo entonces, cambia
        System.out.print("texto") por manejador.write("texto").
        */

        /*A continuación se muestra un programa de ejemplo que crea un fichero de texto y luego esribe en él tres palabras,
        una por cada línea.*/

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/uni11_FicherosDeTextos/Teoria/T2_EscrituraSobreFicheroDeTexto/fruta.txt"));
            bufferedWriter.write("naranja\n");
            bufferedWriter.write("mango\n");
            bufferedWriter.write("fresa\n");

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero.");
        }
    }
}
