package uni10_ColeccionesDiccionarios.Teoria.ArrayList;


import java.util.ArrayList;
import java.util.Collections;

public class ClaseArrayList {

    public static void main(String[] args) {

        System.out.println("=== ARRAYLIST ===");
        /*Un ArrayList es una estructura en forma de lista que permite almacenar elementos del mismo tipo (pueden ser
        incluso objetos); su tamaño va cambiando a medida que se añaden o se eliminan esos elementos.
        Nos podemos imaginar un ArrayList como un conjunto de celdas o cajoncitos donde se guardan los valores,
        exactamente igual que un array convencional. En la práctica será más fácil trabajar con un ArrayList.
        El array convencional  presenta algunos inconvenientesUno de ellos es la necesidad de conocer el tamaño exacto
        en el momento de su creación. Una colección, sin embargo, se crea sin que se tenga que especificar el tamaño;
        posteriormente se van añadiendo y quitando elementos a medida que se necesitan.
        Trabajando con arrays es frecuente cometer errores al utilizar los índices; por ejemplo al intentar guardar un
        elemento en una posición que no existe (índice fuera de rango). Aunque las colecciones permiten el uso de
        índices, no es necesario indicarlos siempre. Por ejemplo, en una colección del tipo ArrayList, cuando hay que
        añadir el elemento "Amapola", se puede hacer simplemente flores.add("Amapola"). Al no especificar índice, el
        elemento "Amapola" se añadiría justo al final de flores independientemente del tamaño y del número de elementos
        que se hayan introducido ya.
        * */

        System.out.println("== Principales Métodos de ArrayList ==");
         /*- add(elemento): Añade un elemento al final de la lista.
        - add(indice, elemento): Inserta un elemento en una posición determinada, desplazando el resto de elementos
        hacia la derecha.
        - clear(): Elimina todos los elementos pero no borra la lista.
        - contains(elemento): Devuelve true si la lista contiene el elemento que se especifica y false en caso contrario.
        - get(indice): Devuelve el elemento de la posición que se indica entre paréntesis.
        - indexOf(elemento): Devuelve la posición de la primera ocurrencia del elemento que se indica entre paréntesis.
        - isEmpty(): Devuelve true si la lista está vacía y false en caso de tener algún elemento.
        - remove(indice): Elimina el elemento que se encuentra en una posición determinada.
        - remove(elemento): Elimina la primera ocurrencia de un elemento.
        - removeIf(filtro): Elimina los elementos que cumplen una determinada condición.
        - set(indice, elemento): Machaca el elemento que se encuentra en una determinada posición con el elemento que se
        pasa como parámetro.
        - size(): Devuelve el tamaño (número de elementos) de la lista.
        - toArray(): Devuelve un array con todos y cada uno de los elementos que contiene la lista.
        */

        //Array de String
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Rojo");
        colors.add("Verde");
        colors.add("Amarillo");
        colors.add("Azul");
        colors.add(2, "Morado");

        System.out.println("Colores: " + colors);
        System.out.println("Cantidad de colores: " + colors.size());
        colors.add("Blanco");
        System.out.println("Colores: " + colors);
        System.out.println("Cantidad de colores: " + colors.size());
        System.out.println("El color que hay en la posicion 1 es: " + colors.get(1));

        System.out.println("Contenido de la lista de colores: ");
        for (String color : colors) {
            System.out.println(color);
        }

        colors.remove(1);
        colors.remove("Blanco");
        System.out.println(colors);

        colors.removeIf(letra -> letra.contains("R"));
        System.out.println(colors);

        //Ordenar por orden alfabético
        Collections.sort(colors);
        System.out.println(colors);

        //Array de números
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Números: " + numbers);
        System.out.println("Cantidad de números: " + numbers.size());
        numbers.add(13);
        System.out.println("Números: " + numbers);
        System.out.println("Cantidad de números: " + numbers.size());
        System.out.println("El número que hay en la posicion 2 es: " + colors.get(2));

        System.out.println("Contenido de la lista de números");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i);
        }

        System.out.println("E cuatro se encuentra en la lista de números? " + numbers.contains(4));
        numbers.set(0, 6);

        for (Integer number : numbers) {
            System.out.println(number);
        }

        numbers.removeIf(number -> number <=4);
        System.out.println("Números que quedaron: " + numbers);


        System.out.println("\n== ArrayList de Objetos ==");
        ArrayList<Gato> gatos = new ArrayList<>();
        gatos.add(new Gato("Pinina", "Cafe", 12));
        gatos.add(new Gato("Muñeca", "Blanco", 11));
        gatos.add(new Gato("Lupe", "Negro", 7));

        ArrayList<Gato> gatos2 = new ArrayList<>();
        gatos2.add(new Gato("Martinia", "Rojo", 6));

        ArrayList<Gato> gatos3 = new ArrayList<>();
        gatos3.add(new Gato("Macarena", "Cafe", 11));



        System.out.println(gatos);
        Collections.sort(gatos);//Para ello implemente la interfaz Comparable co su métod
        System.out.println(gatos);

        System.out.println("Los gatos son iguales?: " + gatos2.equals(gatos3));


    }
}
