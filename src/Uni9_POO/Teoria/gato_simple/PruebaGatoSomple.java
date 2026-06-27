package Uni9_POO.Teoria.gato_simple;

public class PruebaGatoSomple {

    public static void main(String[] args) {

        System.out.println("=== Gardfield ===");
        GatoSimple garfield = new GatoSimple("macho");
        System.out.println("Hola Gatito!!!");
        garfield.maulla();
        System.out.println("Toma una tarta");
        garfield.come("Tarta selva negra");
        System.out.println("Toma pescado a ver si esto te gusta");
        garfield.come("pescado");


        System.out.println("\n=== Tom ===");
        GatoSimple tom = new GatoSimple("macho");
        System.out.println("Toma Tom sopita de verduras");
        tom.come("Sopa de verduras");

        System.out.println("\n=== Lisa ===");
        GatoSimple lisa = new GatoSimple("hembra");

        System.out.println("\n== Gatitos a ver como maullais!!! ==");
        garfield.maulla();
        tom.maulla();
        lisa.maulla();
        System.out.println();
        garfield.peleaCon(lisa);
        lisa.peleaCon(tom);
        tom.peleaCon(garfield);

    }
}
