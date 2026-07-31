package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_17;

/**
 * Implementa las clases {@code Piramide} y {@code Rectangulo}. Sobre una pirámide se debe saber su altura y sobre un
 * rectángulo se debe saber tanto la <i>base</i> como la <i>altura</i>. Cada una de las clases debe tener un atributo de
 * clase (static) que lleve la cuenta de las pirámides y de los rectángulos creados respectivamente.
 * El siguiente código que va dentro del {@code main} genera la salida que se indica.
 * @author Saulolo
 */
public class FigurasMain {

    public static void main(String[] args) {

        System.out.println("=== PIRÁMIDE Y RECTÁNGULO ===");

        Piramide p = new Piramide(4);
        Rectangulo r1 = new Rectangulo(4, 3);
        Rectangulo r2 = new Rectangulo(6, 2);


        System.out.println("\n == Pirámides ==");
        System.out.println(p);

        System.out.println("\n == Rectagulos ==");
        System.out.println(r1);
        System.out.println("\n" + r2);

        System.out.println("\n" + "Pirámides creadas: " + Piramide.getCantidadPiramides());
        System.out.println("Rectángulos creadas: " + Rectangulo.getCantidadRectangulo());

    }
}
