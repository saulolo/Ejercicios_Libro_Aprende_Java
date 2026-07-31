package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Realiza un programa que escoja al azar <b>5 palabras</b> en ingles del {@code minidiccionario} del ejercicio anterior.
 * El programa irá pidiendo que el usuario teclee la traducción al <b>español</b> de cada una de las palabras y comprobará
 * si son correctas. Al final, el programa deberá mostrar cuántas respuestas son <b>válidas</b> y cuántas <b>erróneas</b>.
 * @author Saulolo
 */
public class ValidarDiccionarioMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DICCIONARIO BARAJADO ESPAÑOL - INGLES ===");
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("Backend", "Lógica servidor");
        diccionario.put("Branch", "Rama");
        diccionario.put("Buffer", "Memoria interna");
        diccionario.put("Bug", "Error");
        diccionario.put("Commit", "Confirmar cambios");
        diccionario.put("Database", "Base de datos");
        diccionario.put("Deployment", "Despliegue");
        diccionario.put("Feature", "Funcionalidad");
        diccionario.put("Frontend", "Interfaz de usuario");
        diccionario.put("Framework", "Marco de trabajo");
        diccionario.put("Issue", "Incidencia");
        diccionario.put("Loop", "Bucle");
        diccionario.put("Merge", "Fusionar");
        diccionario.put("Pull request", "Propuesta de cambios");
        diccionario.put("Query", "Consulta");
        diccionario.put("Repository", "Repositorio");
        diccionario.put("Software", "Programa");
        diccionario.put("Source code", "Código fuente");
        diccionario.put("Stack", "Pila");
        diccionario.put("Array", "Arreglo");

        System.out.println(diccionario);

        ArrayList<String> llavesBarajadas = new ArrayList<>(diccionario.keySet());
        int aciertos = 0;
        int errores = 0;

        System.out.println("== Diccionario Barajado ==");
        Collections.shuffle(llavesBarajadas);

        for (int i = 0; i < 5; i++) {
            String palabra = llavesBarajadas.get(i);
            System.out.println(palabra);

            System.out.print("Ingresa palabra número " + (i + 1) + " a traducir: ");
            String respuesta = scanner.nextLine();
            String traduccionCorrecta = diccionario.get(palabra);

            if (traduccionCorrecta.equalsIgnoreCase(respuesta)) {
                aciertos++;
                System.out.println("Correcto");
            } else {
                errores++;
                System.out.println("Incorrecto");
                System.out.println("La respuesta correcta era: " + traduccionCorrecta);
            }
        }

        System.out.println("Cantidad de aciertoe: " + aciertos);
        System.out.println("Cantidad de errores: " + errores);

    }
}