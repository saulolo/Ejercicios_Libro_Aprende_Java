package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_11;

/**
 * La empresa <b>El Corte Islandés</b>  nos ha encargado una aplicación para gestionar las tarjetas regalo.
 * Como primer paso para implementar la aplicación, es necesario crear la clase principal. Implementa la clase
 * {@code TarjetaRegalo} . Cuando se crea una nueva tarjeta, se le da un saldo y se asigna de forma automática
 * un número de 5 dígitos. Si se intenta gastar más dinero del que tiene la tarjeta, se debe mostrar un mensaje
 * de error. Dos tarjetas regalo se pueden fusionar creando una nueva tarjeta con la suma del saldo que tenga
 * cada una y un nuevo número aleatorio de 5 cifras. Al fusionar dos tarjetas en una, las dos tarjetas originales
 * se quedarían con 0 € de saldo.
 * @author Saulolo
 */
public class TarjetaMain {

    public static void main(String[] args) {

        System.out.println("=== TARJETA REGALO ===");

        TarjetaRegalo t1 = new TarjetaRegalo(100);
        TarjetaRegalo t2 = new TarjetaRegalo(120);
        System.out.println(t1);
        System.out.println(t2);

        t1.gasta(200);
        t2.gasta(5);
        t1.gasta(200);
        t2.gasta(3.55);
        System.out.println(t1);
        System.out.println(t2);
        TarjetaRegalo t3 = t1.fusionaCon(t2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }
}
