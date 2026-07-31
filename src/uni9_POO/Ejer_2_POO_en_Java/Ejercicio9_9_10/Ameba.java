package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_10;

public class Ameba {

    private int peso;
    private final int FAGOCITAR = 1;

    public Ameba() {
        this.peso = 3;
    }

    /**
     * La ameba come una partícula de cierto peso.
     * Gasta 1 microgramo en el proceso de fagocitar; el resto lo añade a su peso.
     *
     * @param microgramos Peso de la partícula ingerida, en microgramos.
     */
    public void come(int microgramos) {
        if (microgramos > 0) {
            peso = peso + (microgramos - FAGOCITAR);
        }
    }

    /**
     * La ameba come a otra ameba. Gasta 1 microgramo y suma el resto del peso de la otra ameba, que queda en 0.
     *
     * @param ameba La ameba a ser comida.
     */
    public void come( Ameba ameba) {
        if (ameba.peso > 0) {
            peso = peso + (ameba.peso - FAGOCITAR);
            ameba.peso = 0;
        }

    }

    @Override
    public String toString() {
        return "Soy una ameba y peso " + peso + " microgramos.";
    }
}
