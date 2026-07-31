package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_15;

import uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_14.FichaDomino;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utiliza la clase anterior para generar una secuencia de 8 fichas creadas de forma aleatoria, que encajen bien y que
 * estén bien colocadas según el juego del dominó. No hay que controlar si se repiten o no las fichas.
 * @author Saulolo
 */
public class FichaDominoAleatorioMain {

    public static void main(String[] args) {

        System.out.println("=== FICHA DOMINO ALEATORIA ===");
        final int TOTAL_FICHAS = 8;

        int izquierdo = ThreadLocalRandom.current().nextInt(0, 7);
        int derecho = ThreadLocalRandom.current().nextInt(0, 7);

        FichaDomino ficha = new FichaDomino(izquierdo, derecho);
        System.out.print(ficha);

        for (int i = 1; i < TOTAL_FICHAS; i++) {
            // El lado izquierdo de la nueva ficha DEBE coincidir con el derecho de la anterior
            izquierdo = derecho;

            // El nuevo lado derecho se genera al azar
            derecho = ThreadLocalRandom.current().nextInt(0, 7);

            // Creamos la nueva ficha perfectamente encajada y la imprimimos
            ficha = new FichaDomino(izquierdo, derecho);
            System.out.print(ficha);
        }
    }
}
