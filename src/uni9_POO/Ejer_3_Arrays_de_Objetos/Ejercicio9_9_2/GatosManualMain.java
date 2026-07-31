package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_2;

import uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_1.Gato;

/**
 * Cambia el programa anterior de tal forma que los datos de los gatos se introduzcan directamente en el código de la
 * forma {@code gatito[2].setColor("marrón")} o bien mediante el constructor, de la forma {@code gatito[3] = new Gato("Garfield",
 * "naranja", "macho")}. Muestra a continuación los datos de todos los gatos utilizando un bucle.
 * @author Saulolo
 */
public class GatosManualMain {

    public static void main(String[] args) {

        System.out.println("=== GATOS 2 ===");

        Gato[] gatitos = new Gato[4];


        //Gato 1
        gatitos[0] = new Gato();
        gatitos[0].setNombre("Rocky");
        gatitos[0].setEdad(2);

        //Gato 2
        gatitos[1] = new Gato();
        gatitos[1].setNombre("Pinina");
        gatitos[1].setEdad(5);

        //Gato 3
        gatitos[2] = new Gato();
        gatitos[2].setNombre("Muñeca");
        gatitos[2].setEdad(7);

        //Gato 4
        gatitos[3] = new Gato();
        gatitos[3].setNombre("Lupe");
        gatitos[3].setEdad(10);

        System.out.println("\n== Mostrando los Gatos ==");
        for (Gato g : gatitos) {
            System.out.println(g);
        }

    }

}
