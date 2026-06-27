package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_16;

/**
 * Crea las clases {@code Punto} y {@code Linea}. De un punto se tienen que saber sus coordenadas <b>x</b> e <b>y</b>,
 * mientras que una línea está definida por dos puntos.
 * Define las clases y los métodos necesarios para que el siguiente código muestre la salida que se indica.
 * @author Saulolo
 */
public class PuntoLineaMain {

    public static void main(String[] args) {

        System.out.println("=== PUNTO Y LÍNEA ===");

        Punto p1 = new Punto(4.21, 7.3);
        Punto p2 = new Punto(-2, 1.66);
        Linea l = new Linea(p1, p2);
        System.out.println("Linea formada por los puntos " + l);


    }
}
