package uni7_Arrays;

import javax.swing.*;
import java.util.Scanner;

/**
 * Realiza el juego de las tres en raya.
 * @author Saulolo
 */
public class Ejercicio7_5_10 {

    // Crear un tablero 3x3
    static char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    // Definir símbolos de los jugadores
    static char jugadorActual = 'X';
    public static void main(String[] args) {

        String intro = "TRES EN RAYA";
        JOptionPane.showMessageDialog(null, intro);

        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        // Ciclo principal del juego
        while (!juegoTerminado) {
            // Mostrar el tablero
            mostrarTablero();

            // Pedir al jugador que ingrese su movimiento
            System.out.println("Jugador " + jugadorActual + ", ingresa tu movimiento (fila [1-3] y columna [1-3]):");
            int fila = scanner.nextInt() - 1; // Convertir a índice del array
            int columna = scanner.nextInt() - 1;

            // Validar el movimiento
            if (movimientoValido(fila, columna)) {
                tablero[fila][columna] = jugadorActual; // Realizar el movimiento

                // Verificar si el jugador actual ha ganado
                if (hayGanador()) {
                    mostrarTablero();
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                } else if (tableroLleno()) {
                    mostrarTablero();
                    System.out.println("¡Es un empate!");
                    juegoTerminado = true;
                } else {
                    // Cambiar al siguiente jugador
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }

    // Función para mostrar el tablero
    public static void mostrarTablero() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Función para validar si un movimiento es válido
    public static boolean movimientoValido(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return false; // Fuera de los límites del tablero
        }
        return tablero[fila][columna] == ' '; // La casilla debe estar vacía
    }

    // Función para verificar si el tablero está lleno (empate)
    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Función para verificar si hay un ganador
    public static boolean hayGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugadorActual && tablero[1][j] == jugadorActual && tablero[2][j] == jugadorActual) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;
        }
        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;
        }

        return false;
    }

}


