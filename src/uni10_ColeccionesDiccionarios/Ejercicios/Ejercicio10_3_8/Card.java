package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_8;

import java.util.ArrayList;

public class Card {

    private String valor;
    private String palo;

    public Card(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    /**
     * Genera una baraja completa combinando todos los valores y palos disponibles.
     *
     * @param valores         Lista con las denominaciones de las cartas (ej. "As", "2", "Rey").
     * @param palos           Lista con los palos del juego (ej. "Corazones", "Picas").
     * @param todasLasCartas  Lista destino donde se guardarán los objetos Card creados.
     */
    public static void generarBaraja(ArrayList<String> valores, ArrayList<String> palos, ArrayList<Card> todasLasCartas) {
        for (int i = 0; i < valores.size(); i++) {
            String nuevoValor = valores.get(i);
            for (int j = 0; j < palos.size(); j++) {
                String nuevoPalo = palos.get(j);
                Card nuevaCarta = new Card(nuevoValor, nuevoPalo);
                todasLasCartas.add(nuevaCarta);
            }
        }
    }

    @Override
    public String toString() {
        return "Carta: " + valor + " de " + palo;
    }
}
