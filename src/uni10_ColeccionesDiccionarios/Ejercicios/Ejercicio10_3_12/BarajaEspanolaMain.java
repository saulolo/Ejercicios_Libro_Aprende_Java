package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_12;

import uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Escribe un programa que genere una secuencia de 5 cartas de la baraja española y que sume los puntos según el juego
 * de la brisca. El valor de las cartas se debe guardar en una estructura {@code HashMap} que debe contener parejas
 * (figura, valor), por ejemplo (“caballo”, 3). La secuencia de cartas debe ser una estructura de la clase {@code ArrayList}
 * que contiene objetos de la clase {@code Carta}. El valor de las cartas es el siguiente: as → 11, tres → 10, sota → 2,
 * caballo → 3, rey → 4; el resto de cartas no vale nada.
 * @author Saulolo
 */
public class BarajaEspanolaMain {

    public static void main(String[] args) {

        System.out.println("=== BARAJA ESPAÑOLA JUEGO BRISCA ===");

        HashMap<String, Integer>valoresBrisa = new HashMap<>();
        valoresBrisa.put("As", 11);
        valoresBrisa.put("Tres", 10);
        valoresBrisa.put("Rey", 4);
        valoresBrisa.put("Caballo", 3);
        valoresBrisa.put("Sota", 2);

        ArrayList<String> valores = new ArrayList<>(List.of("As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete",
                "Sota", "Caballo", "Rey"));
        ArrayList<String> palos = new ArrayList<>(List.of("Oros", "Copas", "Espada", "Bastos"));
        ArrayList<Card> todasLasCartas = new ArrayList<>();

        Card.generarBaraja(valores, palos, todasLasCartas);

        Collections.shuffle(todasLasCartas);

        List<Card> cincoCartas = todasLasCartas.subList(0, 5);

        for (Card carta : cincoCartas) {
            System.out.println(carta);
        }


        int totalPuntos = 0;

        for (Card carta : cincoCartas) {
            int puntos = valoresBrisa.getOrDefault(carta.getValor(), 0);
            totalPuntos = totalPuntos + puntos;
        }

        System.out.println("=======================");
        System.out.println("Puntos totales: " + totalPuntos);
    }

}