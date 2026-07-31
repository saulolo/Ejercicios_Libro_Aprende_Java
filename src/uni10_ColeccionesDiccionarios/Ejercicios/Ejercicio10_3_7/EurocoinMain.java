package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_7;

import java.util.ArrayList;
import java.util.List;

/**
 * La máquina <b>Eurocoin</b> genera una moneda de curso legal cada vez que se pulsa un botón siguiendo la siguiente
 * pauta: o bien coincide el valor con la moneda anteriormente generada - 1 céntimo, 2 céntimos, 5 céntimos, 10 céntimos,
 * 25 céntimos, 50 céntimos, 1 euro o 2 euros - o bien coincide la posición – cara o cruz. Simula, mediante un programa,
 * la generación de 6 monedas aleatorias siguiendo la pauta correcta.
 * Cada moneda generada debe ser una instancia de la clase {@code Moneda} y la secuencia se debe ir almacenando en una
 * lista.
 * @author Saulolo
 */
public class EurocoinMain {

    public static void main(String[] args) {

        System.out.println("=== EUROCOIN ===");
        ArrayList<String> valores = new ArrayList<>(List.of("1 céntimo", "2 céntimos", "5 céntimos", "10 céntimos",
                "20 céntimos", "50 céntimos", "1 euro", "2 euros"));
        ArrayList<String> posiciones = new ArrayList<>(List.of("cara", "cruz"));
        ArrayList<Moneda> secuencia = new ArrayList<>();

        String valorAletorio  = (valores.get((int) (Math.random() * valores.size())));
        String posicionAletoria  = (posiciones.get((int) (Math.random() * posiciones.size())));

        Moneda moneda;
        String nuevoValor = " ";
        String nuevaPosicion = " ";

        secuencia.add(new Moneda(valorAletorio, posicionAletoria));

        for (int i = 0; i < 5; i++) {
            Moneda monedaAnterior = secuencia.get(secuencia.size() - 1);
            if (Math.random() < 0.5) {
                nuevoValor = monedaAnterior.getValor();
                nuevaPosicion = (posiciones.get((int) (Math.random() * posiciones.size())));
            } else {
                nuevaPosicion = monedaAnterior.getPisicion();
                nuevoValor = valores.get((int) (Math.random() * valores.size()));
            }
            moneda = new Moneda(nuevoValor, nuevaPosicion);
            secuencia.add(moneda);
        }

        for (Moneda money : secuencia) {
            System.out.println(money);
        }
    }
}