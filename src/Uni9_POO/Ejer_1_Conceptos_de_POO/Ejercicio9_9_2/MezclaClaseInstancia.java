package Uni9_POO.Ejer_1_Conceptos_de_POO.Ejercicio9_9_2;

/**
 * A continuación tienes una lista en la que están mezcladas varias clases con instancias de esas clases.
 * Para ponerlo un poco más difícil, todos los elementos están escritos en minúscula. Di cuáles son las clases, cuáles
 * las instancias, a qué clase pertenece cada una de estas instancias y cuál es la jerarquía entre las clases: paula,
 * goofy, gardfiel, perro, mineral, caballo, tom, silvestre, pirita, rocinante, milu, snoopy, gato, pluto, animal,
 * javier, bucefalo, pegaso, ayudante_de_santa_claus, cuarzo, laika, persona, pato_lucas.
 * @author Saulolo
 */
public class MezclaClaseInstancia {

    public static void main(String[] args) {

        System.out.println("CLASES => Perro, Mineral, Caballo, Gato, Animal, Persona");

        System.out.println("\nINSTANCIAS => paula, goofy, gardfield, tom, silvestre, rocinante, milu, snoopy, pluto, javier, " +
                "bucefalo, pegaso, laika, pato_lucas, cuarzo, pirita, ayudante_de_santa_claus");

        System.out.println("\nInstancias Clase Persona => paula, javier");

        System.out.println("\nInstancias Clase Perro => goofy, milu, snoopy, pluto, laika, ayudante_de_santa_claus");

        System.out.println("\nInstancias Clase Gato => gardfiel, tom, silvestre");

        System.out.println("\nInstancias Clase Caballo => rocinante, bucefalo, pegaso");

        System.out.println("\nInstancias Clase Animal => pato_lucas");

        System.out.println("\nInstancias Clase Mineral => Cuarzo, pirita");

        System.out.println("=== JERARQUIA DE CLASES ===");
        System.out.println("Animal ==> [Perro, Gato, Caballo]");
        System.out.println("Mineral");
        System.out.println("Persona");

    }
}
