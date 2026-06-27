package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_4;

public class Fraccion {

    private int numerador;
    private int denominador;

    /**
     * Invierte la fracción intercambiando numerador y denominador y retorna la división entera.
     * @return Resultado de la división entera del denominador entre el numerador.
     * @throws IllegalArgumentException Si el numerador es cero.
     */
    public int invierte() {
        if (numerador == 0) throw new IllegalArgumentException("El numerador no puede ser cero.");
        return denominador / numerador;
    }

    /**
     * Devuelve la suma del numerador y el denominador.
     * @return Suma de numerador y denominador.
     */
    public int simplifica() {
        return numerador + denominador;
    }

    /**
     * Devuelve el producto del numerador y el denominador.
     * @return Producto de numerador y denominador.
     */
    public int multiplica() {
        return numerador * denominador;
    }

    /**
     * Divide el numerador entre el denominador.
     * @return Resultado como double de la división.
     * @throws IllegalArgumentException Si el denominador es cero.
     */
    public double divide() {
        if (denominador == 0) throw new IllegalArgumentException("El denominador no puede ser cero.");
        return (double) numerador / denominador;
    }

    /**
     * Invierte la fracción recibida por parámetros y retorna la división entera correspondiente.
     * @param numberA El numerador de la fracción.
     * @param numberB El denominador de la fracción.
     * @return Resultado de numberB dividido entre numberA.
     * @throws IllegalArgumentException Si numberB es cero.
     */
    public int invierteConParametros(int numberA, int numberB) {
        if (numberB == 0) throw new IllegalArgumentException("El numerador no puede ser cero.");
        return numberB / numberA;
    }

    /**
     * Suma los dos números recibidos por parámetros.
     * @param numberA Primer número.
     * @param numberB Segundo número.
     * @return Suma de los parámetros.
     */
    public int simplificaConParametros(int numberA, int numberB) {
        return numberA + numberB;
    }

    /**
     * Multiplica los dos números recibidos por parámetros.
     * @param numberA Primer número.
     * @param numberB Segundo número.
     * @return Producto de los parámetros.
     */
    public int multiplicaConParametros(int numberA, int numberB) {
        return numberA * numberB;
    }

    /**
     * Divide numberA entre numberB y retorna la división entera.
     * @param numberA Numerador.
     * @param numberB Denominador.
     * @return Resultado de la división entera.
     * @throws IllegalArgumentException Si numberA es cero.
     */
    public int divideConParametros(int numberA, int numberB) {
        if (numberA == 0) throw new IllegalArgumentException("El denominador no puede ser cero.");
        return numberA / numberB;
    }


    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
