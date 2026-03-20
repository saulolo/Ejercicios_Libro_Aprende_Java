package uni8_Funciones;

/**
 * Crea una biblioteca de funciones matemáticas que contenga las siguientes funciones. Recuerda que puedes usar unas
 * dentro de otras si es necesario. Observa bien lo que hace cada función ya que, si las implementas en el orden adecuado,
 * te puedes ahorrar mucho trabajo. Por ejemplo, la función {@code esCapicua} resulta trivial teniendo {@code voltea} y la función
 * {@code siguientePrimo} también es muy fácil de implementar teniendo {@code esPrimo}.
 * <br>1. esCapicua: Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en caso contrario.</br>
 * <br>2. esPrimo: Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario.</br>
 * <br>3. siguientePrimo: Devuelve el menor primo que es mayor al número que se pasa como parámetro.</br>
 * <br>4. potencia: Dada una base y un exponente devuelve la potencia.</br>
 * <br>5. digitos: Cuenta el número de dígitos de un número entero.</br>
 * <br>6. voltea: Le da la vuelta a un número.</br>
 * <br>7. digitoN: Devuelve el dígito que está en la posición n de un número entero. Se empieza contando por el 0 y de
 * izquierda a derecha.</br>
 * <br>8. posicionDeDigito: Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se
 * encuentra, devuelve -1.</br>
 * <br>9. quitaPorDetras: Le quita a un número n dígitos por detrás (por la derecha).</br>
 * <br>10. quitaPorDelante: Le quita a un número n dígitos por delante (por la izquierda).</br>
 * <br>11. pegaPorDetras: Añade un dígito a un número por detrás.</br>
 * <br>12. pegaPorDelante: Añade un dígito a un número por delante.</br>
 * <br>13. trozoDeNumero: Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo
 * correspondiente.</br>
 * <br>14. juntaNumeros: Pega dos números para formar uno.</br>
 *
 * @author Saulolo
 */
public class Ejercicio8_6_1_a_8_6_14 {

    public static void main(String[] args) {

        System.out.println("=== FUNCIONES ===");

        int numberA = 21434;
        int numberB = 3;
        int position = 2;
        int init = 2;
        int end = 4;


        //Ejercicio 8.6.1. Palíndromo
        System.out.println("Palindromo ==> " + isCapicua(numberA));

        //Ejercicio 8.6.2. Primo
        System.out.println("Primo ==> " + isPrime(numberA));

        //Ejercicio 8.6.3. Siguiente primo
        System.out.println("Siguiente primo ==> " + isPrimeFollowing(numberA));

        //Ejercicio 8.6.4. Potencia
        System.out.println("Potencia ==> " + power(numberA, numberB));

        //Ejercicio 8.6.5. Digitos
        System.out.println("Digitos ==> " + digits(numberA));

        //Ejercicio 8.6.6. Voltea
        System.out.println("Digitos ==> " + tumble(numberA));

        //Ejercicio 8.6.7. Digito N
        System.out.println("Digíto N ==> " + digitN(numberA, position));

        //Ejercicio 8.6.8. Posición de Dígito
        System.out.println("Posición de Dígíto ==> " + digitPosition(numberA, position));

        //Ejercicio 8.6.9. Quita por detras
        System.out.println("Quita por detras ==> " + removeFromBehind(numberA, position));

        //Ejercicio 8.6.10. Quita por delante
        System.out.println("Quita por delante ==> " + removeFromBefore(numberA, position));

        //Ejercicio 8.6.11. Pegar por detras
        System.out.println("Pegar por delante ==> " + pasteFromBehind(numberA, position));

        //Ejercicio 8.6.12. Pegar por delante
        System.out.println("Pegar por delante ==> " + pasteFromBefore(numberA, position));

        //Ejercicio 8.6.13. Trozo de número
        System.out.println("Trozo de número ==> " + numberPiece(numberA, init, end));

        //Ejercicio 8.6.14. Juntar números
        System.out.println("Juntar números ==> " + joinNumbers(numberA, numberB));

    }


    /**
     * Comprueba si un número ingresado es palindromo.
     *
     * @param number Número a validar
     * @return {@code true} si el número es palindromo o {@code false} en caso contrario
     */
    public static boolean isCapicua(int number) {
        String numberText = String.valueOf(number);
        String invertNumber = new StringBuilder(numberText).reverse().toString();

        return numberText.equals(invertNumber);
    }

    /**
     * Comprueba si el número ingresado es primo.
     *
     * @param number Número a validar
     * @return {@code true}si el número es primo o {@code false} en caso contrario
     */
    public static boolean isPrime(int number) {
        int acum = 0;

        if (number < 2) {
            return false;
        }
        for (int i = 1; i <= number; i++) {
            int aux = number % i;
            if (aux == 0) {
                acum = acum + 1;
            }
        }
        if (acum > 2) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve el número menor primo que es mayor al número pasado por parámetro.
     *
     * @param number Número a validar
     * @return el número primo siguiente al número que se pasa por parámetro.
     */
    public static int isPrimeFollowing(int number) {
        int candidate = number + 1;

        while (true) {
            if (isPrime(candidate)) {
                return candidate;
            }
            candidate = candidate + 1;
        }
    }

    /**
     * Calcula la potencia de una base elevada a un exponente entero.
     *
     * @param base El número que se elevará.
     * @param exp  El exponente al que se elevará la base.
     * @return El resultado de {@code base} elevado a {@code exp}.
     */
    public static int power(int base, int exp) {
        return (int) Math.pow(base, exp);
    }

    /**
     * Devuelve la cantidad de digitos que posee un número dado.
     *
     * @param number El número calcular
     * @return La cantidad de digitos que posee el número
     */
    public static int digits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    /**
     * Devuelve el numero invertido pasado por parametro.
     *
     * @param number Número a invertir
     * @return El número invertido
     */
    public static int tumble(int number) {
        String numberText = String.valueOf(number);
        return Integer.parseInt(new StringBuilder(numberText).reverse().toString());
    }

    /**
     * Devuelve el digito que concuerda con la posición dada del número ingresado.
     *
     * @param number   El número a evaluar
     * @param position Ubicación del digito a devolver
     * @return El digito que se halla en la psoción establecida
     */
    public static char digitN(int number, int position) {
        String numberText = String.valueOf(Math.abs(number));
        return (new StringBuilder(numberText).charAt(position));
    }

    /**
     * Devuelve la posición de la primera ocurrencia de un dígito dentro de un número entero.
     * La posición comienza en 0 desde la izquierda. Si el dígito no se encuentra, retorna -1.
     *
     * @param number El número entero a analizar.
     * @param digit  El dígito a buscar (de 0 a 9).
     * @return La posición de la primera ocurrencia del dígito o -1 si no está presente.
     */
    public static int digitPosition(int number, int digit) {
        String numberText = String.valueOf(Math.abs(number));
        char digitText = String.valueOf(digit).charAt(0);

        for (int i = 0; i < numberText.length(); i++) {
            if (numberText.charAt(i) == (digitText)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Quita una cantidad específica de dígitos del final (por la derecha) de un número entero.
     * Si la cantidad de dígitos a quitar es mayor o igual que la cantidad de dígitos del número, retorna 0.
     *
     * @param number El número al que se le quitarán dígitos.
     * @param digits La cantidad de dígitos a quitar del final.
     * @return El número resultante después de quitar los dígitos especificados por la derecha.
     */
    public static int removeFromBehind(int number, int digits) {
        for (int i = 1; i < digits; i++) {
            number = number / 10;
        }
        return number;
    }

    /**
     * Quita una cantidad específica de dígitos del inicio (por la izquierda) de un número entero.
     * Si la cantidad de dígitos a quitar es mayor o igual que la cantidad de dígitos del número, retorna 0.
     *
     * @param number El número al que se le quitarán dígitos.
     * @param digits La cantidad de dígitos a quitar del inicio.
     * @return El número resultante después de quitar los dígitos especificados por la izquierda.
     */
    public static int removeFromBefore(int number, int digits) {
        String numberText = String.valueOf(Math.abs(number));

        if (digits > numberText.length()) {
            return 0;
        }
        int result = Integer.parseInt(numberText.substring(digits));
        // Si el número original era negativo, retorna negativo.
        return number < 0 ? -result : result;
    }

    /**
     * Añade un dígito por detrás (a la derecha) de un número entero.
     * Si el dígito tiene más de un dígito se añade completo su valor absoluto.
     *
     * @param number El número original.
     * @param digits El dígito a añadir (0-9).
     * @return El número resultante después de añadir el dígito por detrás.
     */
    public static int pasteFromBehind(int number, int digits) {
        if (digits < 0 || digits > 9) throw new IllegalArgumentException("El dígito debe de estar entre 0 y 9");
        return number * 10 + digits;
    }

    /**
     * Añade un dígito por delante (a la izquierda) de un número entero.
     *
     * @param number El número original.
     * @param digits El dígito a añadir por delante (0-9).
     * @return El número resultante después de añadir el dígito por delante.
     * @throws IllegalArgumentException si los índices estan fuera del rango.
     */
    public static int pasteFromBefore(int number, int digits) {
        if (digits < 0 || digits > 9) throw new IllegalArgumentException("El dígito debe de estar entre 0 y 9");
        String result = digits + String.valueOf(Math.abs(number));
        return Integer.parseInt(result);
    }

    /**
     * Devuelve un segmento del número, desde la posición inicial hasta la final.
     *
     * @param number El número original.
     * @param init   Posición inicial (incluida, comenzando desde 0).
     * @param end    Posición final (excluida).
     * @return El trozo del número solicitado como un entero.
     * @throws IllegalArgumentException si los índices son inválidos.
     */
    public static int numberPiece(int number, int init, int end) {
        String numberText = String.valueOf(Math.abs(number));
        if (init < 0 || end > numberText.length() || init >= end)
            throw new IllegalArgumentException("Índices fuera de rangos o no válidos.");
        return Integer.parseInt(numberText.substring(init, end));
    }

    /**
     * Junta dos números formando uno nuevo al concatenar sus cifras absolutas.
     *
     * @param numberA Primer número.
     * @param numberB Segundo número.
     * @return El número resultante de unir numberA y numberB, siempre positivo.
     */
    public static int joinNumbers(int numberA, int numberB) {
        String numberAText = String.valueOf(Math.abs(numberA));
        String numberBText = String.valueOf(Math.abs(numberB));
        return Integer.parseInt(numberAText + numberBText);
    }

}
