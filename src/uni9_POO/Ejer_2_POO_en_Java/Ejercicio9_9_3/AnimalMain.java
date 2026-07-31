package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_3;

/**
 * Crea las clases Animal, Mamifero, Ave, Gato, Perro, Canario, Pinguino y Lagarto. Crea, al menos, tres métodos
 * específicos de cada clase y redefne el/los método/s cuando sea necesario. Prueba las clases creadas en un programa en
 * el que se instancien objetos y se les apliquen métodos.
 * @author Saulolo
 */
public class AnimalMain {

    public static void main(String[] args) {

        Gato gato = new Gato("Misu", "atún", 2, "Felino");
        Animal gato2 = new Gato("Misu2", "atún2", 3, "Felino2");
        Perro perro = new Perro("Rex", "croquetas", 4, "Canino");
        Canario canario = new Canario("Piolín", "semillas", 1, "Paseriforme");
        Pinguino pinguino = new Pinguino("Pingüi", "pescado", 3, "Spheniscidae");
        Lagarto lagarto = new Lagarto("Lagun", "insectos", 2, "Reptil");

        System.out.println(gato);
        gato.comer();
        gato.dormir(12);
        gato.vision();

        System.out.println(gato2);
        gato2.comer();

        System.out.println(perro);
        System.out.println(perro.jugar());
        System.out.println(perro.olfato());

        System.out.println(canario);
        canario.cantar();
        canario.tamanio();

        System.out.println(pinguino);
        System.out.println(pinguino.volar());
        pinguino.nadar();

        System.out.println(lagarto);
        lagarto.piel();
        lagarto.sangre();

    }
}
