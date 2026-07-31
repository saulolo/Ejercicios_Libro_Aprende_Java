package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_9;

import uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_8.Terminal;

import java.text.DecimalFormat;

public class Movil extends Terminal {


    private String tarifa;
    private double eurosTarificados = 0.0;


    public Movil(String numberTerminal, String tarifa) {
        super(numberTerminal);
        this.tarifa = tarifa;
    }


    /**
     * Devuelve el precio por segundo en euros, según la tarifa del móvil.
     *
     * @return Precio por segundo en euros.
     */
    public double getTarifaPorSegundo() {
        return switch (tarifa) {
            case "rata" ->  0.06 / 60;
            case "mono" -> 0.12 / 60;
            case "bisonte" -> 0.30 / 60;
            default -> 0.0;
        };
    }

    /**
     * Realiza una llamada a otro móvil. Suma los segundos de conversación a ambos terminales,
     * y añade el coste al total tarificado del llamador, según su tarifa.
     *
     * @param terminal Móvil al que se llama.
     * @param segundos Tiempo de conversación en segundos.
     */
    @Override
    public void llama(Terminal terminal, int segundos) {
        super.llama(terminal, segundos);
        double coste = segundos * getTarifaPorSegundo();
        eurosTarificados += coste;
    }

    /**
     * Devuelve la representación en cadena del móvil, incluyendo los segundos de conversación y el total tarificado.
     *
     * @return Cadena descriptiva del móvil.
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return super.toString() + " - tarificados " + df.format(eurosTarificados).replace('.', ',') + " euros";
    }
}
