package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_10;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Crea un <b>mini-diccionario</b> inglés-español que contenga, al menos, 20 palabras (con su correspondiente traducción).
 * Utiliza un objeto de la clase {@code HashMap} para almacenar las parejas de palabras. El programa pedirá una palabra
 * en español y dará la correspondiente traducción en español.
 * @author Saulolo
 */
public class DiccionarioMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DICCIONARIO ESPAÑOL - INGLES ===");
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("Backend","Lógica servidor");
        dictionary.put("Branch","Rama");
        dictionary.put("Buffer","Memoria interna");
        dictionary.put("Bug","Error");
        dictionary.put("Commit","Confirmar cambios");
        dictionary.put("Database","Base de datos");
        dictionary.put("Deployment","Despiegue");
        dictionary.put("Feature","Funcionalidad");
        dictionary.put("Frontend","Interfaz de usuario");
        dictionary.put("Framework","Marco de trabajo");
        dictionary.put("Issue","Incidencia");
        dictionary.put("Loop","Bucle");
        dictionary.put("Merge","Fusionar");
        dictionary.put("Pull request","Propuesta de cambios");
        dictionary.put("Query","Consulta");
        dictionary.put("Repository","Repositorio");
        dictionary.put("Software","Programa");
        dictionary.put("Source code","Código fuente");
        dictionary.put("Stack","Pila");
        dictionary.put("Array","Arreglo");

        System.out.print("Ingresa la palabra a traducir: ");
        String word = scanner.nextLine();

        String translation = dictionary.get(word);
        if (translation != null) {
            System.out.println("Traduccción ==> " + translation);
        } else {
            System.out.println("Lo siento, esta palabra no se encuentra en el diccionario.");
        }
    }
}