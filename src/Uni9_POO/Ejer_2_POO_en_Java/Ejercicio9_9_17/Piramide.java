package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_17;

public class Piramide {

    private int altura;

    private static int cantidadPiramides = 0;

    public Piramide(int altura) {
        this.altura = altura;;
        cantidadPiramides++;
    }

    public static int getCantidadPiramides() {
        return cantidadPiramides;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < altura; i++) {
            // Espacios en blanco para centrar los asteriscos
            for (int j = 0; j < altura - i - 1; j++) {
                resultado.append(" ");
            }
            // Asteriscos (números impares: 1, 3, 5, 7...)
            for (int k = 0; k < (2 * i + 1); k++) {
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
