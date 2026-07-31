package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_8;

public class Terminal {

    private final String numberTerminal;
    private int time = 0;


    public Terminal(String numberTerminal) {
        this.numberTerminal = numberTerminal;
    }

    /**
     * Realiza una llamada a otro terminal y añade el tiempo de conversación a ambos.
     *
     * @param terminal El terminal al que se llama.
     * @param time Tiempo de conversación en segundos.
     */
    public void llama(Terminal terminal, int time) {
        this.time += time;
        terminal.time += time;
    }

    @Override
    public String toString() {
        return  "Nº " + numberTerminal + " - " + time + "s de conversación";
    }
}
