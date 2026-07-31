package uni10_ColeccionesDiccionarios.Teoria.HashMap;


import java.util.HashMap;
import java.util.Map;

public class ClaseHashMap {

    public static void main(String[] args) {

        System.out.println("=== HASHMAP ===");
        /*Un diccionario en Java Contiene una serie de elementos que son las entradas que a su vez están formadas por un
        par (clave, valor). La clave (key) permite acceder al valor. No puede haber claves duplicadas.

        Java dispone de varios tipos de diccionarios: HashMap, EnumMap, Hashtable, IdentityHashMap, LinkedHashMap, etc.
        Nosotros estudiaremos el diccionario HashMap.
        * */

        System.out.println("== Principales Métodos de HashMap ==");
         /* - get(clave): Obtiene el valor correspondiente a una clave. Devuelve null si no existe esa clave en el diccionario.
            - put(clave, valor): Añade un par (clave, valor) al diccionario. Si ya había un valor para esa clave, se machaca.
            - keySet(): Devuelve un conjunto (set) con todas las claves.
            - values(): Devuelve una colección con todos los valores (los valores pueden estar duplicados a diferencia
            de las claves).
            - entrySet(): Devuelve una colección con todos los pares (clave, valor).
            - containsKey(clave): Devuelve true si el diccionario contiene la clave indicada y false en caso contrario.
            - getKey(): Devuelve la clave de la entrada. Se aplica a una sola entrada del diccionario (no al diccionario
            completo), es decir a una pareja (clave, valor). Por ejemplo:
            for (Map.Entry pareja: m.entrySet()) {
                System.out.println(pareja.getKey());
            }
            - getValue(): Devuelve el contenido de la entrada. Se aplica a una entrada del diccionario (no al diccionario
            completo), es decir a una pareja (clave, valor).
            Por ejemplo:
            for (Map.Entry pareja: m.entrySet()) {
                System.out.println(pareja.getValue());
            }
        */

        HashMap<Integer, String> registroNombres = new HashMap<>();
        registroNombres.put(100, "Alejandra");
        registroNombres.put(101, "Felipe");
        registroNombres.put(102, "Diego");
        registroNombres.put(103, "Leidy");
        registroNombres.put(104, "Saul");

        System.out.println("Cantidad de registros insertados: " + registroNombres.size());

        System.out.println("Mostrando la colección de los registros: ");
        System.out.println(registroNombres);
        System.out.println();
        System.out.println(registroNombres.entrySet());
        System.out.println("Valores: " + registroNombres.values());
        System.out.println("Claves: " + registroNombres.keySet());
        System.out.println("Existe algun valor con la clave 102: " + registroNombres.containsKey(102));


        System.out.println("\nLista de Claves: ");
        for (Integer key : registroNombres.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nLista de valores: ");
        for (String value : registroNombres.values()) {
            System.out.println(value);
        }

        System.out.println("\nLista del Diccionario: ");
        for (Map.Entry<Integer, String> integerStringEntry : registroNombres.entrySet()) {
            System.out.println(integerStringEntry);
        }

        System.out.println("Valor correspondiente a la clave 101: " + registroNombres.get(101));

    }
}
