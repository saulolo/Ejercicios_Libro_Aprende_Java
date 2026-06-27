package Uni9_POO.Teoria.animal;

public class AnimalMain {

    public static void main(String[] args) {

        Gato garfield = new Gato(Sexo.MACHO, "romano");
        Gato tom = new Gato(Sexo.MACHO);
        Gato lisa = new Gato(Sexo.HEMBRA);
        Gato silvestre = new Gato();

        System.out.println("=== GATOS ===");
        System.out.println("Garfield => " + garfield);
        System.out.println("Tom => " +  tom);
        System.out.println("Lisa => " +  lisa);
        System.out.println("Silvestre => " +  silvestre);

        Ave miLoro = new Ave();
        miLoro.aseate();
        miLoro.vuela();

        Pinguino pingu = new Pinguino(Sexo.HEMBRA);
        pingu.aseate();
        pingu.vuela();


    }
}
