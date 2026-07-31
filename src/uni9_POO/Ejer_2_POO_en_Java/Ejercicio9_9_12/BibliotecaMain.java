package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_12;

/**
 * Se quiere informatizar una biblioteca. Crea las clases {@code Publicacion}, {@code Libro} y {@code Revista}.
 * Las clases deben estar implementadas con la jerarquía correcta. Las características comunes de las revistas y de los
 * libros son el {@code código ISBN}, el {@code título}, y el {@code año de publicación}. Los libros tienen además un
 * atributo {@code prestado}.
 * Cuando se crean los libros, no están prestados. Las revistas tienen un número.
 * La clase {@code Libro} debe implementar la interfaz {@code Prestable} que tiene los métodos
 * {@code presta}, {@code devuelve} y {@code estaPrestado}.
 * @author Saulolo
 */
public class BibliotecaMain {

    public static void main(String[] args) {

        System.out.println("=== BIBLIOTECA ===");

        /* LIBROS */
        Libro libro1 = new Libro("123456", "La Ruta Prohibida", 2007);
        Libro libro2 = new Libro("112233", "Los Otros", 2016);
        Libro libro3 = new Libro("456789", "La Rosa del Mundo", 1005);

        /* REVISTAS */
        Revista revista1 = new Revista("444555", "Año Cero", 2019, 344);
        Revista revista2 = new Revista("002244", "National Geographic", 2003, 255);

        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(revista1);
        System.out.println(revista2);

        libro2.presta();
        if (libro2.estaPrestado()) {
            System.out.println("El libro esta prestado.");
        }

        libro2.presta();
        libro2.devuelve();
        if (libro2.estaPrestado()) {
            System.out.println("El libro esta prestado.");
        }

        libro3.presta();
        System.out.println(libro2);
        System.out.println(libro3);

    }
}
