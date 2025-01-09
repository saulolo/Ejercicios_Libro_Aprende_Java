package uni7_Arrays;

import javax.swing.*;
import java.util.Scanner;

/**
 * Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga a qué casillas podría saltar un alfil
 * que se encuentra en esa posición. Como se indica en la figura (Libro Aprende Java con ejercicio, pag 132), el alfil
 * se mueve siempre en diagonal. El tablero cuenta con 64 casillas. Las columnas se indican con las letras de la “a” a
 * la “h” y las filas se indican del 1 al 8.
 * Ejemplo:
 * Introduzca la posición del alfil: d5
 * El álfil puede moverse a las siguientes posiciones:
 * h1 a2 g2 b3 f3 c4 e4 c6 e6 b7 f7 a8 g8
 * @author Saulolo
 */
public class Ejercicio7_5_8 {

    public static void main(String[] args) {

        String intro = "¿A DONDE SALTA EL ALFIL?' ";
        JOptionPane.showMessageDialog(null, intro);

        Scanner scanner = new Scanner(System.in);

        // Pedir la posición inicial del alfil
        System.out.print("Introduzca la posición del alfil (ejemplo: d5): ");
        String posicion = scanner.nextLine();

        // Extraer la columna y la fila de la posición
        char columnaInicial = posicion.charAt(0);
        int filaInicial = Character.getNumericValue(posicion.charAt(1));

        // Convertir la columna a un índice (0 a 7)
        int columnaIndex = columnaInicial - 'a';

        System.out.println("El alfil puede moverse a las siguientes posiciones:");

        // Generar movimientos en las 4 diagonales
        // Diagonal superior derecha
        for (int i = 1; columnaIndex + i < 8 && filaInicial + i <= 8; i++) {
            char nuevaColumna = (char) (columnaInicial + i);
            int nuevaFila = filaInicial + i;
            System.out.print(nuevaColumna + "" + nuevaFila + " ");
        }

        // Diagonal superior izquierda
        for (int i = 1; columnaIndex - i >= 0 && filaInicial + i <= 8; i++) {
            char nuevaColumna = (char) (columnaInicial - i);
            int nuevaFila = filaInicial + i;
            System.out.print(nuevaColumna + "" + nuevaFila + " ");
        }

        // Diagonal inferior derecha
        for (int i = 1; columnaIndex + i < 8 && filaInicial - i >= 1; i++) {
            char nuevaColumna = (char) (columnaInicial + i);
            int nuevaFila = filaInicial - i;
            System.out.print(nuevaColumna + "" + nuevaFila + " ");
        }

        // Diagonal inferior izquierda
        for (int i = 1; columnaIndex - i >= 0 && filaInicial - i >= 1; i++) {
            char nuevaColumna = (char) (columnaInicial - i);
            int nuevaFila = filaInicial - i;
            System.out.print(nuevaColumna + "" + nuevaFila + " ");
        }

    }

}


