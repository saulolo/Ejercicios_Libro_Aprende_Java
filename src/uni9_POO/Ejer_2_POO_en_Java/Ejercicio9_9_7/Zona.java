package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_7;

public class Zona {

    private int entradasPorVender;

    public Zona(int entradasPorVender) {
        this.entradasPorVender = entradasPorVender;
    }

    public int getEntradasPorVender() {
        return entradasPorVender;
    }

    /**
     * Vende un número de entradas.
     * Comprueba si quedan entradas libres antes de realizar la venta.
     *
     * @param n número de entradas a vender
     */
    public void vender(int n) {
        if (entradasPorVender == 0) {
            System.out.println("Lo siento, las entradas disponibles para esta zona estan agotadas.");
        } else if (entradasPorVender < n) {
            System.out.println("Solo me quedan " + entradasPorVender + " entradas dipsonibles para esta zona.");
        } if (entradasPorVender >= n) {
            entradasPorVender -= n;
            System.out.println("Aqui tienes tus " + n + " entradas, gracias.");
        }
    }
}
