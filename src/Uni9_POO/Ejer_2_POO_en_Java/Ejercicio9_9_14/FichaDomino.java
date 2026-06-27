package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_14;

public class FichaDomino {

    private int ladoA;
    private int ladoB;

    public FichaDomino(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    /**
     * Invierte la posición de los lados de la ficha actual.
     * El lado izquierdo pasa al derecho y viceversa.
     * @return La propia instancia de la ficha (this) con los lados ya invertidos.
     */
    public FichaDomino voltea() {
        int aux = this.ladoA;
        this.ladoA = this.ladoB;
        this.ladoB = aux;
        return this;
    }

    /**
     * Comprueba si la ficha actual encaja con otra ficha dada según las reglas del dominó.
     * Dos fichas encajan si comparten al menos un valor en cualquiera de sus lados.
     * @param otraFicha La otra ficha de dominó con la que se quiere realizar la comprobación.
     * @return true si las fichas encajan y se pueden colocar juntas; false en caso contrario.
     */
    public boolean encaja(FichaDomino otraFicha) {
        return this.ladoA == otraFicha.ladoA ||
                this.ladoA == otraFicha.ladoB ||
                this.ladoB == otraFicha.ladoA ||
                this.ladoB == otraFicha.ladoB;
    }


    @Override
    public String toString() {
        String l1 = (this.ladoA == 0) ? " " : String.valueOf(this.ladoA);
        String l2 = (this.ladoB == 0) ? " " : String.valueOf(this.ladoB);
        return "[" + l1 + "]" + "[" + l2 + "]";
    }
}
