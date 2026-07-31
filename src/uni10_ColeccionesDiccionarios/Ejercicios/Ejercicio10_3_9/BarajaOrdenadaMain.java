package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_9;

import uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8.Card.generarBaraja;

/**
 * Modifica el programa anterior de tal forma que las cartas se muestren <b>ordenadas</b>.
 * Primero se ordenarán por <b>palo:</b> bastos, copas, espadas, oros. Cuando coincida el palo, se ordenará por
 * <b>número:</b> as, 2, 3, 4, 5, 6, 7, sota, caballo, rey.
 * @author Saulolo
 */
public class BarajaOrdenadaMain {

    public static void main(String[] args) {

        System.out.println("=== BARAJA ORDENADA===");
        ArrayList<String> valores = new ArrayList<>(List.of("As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete",
                "Sota", "Caballo", "Rey"));
        ArrayList<String> palos = new ArrayList<>(List.of("Oros", "Copas", "Espada", "Bastos"));
        ArrayList<Card> todasLasCartas = new ArrayList<>();

        generarBaraja(valores, palos, todasLasCartas);

        System.out.println("10 cartas sin repetir: ");

        for (int i = 0; i < 10; i++) {
            System.out.println(todasLasCartas.get(i));
        }

    }
}