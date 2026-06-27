package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_1;

public class CaballoMain {

    public static void main(String[] args) {


        Caballo rocinante = new Caballo(1L, "Rocinante", "Persa", "Blanco", "Macho", 350.0, 10);
        Caballo pegaso = new Caballo(2L, "Pegasso", "Romano", "Negro", "Hembra", 245.0, 5);

        System.out.println("=== DATOS ===");
        System.out.println(rocinante);
        System.out.println(pegaso);

        System.out.println("Me llamo " + rocinante.getNombre() + " soy un caballo " + rocinante.getRaza());
        System.out.println("En estos momentos estoy ==> ");
        rocinante.comer();


        System.out.println("\nMe llamo " + pegaso.getNombre() + " soy un caballo " + pegaso.getRaza() + " y soy " + pegaso.getGenero());
        System.out.println("En estos momentos estoy ==> ");
        pegaso.correr();
        System.out.println(" y ");
        pegaso.relinchar();

    }
}
