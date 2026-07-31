package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8.Card.generarBaraja;

/**
 * Realiza un programa que escoja al azar <b>10 cartas</b> de la baraja española (10 objetos de la clase {@code Carta}).
 * Emplea un objeto de la clase {@code ArrayList} para almacenarlas y asegúrate de que no se repite ninguna.
 * @author Saulolo
 */
public class BarajaMain {

    public static void main(String[] args) {

        System.out.println("=== BARAJA ===");

        ArrayList<String> valores = new ArrayList<>(List.of("As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete",
                "Sota", "Caballo", "Rey"));
        ArrayList<String> palos = new ArrayList<>(List.of("Oros", "Copas", "Espada", "Bastos"));
        ArrayList<Card> todasLasCartas = new ArrayList<>();

        generarBaraja(valores, palos, todasLasCartas);

        Collections.shuffle(todasLasCartas);
        System.out.println("10 cartas sin repetir: ");

        for (int i = 0; i < 10; i++) {
            System.out.println(todasLasCartas.get(i));
        }

    }
}