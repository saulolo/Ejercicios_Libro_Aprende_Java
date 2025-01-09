package uni7_Arrays;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Mejora el juego “Busca el tesoro” de tal forma que si hay una mina a una casilla de distancia, el programa avise
 * diciendo ¡Cuidado! ¡Hay una mina cerca!.
 * @author Saulolo
 */
public class Ejercicio7_5_7 {

    public static void main(String[] args) {

        String intro = "MEJORANDO EL JUEGO 'BUSCA EL TESORO' ";
        JOptionPane.showMessageDialog(null, intro);

        // Constantes
        final int VACIO = 0;
        final int MINA = 1;
        final int TESORO = 2;
        final int INTENTO = 3;

        int[][] cuadrante = new int[5][4];
        int x, y;

        // Inicializa el array
        for (x = 0; x < 5; x++) {
            for (y = 0; y < 4; y++) {
                cuadrante[x][y] = VACIO;
            }
        }

        // Coloca la mina
        int minaX = (int) (Math.random() * 5);
        int minaY = (int) (Math.random() * 4);
        cuadrante[minaX][minaY] = MINA;

        // Coloca el tesoro
        int tesoroX, tesoroY;
        do {
            tesoroX = (int) (Math.random() * 5);
            tesoroY = (int) (Math.random() * 4);
        } while (tesoroX == minaX && tesoroY == minaY);
        cuadrante[tesoroX][tesoroY] = TESORO;

        // Inicio del juego
        System.out.println("¡BUSCA EL TESORO!");

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        do {
            // Pinta el cuadrante
            for (y = 3; y >= 0; y--) {
                System.out.print(y + "|");
                for (x = 0; x < 5; x++) {
                    if (cuadrante[x][y] == INTENTO) {
                        System.out.print("X ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println("  ----------");
            System.out.println("   0 1 2 3 4");

            // Pedir coordenadas al usuario
            System.out.print("Coordenada x: ");
            x = scanner.nextInt();
            System.out.print("Coordenada y: ");
            y = scanner.nextInt();

            // Verifica minas cercanas
            if (hayMinaCerca(cuadrante, x, y)) {
                System.out.println("¡Cuidado! ¡Hay una mina cerca!");
            }

            // Mira lo que hay en las coordenadas indicadas por el usuario
            switch (cuadrante[x][y]) {
                case VACIO:
                    cuadrante[x][y] = INTENTO;
                    break;
                case MINA:
                    System.out.println("Lo siento, has perdido.");
                    salir = true;
                    break;
                case TESORO:
                    System.out.println("¡Enhorabuena! ¡Has encontrado el tesoro!");
                    salir = true;
                    break;
                default:
            }
        } while (!salir);

        // Pinta el cuadrante final
        for (y = 3; y >= 0; y--) {
            System.out.print(y + " ");
            for (x = 0; x < 5; x++) {
                switch (cuadrante[x][y]) {
                    case VACIO:
                        System.out.print("  ");
                        break;
                    case MINA:
                        System.out.print("* ");
                        break;
                    case TESORO:
                        System.out.print("€ ");
                        break;
                    case INTENTO:
                        System.out.print("X ");
                        break;
                    default:
                }
            }
            System.out.println();
        }
        System.out.println("  ----------");
        System.out.println("   0 1 2 3 4");
    }

    /**
     * Comprueba si hay una mina cerca de las coordenadas dadas.
     */
    public static boolean hayMinaCerca(int[][] cuadrante, int x, int y) {
        int filas = cuadrante.length;
        int columnas = cuadrante[0].length;

        // Recorre las 8 posiciones vecinas
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;

                // Asegúrate de que las coordenadas estén dentro del tablero
                if (nx >= 0 && nx < filas && ny >= 0 && ny < columnas) {
                    if (cuadrante[nx][ny] == 1) { // Si hay una mina
                        return true;
                    }
                }
            }
        }
        return false;
    }

}


