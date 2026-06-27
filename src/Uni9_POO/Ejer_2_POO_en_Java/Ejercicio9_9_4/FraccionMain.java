package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_4;

/**
 * Crea la clase Fracción. Los atributos serán numerador y denominador. Y algunos de los métodos pueden ser invierte,
 * simplifica, multiplica, divide, etc.
 * @author Saulolo
 */
public class FraccionMain {

    public static void main(String[] args) {

        Fraccion fraccion = new Fraccion();

        int numA = 10;
        int numB = 2;

        fraccion.setNumerador(4);
        fraccion.setDenominador(2);

        System.out.println("=== FRACCIÓN ===");

        System.out.println("\n== Invertida ==");
        System.out.println(fraccion.invierte());

        System.out.println("\n== Simplifica ==");
        System.out.println(fraccion.simplifica());

        System.out.println("\n== Multiplica ==");
        System.out.println(fraccion.multiplica());

        System.out.println("\n== Divide ==");
        System.out.println(fraccion.divide());

        System.out.println("\n== Invierte con parametros ==");
        System.out.println(fraccion.invierteConParametros(numA, numB));

        System.out.println("\n== Simplifica con parametros ==");
        System.out.println(fraccion.simplificaConParametros(numA, numB));

        System.out.println("\n== Multiplica con parametros ==");
        System.out.println(fraccion.multiplicaConParametros(numA, numB));

        System.out.println("\n== Divide con parametros ==");
        System.out.println(fraccion.divideConParametros(numA, numB));

    }
}
