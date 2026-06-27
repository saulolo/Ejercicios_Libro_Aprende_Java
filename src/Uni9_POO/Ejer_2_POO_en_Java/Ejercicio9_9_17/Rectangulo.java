package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_17;

public class Rectangulo {

    private int base;
    private int altura;

    private static int cantidadRectangulo = 0;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
        cantidadRectangulo++;
    }

    public static int getCantidadRectangulo() {
        return cantidadRectangulo;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                resultado.append("*");
            }
            // Salto de línea si no es la última fila
            if (i < altura - 1) {
                resultado.append("\n");
            }
        }
        return resultado.toString();
    }
}

