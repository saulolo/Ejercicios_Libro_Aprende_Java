package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_13;

import java.text.DecimalFormat;

public class CuentaCorriente {

    private long numeroCta;
    private int saldoInicial;

    public CuentaCorriente() {
        this.numeroCta = generarNumeroCuenta();
    }

    public CuentaCorriente(int saldoInicial) {
        this.numeroCta = generarNumeroCuenta();
        this.saldoInicial = saldoInicial;
    }

    /**
     * Genera un número de cuenta aleatorio de 10 dígitos.
     *
     * @return Número de cuenta aleatorio entre 1.000.000.000 y 9.999.999.999.
     */
    private long  generarNumeroCuenta() {
        return (long) ((Math.random() * 9_000_000_000L) + 1_000_000_000);
    }

    /**
     * Realiza un ingreso en la cuenta.
     * Solo se acepta si la cantidad es positiva.
     *
     * @param saldo Cantidad a ingresar.
     */
    public void ingreso(int saldo) {
        if (saldo > 0) saldoInicial = saldoInicial + saldo;
    }

    /**
     * Realiza un cargo (gasto) en la cuenta.
     * Solo se acepta si la cantidad es positiva.
     *
     * @param saldo Cantidad a cargar.
     */
    public void cargo(int saldo) {
        if (saldo > 0) saldoInicial = saldoInicial - saldo;
    }

    /**
     * Realiza una transferencia de dinero desde esta cuenta a otra.
     * Se descuenta de esta cuenta y se suma a la cuenta destino.
     *
     * @param cuenta Cuenta destino de la transferencia.
     * @param saldo Cantidad a transferir.
     */
    public void transferencia(CuentaCorriente cuenta, int saldo) {
        if (saldo > 0) {
            cargo(saldo);
            cuenta.ingreso(saldo);
        }
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Número de cta: " + numeroCta + " Saldo: " + df.format(saldoInicial) + " €";
    }
}
