package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_11;

import java.text.DecimalFormat;

public class TarjetaRegalo {

    private double saldo;
    private int numero;


    public TarjetaRegalo(double saldo) {
        this.saldo = saldo;
        numero = (int) (Math.random() * 90_000) + 10_000;
    }

    /**
     * Intenta gastar una cantidad de la tarjeta. Muestra mensaje si no hay suficiente saldo.
     * @param dinero Monto a gastar.
     */
    public void gasta(double dinero) {
        DecimalFormat df = new DecimalFormat("0.00");
        if (dinero > saldo) {
            System.err.println("Error: No tiene suficiente saldo para gastar." + df.format(dinero));
        } else {
            saldo -= dinero;
        }
    }

    /**
     * Fusiona dos tarjetas: suma los saldos y deja ambas originales en 0, creando una nueva.
     * @param t Tarjeta a fusionar con esta.
     * @return Nueva tarjeta con el saldo combinado.
     */
    public TarjetaRegalo fusionaCon(TarjetaRegalo t) {
        TarjetaRegalo nueva = new TarjetaRegalo(this.saldo + t.saldo);
        this.saldo = 0;
        t.saldo = 0;
        return nueva;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String numFormato = String.format("%5d",numero);
        return "Tarjeta nº " + numFormato + " - Saldo " + df.format(saldo) + " $";
    }
}
