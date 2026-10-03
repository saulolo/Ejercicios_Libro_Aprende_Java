package uni11_FicherosDeTextos.Teoria.T7_ProcesamientoArchivosDeTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A continuación se muestra un programa que procesa archivos de texto. Lo que hace es cambiar cada tabulador por dos
 * espacios en blanco.
 * @author Saulolo
 */
public class EjemplosString {

    public static void main(String[] args) {

        System.out.println("== Cambiar tabulador por dos espacios en blanco ==");

/*
        for (int i = 0; i < args.length; i++) {

            File ficheroOriginal = new File(args[i]);
            File ficheroTemporal = new File(args[i] + ".tmp");
            ficheroOriginal.renameTo(ficheroTemporal);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(ficheroTemporal));
                BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroOriginal));

                // 1. Leemos la primera línea antes del bucle
                String linea = reader.readLine();

                // 2. El bucle se repite solo si la línea NO es nula
                while (linea != null) {
                    // Reemplazamos tabuladores por dos espacios
                    linea = linea.replace("\t", "  ");

                    // Escribimos la línea procesada
                    writer.write(linea);
                    writer.newLine(); // Métod nativo de BufferedWriter para saltos de línea limpios

                    // 3. Leemos la siguiente línea para la próxima vuelta
                    linea = reader.readLine();
                }

                writer.close();
                reader.close();

                // Opcional: Borrar el archivo temporal .tmp una vez que tod salió bien
                ficheroTemporal.delete();

                System.out.println("¡Archivo procesado con éxito: " + args[i] + "!");

            } catch (FileNotFoundException e) {
                System.out.println("Error: No se encuentra el fichero en la ruta: " + ficheroOriginal);
            } catch (IOException e) {
                System.out.println("Error de lectura: " + e.getMessage());
            }

        }*/
        //Comente este codio porque si bie funciono, me genero probemas en el DD no se si por coinsidencia o no
        //pero mejor no arriesgarme.

    }
}
